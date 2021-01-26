package com.example.my123;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MenuItem menuItemcsgo,menuItemdota2,menuItemlol;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] pageTitle = {"All Games", "Live", "Finished"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        textView=findViewById(R.id.url);
        textView.setText("textView.setText(\"https://api.pandascore.co/lol/\");");

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuItemcsgo=menu.findItem(R.id.csgo_item);
        menuItemdota2=menu.findItem(R.id.dota2_item);
        menuItemlol=menu.findItem(R.id.lol_item);
        if (getFromSP("cec1")){
            menuItemcsgo.setChecked(true);
            textView.setText("https://api.pandascore.co/csgo/");
//            BASE_URL= getString(R.string.BASE_URL_CSGO);
        }

        if (getFromSP("cec2")){

            menuItemlol.setChecked(true);
            textView.setText("https://api.pandascore.co/lol/");

//            BASE_URL= getString(R.string.BASE_URL_LOL);
        }

        if (getFromSP("cec3")){

            menuItemdota2.setChecked(true);
            textView.setText("https://api.pandascore.co/dota2/");
//            BASE_URL= getString(R.string.BASE_URL_DOTA2);
        }

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.csgo_item) {
            item.setChecked(true);
            textView.setText("https://api.pandascore.co/csgo/");

//            BASE_URL= getString(R.string.BASE_URL_DOTA2);
            saveInSp("cec1","cec2","cec3",true,false,false);
//            adapter.mFragments.remove(2);
            return true;
        }
        if (id == R.id.lol_item) {
            item.setChecked(true);
            textView.setText("https://api.pandascore.co/lol/");
//            BASE_URL= getString(R.string.BASE_URL_LOL);
            saveInSp("cec1","cec2","cec3",false,true,false);
            return true;
        }
        if (id == R.id.dota2_item) {
            item.setChecked(true);
            textView.setText("https://api.pandascore.co/dota2/");
//            BASE_URL= getString(R.string.BASE_URL_DOTA2);
            saveInSp("cec1","cec2","cec3",false,false,true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean getFromSP(String key){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    private void saveInSp(String key,String key1,String key2,boolean value,boolean value1,boolean value2){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.putBoolean(key1, value1);
        editor.putBoolean(key2, value2);
        editor.commit();
    }

}