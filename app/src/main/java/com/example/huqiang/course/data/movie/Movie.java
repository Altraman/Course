package com.example.huqiang.course.data.movie;

import java.util.List;

public class Movie {

    /**
     * count : 20
     * start : 0
     * total : 34
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private List<Subject> subjects;
    private String title;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
