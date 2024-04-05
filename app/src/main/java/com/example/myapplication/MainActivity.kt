package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HistoricalFigures(val name: String, val age: Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<EditText>(R.id.editTextNumber)
        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val textView = findViewById<TextView>(R.id.textView)
        val clearButton = findViewById<Button>(R.id.clearButton) // Define clearButton here

        clickMeButton.setOnClickListener {
            val ageString = textInput.text.toString()
            if (ageString.isNotEmpty()) {
                val age = ageString.toInt()
                val matchedFigure = findMatchedHistoricalFigure(age)
                if (matchedFigure != null) {
                    textView.text = " $age, ${matchedFigure.name} "
                } else {
                    textView.text = "No famous historical figure found for age: $age"
                }

                // Add a dialog to display the matched figure's name for debugging
                val matchedFigureDialogMessage = matchedFigure?.let { "Matched Figure: ${it.name}" }
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Matched Figure")
                alertDialogBuilder.setMessage(matchedFigureDialogMessage ?: "No matched figure found.")
                alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                val alertDialog = alertDialogBuilder.create()
                /*alertDialog.show()*/
            } else {
                textView.text = "Please enter an age."
            }
        }



        clearButton.setOnClickListener {
            textInput.text.clear()
        }
    }

    private fun findMatchedHistoricalFigure(age: Int): HistoricalFigures? {
        val figures = listOf(
            HistoricalFigures("Julius Caesar", 56),
            HistoricalFigures("Albert Einstein", 76),
            HistoricalFigures("Alexander the Great", 32),
            HistoricalFigures("Cleopatra VII", 39),
            HistoricalFigures("Napoleon Bonaparte", 51),
            HistoricalFigures("Tutankhamun", 18),
            HistoricalFigures("Mozart", 35),
            HistoricalFigures("Nelson Mandela", 95),
            HistoricalFigures("Vincent van Gogh", 37),
            HistoricalFigures("Anne Frank", 15)
        )

        for (figure in figures) {
            if (figure.age == age) {
                return figure
            }
        }
        return null
    }

}