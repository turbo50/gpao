package com.sdcc.gpao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Usine;


@Repository
public interface IUsineRepository extends JpaRepository<Usine, Integer> {
	
}
