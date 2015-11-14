package com.proj.tessa.tzelee.tessaproject3;


import android.test.ActivityInstrumentationTestCase2;
/**
 * Created by tzelee on 11/7/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest()
    {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void testClickSetting()
    {

    }
}
