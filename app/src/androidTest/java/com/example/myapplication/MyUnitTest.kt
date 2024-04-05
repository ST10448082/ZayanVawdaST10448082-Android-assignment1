import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.myapplication.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Clear text input before each test
        onView(withId(R.id.editTextNumber)).perform(clearText())
    }

    @Test
    fun enterValidAge_showMatchedFigure() {
        // Enter a valid age and click the button
        onView(withId(R.id.editTextNumber)).perform(typeText("32"), closeSoftKeyboard())
        onView(withId(R.id.clickMeButton)).perform(click())

        // Check if the matched figure's name is displayed
        onView(withId(R.id.textView)).check(matches(withText("At age 32, Alexander the Great achieved")))
    }

    @Test
    fun enterInvalidAge_showErrorMessage() {
        // Enter an invalid age and click the button
        onView(withId(R.id.editTextNumber)).perform(typeText("99"), closeSoftKeyboard())
        onView(withId(R.id.clickMeButton)).perform(click())

        // Check if the error message is displayed
        onView(withId(R.id.textView)).check(matches(withText("No famous historical figure found who achieved at the age of 99.")))
    }

    @Test
    fun clickClearButton_clearTextInput() {
        // Enter text into the input field
        onView(withId(R.id.editTextNumber)).perform(typeText("32"), closeSoftKeyboard())

        // Click the clear button
        onView(withId(R.id.clearButton)).perform(click())

        // Check if the input field is empty
        onView(withId(R.id.editTextNumber)).check(matches(withText("")))
    }
}
