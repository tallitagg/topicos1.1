package org.acme.model;

public enum Sexo {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");

    private Integer id;
    private String nome;

    Sexo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Sexo valueOf(Integer id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Id Sexo não pode ser nulo!");
        }
        for (Sexo sexo : Sexo.values()) {
            if (sexo.getId().equals(id)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Id Sexo Inválido!");
    }
}