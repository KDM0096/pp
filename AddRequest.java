package com.example.kdm.mytest;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddRequest extends StringRequest {

    final static private String URL = "http://222.117.131.189/CourseAdd.php";
    private Map<String, String> parameters;

    public AddRequest(String userID, String crID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("crID", crID);

    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}