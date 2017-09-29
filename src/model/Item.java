/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Loc
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String descricao;
    private double valor;
    
    public Item(int id, String descricao, double valor){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
            }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item) {
            Item item = (Item) o;
            if(item.id == this.id && 
                    item.descricao.equals(this.descricao) &&
                    item.valor == this.valor){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return  this.id; 
    }

    
    
}
