package Janela;

import Janela.JanelaPrincipal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalho.Model.Item;


public class JanelaItem extends JFrame {

   
    private final JLabel lblNome =  new JLabel("                                  Nome:");
    private final JLabel lblPreco = new JLabel("                                 Preço:");
    private final JTextField txtNome = new JTextField(30);
    private final JTextField txtPreco = new JTextField(30);
    private final JButton btnCriar = new JButton("Criar Item");
    private JanelaPrincipal janelaPrincipal;
    private Item a = new Item();

    public JanelaItem() throws HeadlessException {
        super("Criar novo Item");
        setSize(300, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(2, 2));
        principal.add(lblNome);
        principal.add(txtNome);
        principal.add(lblPreco);
        principal.add(txtPreco);
        add(principal, BorderLayout.CENTER);
        add(btnCriar, BorderLayout.SOUTH);
        

        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtNome.getText().isEmpty() && !txtPreco.getText().isEmpty()) {
                    Item a = new Item();
                    a.setNome(txtNome.getText());
                    a.setPreco(Double.parseDouble(txtPreco.getText()));
                    janelaPrincipal.adicionaItem(a);
                }
            }
        });
    }

    public void setJanelaTurmas(JanelaPrincipal janela) {
        this.janelaPrincipal=janela;
    }
    void solicitaNovoItem() {
        setLocationRelativeTo(null);
        setVisible(true);
        txtNome.setText("");
        txtNome.requestFocus();
        txtPreco.setText("");
        
    }
  
}
