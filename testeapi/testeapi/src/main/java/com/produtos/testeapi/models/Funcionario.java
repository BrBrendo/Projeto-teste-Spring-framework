package com.produtos.testeapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    private long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;

    public Funcionario() {

    }

    public Funcionario(String firstName, String lastName, String emailId) {
        this.primeiroNome = firstName;
        this.ultimoNome = lastName;
        this.email = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "primeiro_nome", nullable = false)
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    @Column(name = "ultimo_nome", nullable = false)
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", email=" + email
                + "]";
    }

}



