package com.funcionarios.testeapi.controller;
import java.util.List;

import javax.validation.Valid;

import com.funcionarios.testeapi.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.funcionarios.testeapi.models.Funcionario;
import com.funcionarios.testeapi.repository.FuncionarioRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

   //"Retorna uma lista de funcionarios"
    @GetMapping("/funcionarios")
    public List<Funcionario> listaFuncionarios(){
        return funcionarioRepository.findAll();
    }

    //Retorna um funcionario especifico
    @GetMapping("/funcionario/{id}")
    public Funcionario listaFuncionarioUnico(@PathVariable(value="id") long id){
        return funcionarioRepository.findById(id);
    }

   //"Salva um novo funcionario"
    @PostMapping("/funcionario")
    public Funcionario salvaFuncionario(@RequestBody @Valid Funcioanrio funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    //"Deleta um funcionario"
    @DeleteMapping("/funcionario")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletaFuncionario(@RequestBody @Valid Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    //"Atualiza um funcionario"
    @PutMapping("/funcionario")
    public Funcionario atualizaFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }


}
