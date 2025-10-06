package org.acme.dto.response;

import org.acme.model.Usuario;
import org.acme.model.enums.Sexo;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        Sexo sexo,
        String senha
) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getSexo(),
                usuario.getSenha()
        );
    }
}
