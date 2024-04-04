import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

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
                    textView.text = "At age $age ${matchedFigure.name} achieved"
                } else {
                    textView.text = "No famous historical figure found who died at this age."
                }
            } else {
                textView.text = "Please enter your age."
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
            HistoricalFigures("Bruce Lee", 32),
            HistoricalFigures("Vincent van Gogh", 37),
            HistoricalFigures("Anne Frank", 15)
        )
        return figures.find { it.age == age }
    }
}