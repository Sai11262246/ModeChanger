package com.vivartha.modechanger;

/**
 * created by vikas.
 * It is an background activity which allows user to grant the permission
 * to access the contacts, location and message.
 */

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.vivartha.modechanger.fragments.AboutFragment;
import com.vivartha.modechanger.fragments.HomeFragment;
import com.vivartha.modechanger.fragments.ModesFragment;
import com.vivartha.modechanger.fragments.NetworkFragment;
import com.vivartha.modechanger.fragments.OtherFragment;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class Home_Activity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener, ChnageFragmentListener {


    public static final int POS_HOME = 0;
    public static final int POS_MODES = 1;
    public static final int POS_NETWORK = 2;
    public static final int POS_OTHER = 3;
    public static final int POS_ABOUT = 4;

    public static final int POS_LOGOUT = 6;

    private String[] screenTitles;
    private Drawable[] screenIcons;
    private SlidingRootNav slidingRootNav;
    Toolbar toolbar;
    AppPreferences mAppPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        mAppPreferences = new AppPreferences(this);
        mAppPreferences.saveLoginStatte(1);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, GPSTracker.class);
        startService(intent);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenTitles = loadScreenTitles();
        screenIcons = loadScreenIcons();
        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_MODES),
                createItemFor(POS_NETWORK),
                createItemFor(POS_OTHER),
                createItemFor(POS_ABOUT),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);


        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_HOME);
        checkRuntimePermissions();
    }


    public void checkRuntimePermissions() {

        String str_per_phone_state = Manifest.permission.READ_PHONE_STATE;
        String str_per_loc1_state = Manifest.permission.ACCESS_COARSE_LOCATION;
        String str_per_loc2_state = Manifest.permission.ACCESS_FINE_LOCATION;

        String str_per_bt1_state = Manifest.permission.BLUETOOTH;
        String str_per_bt2_state = Manifest.permission.BLUETOOTH_ADMIN;

        String str_per_wifi1_state = Manifest.permission.ACCESS_WIFI_STATE;
        String str_per_wifi2_state = Manifest.permission.CHANGE_WIFI_STATE;

        String str_per_sms1_state = Manifest.permission.RECEIVE_SMS;
        String str_per_sms2_state = Manifest.permission.READ_SMS;
        String str_per_sms3_state = Manifest.permission.SEND_SMS;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int has_permission_state = checkSelfPermission(str_per_phone_state);
            int has_permission_loc1 = checkSelfPermission(str_per_loc1_state);
            int has_permission_loc2 = checkSelfPermission(str_per_loc2_state);
            int has_permission_bt1 = checkSelfPermission(str_per_bt1_state);
            int has_permission_bt2 = checkSelfPermission(str_per_bt2_state);
            int has_permission_wifi1 = checkSelfPermission(str_per_wifi1_state);
            int has_permission_wifi2 = checkSelfPermission(str_per_wifi2_state);
            int has_permission_sms1 = checkSelfPermission(str_per_sms1_state);
            int has_permission_sms2 = checkSelfPermission(str_per_sms2_state);
            int has_permission_sms3 = checkSelfPermission(str_per_sms3_state);

            if (has_permission_state != PackageManager.PERMISSION_GRANTED ||
                    has_permission_loc1 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_loc2 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_bt1 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_bt2 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_wifi1 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_wifi2 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_sms1 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_sms2 != PackageManager.PERMISSION_GRANTED ||
                    has_permission_sms3 != PackageManager.PERMISSION_GRANTED ) {
                String[] persmisions = new String[]{str_per_phone_state, str_per_loc1_state, str_per_loc2_state,
                        str_per_bt1_state, str_per_bt2_state, str_per_wifi1_state, str_per_wifi2_state,
                        str_per_sms1_state, str_per_sms2_state,str_per_sms3_state};
                requestPermissions(persmisions, 100);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[2] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[5] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[6] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[7] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[8] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[9] == PackageManager.PERMISSION_GRANTED) {

                }else{
                    checkRuntimePermissions();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    public void changeFragment(Fragment mFragment) {
        showFragment(mFragment);
    }

    @Override
    public void onItemSelected(int position) {
        slidingRootNav.closeMenu();
        if(position == POS_HOME){
            toolbar.setTitle("Home");
            Fragment selectedScreen = HomeFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }
        else if(position == POS_MODES){
            toolbar.setTitle("Modes");
            Fragment selectedScreen = ModesFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }else if(position == POS_NETWORK){
            toolbar.setTitle("Networks");
            Fragment selectedScreen = NetworkFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }else if(position == POS_OTHER){
            toolbar.setTitle("Other");
            Fragment selectedScreen = OtherFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }//else if(position == POS_CHANGE){
//            Fragment selectedScreen = ManifestViewerFragment.createFor(screenTitles[position]);
//            showFragment(selectedScreen);
//        }else if(position == POS_SETTINGS){
//            Fragment selectedScreen = ServeyFragment.createFor(screenTitles[position]);
//            showFragment(selectedScreen);
//        }

        else if (position == POS_ABOUT) {
            toolbar.setTitle("About");
            Fragment selectedScreen = AboutFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }

        else{
                logOut();
        }



    }

    private void logOut(){
        mAppPreferences.deletePref();
        startActivity(new Intent(Home_Activity.this, LoginActivity.class ));
        finish();
    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }


    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.colorPrimary))
                .withTextTint(color(R.color.colorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }


    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }
}
