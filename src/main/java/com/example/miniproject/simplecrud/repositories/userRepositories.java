package com.example.miniproject.simplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniproject.simplecrud.entities.userEntities;

public interface userRepositories extends JpaRepository<userEntities, Integer> {


}
