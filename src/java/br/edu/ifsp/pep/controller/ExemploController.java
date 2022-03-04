/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
//@RequestScoped
@ViewScoped
public class ExemploController implements Serializable{

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoa;
    //private List<Pessoa> pessoas = new ArrayList<>();
    private Pessoa pessoaSelecionada;

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }



    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
//        return pessoas;
        return null;
    }
//
//    public void setPessoas(List<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }

    public void excluir(){
        
        System.out.println("Metodo Excluir");
//        if (pessoaSelecionada != null) {
//            for (Pessoa pessoa1 : pessoas) {
//                System.out.println(pessoa);
//                System.out.println(pessoa1);
//                if(pessoa1.getNome().equals(pessoaSelecionada.getNome())){
//                    pessoas.remove(pessoa1);
//                    addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa excluida");
//                    return;
//                }
//            }
//            addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa não apagada");
//        }else{
//            addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Pessoa Não selecionada");
//            return;
//        }
        

        
    }


    public void adicionar(){

        System.out.println("Executou o método adicionar");
        System.out.println("Nome: " + this.pessoa.getNome());
        //this.pessoas.add(pessoa);
        pessoaDAO.inserir(pessoa);
        this.pessoa = new Pessoa();

        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro Realizado");             

    }

    public void exibir(){
        System.out.println("Executou o método exibir");
//        for (Pessoa p : pessoas) {
//            System.out.println("Nome na lista: " + p.getNome());
//        }
    }



    public ExemploController(){

        System.out.println("Construido");   
        this.pessoa = new Pessoa();
 

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    
    
    
}
