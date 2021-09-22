package com.sdcc.gpao.security;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
	//@Query(value = "select * from roles where id_roles in (select id_roles from users_roles where id_users = :id)", nativeQuery = true)
	@Query("select ur.idRoles from UsersRoles ur where ur.idUsers.idUsers=?1")
	Collection<Roles> getRoles(Long id);
	
	//@Query( value = "select * from roles where id_roles in (select id_roles from users_roles where id_users = (select id_users from users where login =:log and password=:pass))", nativeQuery=true)
	@Query("select ur.idRoles from UsersRoles ur where ur.idUsers.login=?1 and ur.idUsers.password=?2")
	Collection<Roles> getRoles(String login, String password);
	
	Optional<Users> findByLogin(String login);
}
