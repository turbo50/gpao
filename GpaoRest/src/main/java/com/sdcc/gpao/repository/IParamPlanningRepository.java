package com.sdcc.gpao.repository;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.ParamPlanning;

@Repository
public interface IParamPlanningRepository extends JpaRepository<ParamPlanning, Integer> {
	@Query(value = "SELECT * FROM ParamPlanning d WHERE d.date_base = (select max(date_base) from ParamPlanning)", nativeQuery = true)
	public Collection<ParamPlanning> getParamActuel();
	@Query(value = "SELECT top 4 * FROM ParamPlanning d WHERE d.date_base <= :date order by date_base desc", nativeQuery = true)
	public Collection<ParamPlanning> getParamEnDateDu(LocalDate date);
}
