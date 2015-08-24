package com.proj.tessa.tzelee.tessaproject3;

import android.graphics.Bitmap;

import java.security.Key;
import java.util.Hashtable;

/**
 * Created by tzelee on 7/26/15.
 */
public class NativeLRU {

    // LRU class that only saves the top three images in memory
    // 1. create a has table with key as file name
    // 2. Create a bit map for each image..
    // 3. Retrive logic
    // 4. Expunge logic

    private Hashtable<String, Bitmap> lruCacheMap = new Hashtable();

    public boolean isLRUEmpty()
    {
        return lruCacheMap.isEmpty();
    }

    public void expunge()
    {
        lruCacheMap.clear();
    }
    public boolean putItem(String cacheKey, Bitmap bitMapAssset)
    {
        if(!lruCacheMap.containsKey(cacheKey))
        {
            lruCacheMap.put(cacheKey, bitMapAssset);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Bitmap getItem(String cacheKey)
    {
        if(cacheKey != null && lruCacheMap.containsKey(cacheKey))
        {
            return lruCacheMap.get(cacheKey);
        }
        else
        {
            return null;
        }
    }
    /*
    public Bitmap getCacheBitMap(string cacheKey)
    {
        return new Bitmap();

    }
    */



}
