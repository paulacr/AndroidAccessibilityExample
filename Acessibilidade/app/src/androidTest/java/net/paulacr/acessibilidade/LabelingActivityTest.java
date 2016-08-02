package net.paulacr.acessibilidade;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by paularosa on 7/31/16.
 */
@RunWith(AndroidJUnit4.class)
public class LabelingActivityTest  {

    @Rule
    public ActivityTestRule<LabelingActivity_> rule = new ActivityTestRule<LabelingActivity_>(LabelingActivity_.class);

    @Test
    public void testaSeTemNullContentDescription() {
        onView(withId(R.id.ic_app_notificacao)).check
                (matches(not(hasContentDescription())));
    }

    @Test
    public void testaSeTemContentDescriptionTwitter() {
        onView(withId(R.id.botao_twitter)).check
                (matches(withContentDescription("Logar com Twitter")));
    }

}
