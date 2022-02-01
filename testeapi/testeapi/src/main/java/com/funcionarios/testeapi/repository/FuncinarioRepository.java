package com.funcionarios.testeapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.funcionarios.testeapi.models.Funcionario;

public interface FuncinarioRepository extends JpaRepository<Funcionario, long>{

}
