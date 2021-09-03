package com.sdcc.gpao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdcc.gpao.entity.Personnel;

@Repository
public interface IPersonnelRepository extends JpaRepository<Personnel, Integer> {
}
