package com.proj.tessa.tzelee.tessaproject3;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by tzelee on 8/8/15.
 */
public class MyStack {

    private ArrayList<String> arrayList = new ArrayList<String>();
    private final String debugTag = "MyStack";

    /*
    public boolean isEmpty()
    {
        return this.arrayList != null && !this.arrayList.isEmpty();
    }
    */
    public boolean push(String value)
    {
        if(this.arrayList != null)
        {
            this.arrayList.add(value);
            Log.v(debugTag, " Pushing " + value);
            return true;
        }
        return false;
    }
    public String pop()
    {
        if(this.arrayList != null)
        {
            int index = arrayList.size() - 1;
            Log.v(debugTag, " Size " + index);

            String removedValue = arrayList.get(index);
            arrayList.remove(index);
            Log.v(debugTag, " Poping " + removedValue);

            return removedValue;
        }
        return null;
    }
    public void clear()
    {
        this.arrayList = new ArrayList<String>();
    }
    public int length()
    {
        return arrayList.size();
    }
    public void printStack()
    {
        if(this.arrayList != null)
        {
            for(String i : this.arrayList)
            {
                Log.v(debugTag, " debug print: " + i);
            }
        }
    }
    public void enqueue(String value)
    {
        this.push(value);
    }
    public String dequeue()
    {
        String dequeuedValue = "";

        if(this.arrayList != null)
        {
            ArrayList<String> newArrayList = new ArrayList<String>();
            boolean isFirst = true;
            for (String x : this.arrayList)
            {
                if(isFirst)
                {
                    // remove this item
                    isFirst = false;
                    dequeuedValue = x;
                }
                else
                {
                    newArrayList.add(x);
                }
            }
            this.arrayList = newArrayList;
        }
        return dequeuedValue;
    }
}
