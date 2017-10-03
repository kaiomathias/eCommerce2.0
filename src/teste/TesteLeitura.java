/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import model.Carrinho;

/**
 *
 * @author Loc
 */
public class TesteLeitura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o #ID da compra: ");
        int idCompra = scanner.nextInt();
        
        String arquivoCompra = "C:/Temp/compra"+idCompra+".dat";
        Carrinho carrinho = null;
        try(FileInputStream fis = new FileInputStream(arquivoCompra);
                ObjectInputStream in = new ObjectInputStream(fis))
                {
                    carrinho = (Carrinho) in.readObject();
                    System.out.println("Conteudo arquivo: \n");
                    System.out.println(carrinho.imprimirCarrinho());
                    
                } catch (ClassNotFoundException | IOException ex){
                        System.out.println("Erro de leitura do arquivo!\n" + ex.getMessage());
                        } //fim try
    }
    
}
