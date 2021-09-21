package com.sdcc.gpao.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Chauffeur;
import com.sdcc.gpao.projection.IChauffeurDTO;


@Repository
public interface IChauffeurRepository extends JpaRepository<Chauffeur, Integer> {
	<T> Collection<T> findAllProjectedBy(Class<T> projectionClass);
}
