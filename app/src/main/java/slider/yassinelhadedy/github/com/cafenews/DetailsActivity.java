package slider.yassinelhadedy.github.com.cafenews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import slider.yassinelhadedy.github.com.cafenews.fragments.HomeFragment;
import slider.yassinelhadedy.github.com.cafenews.fragments.MoviesFragment;
import slider.yassinelhadedy.github.com.cafenews.fragments.NotificationsFragment;
import slider.yassinelhadedy.github.com.cafenews.fragments.PhotosFragment;
import slider.yassinelhadedy.github.com.cafenews.fragments.SettingsFragment;

public class DetailsActivity extends AppCompatActivity {

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "notifications";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Fragment fragment = getHomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();


    }


    private Fragment getHomeFragment() {
        int name=getIntent().getIntExtra("frag",1);
        switch (name){
            case 1:
                // home
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 2:
                // photos
                PhotosFragment photosFragment = new PhotosFragment();
                return photosFragment;
            case 3:
                // movies fragment
                MoviesFragment moviesFragment = new MoviesFragment();
                return moviesFragment;
            case 4:
                // notifications fragment
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                return notificationsFragment;

            case 5:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            default:
                return new HomeFragment();

        }
    }
}
