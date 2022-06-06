package com.example.callbacktest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YtsData {

    private String status;
    @SerializedName("status_message") // 이 이름으로 들어오는 키 값을 객체로 직렬화
    @Expose // object 중 해당 값이 null일 경우, json으로 만들 필드를 자동 생략
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
