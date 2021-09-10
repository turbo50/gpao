package com.sdcc.gpao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Reception;

@Repository
public interface IReceptionRepository extends JpaRepository<Reception, Integer> {

}
