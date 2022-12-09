package com.example.cameratest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private ListView listView =(ListView)findViewById(R.id.listView);
    private ListView listView;
    //ArrayList<MyItem> Item = new ArrayList<MyItem>();
    //ArrayList<MyItem> Item;
    //MyAdapter adapter= new MyAdapter(this, R.layout.item, Item);
    MyAdapter adapter;
    MyItem myIem1,myItem2,myItem3;
    Button btnCamera;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 디자인 정의
        btnCamera = (Button) findViewById(R.id.btnPhoto);
        imageView = (ImageView) findViewById(R.id.imageView);
        //listView =(ListView)findViewById(R.id.listView);
        btnCamera.setOnClickListener(this);   // 카메라 버튼 누르면 , 저장

        ////어댑터 생성
        //        adapter = new MyAdapter(this, R.layout.item, data);
        //
        //        //어댑터 연결
        //        ListView listView = (ListView)findViewById(R.id.listView);
        //ArrayList<MyItem> Item = new ArrayList<MyItem>();
        //adapter= new MyAdapter(this, R.layout.item, Item);
        //listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 카메라촬영 클릭 이벤트
            case R.id.btnPhoto:
                // 카메라 기능을 Intent
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)    {  //새로 불리는 엑티비티여기서 이미지 삽입
        super.onActivityResult(requestCode, resultCode, data);
        listView =(ListView)findViewById(R.id.listView);

        // 카메라 촬영을 하면 이미지뷰에 사진 삽입
        if(requestCode == 0 && resultCode == RESULT_OK) {
            //        // 데이터 원본 준비 : 7개의 사진 리스트
            // listView =(ListView)findViewById(R.id.listView);
            // ArrayList<MyItem> data = new ArrayList<MyItem>();
            //
            // data.add(new MyItem(imageBitmap, "x"));
            //


            ArrayList<MyItem> Item = new ArrayList<MyItem>();
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            //int count;
            //count = adapter.getCount();

            // 이미지뷰에 Bitmap으로 이미지를 입력 -> 리스트뷰의 imageView에 이미지 입력
           //imageView.setImageBitmap(imageBitmap);
            Item.add(new MyItem(imageBitmap, "x" ));

            adapter= new MyAdapter(this, R.layout.item, Item);
            listView.setAdapter(adapter);
        }
    }
}