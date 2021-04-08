package com.example.miniproject.simplecrud.controller;

import com.example.miniproject.simplecrud.entities.newEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.miniproject.simplecrud.response.responseData;
import com.example.miniproject.simplecrud.response.responseGenerator;
import com.example.miniproject.simplecrud.repositories.userRepositories;
import com.example.miniproject.simplecrud.entities.userEntities;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    responseGenerator responseAPI;

    @Autowired
    userRepositories user;

    @GetMapping(value = "")
    public String home(){
        return "Ini adalah endpoint User";
    }

    @GetMapping(value = "getAll")
    public responseData<List<newEntities>> getAllUser() {

        return responseAPI.successResponse(user.findAll(), "Succes get All User");
    }

    @PostMapping(
            value = "addNewUser",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public  responseData<String> addNewUser(userEntities param){
        user.save(param);
        return responseAPI.successResponse(param,"Sukses menambah user baru");
    }


    @GetMapping(value = "getSingleUser/{id}")
    public responseData<userEntities> getSingleUser(@PathVariable("id") Integer id){
        userEntities data = user.findById(id).get();
        return responseAPI.successResponse(data, "Sukses mendapatkan Data User");
    }

    @PatchMapping(
            value = "updateUserData/{id}",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public responseData<String> updateUserData (userEntities param, @PathVariable("id") Integer id){
        System.out.println(param);
        param.id = id;
        user.save(param);
        return  responseAPI.successResponse(param,"Sukses update data pada ID : "+id);
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public responseData<userEntities> deleteUser(@PathVariable("id") int id){
        userEntities data = user.findById(id).get();
        user.deleteById(id);
        return responseAPI.successResponse(data,"Sukses menghapus data pada ID : "+id);
    }




}
