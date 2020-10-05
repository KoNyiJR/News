package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
//
//    ListView listView;
//    public static List<Model> modelList = new ArrayList<>();
//    Model model;
//    Adapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        listView = findViewById(R.id.listView);
//
//        fetchData();
//    }
//
//    private void fetchData() {
//
//        String url = "http://newsapi.org/v2/top-headlines?country=in&apiKey=fc08ae6006214e6b97699edbc62992b6";
//
//
//
//        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("articles");
//                    int c =0;
//
//                    for (int i=0;i<jsonArray.length();i++)
//                    {
////                        JSONObject object = jsonArray.getJSONObject(i);
////
////                        String description = object.getString("description");
////                        String title = object.getString("title");
////                        String url = object.getString("url");
////                        String urlToImage = object.getString("urlToImage");
//
////                        model = new Model(urlToImage,url,description,title);
////                        modelList.add(model);
//                        c++;
//
//
//                    }
//
////                    adapter = new Adapter(MainActivity.this,modelList);
////                    listView.setAdapter(adapter);
//                    Toast.makeText(MainActivity.this,jsonArray.length() + " ",Toast.LENGTH_LONG).show();
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(request);
//
//    }
//}

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public static List<Model> modelList = new ArrayList<>();
    Model model;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        fetchData();
    }

    private void fetchData() {

        String url = "http://newsapi.org/v2/top-headlines?country=in&apiKey=fc08ae6006214e6b97699edbc62992b6";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("articles");

                    int c=0;
                    for(int i=0;i<jsonArray.length();i++)
                    {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String dec = jsonObject.getString("description");
                        String tit = jsonObject.getString("title");
                        String img = jsonObject.getString("urlToImage");

//                        c++;
//                        Toast.makeText(MainActivity.this,img + " ",Toast.LENGTH_LONG).show();

                        model = new Model(img,"0",dec,tit);
                        modelList.add(model);

                    }

                    adapter = new Adapter(MainActivity.this,modelList);
                    listView.setAdapter(adapter);





                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}