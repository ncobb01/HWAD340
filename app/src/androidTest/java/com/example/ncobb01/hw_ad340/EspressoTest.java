package com.example.ncobb01.hw_ad340;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onData;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import org.hamcrest.Matchers;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import android.support.test.espresso.contrib.PickerActions;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.DatePicker;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;



@RunWith(AndroidJUnit4.class)
public class EspressoTest {
    private Card mActivity;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void mainActivityTest0() {
        onView(withId(R.id.form_birthSpin)).check(matches(withText(R.string.please_select_your_birthdate)));
    }

    @Test
    public void mainActivityTest() {
        onView(withId(R.id.assignInfo)).check(matches(withText(R.string.nathan_cobb_5_18_18)));
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



        onView(withId(R.id.tab_layout))
               .perform(swipeRight()) .perform(click())
                .check(matches(isDisplayed()));



    }



        public static void setDate ( int datePickerLaunchViewId, int year, int monthOfYear,
        int dayOfMonth){

            onView(withId(datePickerLaunchViewId)).perform(click());

            onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));

        }


   @Test
    public void entryExample2() {
setDate(R.id.dp, 1989, 8, 1);

       onView(withId(R.id.secondActivityBtn)).perform(scrollTo(),click());

   }







}



