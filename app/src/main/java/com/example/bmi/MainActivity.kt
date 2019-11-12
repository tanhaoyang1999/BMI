package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            calculate()
        }

    }
    fun calculate(){
        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()
        val bmi : Float = weight / (height/100).pow(2)
        if(bmi<18.5){
            textViewBMI.text = String.format("%s: %.2f (%s)",getString(R.string.bmi),bmi, getString(R.string.under))
            imageViewProfile.setImageResource(R.drawable.under)
        }else if(bmi in 18.5 .. 25.0){
            textViewBMI.text = String.format("%s: %.2f (%s)",getString(R.string.bmi),bmi, getString(R.string.normal))
            imageViewProfile.setImageResource(R.drawable.normal)
        }else{
            textViewBMI.text = String.format("%s: %.2f (%s)",getString(R.string.bmi),bmi, getString(R.string.over))
            imageViewProfile.setImageResource(R.drawable.over)
        }
    }

    fun reset(view : View){
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.setText("BMI: ")

    }
}
