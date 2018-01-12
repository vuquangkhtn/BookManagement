package com.hcmus.study.bookmanagement.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.adaper.AuthorAdapter;
import com.hcmus.study.bookmanagement.adaper.BookAdapter;
import com.hcmus.study.bookmanagement.adaper.TopicAdapter;
import com.hcmus.study.bookmanagement.app.BookManagementApp;
import com.hcmus.study.bookmanagement.model.Author;
import com.hcmus.study.bookmanagement.model.AuthorManager;
import com.hcmus.study.bookmanagement.model.Book;
import com.hcmus.study.bookmanagement.model.BookList;
import com.hcmus.study.bookmanagement.model.Topic;
import com.hcmus.study.bookmanagement.utils.SharePrefHelper;
import com.hcmus.study.bookmanagement.utils.TopicFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View navHeader;
    private DrawerLayout drawer;
    private TextView txtName;
    private NavigationView navigationView;
    private ImageButton imbMenu;
    private TextView tvTitle;

    private RecyclerView rvTopicList;

    private RecyclerView rvItemList;
    private AuthorAdapter authorAdapter;
    private BookAdapter bookAdapter;
    private TopicAdapter topicAdapter;

    BookList bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

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
        final List<Topic> topicList = new ArrayList<>();//get data
        TopicFactory topicFactory = new TopicFactory();
        TopicFactory.TopicType arr[] = TopicFactory.TopicType.values();
        for (int i = 0; i < arr.length; i++) {
            topicList.add(topicFactory.getTopic(arr[i]));
        }
        rvTopicList = findViewById(R.id.rv_listTopic);
        rvTopicList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topicAdapter = new TopicAdapter(this);
        rvTopicList.setAdapter(topicAdapter);
        topicAdapter.setData(topicList);


        loadNavHeader();

        setUpNavigationView();

        //create test data

        bookList = new BookList();//get data
        for (int i=0;i < 10; i++) {
            Book book = new Book();
            book.name = "New Book " + i;
            book.publicYear = String.valueOf(i)+ "/12/2017";
            book.content = getResources().getString(R.string.content_test);
            bookList.addBook(book);
        }

        for (int i=0;i < 10; i++) {
            Author author = new Author();
            author.name = "Author "+i;
            author.nation = i%2==0? "Vietnam":"England";
            author.bookList = bookList.clone();
            AuthorManager.registerObject(author);
        }

        //view default
        setBookView();
    }


    public void openDrawer() {
        drawer.openDrawer(navigationView);
    }

    public void closeDrawer(){
        drawer.closeDrawer(navigationView);
    }

    private void loadNavHeader() {
        // name, website
        txtName.setText(SharePrefHelper.get().getString("username_pref"));
    }

    public void setBookView() {
        tvTitle.setText("Book");
        rvTopicList.setVisibility(View.VISIBLE);
//                        mViewPager.setCurrentItem(4);

        rvItemList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bookAdapter = new BookAdapter(this);
        rvItemList.setAdapter(bookAdapter);
        bookAdapter.setData(bookList.getListBook());
    }

    public void setAuthorView() {
        rvTopicList.setVisibility(View.GONE);
        tvTitle.setText("Author");
//                        mViewPager.setCurrentItem(2);
        rvItemList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        authorAdapter = new AuthorAdapter(this);
        rvItemList.setAdapter(authorAdapter);
        authorAdapter.setData(new ArrayList(AuthorManager.list.values()));
    }

    public void setFavorView() {
        tvTitle.setText("Favorite");
        rvTopicList.setVisibility(View.GONE);
//                        mViewPager.setCurrentItem(4);
        BookList books = new BookList();
        for(Book book: bookList.getListBook()) {
            if(book.isFavor) {
                books.addBook(book);
            }
        }

        rvItemList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bookAdapter = new BookAdapter(this);
        rvItemList.setAdapter(bookAdapter);
        bookAdapter.setData(books.getListBook());
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_book:
                        setBookView();
                        closeDrawer();
                        return true;
                    case R.id.nav_author:
                        setAuthorView();
                        closeDrawer();
                        return true;
                    case R.id.nav_favor:
                        setFavorView();
                        closeDrawer();
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
