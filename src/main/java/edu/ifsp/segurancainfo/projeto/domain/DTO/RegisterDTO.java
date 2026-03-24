package edu.ifsp.segurancainfo.projeto.domain.DTO;

import edu.ifsp.segurancainfo.projeto.domain.users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
