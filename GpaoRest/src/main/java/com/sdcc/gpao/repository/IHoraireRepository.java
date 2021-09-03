package com.sdcc.gpao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Horaire;


@Repository
public interface IHoraireRepository extends JpaRepository<Horaire, Integer> {

}
