/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Janela.JanelaPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import trabalho.Model.Item;
import trabalho.Model.Mesa;
import trabalho.Model.Pedido;

/**
 *
 * @author Desenvolvedor
 */
public class Trabalho {

 
    public static void main(String[] args) {
        
        JanelaPrincipal janela = new JanelaPrincipal(getSampleData(),dadosItem());
        janela.setSize(800, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    private static List<Mesa> getSampleData() {
        
     
        Mesa m1 = new Mesa("Mesa 1");
        Mesa m2 = new Mesa("Mesa 2");
        
       
        
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(m1);
        mesas.add(m2);
        return mesas;
    }
    public static List<Item> dadosItem(){
        List<Item> itens= new ArrayList<>();
        
        Item i1=new Item("Batata",5.0);
        Item i2=new Item("Refrigerante",6.0);
        Item i3=new Item("Hamburg",15.0);
        Item i4=new Item("Suco de laranja",4.0);
        Item i5=new Item("Suco de Abacaxi",3.0);
        
        itens.add(i1);
        itens.add(i2);
        itens.add(i3);
        itens.add(i4);
        itens.add(i5);
        
        return itens;
        
        
    }
    
}
