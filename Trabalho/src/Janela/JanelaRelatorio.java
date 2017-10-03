package Janela;

import ListModel.MesaListModel;
import ListModel.PedidoListModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import trabalho.Model.Item;
import trabalho.Model.Mesa;
import trabalho.Model.Pedido;

public class JanelaRelatorio extends JFrame {

    private final JList<Pedido> lstMesas = new JList<>(new DefaultListModel<>());
    private JLabel txtTotal= new JLabel();

    public JanelaRelatorio(List<Pedido> pedidos) throws HeadlessException {
        super("Janela do Relatorio");
        
        setSize(600, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        lstMesas.setModel(new PedidoListModel(pedidos));
        
        JPanel principal = new JPanel(new GridLayout(2, 2));
        double total=0;
        String totalPreco;
        for (int i = 0; i < pedidos.size(); i++) {

                    total = total + pedidos.get(i).getPreco();
        }
        
        
        txtTotal.setText("                               Total       R$" + String.valueOf(total));

     
        
        add(new JScrollPane(lstMesas), BorderLayout.CENTER);
        add(txtTotal, BorderLayout.SOUTH);
        
    }

    void solicitaRelatorio() {
        setLocationRelativeTo(null);
        setVisible(true);
   
    }
}


