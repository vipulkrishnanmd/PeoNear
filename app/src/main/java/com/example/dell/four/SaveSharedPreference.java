package com.example.dell.four;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by DELL on 3/22/2017.
 */

public class SaveSharedPreference
{
    static final String PREF_USER_NAME= "username";
    static final String LOCATION_STRING = "location string";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static void clearUserName(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.commit();
    }

    public static void setLocationString(Context ctx, String locationString)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(LOCATION_STRING, locationString);
        editor.commit();
    }

    public static String getLocationString(Context ctx)
    {
        return getSharedPreferences(ctx).getString(LOCATION_STRING, "");
    }

}