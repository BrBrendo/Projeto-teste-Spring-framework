package com.produtos.testeapi.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.produtos.testeapi.models.Funcionario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class FuncionarioController {

    @Autowired
    ProdutoRepository funcionarioRepository;

    @ApiOperation(value="Retorna uma lista de funcionarios")
    @GetMapping("/funcionarios")
    public List<Funcionario> listaFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @ApiOperation(value="Retorna um funcionario especifico")
    @GetMapping("/funcionario/{id}")
    public Produto listaFuncionarioUnico(@PathVariable(value="id") long id){
        return funcionarioRepository.findById(id);
    }

    @ApiOperation(value="Salva um novo funcionario")
    @PostMapping("/funcionario")
    public Produto salvaFuncionario(@RequestBody @Valid Funcioanrio funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @ApiOperation(value="Deleta um funcionario")
    @DeleteMapping("/funcionario")
    public void deletaFuncionario(@RequestBody @Valid Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    @ApiOperation(value="Atualiza um funcionario")
    @PutMapping("/funcionario")
    public Produto atualizaFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }


}
