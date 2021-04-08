package com.example.miniproject.simplecrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.miniproject.simplecrud.repositories.newRepositories;
import com.example.miniproject.simplecrud.response.responseData;
import com.example.miniproject.simplecrud.response.responseGenerator;
import com.example.miniproject.simplecrud.entities.newEntities;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/miniCRUD")
public class newController {

    @Autowired
    newRepositories newRepositories;

    @Autowired
    responseGenerator responseAPI;

    @GetMapping(value = "mainPage")
    public responseData<String> Hello() {
        return responseAPI.successResponse("Hello", "success");
    }


    @PostMapping(
            value = "addNewUser",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public responseData<String> addNewUser(newEntities param) {

        newRepositories.save(param);
        return responseAPI.successResponse(param, "success menambahkan data baru");
    }

    @GetMapping(value = "getAllUser")
    public responseData<List<newEntities>> getAllUser() {

        ArrayList arrayList = newRepositories.getAllData();

        return responseAPI.successResponse(arrayList, "Succes get All User");
    }

    @GetMapping(value = "getUserById")
    public responseData<newEntities> getUserById(@RequestParam int id) {
        newEntities data = newRepositories.findById(id).get();

        return responseAPI.successResponse(data, "Sukses mendapatkan data");

    }

    @PatchMapping(
            value = "updateUser",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public responseData<String> updateUser(newEntities param, @RequestParam int id) {
//         newRepositories.updateData(param, id);
        param.id = id;
        newRepositories.save(param);
//         return responseAPI.successResponse(param, "Sukses update pada ID : "+id);
        return responseAPI.successResponse(param, "Update pada ID " + id);
    }

    @DeleteMapping(value = "deleteUser")
    public responseData<String> deleteUser(@RequestParam int id) {
        newEntities data = newRepositories.findById(id).get();
        newRepositories.deleteById(id);
        return responseAPI.successResponse(data, "Sukses menghapus data pada ID : " + id);
    }
}
