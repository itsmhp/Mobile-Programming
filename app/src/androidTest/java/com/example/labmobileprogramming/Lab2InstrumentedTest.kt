package com.example.labmobileprogramming

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Lab2InstrumentedTest {
    @Test
    fun test_isActivityInView() {
        val activitySceneario = ActivityScenario.launch(Lab2Activity::class.java)
        onView(withId(R.id.lab2layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_all_visibilities() {
        val activitySceneario = ActivityScenario.launch(Lab2Activity::class.java)
        onView(withId(R.id.counterTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.resetBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.incrementBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.decrementBtn)).check(matches(isDisplayed()))
    }

    @Test
    fun test_can_all_button_be_clicked(){
        val activitySceneario = ActivityScenario.launch(Lab2Activity::class.java)
        onView(withId(R.id.resetBtn)).perform(click())
        onView(withId(R.id.incrementBtn)).perform(click())
        onView(withId(R.id.decrementBtn)).perform(click())
    }
}