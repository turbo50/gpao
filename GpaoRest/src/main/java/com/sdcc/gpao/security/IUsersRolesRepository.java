package com.sdcc.gpao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRolesRepository extends JpaRepository<UsersRoles, Long> {

}
