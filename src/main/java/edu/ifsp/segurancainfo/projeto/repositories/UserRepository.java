package edu.ifsp.segurancainfo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import  edu.ifsp.segurancainfo.projeto.domain.users.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<UserDetails> findByLogin(String login);
}
