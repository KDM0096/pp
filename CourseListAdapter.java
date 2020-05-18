package com.example.kdm.mytest;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;
    private String userID = MainActivity.userID;
    private Schedule schedule= new Schedule();
    private List<Integer> crIDList;
    public static int totalCredit = 0;

    public CourseListAdapter(Context context, List<Course> courseList, Fragment parent) {
        this.context = context;
        this.courseList = courseList;
        this.parent = parent;
        crIDList = new ArrayList<Integer>();
        new BackgroundTask().execute();
        totalCredit = 0;

    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.course, null);

        TextView crGrade = (TextView) v.findViewById(R.id.crGrade);
        TextView crTitle = (TextView) v.findViewById(R.id.crTitle);
        TextView crCredit = (TextView) v.findViewById(R.id.crCredit);
        TextView crDivide = (TextView) v.findViewById(R.id.crDivide);
        TextView crPersonnal = (TextView) v.findViewById(R.id.crPersonnal);
        TextView crProfessor = (TextView) v.findViewById(R.id.crProfessor);
        TextView crTime = (TextView) v.findViewById(R.id.crTime);

        if (courseList.get(i).getCrGrade().equals("제한 없음") || courseList.get(i).getCrGrade().equals("")) {
            crGrade.setText("모든 학년");
        } else {
            crGrade.setText(courseList.get(i).getCrGrade() + "학년");
        }
        crTitle.setText(courseList.get(i).getCrTitle());
        crCredit.setText(courseList.get(i).getCrCredit() + "학점");
        crDivide.setText(courseList.get(i).getCrDivide() + "분반");

        if (courseList.get(i).getCrPersonnal() == 0) {
            crPersonnal.setText("인원 제한없음");
        }
        else
            {
            crPersonnal.setText("제한인원 :" + courseList.get(i).getCrPersonnal() + "명");
        }
        if (courseList.get(i).getCrPersonnal() == 0)
        {
            crProfessor.setText("개인연구");
        }
        else {
            crProfessor.setText(courseList.get(i).getCrProfessor() + "교수님");
        }
        crTime.setText(courseList.get(i).getCrTime() + "");

        v.setTag(courseList.get(i).getCrID());

        Button addButton = (Button) v.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validate = false;
                   validate = schedule.validate(courseList.get(i).getCrTime());
                if (!alreadyIn(crIDList, courseList.get(i).getCrID())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                    AlertDialog dialog = builder.setMessage("이미 추가된 강의입니다!")
                            .setPositiveButton("다시 시도", null)
                            .create();
                    dialog.show();
                }
                else if(totalCredit + courseList.get(i).getCrCredit() > 24)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                    AlertDialog dialog = builder.setMessage("학점은 24학점이 최대입니다")
                            .setPositiveButton("다시 시도" , null)
                            .create();
                    dialog.show();
                }
                else if(validate == false)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                    AlertDialog dialog = builder.setMessage("강의 시간이 중복됩니다")
                            .setPositiveButton("다시 시도" , null)
                            .create();
                    dialog.show();
                } else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                    AlertDialog dialog = builder.setMessage("강의 추가 완료!")
                                            .setPositiveButton("확인", null)
                                            .create();
                                    dialog.show();
                                    crIDList.add(courseList.get(i).getCrID());
                                    schedule.addSchedule(courseList.get(i).getCrTime());
                                    totalCredit += courseList.get(i).getCrCredit();
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                    AlertDialog dialog = builder.setMessage("강의 추가 실패..")
                                            .setNegativeButton("확인", null)
                                            .create();
                                    dialog.show();
                                }
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    };
                    AddRequest addRequest = new AddRequest(userID, courseList.get(i).getCrID() + "", responseListener);
                    RequestQueue queue = Volley.newRequestQueue(parent.getActivity());
                    queue.add(addRequest);
                }
            }
        });
        return  v;
    }


    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute() {
            try {
                target = "http://222.117.131.189:80/ScheduleList.php?userID=" + URLEncoder.encode(userID, "UTF-8");
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String crProfessor;
                String crTime;
                int crID;
                totalCredit = 0;
                while(count < jsonArray.length()) {
                    JSONObject object = jsonArray.getJSONObject(count);
                    crID = object.getInt("crID");
                    crProfessor = object.getString("crProfessor");
                    crTime = object.getString("crTime");
                    totalCredit += object.getInt("crCredit");
                    crIDList.add(crID);
                    schedule.addSchedule(crTime);
                    count++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



    public boolean alreadyIn(List<Integer> crIDList, int item)
    {
        for (int i =0; i<crIDList.size(); i++)
        {
            if(crIDList.get(i) == item)
            {
                return false;
            }
        }
        return true;
    }

}
