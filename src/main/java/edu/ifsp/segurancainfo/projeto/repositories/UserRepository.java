package edu.ifsp.segurancainfo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<edu.ifsp.segurancainfo.projeto.domain.users.User, String> {

    UserDetails findByLogin(String login);
}
