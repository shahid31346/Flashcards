package com.saishaddai.bwq

//import android.app.Activity
import android.support.test.InstrumentationRegistry

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
//import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//uncomment when using
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
//import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
//import android.support.test.espresso.action.ViewActions.typeText
//import android.support.test.espresso.assertion.ViewAssertions.matches

import android.support.test.espresso.matcher.ViewMatchers.withId
//import android.support.test.espresso.matcher.ViewMatchers.withText


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppContext() {
//        val mainActivity = mActivityRule.activity

        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals("com.saishaddai.bwq", appContext.packageName)

        //kick start to use espresso
        onView(withId(R.id.message)).perform(click()).perform(click())

//        val instance = getActivityInstance()
//        Espresso.onView(ViewMatchers.withId(R.id.message)).perform(ViewActions.click())
//        val activity = getActivityInstance()
//        val b = activity is SecondActivity
//        assertTrue(b)

        //Espresso.onView(ViewMatchers.withId(R.id.editText))
        //   .check(ViewAssertions.matches(
        //             ViewMatchers.withEffectiveVisibility(
        //             ViewMatchers.Visibility.VISIBLE)));


//        ViewActions.click
//        ViewActions.typeText()
//        ViewActions.pressKey()
//        ViewActions.clearText()

    }

//    fun getActivityInstance(): Activity? {
//        val activity = arrayOfNulls<Activity>(1)
//        InstrumentationRegistry.getInstrumentation().runOnMainSync {
//            var currentActivity: Activity? = null
//            val resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED)
//            if (resumedActivities.iterator().hasNext()) {
//                currentActivity = resumedActivities.iterator().next() as Activity
//                activity[0] = currentActivity
//            }
//        }
//
//        return activity[0]
//    }

//    @Test
//    fun ensureTextChangesWork() {
//        // Type text and then press the button.
//        onView(withId(R.id.inputField))
//            .perform(typeText("HELLO"), closeSoftKeyboard())
//        onView(withId(R.id.changeText)).perform(click())
//
//        // Check that the text was changed.
//        onView(withId(R.id.inputField)).check(matches(withText("Lalala")))
//    }

//    @Test
//    fun changeText_newActivity() {
//        // Type text and then press the button.
//        onView(withId(R.id.inputField)).perform(
//            typeText("NewText"),
//            closeSoftKeyboard()
//        );
//        onView(withId(R.id.switchActivity)).perform(click());
//
//        // This view is in a different Activity, no need to tell Espresso.
//        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
//
//
//        //add more tests here
//    }
}
