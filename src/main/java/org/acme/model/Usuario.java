package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.acme.model.enums.Sexo;

@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(name = "uk_usuario_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_usuario_cpf", columnNames = "cpf")
})
public class Usuario extends DefaultEntity {
    @Column(nullable = false, length = 120)
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true, length = 160)
    private String email;

    @Column(nullable = false) // Impede valores nulos no banco
    @NotBlank(message = "A senha não pode ser nula ou vazia.") // Valida no backend
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 12)
    private Sexo sexo;

    @NotBlank
    @Column(nullable = false, length = 14)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}