package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demoapplication.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private List<userModelClass> userList;
    String url = "https://reqres.in/api/users?page=2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userList= new ArrayList<>();
        getData();

    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray =response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        userModelClass userModelClass = new userModelClass();
                        userModelClass.setId(object.getString("id").toString());
                        userModelClass.setUserEmail(object.getString("email").toString());
                        userModelClass.setFirstName(object.getString("first_name").toString());
                        userModelClass.setLastName(object.getString("last_name").toString());
                        userModelClass.setUserProfile(object.getString("avatar"));
                        userList.add(userModelClass);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                userAdapter adapter =new userAdapter(getApplicationContext(),userList);
                binding.recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }
}