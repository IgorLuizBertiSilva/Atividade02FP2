/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.model.Produto;
import java.io.Serializable;
import java.util.List;
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
@ViewScoped
public class ExemploController implements Serializable {

    

    @Inject
    private ProdutoDAO produtoDAO;

    private Produto produto;
    private List<Produto> produtos;
    private Produto produtoSelecionado;

 
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        if (this.produtos == null) {
            System.out.println("Carregando...");
            this.produtos = produtoDAO.listar();
        }
                
        return this.produtos;
    }

    

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }


    public void excluir() {

        if (produtoSelecionado != null) {
            System.out.println("Metodo Excluir");
            produtoDAO.remove(produtoSelecionado);
            addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa excluida");
            this.produto = null;
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Pessoa Não selecionada");
            return;
        }

    }

    public void adicionar() {
        


        System.out.println("Executou o método adicionar");
        System.out.println("Produto");
        System.out.println(produto);
        produtoDAO.inserir(produto);
        this.produtos.add(produto);
        
        this.produto = new Produto();
        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro Realizado");

    }

    public void exibir() {
        System.out.println("Executou o método exibir");
    }

    public ExemploController() {

        System.out.println("Construido");
        
        this.produto = new Produto();

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
