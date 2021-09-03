package com.sdcc.gpao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Quart;

@Repository
public interface IQuartRepository extends JpaRepository<Quart, Integer> {

}
