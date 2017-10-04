package Janela;

import ListModel.ItemListModel;
import ListModel.MesaListModel;
import ListModel.PedidoListModel;

import trabalho.Model.Mesa;
import trabalho.Model.Pedido;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalho.Model.Item;
import trabalho.Model.Pedido;

public class JanelaPrincipal extends JFrame {

    private final JComboBox<Item> combobox = new JComboBox();
    private final JTextField txtQuantidade = new JTextField();

    private final List<Mesa> mesas;
    private final List<Item> itens;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedido = new JList<>(new DefaultListModel<>());
    private final JList<Item> lstItem = new JList<>(new DefaultListModel<>());

    private final JButton btnCriarMesa = new JButton("Cria Mesa");
    private final JButton btnExcluiMesa = new JButton("Exclui Mesa");
    private final JButton btnCriaPedido = new JButton("Inseir Item no Pedido");
    private final JButton btnIniciarPedido = new JButton("Abrir Pedido");
    private final JButton btnFecharPedido = new JButton("Fechar Pedido");
    private final JButton btnExcluiPedido = new JButton("Exclui Pedido");
    private final JButton btnCriarItem = new JButton("Incluir Item");
    private final JButton btnExcluiItem = new JButton("Exclui Item");
    private final JButton btnGerarRelatorio = new JButton("Gerar Relatorio");
    private final JButton btnLimpaPedido = new JButton("Limpar Pedido Mesa");

    private final JLabel inserirM = new JLabel("                                                                                                        Selecione um Item:");
    private final JLabel excluirM = new JLabel("                                          Digite a quantidade do item a ser Inserido no pedido:");
    private final JLabel tabelaM = new JLabel("Tabela de Mesas");
    private final JLabel tabelaI = new JLabel("Tabela do Itens Disponiveis");
    private final JLabel tabelaP = new JLabel("Tabela de Pedidos");
    private final JLabel totalPreco = new JLabel("                                                                         Total:  ");

    private JanelaRelatorio janelaPedido;
    private JanelaItem janelaItem = new JanelaItem();
    
   

    public JanelaPrincipal(List<Mesa> sampleData, List<Item> dadosItens) {
        super("Sitema de Pedido de Lanchonete");

        setMinimumSize(new Dimension(1350, 400));

        this.mesas = sampleData;
        this.itens = dadosItens;

        lstMesas.setModel(new MesaListModel(mesas));
        lstItem.setModel(new ItemListModel(itens));

        JPanel tabelas = new JPanel();
        tabelas.setLayout(new GridLayout(1, 3));

        tabelas.add(new JScrollPane(lstMesas), BorderLayout.CENTER);
        tabelas.add(new JScrollPane(lstPedido), BorderLayout.CENTER);
        tabelas.add(new JScrollPane(lstItem), BorderLayout.CENTER);

        updateComBoBox();
        combobox.setSelectedIndex(-1);

        JPanel botoes = new JPanel(new GridLayout(5, 3));

        btnCriaPedido.setEnabled(false);
        btnExcluiPedido.setEnabled(false);
        btnIniciarPedido.setEnabled(false);
        btnFecharPedido.setEnabled(false);
        btnGerarRelatorio.setEnabled(false);
        btnLimpaPedido.setEnabled(false);
        
        botoes.add(inserirM);
        botoes.add(combobox);
        botoes.add(new JPanel());

        botoes.add(excluirM);
        botoes.add(txtQuantidade);
        botoes.add(new JPanel());

        botoes.add(btnCriarMesa);
        botoes.add(btnCriaPedido);
        botoes.add(btnCriarItem);

        botoes.add(btnExcluiMesa);
        botoes.add(btnExcluiPedido);
        botoes.add(btnExcluiItem);

        botoes.add(tabelaM);
        botoes.add(tabelaP);
        botoes.add(tabelaI);

        JPanel botoes2 = new JPanel(new GridLayout(3, 3));

        botoes2.add(new JPanel());
        botoes2.add(totalPreco);
        botoes2.add(new JPanel());
        botoes2.add(new JPanel());
        botoes2.add(btnIniciarPedido);
        botoes2.add(new JPanel());
        botoes2.add(btnLimpaPedido);
        botoes2.add(btnFecharPedido);
        botoes2.add(btnGerarRelatorio);

        add(botoes, BorderLayout.NORTH);
        add(tabelas, BorderLayout.CENTER);
        add(botoes2, BorderLayout.SOUTH);

        
        lstMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstMesas.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Mesa mesa = lstMesas.getSelectedValue();
                if (mesa != null) {
                    lstPedido.setModel(new PedidoListModel(mesa.getPedido()));
                    tabelaP.setText("Tabela de Pedidos da '" + mesa.getCodigo() + "'");
                    if (mesa.getEstado() == 0) {
                        btnCriaPedido.setEnabled(false);
                        btnExcluiPedido.setEnabled(false);
                        btnIniciarPedido.setEnabled(true);
                        btnFecharPedido.setEnabled(false);
                        
                    } else if(mesa.getEstado() == 2){
                         btnGerarRelatorio.setEnabled(true);
                         btnLimpaPedido.setEnabled(true);
                    } else{
                        btnCriaPedido.setEnabled(true);
                        btnExcluiPedido.setEnabled(true);
                        btnIniciarPedido.setEnabled(false);
                        btnFecharPedido.setEnabled(true);
                        
                    }
                } else {
                    lstPedido.setModel(new DefaultListModel<>());
                }
            }
        });

        
        btnCriarMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Nome da nova Mesa: ");
                if (cod != null && !cod.isEmpty()) {
                    Mesa t = new Mesa(cod);
                    mesas.add(t);
                    lstMesas.updateUI();
                }
            }
        });

        btnIniciarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lstMesas.isSelectionEmpty()) {
                    Date hora = new Date();

                    lstMesas.getSelectedValue().setAberto(
                            String.valueOf(hora.getHours())
                            + ":"
                            + String.valueOf(hora.getMinutes())
                            + ":"
                            + String.valueOf(hora.getSeconds()));
                    mesas.get(lstMesas.getSelectedIndex()).setEstado(1);
                    lstMesas.updateUI();

                    btnIniciarPedido.setEnabled(false);
                    btnFecharPedido.setEnabled(true);
                    btnCriaPedido.setEnabled(true);
                    btnExcluiPedido.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma Mesa");
                }

            }
        });
        
        btnFecharPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date hora= new Date();
                lstMesas.getSelectedValue().setEstado(2);
                lstMesas.getSelectedValue().setFechado(
                        String.valueOf(hora.getHours())
                        + ":"
                        + String.valueOf(hora.getMinutes())
                        + ":"
                        + String.valueOf(hora.getSeconds()));
                mesas.get(lstMesas.getSelectedIndex()).setEstado(2);
                double total = 0;

                lstMesas.updateUI();

                btnIniciarPedido.setEnabled(true);
                btnCriaPedido.setEnabled(false);
                btnExcluiPedido.setEnabled(false);
                
                janelaPedido = new JanelaRelatorio(lstMesas.getSelectedValue().getPedido());
                janelaPedido.solicitaRelatorio();
                
                btnGerarRelatorio.setEnabled(true);
                btnLimpaPedido.setEnabled(true);
                

            }
        });

        btnGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(lstMesas.getSelectedValue().getEstado()==2){
                janelaPedido = new JanelaRelatorio(lstMesas.getSelectedValue().getPedido());
                janelaPedido.solicitaRelatorio();
               }
            }
        });
        
        btnLimpaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lstMesas.getSelectedValue().getPedido().size(); i++) {
                    lstMesas.getSelectedValue().getPedido().remove(i);
                }
                
                
                lstMesas.getSelectedValue().setEstado(0);
                lstPedido.updateUI();
                lstMesas.updateUI();
            }
        });
        
        btnCriaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (combobox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Item");
                } else {
                    if (lstMesas.isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(null, "Selecione uma Mesa");
                    } else {

                        if (lstMesas.getSelectedValue().getEstado() == 0) {
                            JOptionPane.showMessageDialog(null, "Inicie uma Mesa para acrescentar o item");
                        } else if (lstMesas.getSelectedValue().getEstado() == 2) {
                            JOptionPane.showMessageDialog(null, "Esta Mesa esta fechada não e possivel adicionar item");
                        } else if(txtQuantidade.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Digite uma Quantidade do Item");
                        }else{
                            String quant = txtQuantidade.getText();
                            if (quant == null && quant.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Insira a Quantidade");
                            }
                            Pedido p = new Pedido(itens.get(combobox.getSelectedIndex()), Integer.parseInt(quant), Double.parseDouble(quant) * itens.get(combobox.getSelectedIndex()).getPreco());

                            lstMesas.getSelectedValue().getPedido().add(p);
                            lstMesas.updateUI();
                            lstPedido.updateUI();
                            combobox.setSelectedIndex(-1);
                            txtQuantidade.setText("");

                            double total = 0;
                            
                            for (int i = 0; i < lstMesas.getSelectedValue().getPedido().size(); i++) {

                                total = total + lstMesas.getSelectedValue().getPedido().get(i).getPreco();
                            }

                            totalPreco.setText("                                                                         Total : R$" + String.valueOf(total));

                        }
                    }
                }
            }
        });

        janelaItem.setJanelaTurmas(this);
        btnCriarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaItem.solicitaNovoItem();

            }
        });

        btnExcluiMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstMesas.isSelectionEmpty()) {
                    return;
                }
                mesas.remove(lstMesas.getSelectedValue());
                lstMesas.clearSelection();
                lstMesas.updateUI();
            }
        });

        btnExcluiItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstItem.isSelectionEmpty()) {
                    return;
                }
                itens.remove(lstItem.getSelectedValue());
                lstItem.clearSelection();
                lstItem.updateUI();
            }
        });
        btnExcluiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstPedido.isSelectionEmpty()) {
                    return;
                }
                mesas.get(lstMesas.getSelectedIndex()).getPedido().remove(lstPedido.getSelectedValue());
                lstPedido.clearSelection();
                lstPedido.updateUI();
            }
        });

    }

    void setPedido(Pedido p) {
        lstMesas.getSelectedValue().getPedido().add(p);
        lstPedido.updateUI();
        janelaItem.setVisible(false);

    }

    public void adicionaItem(Item p) {
        itens.add(p);
        lstItem.updateUI();
        combobox.addItem(p);
        combobox.updateUI();
        janelaItem.setVisible(false);
    }

    void updateComBoBox() {
        for (int i = 0; i < itens.size(); i++) {
            combobox.addItem(itens.get(i));
        }
    }
    
    

}
