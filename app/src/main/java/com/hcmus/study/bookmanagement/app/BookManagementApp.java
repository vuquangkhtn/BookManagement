package com.hcmus.study.bookmanagement.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.hcmus.study.bookmanagement.activity.WelcomeActivity;
import com.hcmus.study.bookmanagement.model.Account;
import com.hcmus.study.bookmanagement.utils.SharePrefHelper;

import java.io.File;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class BookManagementApp extends Application {

    private static BookManagementApp instance;

//    private RequestQueue mRequestQueue;
//    private Cache mCache;

    private Account mAccount;

    private BookManagementApp() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//        this.mCache = new DiskBasedCache(getCacheDir("main"), (getMainDiskCacheSizeInMb() * 1024) * 1024);
//        this.mRequestQueue = new RequestQueue(this.mCache, createNetwork(), 20);
//        this.mRequestQueue.start();

        mAccount = new Account();

    }

    public Account getAccount(){
        return mAccount;
    }

    public static BookManagementApp getApp() {
        return instance;
    }

    public void logout(Activity currentActivity) {
        SharePrefHelper.get().setString("username_pref", "");
        SharePrefHelper.get().setString("password_pref", "");
        Intent i = new Intent(currentActivity, WelcomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);


        Intent logoutIntent = new Intent("ACTION_LOGOUT");
        sendBroadcast(logoutIntent);
    }
}

