package com.example.miniproject.simplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniproject.simplecrud.entities.newEntities;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository

public  interface newRepositories extends JpaRepository<newEntities, Integer>{

    //native query
    @Query(
            value = "SELECT * FROM new_table",
            nativeQuery = true
    )
    ArrayList<newEntities> getAllData();

//    @Modifying
//    @Query(
//            value = "UPDATE new_table tb SET ? WHERE tb.id = ?",
//            nativeQuery = true
//    )
//    @Transactional
//    void updateData(newEntities data, Integer id);

    @Query(
            value = "SELECT * FROM new_table WHERE new_table.id = ?",
            nativeQuery = true
    )
    newEntities getSingleData(Integer id);

    @Modifying
    @Query(
            value = "DELETE FROM new_table WHERE new_table.id = ?",
            nativeQuery = true
    )
    @Transactional
    void deleteSingleData(Integer id);

}
