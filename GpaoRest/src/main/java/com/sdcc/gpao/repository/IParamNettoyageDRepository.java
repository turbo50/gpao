package com.sdcc.gpao.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.ParamNettoyageD;


@Repository
public interface IParamNettoyageDRepository extends JpaRepository<ParamNettoyageD, Integer> {
	@Query(value = "Select * from paramNettoyageD where id_planning = (select top 1 id_planning from planning where date_planning = :date)", nativeQuery = true)
	public Collection<ParamNettoyageD> findByDate(LocalDate date);
}
