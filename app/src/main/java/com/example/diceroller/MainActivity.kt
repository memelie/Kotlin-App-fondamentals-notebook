package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    var diceValue = 0;
    lateinit var diceImageDouble : ImageView
    var diceValueDouble = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
        diceImage = findViewById(R.id.dice_image)
        diceImageDouble = findViewById(R.id.dice_image_double)
    }

    private fun getImage(number: Int): Int {
        val drawableResource = when (number) {
            0 -> R.drawable.empty_dice
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource;
    }

    private fun replaceImage(number: Int) {
        val drawableResource = getImage(number)
        diceValue = number;
        diceImage.setImageResource(drawableResource)
    }

    private fun replaceImageDouble(number: Int) {
        val drawableResource = getImage(number)
        diceValueDouble = number;
        diceImageDouble.setImageResource(drawableResource)
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        replaceImage(randomInt);
        val randomIntDouble = (1..6).random()
        replaceImageDouble(randomIntDouble);
    }

    private fun countUp() {
        fun getNewInt (oldInt: Int): Int {
            if (oldInt != 6) {
                return oldInt + 1;
            }
            return oldInt;
        }
        val currentVal: Int = diceValue;
        var newInt = getNewInt(currentVal);
        replaceImage(newInt)
        val currentValDouble: Int = diceValueDouble;
        var newIntDouble = getNewInt(currentValDouble);
        replaceImageDouble(newIntDouble)
    }

    private fun reset() {
        replaceImage(0)
        replaceImageDouble(0)
    }
}