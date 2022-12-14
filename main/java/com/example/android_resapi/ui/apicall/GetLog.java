package com.example.android_resapi.ui.apicall;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.example.android_resapi.R;
import com.example.android_resapi.httpconnection.GetRequest;
import com.example.android_resapi.ui.DeviceActivity;
import com.example.android_resapi.ui.DeviceTestActivity;
import com.example.android_resapi.ui.ListThingsActivity;

public class GetLog extends GetRequest {
    final static String TAG = "AndroidAPITest";
    String urlStr;
    public GetLog(Activity activity, String urlStr) {
        super(activity);
        this.urlStr = urlStr;
    }

    @Override
    protected void onPreExecute() {
        try {

//            TextView textView_Date1 = activity.findViewById(R.id.textView_date1);
//            TextView textView_Time1 = activity.findViewById(R.id.textView_time1);
//            TextView textView_Date2 = activity.findViewById(R.id.textView_date2);
//            TextView textView_Time2 = activity.findViewById(R.id.textView_time2);
//
//            String params = String.format("?from=%s:00&to=%s:00",textView_Date1.getText().toString()+textView_Time1.getText().toString(),
//                                                            textView_Date2.getText().toString()+textView_Time2.getText().toString());

            Log.i(TAG,"urlStr="+urlStr);//+params);
            url = new URL(urlStr);//+params);

        } catch (MalformedURLException e) {
            Toast.makeText(activity,"URL is invalid:"+urlStr, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        TextView message = activity.findViewById(R.id.message2);
        message.setText("조회중...");
    }

    @Override
    protected void onPostExecute(String jsonString) {
        TextView message = activity.findViewById(R.id.message2);
        if (jsonString == null) {
            message.setText("로그 없음");
            return;
        }
        message.setText("");
        ArrayList<Tag> arrayList = getArrayListFromJSONString(jsonString);

        final ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView txtList = activity.findViewById(R.id.logList);
        txtList.setAdapter(adapter);
        txtList.setDividerHeight(10);
        // 목록 누르면 상세정보로 이동
        txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Tag thing = (Tag)adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(activity, ListThingsActivity.class );
                //Intent intent = new Intent(activity, DeviceTestActivity.class );  // 0
                //  intent.putExtra("thingShadowURL", urlStr+"/"+thing.name);
                activity.startActivity(intent);
            }
        });
    }

    protected ArrayList<Tag> getArrayListFromJSONString(String jsonString) {
        ArrayList<Tag> output = new ArrayList();
        try {
            // 처음 double-quote와 마지막 double-quote 제거
            jsonString = jsonString.substring(1,jsonString.length()-1);
            // \\\" 를 \"로 치환
            jsonString = jsonString.replace("\\\"","\"");

            Log.i("kk", "jsonString!="+jsonString);

            JSONObject root = new JSONObject(jsonString);
            JSONArray jsonArray = root.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject)jsonArray.get(i);

                //////////////////iot클라우드 ////////////////
                /*
                Tag thing = new Tag(jsonObject.getString("dustsin"),
                                    jsonObject.getString("dustsout"),
                                    jsonObject.getString("fanled"),
                                    jsonObject.getString("fan"),
                                    jsonObject.getString("timestamp"));*/



                Tag thing = new Tag(jsonObject.getString("finded"),
                        jsonObject.getString("left"),
                        jsonObject.getString("right"),
                        jsonObject.getString("timestamp"));
                output.add(thing);
            }

        } catch (JSONException e) {
            //Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }

    class Tag {

        ////////////////////iot클라우드 ////////////////
        /*String dustsin;
        String dustsout;
        String fanled;
        String fan;
        String timestamp; */


        String finded;
        String left;
        String right;
        String timestamp;

        public Tag(String nfinded,String nleft,String nright,String ntimestamp) {
            //String ndust_s_in,String ndust_s_out,String nfan_led,String nfan,String ntimestamp
            //////////////////iot클라우드 ////////////////
            /*dustsin=ndust_s_in;
            dustsout=ndust_s_out;
            fanled=nfan_led;
            fan=nfan;
            timestamp=ntimestamp;*/




            finded=nfinded;
            left=nleft;
            right=nright;
            timestamp=ntimestamp;


        }

        public String toString() {
            //return String.format("[%s] Temperature1: %s,emperature1: %s, LED: %s", timestamp, temperature1,temperature2, LED);// 타임, 내부농도, 외부농도, 팬 세기

            ////////////////////iot클라우드 ////////////////
            /*return String.format("[%s] Dustsin: %s,Dustsout: %s, Fan: %s, Fanled: %s"
                    , timestamp, dustsin,dustsout,fan,fanled);*/




            return String.format("[%s] Finded: %s,Left: %s, Right: %s "
                    , timestamp, finded,left,right);

        }
    }
}