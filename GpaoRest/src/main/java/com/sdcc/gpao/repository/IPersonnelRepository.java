package com.sdcc.gpao.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Personnel;
import com.sdcc.gpao.projection.PersonnelDTO;

@Repository
public interface IPersonnelRepository extends JpaRepository<Personnel, Integer> {
	@Query("select new com.sdcc.gpao.projection.PersonnelDTO(p.nom, p.matricule) from Personnel p")
	Collection<PersonnelDTO> findAllPersonnel();
}
