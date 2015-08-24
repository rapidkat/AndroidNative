package com.proj.tessa.tzelee.tessaproject3;

/**
 * Created by tzelee on 8/8/15.
 */
public class DictionaryObject {
    private String key = "";
    private String value ="";
    public DictionaryObject(String key, String value)
    {
        this.key = key;
        this.value = value;
    }
    public String getKey()
    {
        return key;
    }
    public void setKey(String keyValue)
    {
        this.key = value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    public String getValue()
    {
        return this.value;
    }
}
