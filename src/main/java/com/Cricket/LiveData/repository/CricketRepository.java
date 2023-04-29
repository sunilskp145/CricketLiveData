package com.Cricket.LiveData.repository;

import com.Cricket.LiveData.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CricketRepository extends JpaRepository<TableEntity,String> {

    List<TableEntity> findAll();

}
