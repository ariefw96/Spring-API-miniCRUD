package com.example.miniproject.simplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniproject.simplecrud.entities.newEntities;

import java.util.ArrayList;

@Repository

public  interface newRepositories extends JpaRepository<newEntities, Integer>{

    //native query
    @Query(
            value = "SELECT * FROM new_table",
            nativeQuery = true)
    ArrayList<newEntities> getAllData();

    @Query(
            value = "UPDATE new_table SET = :data WHERE id = :id",
            nativeQuery = true
    )
    void updateData(@Param("data") newEntities data, @Param("id") Integer id);

}
