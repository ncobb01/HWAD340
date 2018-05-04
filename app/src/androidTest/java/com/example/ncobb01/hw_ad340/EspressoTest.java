package com.example.ncobb01.hw_ad340;

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
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.hamcrest.Matchers;

import android.support.test.espresso.contrib.PickerActions;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;

import android.widget.DatePicker;
import android.widget.TimePicker;


import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.DatePicker;
import android.widget.EditText;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

//    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
//
//        onView(withId(datePickerLaunchViewId)).perform(click());
//
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
//
//        onView(withId(android.R.id.button1)).perform(click());
//
//    }
//
//    //it changed damn you android studio
//    @Test
//    public void formfillout() {
//        onView(withText("Click to see your profile!")).perform(scrollTo(),click());
//
//        onView(withId(R.id.nameEditText))
//                .perform(typeText("Nathan"), closeSoftKeyboard());
//        onView(withId(R.id.occupationEditText))
//                .perform(typeText("Student"), closeSoftKeyboard());
//        onView(withId(R.id.occupation2EditText))
//                .perform(typeText("I like the sun."), closeSoftKeyboard());
//
//
//        setDate(R.id.dp, 1989, 8, 1);
//
//        onView(withText("Click to see your profile!")).perform(click());
//
//        onView(withId(R.id.nameEditText))
//                .check(matches(withText("Nathan")));
//        onView(withId(R.id.occupationEditText))
//                .check(matches(withText("Student")));
//        onView(withId(R.id.occupation2EditText))
//                .check(matches(withText("I like the sun.")));
//        onView(withId(R.id.dp))
//                .check(matches(withText("28")));
//
//
//    }


    @Test
    public void mainActivityTest0() {
        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
    }

    @Test
    public void mainActivityTest() {
        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_4_30_18)));
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

        onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());

    }

//    @Test
//    public void entryExample2() {
//        onView(withId(R.id.occupation2EditText))
//                .perform(typeText("Sun"), closeSoftKeyboard());
//        onView(withId(R.id.occupationEditText)).check(matches(withText("Sun")));
//    }
    //
//    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
//        onView(withId(datePickerLaunchViewId)).perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
//
//        setDate(R.id.dp, 1999, 1, 1);
//        onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
//    }
}
//
//
//
//    @Test
//    public void submit() {
//
//        onView(withId(R.id.nameEditText))
//                .perform(typeText("test_user")).perform(closeSoftKeyboard());
//        onView(withId(R.id.occupationEditText))
//                .perform(typeText("test_job")).perform(closeSoftKeyboard());
//
//        onView(withId(R.id.occupation2EditText))
//                .perform(typeText("I like sun.")).perform(closeSoftKeyboard());
//        //Thread.sleep(250);
//
//        onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());
//
//    //onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());
//
//        }

//
////    public void clickOnTab() {
//        Matcher<View> matcher = allOf(withText("Matches"),
//                isDescendantOfA(withId(R.id.customTab)));
//        onView(matcher).perform(click());
//        SystemClock.sleep(800); // Wait a little until the content is loaded
//    }
//}
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








