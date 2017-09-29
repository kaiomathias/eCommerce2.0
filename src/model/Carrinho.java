/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Loc
 */
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L; //PADRÃO

    private int id;
    private Date dataCompra;
    private List<Item> items;
    private transient double totalCompra;

    public Carrinho(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.dataCompra = Calendar.getInstance().getTime();
        this.totalCompra = 0;
    }

    public double getTotalCompra() {
        return this.totalCompra;
    }

    public int getId() {
        return this.id;
    }

    public int contItens() {
        return items.size();
    }

    public List<Item> getItems() {
        return this.items;
    }
    
    public void adicionarItem(Item item){
        this.items.add(item);
        this.totalCompra += item.getValor();
    }
    
    public void removerItem(Item item){
        this.items.remove(item);
        this.totalCompra -= item.getValor();
    }
    
    public Date getDataCompra(){
        return this.dataCompra;
    }
    public void setDataCompra(Date dataCompra){
        this.dataCompra = dataCompra;
    }
    
    //escreve o objeto para arquivo
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }
    
    private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        
        //recalcula total
        if(totalCompra == 0 && items.size() > 0) {
            items.forEach((i) -> {
                this.totalCompra += i.getValor();
            });
        }
    }
    public String imprimirCarrinho(){
        String info = "";
        info += "Carrinho #ID: " + getId() + "\n";
        info += "[-- Lista de Itens --] \n";
        for (Item i : items) {
            info += "Item: " + i.getId() + " - " + i.getDescricao() + ":" +
                    NumberFormat.getCurrencyInstance().format(i.getValor()) 
                    + "\n";
        }
        info += "Total Compra: " + NumberFormat.getCurrencyInstance().format(totalCompra) +
                "\n\n";
                return info;
    }

}
