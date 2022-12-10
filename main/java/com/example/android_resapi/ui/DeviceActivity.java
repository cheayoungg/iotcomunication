package com.example.android_resapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android_resapi.R;
import com.example.android_resapi.ui.apicall.GetThingShadow;
import com.example.android_resapi.ui.apicall.UpdateShadow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Timer;
import java.util.TimerTask;

public class DeviceActivity extends AppCompatActivity {
    String urlStr;
    final static String TAG = "AndroidAPITest";
    Timer timer;
    Button startGetBtn;
    Button stopGetBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        Intent intent = getIntent();
        urlStr = intent.getStringExtra("thingShadowURL");

        startGetBtn = findViewById(R.id.startGetBtn);
        startGetBtn.setEnabled(true);
        startGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                                   @Override
                                   public void run() {
                                       new GetThingShadow(DeviceActivity.this, urlStr).execute();
                                   }
                               },
                        0,2000);

                startGetBtn.setEnabled(false);
                stopGetBtn.setEnabled(true);
            }
        });

        stopGetBtn = findViewById(R.id.stopGetBtn);
        stopGetBtn.setEnabled(false);
        stopGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null)
                    timer.cancel();
                startGetBtn.setEnabled(true);
                stopGetBtn.setEnabled(false);
            }
        });

        // /////////////////////////팬 세기 :0- 수동 ///////////////////////////////////////////////////
        Button fanspeedBtn0 = findViewById(R.id.fanspeed_0);
        fanspeedBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanspeed0_input = "0";
                    if (fanspeed0_input != null && !fanspeed0_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fanled");
                        tag1.put("tagValue", fanspeed0_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"세기: 0", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
        Button fanspeedBtn1 = findViewById(R.id.fanspeed_1);
        fanspeedBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanspeed1_input = "1";
                    if (fanspeed1_input != null && !fanspeed1_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fanled");
                        tag1.put("tagValue", fanspeed1_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"세기: 1", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
        Button fanspeedBtn2 = findViewById(R.id.fanspeed_2);
        fanspeedBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanspeed2_input = "2";
                    if (fanspeed2_input != null && !fanspeed2_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fanled");
                        tag1.put("tagValue", fanspeed2_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"세기: 2", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
        Button fanspeedBtn3 = findViewById(R.id.fanspeed_3);
        fanspeedBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanspeed3_input = "3";
                    if (fanspeed3_input != null && !fanspeed3_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fanled");
                        tag1.put("tagValue", fanspeed3_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"세기: 3", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////팬방향 : 수동 ////////////////////////////////////////////////////
        Button fanBtnB = findViewById(R.id.fandirect_back);
        fanBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanB_input = "Back";
                    if (fanB_input != null && !fanB_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fan");
                        tag1.put("tagValue", fanB_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"fan방향: BACK", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
        Button fanBtnS = findViewById(R.id.fandirect_stop);
        fanBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanS_input = "Stop";
                    if (fanS_input != null && !fanS_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fan");
                        tag1.put("tagValue", fanS_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"fan방향: STOP", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
        Button fanBtnF = findViewById(R.id.fandirect_front);
        fanBtnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject payload = new JSONObject();

                try {
                    JSONArray jsonArray = new JSONArray();
                    String fanF_input = "Front";
                    if (fanF_input != null && !fanF_input.equals("")) {
                        JSONObject tag1 = new JSONObject();
                        tag1.put("tagName", "fan");
                        tag1.put("tagValue", fanF_input);

                        jsonArray.put(tag1);
                    }
                    if (jsonArray.length() > 0)
                        payload.put("tags", jsonArray);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                Log.i(TAG,"payload="+payload);
                if (payload.length() >0 ) {
                    Toast.makeText(DeviceActivity.this,"fan방향: FRONT", Toast.LENGTH_SHORT).show();
                    new UpdateShadow(DeviceActivity.this, urlStr).execute(payload);
                }
                else
                    Toast.makeText(DeviceActivity.this,"변경할 상태 정보를 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
