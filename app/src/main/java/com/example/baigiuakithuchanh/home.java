package com.example.baigiuakithuchanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {
    private FrameLayout viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Danh sách công an");

        viewPager = findViewById(R.id.view_page);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.view_page,new listview()).commit();
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment seletedFragmet = null;
                switch (item.getItemId())
                {
                    case R.id.menu_tab1:
                        seletedFragmet = new listview();
                        setTitle("Danh sách công an");
                        break;
                    case R.id.menu_tab2:
                        seletedFragmet = new profile();
                        setTitle("Profile");
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.view_page,seletedFragmet).commit();

            }
        });




    }
}