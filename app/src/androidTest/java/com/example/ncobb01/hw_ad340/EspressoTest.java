package com.example.ncobb01.hw_ad340;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.espresso.contrib.PickerActions;
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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.DatePicker;
import android.widget.TimePicker;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_4_24_18)));
//        onView(withId(R.id.nameEditText)).check(matches(withText(R.string.please_enter_your_name)));
//        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
//
//        // need to add datepicker still!
//
//        onView(withId(R.id.occupationEditText)).check(matches(withText(R.string.please_enter_your_occupation)));
//        onView(withId(R.id.occupation2EditText)).check(matches(withText(R.string.please_describe_yourself)));
//        onView(withId(R.id.loginBtn)).check(matches(withText(R.string.log_in)));


        //onView(withId(R.id.loginBtn)).perform(click()).check(matches(isEnabled()));
//        onView(withId(R.id.dp)).perform(click()).check(matches(isEnabled()));



    }

    @Test
    public void mainActivityTest2() {
        onView(withId(R.id.secondActivityBtn)).check(matches(withText(R.string.click_to_see_your_profile)));
    }




//    @Test
//    public void entryExample() {
//
//        onView(withId(R.id.nameEditText))
//                .perform(typeText("Nathan Cobb"), closeSoftKeyboard());
//        onView(withId(R.id.secondActivityBtn)).perform(scrollTo()).perform(click());}
//
//
//        @Test
//        public void entryExample2() {
//
//        onView(withId(R.id.occupationEditText))
//                .perform(typeText("Office Manager"), closeSoftKeyboard());
//        onView(withId(R.id.secondActivityBtn)).perform(scrollTo()).perform(click());}
//
//    @Test
//    public void entryExample3() {
//
//        onView(withId(R.id.occupation2EditText))
//                .perform(typeText("I like long walks on the beach."), closeSoftKeyboard());
//        onView(withId(R.id.secondActivityBtn)).perform(scrollTo()).perform(click());}









//
//    @Test
//    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
//        onView(withId(datePickerLaunchViewId)).perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
//        onView(withId(android.R.id.button1)).perform(click());
//
//
//        setDate(R.id.dp, 1994, 1, 1);
//    }







//
//    @Test
//    public void canGoToSecondActivityWithMessage() {
//        onView(withId(R.id.nameEditText)).perform(typeText("Nathan Cobb"));
//
//        try {
//            Intents.init();
//            onView(withId(R.id.secondActivityBtn)).perform(scrollTo(), click());
//            intended(hasComponent(ConfirmationPage.class.getName()));
//            intended(hasExtra(Constants.KEY_NAME, "Nathan Cobb"));
//
//           // intended(hasExtra(Constants.KEY_OCCUPATION, "Office Manager"));
//           // intended(hasExtra(Constants.KEY_OCCUPATION2, "I like the sun."));
//
//
//
//        } finally {
//            Intents.release();
//        }
//    }
//
    }
