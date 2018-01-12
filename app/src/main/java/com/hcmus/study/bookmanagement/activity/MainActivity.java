package com.hcmus.study.bookmanagement.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.app.BookManagementApp;

public class MainActivity extends AppCompatActivity {

    private View navHeader;
    private DrawerLayout drawer;
    private TextView txtName;
    private NavigationView navigationView;
    private ImageButton imbMenu;
    private RecyclerView rvItemList;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);

        imbMenu = findViewById(R.id.imv_navi_menu);
        imbMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer();
            }
        });

        tvTitle = findViewById(R.id.tv_title);

        rvItemList = findViewById(R.id.rv_listItem);

        loadNavHeader();

        setUpNavigationView();

    }


    public void openDrawer() {
        drawer.openDrawer(navigationView);
    }

    public void closeDrawer(){
        drawer.closeDrawer(navigationView);
    }

    private void loadNavHeader() {
        // name, website
        txtName.setText(BookManagementApp.getApp().getAccount().user);
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_book:
//                        mViewPager.setCurrentItem(4);
                        tvTitle.setText("Book");
                        closeDrawer();
                        return true;
                    case R.id.nav_author:
//                        mViewPager.setCurrentItem(2);
                        closeDrawer();
                        tvTitle.setText("Author");
                        return true;
                    case R.id.nav_sign_out:
                        BookManagementApp.getApp().logout(MainActivity.this);
                        return true;
                }
                return true;
            }
        });
        drawer.closeDrawers();
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, navigationView);
    }


}
