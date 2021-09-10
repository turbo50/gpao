package com.sdcc.gpao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Chauffeur;


@Repository
public interface IChauffeurRepository extends JpaRepository<Chauffeur, Integer> {

}
