package org.nagyza.cardealer.advice.ErrorMessage;

import java.util.Date;

public class ErrorMessage {
    private int httpResponseValue;
    private Date date;
    private String message;
    private String description;

    public ErrorMessage(int httpResponseValue, Date date, String message, String description) {
        this.httpResponseValue = httpResponseValue;
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public int getHttpResponseValue() {
        return httpResponseValue;
    }

    public void setHttpResponseValue(int httpResponseValue) {
        this.httpResponseValue = httpResponseValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
