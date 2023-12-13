package com.mycompany.model;

public class Pessoa {
    private String sexo;
    private String nome;
    private String estadoCivil;

    public Pessoa() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Sexo: " + sexo + ", Estado Civil: " + estadoCivil;
    }
}
