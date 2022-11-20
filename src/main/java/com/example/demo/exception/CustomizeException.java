package com.example.demo.exception;

import com.example.demo.entities.Popup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CustomizeException extends RuntimeException {

    private int responseCode;

    private Object data;

    private Popup message;

    public CustomizeException(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(Popup message) {
        this.message = message;
    }
}
