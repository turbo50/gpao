package com.sdcc.gpao.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.NettoyageD;


@Repository
public interface INettoyageDRepository extends JpaRepository<NettoyageD, Integer> {

	@Query(value = "Select * from nettoyageD where id_planning = (select top 1 id_planning from planning where date_planning = :date)", nativeQuery = true)
	public Collection<NettoyageD> findByDate(LocalDate date);
}
