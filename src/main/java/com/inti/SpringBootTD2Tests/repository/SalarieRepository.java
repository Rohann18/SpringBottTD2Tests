package com.inti.SpringBootTD2Tests.repository;

import com.inti.SpringBootTD2Tests.model.Salarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Integer> {

}
