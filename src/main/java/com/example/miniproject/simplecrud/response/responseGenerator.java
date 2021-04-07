package com.example.miniproject.simplecrud.response;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class responseGenerator <T> {

    public <T> responseData <T> successResponse (T data, String message) {

        responseData responseData = new responseData <>();
        responseData.setStatus("200");
        responseData.setMessage(message);
        responseData.setData(data);

        return responseData;
    }

    public  <T> responseData <T> notFoundResponse (){
        responseData responseData = new responseData <> ();
        responseData.setStatus("404");
        responseData.setMessage("Data tidak ditemukan");
        responseData.setData("Kosong");

        return responseData;
    }

}
