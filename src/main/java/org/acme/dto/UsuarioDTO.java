package org.acme.dto;

import org.acme.model.enums.Sexo;

public record UsuarioDTO(

        String nome,
        String email,
        Sexo sexo,
        String cpf

) {
}
