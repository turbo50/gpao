package com.sdcc.gpao.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.ActiviteNettoyageD;


@Repository
public interface IActiviteNettoyageDRepository extends JpaRepository<ActiviteNettoyageD, Integer> {
	@Query(value = "Select * from ActiviteNettoyageD where id_planning = (select top 1 id_planning from planning where date_planning = :date)", nativeQuery = true)
	public Collection<ActiviteNettoyageD> findByDate(LocalDate date);
}
