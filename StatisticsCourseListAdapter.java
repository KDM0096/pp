package com.example.kdm.mytest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class StatisticsCourseListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;
    private String userID = MainActivity.userID;

    public StatisticsCourseListAdapter(Context context, List<Course> courseList, Fragment parent) {
        this.context = context;
        this.courseList = courseList;
        this.parent = parent;
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
        View v = View.inflate(context, R.layout.statistics, null);

        TextView crGrade = (TextView) v.findViewById(R.id.crGrade);
        TextView crTitle = (TextView) v.findViewById(R.id.crTitle);
        TextView crDivide = (TextView) v.findViewById(R.id.crDivide);
        TextView crPersonnal = (TextView) v.findViewById(R.id.crPersonnal);
        TextView crRate = (TextView) v.findViewById(R.id.crRate);

        if (courseList.get(i).getCrGrade().equals("제한 없음") || courseList.get(i).getCrGrade().equals("")) {
            crGrade.setText("모든 학년");
        } else {
            crGrade.setText(courseList.get(i).getCrGrade() + "학년");
        }
        crTitle.setText(courseList.get(i).getCrTitle());
        crDivide.setText(courseList.get(i).getCrDivide() + "분반");

        if (courseList.get(i).getCrPersonnal() == 0) {
            crPersonnal.setText("인원 제한없음");
            crRate.setText("");
        } else {
            crPersonnal.setText("신청인원 :" + courseList.get(i).getCrRival() + " / " + courseList.get(i).getCrPersonnal());
            int rate = ((int) (((double) courseList.get(i).getCrRival() * 100 / courseList.get(i).getCrPersonnal()) + 0.5));
            crRate.setText("경쟁률 : " + rate + "%");
            if (rate < 20) {
                crRate.setTextColor(parent.getResources().getColor(R.color.colorBlue));
            } else if (rate <= 50) {
                crRate.setTextColor(parent.getResources().getColor(R.color.colorWarning));
            } else if (rate <= 100) {
                crRate.setTextColor(parent.getResources().getColor(R.color.colorRed));
            } else if (rate <= 150) {
                crRate.setTextColor(parent.getResources().getColor(R.color.colorPrimary));
            } else {
                crRate.setTextColor(parent.getResources().getColor(R.color.colorSafe));
            }
        }
            v.setTag(courseList.get(i).getCrID());

            Button deleteButton = (Button) v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                AlertDialog dialog = builder.setMessage("강의 삭제 완료!")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                StatisticsFragment.totalCredit -= courseList.get(i).getCrCredit();
                                StatisticsFragment.credit.setText(StatisticsFragment.totalCredit + "학점");
                                courseList.remove(i);
                                notifyDataSetChanged();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getActivity());
                                AlertDialog dialog = builder.setMessage("강의 삭제 실패..")
                                        .setNegativeButton("다시 시도", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                DeleteRequest deleteRequest = new DeleteRequest(userID, courseList.get(i).getCrID() + "", responseListener);
                RequestQueue queue = Volley.newRequestQueue(parent.getActivity());
                queue.add(deleteRequest);
            }
        });

            return v;

        }
    }
