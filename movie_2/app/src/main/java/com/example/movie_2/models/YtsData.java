package com.example.movie_2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YtsData {

    private String status;
    @SerializedName("stauts_message")
    @Expose
    private String statusMessage;
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
