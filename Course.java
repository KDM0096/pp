package com.example.kdm.mytest;

public class Course {

    int crID;
    String crUniversity;
    String crYear;
    String crTerm;
    String crArea;
    String crMajor;
    String crGrade;
    String crTitle;
    int crCredit;
    String crDivide;
    int crPersonnal;
    String crProfessor;
    String crTime;
    String crRoom;
    String crRate;
    int crRival; // 강의 경쟁자 수

    public int getCrID() {
        return crID;
    }

    public void setCrID(int crID) {
        this.crID = crID;
    }

    public String getCrUniversity() {
        return crUniversity;
    }

    public void setCrUniversity(String crUniversity) {
        this.crUniversity = crUniversity;
    }

    public String getCrYear() {
        return crYear;
    }

    public void setCrYear(String crYear) {
        this.crYear = crYear;
    }

    public String getCrTerm() {
        return crTerm;
    }

    public void setCrTerm(String crTerm) {
        this.crTerm = crTerm;
    }

    public String getCrArea() {
        return crArea;
    }

    public void setCrArea(String crArea) {
        this.crArea = crArea;
    }

    public String getCrMajor() {
        return crMajor;
    }

    public void setCrMajor(String crMajor) {
        this.crMajor = crMajor;
    }

    public String getCrGrade() {
        return crGrade;
    }

    public void setCrGrade(String crGrade) {
        this.crGrade = crGrade;
    }

    public String getCrTitle() {
        return crTitle;
    }

    public void setCrTitle(String crTitle) {
        this.crTitle = crTitle;
    }

    public int getCrCredit() {
        return crCredit;
    }

    public void setCrCredit(int crCredit) {
        this.crCredit = crCredit;
    }

    public String getCrDivide() {
        return crDivide;
    }

    public void setCrDivide(String crDivide) {
        this.crDivide = crDivide;
    }

    public int getCrPersonnal() {
        return crPersonnal;
    }

    public void setCrPersonnal(int crPersonnal) {
        this.crPersonnal = crPersonnal;
    }

    public String getCrProfessor() {
        return crProfessor;
    }

    public void setCrProfessor(String crProfessor) {
        this.crProfessor = crProfessor;
    }

    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
    }

    public String getCrRoom() {
        return crRoom;
    }

    public void setCrRoom(String crRoom) {
        this.crRoom = crRoom;
    }

    public Course(int crID, String crUniversity, String crYear, String crTerm, String crArea, String crMajor, String crGrade, String crTitle, int crCredit, String crDivide, int crPersonnal, String crProfessor, String crTime, String crRoom) {
        this.crID = crID;
        this.crUniversity = crUniversity;
        this.crYear = crYear;
        this.crTerm = crTerm;
        this.crArea = crArea;
        this.crMajor = crMajor;
        this.crGrade = crGrade;
        this.crTitle = crTitle;
        this.crCredit = crCredit;
        this.crDivide = crDivide;
        this.crPersonnal = crPersonnal;
        this.crProfessor = crProfessor;
        this.crTime = crTime;
        this.crRoom = crRoom;
    }

    public int getCrRival() {
        return crRival;
    }

    public void setCrRival(int crRival) {
        this.crRival = crRival;
    }

    public Course(int crID, String crGrade, String crTitle, String crDivide, int crPersonnal, int crRival) {
        this.crID = crID;
        this.crGrade = crGrade;
        this.crTitle = crTitle;
        this.crDivide = crDivide;
        this.crPersonnal = crPersonnal;
        this.crRival = crRival;
    }

    public Course(int crID, String crGrade, String crTitle, String crDivide, int crPersonnal, int crRival, int crCredit) {
        this.crID = crID;
        this.crGrade = crGrade;
        this.crTitle = crTitle;
        this.crDivide = crDivide;
        this.crPersonnal = crPersonnal;
        this.crRival = crRival;
        this.crCredit = crCredit;
    }
}
