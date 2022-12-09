package com.example.cameratest;

import android.graphics.Bitmap;

public class MyItem {
    //int mIcon; // image resource
    Bitmap imageBitmap ; // 이미지데이터
    String nCheck; // text
    //String nAge;  // text

    MyItem(Bitmap aimageBitmap, String aCheck) { //int aIcon, String aCheck
        //Bitmap aimageBitmap, String aCheck
        imageBitmap = aimageBitmap;
        //mIcon = aIcon;
        nCheck = aCheck;
        //nAge = aAge;
    }
}
