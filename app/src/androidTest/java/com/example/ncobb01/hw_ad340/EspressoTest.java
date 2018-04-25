package com.example.ncobb01.hw_ad340;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.action.ViewActions.click;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



// My espresso test


@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoTest() {
        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_4_24_18)));
        onView(withId(R.id.nameEditText)).check(matches(withText(R.string.name)));
//        onView(withId(R.id.form_email)).check(matches(withText(R.string.email)));
//        onView(withId(R.id.form_username)).check(matches(withText(R.string.username)));
//        onView(withId(R.id.form_age)).check(matches(withText(R.string.age)));
//        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
//        onView(withId(R.id.form_submit)).check(matches(withText(R.string.submit)));
//        onView(withId(R.id.homepage)).check(matches(withText(R.string.home)));
//
//        onView(withId(R.id.form_submit)).perform(click()).check(matches(isEnabled()));
//        onView(withId(R.id.dp)).perform(click()).check(matches(isEnabled()));
//        onView(withId(R.id.homepage)).perform(click()).check(matches(isEnabled()));


    }
}