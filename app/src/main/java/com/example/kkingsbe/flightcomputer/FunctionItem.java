package com.example.kkingsbe.flightcomputer;

public class FunctionItem {
    private int mImageResource;
    private String mText;

    public FunctionItem(int imageResource, String text){
        mImageResource = imageResource;
        mText = text;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public String getText(){
        return mText;
    }
}
