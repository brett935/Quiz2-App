package com.brettnapier.quiz2;


import android.test.ActivityTestCase;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
/**
 * Created by Brett on 3/1/2016.
 */

@RunWith(AndroidJUnit4.class)
public class Question3Test {
    @Rule
    public ActivityTestRule<Question3> question3ActivityTestRule =
            new ActivityTestRule<Question3>(Question3.class);

    @Test
    public void select(){
        onView( withId( R.id.radioButton2 )).perform(click());
        onView( withId( R.id.radioButton2 )).check(matches(isChecked()));
    }

}
