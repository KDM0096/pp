package com.example.kdm.mytest;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

public class Schedule {

    private String monday[] = new String[9];
    private String tuesday[] = new String[9];
    private String wednesday[] = new String[9];
    private String thursday[] = new String[9];
    private String friday[] = new String[9];

    public Schedule() {
        for (int i = 0; i < 9; i++) {
            monday[i] = "";
            wednesday[i] = "";
            tuesday[i] = "";
            thursday[i] = "";
            friday[i] = "";
        }
    }

    public void addSchedule(String scheduleText) {
        int temp;
        if ((temp = scheduleText.indexOf("월")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("수")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("목")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if ((temp = scheduleText.indexOf("금")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
    }



    public boolean validate(String scheduleText) {
        if (scheduleText.equals("")) {
            return true;
        }
        int temp;


        if ((temp = scheduleText.indexOf("월")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;

            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        if ((temp = scheduleText.indexOf("수")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        if ((temp = scheduleText.indexOf("목")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }

        if ((temp = scheduleText.indexOf("금")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    if (!friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void addSchedule(String scheduleText, String crTitle, String crProfessor) {
        String professor;
        if(crProfessor.equals(""))
        {
            professor = "";
        }
        else
        {
            professor = "";
        }
        int temp;
        if ((temp = scheduleText.indexOf("월")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = crTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("화")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = crTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("수")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = crTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("목")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = crTitle + professor;
                }
            }
        }
        if ((temp = scheduleText.indexOf("금")) > -1) {
            temp += 2;
            int startPoint = temp;
            int endPoint = temp;
            for (int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++) {
                if (scheduleText.charAt(i) == '[') {
                    startPoint = i;
                }
                if (scheduleText.charAt(i) == ']') {
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = crTitle + professor;
                }
            }
        }
    }



    public void setting(AutoResizeTextView[] monday, AutoResizeTextView[] tuesday, AutoResizeTextView[] wednesday, AutoResizeTextView[] thursday, AutoResizeTextView[] friday, Context context)
    {
        int maxLength = 0;
        String maxString = "";
        for(int i = 0; i <9; i++) {
            if(this.monday[i].length() > maxLength)
            {
                maxLength = this.monday[i].length();
                maxString = this.monday[i];
            }
        }

        for(int i = 0; i <9; i++) {
            if(this.tuesday[i].length() > maxLength)
            {
                maxLength = this.tuesday[i].length();
                maxString = this.tuesday[i];
            }
        }

        for(int i = 0; i <9; i++) {
            if(this.wednesday[i].length() > maxLength)
            {
                maxLength = this.wednesday[i].length();
                maxString = this.wednesday[i];
            }
        }

        for(int i = 0; i <9; i++) {
            if(this.thursday[i].length() > maxLength)
            {
                maxLength = this.thursday[i].length();
                maxString = this.thursday[i];
            }
        }

        for(int i = 0; i <9; i++) {
            if(this.friday[i].length() > maxLength)
            {
                maxLength = this.friday[i].length();
                maxString = this.friday[i];
            }
        }



        for(int i = 0; i <9; i++) {
            if(!this.monday[i].equals("")){
                monday[i].setText(this.monday[i]);
                monday[i].setTextColor(context.getResources().getColor(R.color.colorBlue));
            }
            else
            {
                monday[i].setText(maxString);
            }
            if(!this.tuesday[i].equals("")){
                tuesday[i].setText(this.tuesday[i]);
                tuesday[i].setTextColor(context.getResources().getColor(R.color.colorBlue));
            }
            else
            {
                tuesday[i].setText(maxString);
            }
            if(!this.wednesday[i].equals("")){
                wednesday[i].setText(this.wednesday[i]);
                wednesday[i].setTextColor(context.getResources().getColor(R.color.colorBlue));
            }
            else
            {
                wednesday[i].setText(maxString);
            }
            if(!this.thursday[i].equals("")){
                thursday[i].setText(this.thursday[i]);
                thursday[i].setTextColor(context.getResources().getColor(R.color.colorBlue));
            }
            else
            {
                thursday[i].setText(maxString);
            }
            if(!this.friday[i].equals("")){
                friday[i].setText(this.friday[i]);
                friday[i].setTextColor(context.getResources().getColor(R.color.colorBlue));
            }
            else
            {
                friday[i].setText(maxString);
            }
        }
    }
}
