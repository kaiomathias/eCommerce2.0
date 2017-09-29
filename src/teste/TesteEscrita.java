/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import model.Carrinho;
import model.Item;

/**
 *
 * @author Loc
 */
public class TesteEscrita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código do carrinho: ");
        int id = scanner.nextInt();
        
        Carrinho carrinho = new Carrinho(id);
        carrinho.adicionarItem(new Item(200, "Monitor LED FullHD", 1500.00));
        carrinho.adicionarItem(new Item(210, "Mouse Optico Microsoft", 49.90));
        carrinho.adicionarItem(new Item(220, "Teclado Multilaser", 39.90));
   
    String arquivoCarrinho = "C:/Temp/compra"+carrinho.getId()+".dat";
    ///try with resources
    try (FileOutputStream fos = new FileOutputStream(arquivoCarrinho); ///fala com o SO
        ObjectOutputStream o = new ObjectOutputStream(fos)){ //fala com o objeto
        o.writeObject(carrinho);
        System.out.println("Arquivo gravado com sucesso!");
        
    } catch (IOException ex) {
        System.out.println("Erro ao gravar arquivo" + "\n" + ex.getMessage());
    }
    }
    
}
