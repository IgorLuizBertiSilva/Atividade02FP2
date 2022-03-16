/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */

@Stateless
public class ProdutoDAO {
    
    @PersistenceContext(unitName = "aulaPU")
    private EntityManager em;
    
    public void inserir(Produto produto){
        em.persist(produto);
    }
    
    public List<Produto> listar(){
        
        return em.createQuery("SELECT p FROM Produto p", Produto.class)
        .getResultList();
        
    }
    
    public void remove(Produto produto){
        System.out.println(produto);
        
        if(!em.contains(produto)){
            produto = em.merge(produto);
        }
        em.remove(produto);
    }
    
}
