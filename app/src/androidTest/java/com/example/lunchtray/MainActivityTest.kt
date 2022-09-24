package com.example.lunchtray


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.start_order_btn), withText("Start Order"),
                childAtPosition(
                    allOf(
                        withId(R.id.layout_start_order),
                        childAtPosition(
                            withId(R.id.fragment_nav_host),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val materialRadioButton = onView(
            allOf(
                withId(R.id.chili), withText("Three Bean Chili"),
                childAtPosition(
                    allOf(
                        withId(R.id.entree_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    4
                )
            )
        )
        materialRadioButton.perform(scrollTo(), click())

        val materialRadioButton2 = onView(
            allOf(
                withId(R.id.pasta), withText("Mushroom Pasta"),
                childAtPosition(
                    allOf(
                        withId(R.id.entree_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    8
                )
            )
        )
        materialRadioButton2.perform(scrollTo(), click())

        val materialRadioButton3 = onView(
            allOf(
                withId(R.id.skillet), withText("Spicy Black Bean Skillet"),
                childAtPosition(
                    allOf(
                        withId(R.id.entree_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    12
                )
            )
        )
        materialRadioButton3.perform(scrollTo(), click())

        val materialRadioButton4 = onView(
            allOf(
                withId(R.id.cauliflower), withText("Cauliflower"),
                childAtPosition(
                    allOf(
                        withId(R.id.entree_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                )
            )
        )
        materialRadioButton4.perform(scrollTo(), click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.next_button), withText("Next"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    4
                )
            )
        )
        materialButton2.perform(scrollTo(), click())

        val materialRadioButton5 = onView(
            allOf(
                withId(R.id.soup), withText("Butternut Squash Soup"),
                childAtPosition(
                    allOf(
                        withId(R.id.side_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    4
                )
            )
        )
        materialRadioButton5.perform(scrollTo(), click())

        val materialRadioButton6 = onView(
            allOf(
                withId(R.id.potatoes), withText("Spicy Potatoes"),
                childAtPosition(
                    allOf(
                        withId(R.id.side_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    8
                )
            )
        )
        materialRadioButton6.perform(scrollTo(), click())

        val materialRadioButton7 = onView(
            allOf(
                withId(R.id.rice), withText("Coconut Rice"),
                childAtPosition(
                    allOf(
                        withId(R.id.side_options),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    12
                )
            )
        )
        materialRadioButton7.perform(scrollTo(), click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.cancel_button), withText("Cancel"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_side_menu),
                        0
                    ),
                    3
                )
            )
        )
        materialButton3.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
