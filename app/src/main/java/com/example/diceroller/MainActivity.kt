package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    var diceValue = 0;

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
    }

    private fun replaceImage(number: Int) {
        val drawableResource = when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceValue = number;
        diceImage.setImageResource(drawableResource)
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        replaceImage(randomInt);
    }

    private fun countUp() {
        var newInt: Int;
        val currentVal: Int = diceValue;
        newInt = if (currentVal != 6) {
            currentVal + 1;
        } else {
            currentVal;
        }
        replaceImage(newInt)
    }

    private fun reset() {
        replaceImage(0)
    }
}