package com.begentgroup.sampletab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class FragmentTabActivity extends AppCompatActivity {

    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);
        tabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("TAB1"),
                OneFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("TAB2"),
                TwoFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("TAB3"),
                ThreeFragment.class, null);


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if ("tab2".equals(s)) {
                    Toast.makeText(FragmentTabActivity.this, "tab2 click", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tabHost.setCurrentTabByTag("tab2");
    }


    public void receiveText(String text) {
        Fragment f = getSupportFragmentManager()
                .findFragmentByTag("tab3");
        if (f != null) {
            ((ThreeFragment)f).setMessage(text);
        } else {
            savedMessage = text;
        }
        tabHost.setCurrentTabByTag("tab3");
    }

    public String getSavedMessage() {
        return savedMessage;
    }

    String savedMessage = null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fragment_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId() == R.id.menu_am1) {
            Toast.makeText(this, "AM1 click", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
