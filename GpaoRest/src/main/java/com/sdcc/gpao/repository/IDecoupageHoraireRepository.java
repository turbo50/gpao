package com.sdcc.gpao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.DecoupageHoraire;

import java.time.LocalTime;
import java.util.Collection;
//import java.util.Date;

@Repository
public interface IDecoupageHoraireRepository extends JpaRepository<DecoupageHoraire, Integer> {
	@Query("SELECT d FROM DecoupageHoraire d WHERE d.heure between convert(time, :heureDeb) and convert(time, :heureFin)")
	public Collection<DecoupageHoraire> findDecoupageByHeure(@Param("heureDeb") LocalTime deb, @Param("heureFin")LocalTime fin);
	public Collection<DecoupageHoraire> findByHeureBetween(LocalTime deb, LocalTime fin);
}
