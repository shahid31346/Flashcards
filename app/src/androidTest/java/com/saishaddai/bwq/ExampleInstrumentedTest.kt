package com.saishaddai.bwq

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


import android.support.test.rule.ActivityTestRule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    public var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.saishaddai.bwq", appContext.packageName)

        //kickstart to use espresso
        Espresso.onView(ViewMatchers.withId(R.id.message)).perform(ViewActions.click()).perform(ViewActions.click())

        //Espresso.onView(ViewMatchers.withId(R.id.editText))
        //   .check(ViewAssertions.matches(
        //             ViewMatchers.withEffectiveVisibility(
        //             ViewMatchers.Visibility.VISIBLE)));


//        ViewActions.click
//        ViewActions.typeText()
//        ViewActions.pressKey()
//        ViewActions.clearText()

    }

    //add more tests here
}
