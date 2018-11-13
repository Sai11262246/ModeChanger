import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import com.vivartha.modechanger.Home_Activity;
import com.vivartha.modechanger.MainActivity;
import com.vivartha.modechanger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class Home_ActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<Home_Activity> rule = new ActivityTestRule<Home_Activity>(Home_Activity.class) {
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent i = new Intent(Intent.ACTION_MAIN);
            return i;
        }
    };



    @Test
    public void checkLaunchAdminLoginActivity() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(AdminLoginActivity.class.getName(),null,false);

        MainActivity activity = rule.getActivity();
        final Button button = (Button) activity.findViewById(R.id.btnIsAdmin);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open activity.
                button.performClick();
            }
        });

        AdminLoginActivity adminLoginActivity = (AdminLoginActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // activity is opened and captured.
        assertNotNull(adminLoginActivity);
        adminLoginActivity.finish();
    }

    @Test
    public void checkLaunchUserWelcomeActivity() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(UserWelcomeActivity.class.getName(),null,false);

        MainActivity activity = rule.getActivity();
        final Button button = (Button) activity.findViewById(R.id.btnIsUser);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open activity.
                button.performClick();
            }
        });

        UserWelcomeActivity userWelcomeActivity = (UserWelcomeActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // activity is opened and captured.
        assertNotNull(userWelcomeActivity);
        userWelcomeActivity.finish();
    }
}