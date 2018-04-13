package com.example.cm.learning_mobile.MODEL;

/**
 * Created by cm on 27/11/2017.
 */

public class data {

    String title;
    String number;

    public data(String number ,String title) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
