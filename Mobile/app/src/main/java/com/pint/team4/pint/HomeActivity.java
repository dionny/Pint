package com.pint.team4.pint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pint.team4.pint.Network.PintAPI;
import com.pint.team4.pint.Network.RequestURL;
import com.pint.team4.pint.Storage.TokenManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private PintAPI pintAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        this.pintAPI = new HomeApiCalls();
    }

    @Override
    public void onClick(View v) {
        TokenManager.getTokenStore(getApplicationContext()).deleteToken();
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    private class HomeApiCalls implements PintAPI {

        private RequestQueue requestQueue;

        public HomeApiCalls() {
            this.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        @Override
        public void GetBloodDrivesByLocation(String city, String state) {
            StringRequest getBloodDriveByLocation = new StringRequest(Request.Method.GET, RequestURL.REQ_BD_BY_LOC,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray initArray = new JSONArray(response);
                                int length = initArray.length();

                                for(int i = 0; i < length; i++) {
                                    JSONObject bloodDrive = initArray.getJSONObject(i);


                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

        @Override
        public void GetUserNotifications(long userId) {
            //ArrayList<int[]> lists;
        }

        @Override
        public void GetBloodDriveNotifications(long bloodDriveId) {

        }
    }
}
