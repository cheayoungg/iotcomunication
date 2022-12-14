package com.example.cameratest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context mContext =null;
    private int layout = 0;
    //private int mResource; // 이미지 리소스
    //Bitmap mimageBitmap ; // 이미지데이터
    private ArrayList<MyItem> mItems = null;  // data = mItems
    private LayoutInflater inflater = null;

    public MyAdapter(Context context, int l, ArrayList<MyItem> items) {
        // Context context, Bitmap imageBitmap, ArrayList<MyItem> items
        this.mContext = context;
        this.mItems = items;
        this.layout = l;
        this.mItems = items;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // mimageBitmap = imageBitmap;
        //mResource = resource;
    }

    // MyAdapter 클래스가 관리하는 항목의 총 개수를 반환
    @Override
    public int getCount() {
        return mItems.size();
    }

    // MyAdapter 클래스가 관리하는 항목의 중에서 position 위치의 항목을 반환
    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    // 항목 id를 항목의 위치로 간주함
    @Override
    public long getItemId(int position) {
        return position;
    }

    // position 위치의 항목에 해당되는 항목뷰를 반환하는 것이 목적임
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) { // 해당 항목 뷰가 이전에 생성된 적이 없는 경우
            //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 항목 뷰를 정의한 xml 리소스(여기서는 mResource 값)으로부터 항목 뷰 객체를 메모리로 로드
            convertView = inflater.inflate(this.layout, parent,false);
            // convertView = inflater.inflate(mResource, parent,false);
        }

        // convertView 변수로 참조되는 항목 뷰 객체내에 포함된 이미지뷰 객체를 id를 통해 얻어옴
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        // 어댑터가 관리하는 항목 데이터 중에서 position 위치의 항목의 이미지 리소스를 이미지뷰 객체에 설정
        icon.setImageBitmap(mItems.get(position).imageBitmap);

        // convertView 변수로 참조되는 항목 뷰 객체내에 포함된 텍스트뷰 객체를 id를 통해 얻어옴
        TextView name = (TextView) convertView.findViewById(R.id.textItem1);
        // 어댑터가 관리하는 항목 데이터 중에서 position 위치의 항목의 문자열을 설정 텍스트뷰 객체에 설정
        name.setText(mItems.get(position).nCheck);

        return convertView;
    }
}

