package com.example.ncobb01.hw_ad340;

//import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
//import android.support.test.espresso.intent.Intents;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.action.ViewActions.scrollTo;
//import static android.support.test.espresso.action.ViewActions.typeText;
//import static android.support.test.espresso.intent.Intents.intended;
//import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
//import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//
//import org.hamcrest.Matchers;
//
//import android.support.test.espresso.contrib.PickerActions;
//
//import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
//
//import android.widget.DatePicker;
//import android.widget.TimePicker;
//
//
//
//@RunWith(AndroidJUnit4.class)
//public class EspressoTest {
//
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
//
//
//
//    @Test
//    public void mainActivityTest0() {
//        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
//    }
//
//    @Test
//    public void mainActivityTest() {
//        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_4_24_18)));
//    }
//
//    @Test
//    public void mainActivityTest2() {
//        onView(withId(R.id.secondActivityBtn)).check(matches(withText(R.string.click_to_see_your_profile)));
//    }
//
//
//
//        @Test
//  public void entryExample() {
//
//        onView(withId(R.id.nameEditText))
//                .perform(typeText("Nathan Cobb"), closeSoftKeyboard());
//        onView(withId(R.id.nameEditText)).check(matches(withText("Nathan Cobb")));
//    }
//
//
//    @Test
//    public void canGoToSecondActivityWithMessage() {
//        onView(withId(R.id.nameEditText)).perform(typeText("Nathan Cobb"), closeSoftKeyboard());
//
//        try {
//            Intents.init();
//            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
//            intended(hasComponent(ConfirmationPage.class.getName()));
//            intended(hasExtra(Constants.KEY_NAME, "Nathan Cobb"));
//        } finally {
//            Intents.release();
//
//
//        }
//    }
//
//
//    @Test
//    public void canGoToSecondActivityWithMessage2() {
//        onView(withId(R.id.occupationEditText)).perform(typeText("Office Manager"), closeSoftKeyboard());
//
//        try {
//            Intents.init();
//            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
//            intended(hasComponent(ConfirmationPage.class.getName()));
//            intended(hasExtra(Constants.KEY_OCCUPATION, "Office Manager"));
//        } finally {
//            Intents.release();
//        }
//    }
//
//
//    @Test
//    public void canGoToSecondActivityWithMessage3() {
//        onView(withId(R.id.occupation2EditText)).perform(typeText("I like long walks on the beach."), closeSoftKeyboard());
//
//        try {
//            Intents.init();
//            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
//            intended(hasComponent(ConfirmationPage.class.getName()));
//            intended(hasExtra(Constants.KEY_OCCUPATION2, "I like long walks on the beach."));
//        } finally {
//            Intents.release();
//        }
//    }
//
//    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
//        onView(withId(datePickerLaunchViewId)).perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
//
//        setDate(R.id.dp, 1999, 1, 1);
//    }



import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.hamcrest.Matchers;

import android.support.test.espresso.contrib.PickerActions;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;

import android.widget.DatePicker;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;



@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void mainActivityTest0() {
        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
    }

    @Test
    public void mainActivityTest() {
        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_4_24_18)));
    }

    @Test
    public void mainActivityTest2() {
        onView(withId(R.id.secondActivityBtn)).check(matches(withText(R.string.click_to_see_your_profile)));
    }


    @Test
    public void entryExample() {

        onView(withId(R.id.nameEditText))
                .perform(typeText("Nathan Cobb"), closeSoftKeyboard());
        onView(withId(R.id.nameEditText)).check(matches(withText("Nathan Cobb")));

        onView(withId(R.id.occupationEditText))
                .perform(typeText("Student"), closeSoftKeyboard());
        onView(withId(R.id.occupationEditText)).check(matches(withText("Student")));

        onView(withId(R.id.occupation2EditText))
                .perform(typeText("Sun"), closeSoftKeyboard());
        onView(withId(R.id.occupation2EditText)).check(matches(withText("Sun")));

        onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());



    }

    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {

        onView(withId(datePickerLaunchViewId)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));



    }

    @Test
    public void entryExample2() {
        setDate(R.id.dp, 1989, 8, 1);

        onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());

    }



    @Test
    public void canGoToSecondActivityWithMessage3() {
        onView(withId(R.id.occupation2EditText)).perform(typeText("I like long walks on the beach."), closeSoftKeyboard());

        try {
            Intents.init();
            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
            intended(hasComponent(ConfirmationPage.class.getName()));
            intended(hasExtra(Constants.KEY_OCCUPATION2, "I like long walks on the beach."));
        } finally {
            Intents.release();
        }
    }


}




