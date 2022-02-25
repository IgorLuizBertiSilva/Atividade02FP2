/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
//@RequestScoped
@ViewScoped
public class ExemploController implements Serializable{

    private Pessoa pessoa;
    private List<Pessoa> pessoas = new ArrayList<>();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void excluir(){
        for (Pessoa pessoa1 : pessoas) {
            System.out.println(pessoa);
            System.out.println(pessoa1);
            if(pessoa1.getNome().equals(pessoa.getNome())){
                pessoas.remove(pessoa1);
                return;
            }
        }
    }


    public void adicionar(){

        System.out.println("Executou o método adicionar");
        System.out.println("Nome: " + this.pessoa.getNome());
        this.pessoas.add(pessoa);
        this.pessoa = new Pessoa();

        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro Realizado");             

    }

    public void exibir(){
        System.out.println("Executou o método exibir");
        for (Pessoa p : pessoas) {
            System.out.println("Nome na lista: " + p.getNome());
        }
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
