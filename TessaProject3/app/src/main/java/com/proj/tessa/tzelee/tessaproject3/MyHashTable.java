package com.proj.tessa.tzelee.tessaproject3;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import android.util.Log;


/**
 * Created by tzelee on 8/8/15.
 */
public class MyHashTable {

    private final String debugTag = "MyHashTable";
    private ArrayList<DictionaryObject> arrList = new ArrayList<DictionaryObject>();

    public boolean add(String key, String value)
    {
        if(key == null || key.length() <= 0)
        {
            Log.v(debugTag, "Cannot add - key not valid");
            return false;
        }
        if(value == null || value.length() < 0)
        {
            value = "";
        }
        DictionaryObject dictionaryObject = new DictionaryObject(key, value);
        arrList.add(dictionaryObject);
        return true;
    }
    public boolean remove(String key)
    {
        int index = 0;
        if(key != null && key.length() > 0)
        {
            for(DictionaryObject obj : this.arrList)
            {
                index++;
                if(obj.getKey() == key)
                {
                    this.arrList.remove(index);
                    return true;
                }
            }
        }
        return false;
        // Loop through all and remove this key.
    }
    public DictionaryObject doesKeyExist(String key)
    {
        if(key != null && key.length() > 0)
        {
            for(DictionaryObject obj : this.arrList)
            {
                if(obj.getKey() == key)
                {
                    return obj;
                }
            }
        }
        return null;
    }
    public String getValue(String key)
    {
        if(key != null && key.length() > 0)
        {
            DictionaryObject dobj = this.doesKeyExist(key);
            if(dobj != null)
            {
                return dobj.getValue();
            }
        }
        return "";
    }
    public int printHashTable()
    {
        int length = 0;
        if(!this.arrList.isEmpty())
        {
            for(DictionaryObject obj : this.arrList)
            {
                Log.v(debugTag, " Key: " + obj.getKey() + "--- Value: " + obj.getValue());
                length++;
            }
        }
        return length;
    }
}
