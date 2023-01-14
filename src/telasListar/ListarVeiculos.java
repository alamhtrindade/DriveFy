package telasListar;

import Classes.Agenda;
import Classes.Carro;
import Classes.Pesado;
import Classes.Banco;
import Classes.Cliente;
import Classes.Moto;
import interfaces.iVeiculo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import telasEdicao.EditarCarro;
import telasEdicao.EditarMoto;
import telasEdicao.EditarPesados;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamtrindade
 */
public class ListarVeiculos extends javax.swing.JFrame implements iVeiculo {

    Banco b = new Banco();
    ArrayList<Pesado> pesados = b.CarregaPesados();
    ArrayList<Carro> carros = b.CarregaCarros();
    ArrayList<Moto> motos = b.CarregaMotos();
    ArrayList<Cliente> clientes = b.CarregarCliente();
    ArrayList<Agenda> agendamentos = b.CarregarAgendamentos();

    /**
     * Creates new form ListarClientes
     */
    public ListarVeiculos() {
        initComponents();
        this.setVisible(true);

        carregar();

        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnEditar.setEnabled(jTable1.getSelectedRow() >= 0);
                btnExcluir.setEnabled(jTable1.getSelectedRow() >= 0);
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPlaca = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnSair1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(84, 170, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 340));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 660, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/drivefylogo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 70));

        jLabel2.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Listar Veículos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Placa:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 40, 20));

        jPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlacaActionPerformed(evt);
            }
        });
        jPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPlacaKeyReleased(evt);
            }
        });
        jPanel1.add(jPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 120, 30));

        btnExcluir.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 120, 30));

        btnSair1.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        btnSair1.setForeground(new java.awt.Color(84, 170, 231));
        btnSair1.setText("Sair");
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 90, 30));

        btnEditar.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 204));
        btnEditar.setText("Editar ");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPlacaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        Carro carro = null;
        Pesado pesado = null;
        Moto moto = null;
        Cliente cliente = null;

        int linha = this.jTable1.getSelectedRow();

        if (linha >= 0) {
            String placa = this.jTable1.getValueAt(linha, 0).toString();

            boolean achei = false;
            for (Carro p : this.carros) {
                if (p.getPlaca().equals(placa)) {
                    carro = p;
                    achei = true;

                    break;
                }
            }
            if (achei == false) {
                for (Moto p : this.motos) {
                    if (p.getPlaca().equals(placa)) {
                        moto = p;
                        achei = true;
                        break;
                    }
                }
            }
            if (achei == false) {
                for (Pesado p : this.pesados) {
                    if (p.getPlaca().equals(placa)) {
                        pesado = p;
                        achei = true;
                        break;
                    }
                }
            }

            if (carro != null) {

                for (Agenda a : agendamentos) {
                    if ((a.getPlacaVeiculo().equals(carro.getPlaca())) && a.isStatus() == false) {

                        JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir esse veiculo pois existe um agendamento pendente,\ngentileza concluir ou apagar o agendamento para seguir com exclusão do veiculo!");
                        break;
                    } else {

                        cliente = Achacliente(carro.getCPF());
                        //System.out.println("Achei um carro é do "+cliente.getNome()+" modelo "+carro.getModelo()+" \n");

                        Object[] options = {"Prosseguir com exclusão!", "Cancelar exclusão!"};
                        int n = JOptionPane.showOptionDialog(null,
                                "Deseja excluir o cadastro do veiculo de placa " + carro.getPlaca() + " (Cliente " + cliente.getNome() + ")? ",
                                "Excluir", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        if (n == 0) {
                            if (b.apagarCarro(carro)) {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo apagado com sucesso!");
                                carregar();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo não apagado, não houve alterações na base");
                            }
                        }

                    }

                }

            } else if (moto != null) {
                for (Agenda a : agendamentos) {
                    if ((a.getPlacaVeiculo().equals(moto.getPlaca())) && a.isStatus() == false) {

                        JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir esse veiculo pois existe um agendamento pendente,\ngentileza concluir ou apagar o agendamento para seguir com exclusão do veiculo!");
                        break;
                    } else {

                        cliente = Achacliente(moto.getCPF());
                        //System.out.println("Achei uma moto é do "+cliente.getNome()+" modelo "+moto.getModelo()+" \n");

                        Object[] options = {"Prosseguir com exclusão!", "Cancelar exclusão!"};
                        int n = JOptionPane.showOptionDialog(null,
                                "Deseja excluir o cadastro do veiculo de placa " + moto.getPlaca() + " (Cliente " + cliente.getNome() + ")? ",
                                "Excluir", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        if (n == 0) {
                            if (b.apagarMoto(moto)) {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo apagado com sucesso!");
                                carregar();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo não apagado, não houve alterações na base");
                            }
                        }
                    }
                }
            } else if (pesado != null) {

                for (Agenda a : agendamentos) {
                    if ((a.getPlacaVeiculo().equals(pesado.getPlaca())) && a.isStatus() == false) {

                        JOptionPane.showMessageDialog(rootPane, "Não é possivel excluir esse veiculo pois existe um agendamento pendente,\ngentileza concluir ou apagar o agendamento para seguir com exclusão do veiculo!");
                        break;
                    } else {
                        cliente = Achacliente(pesado.getCPF());
                        //System.out.println("Achei um caminhao é do "+cliente.getNome()+" modelo "+pesado.getModelo()+" \n");
                        Object[] options = {"Prosseguir com exclusão!", "Cancelar exclusão!"};
                        int n = JOptionPane.showOptionDialog(null,
                                "Deseja excluir o cadastro do veiculo de placa " + pesado.getPlaca() + " (Cliente " + cliente.getNome() + ")? ",
                                "Excluir", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        if (n == 0) {
                            if (b.apagarPesado(pesado)) {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo apagado com sucesso!");
                                carregar();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Veiculo não apagado, não houve alterações na base");
                            }

                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "A seleção atual não capturou nenhum veiculo!");
            }

        }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPlacaKeyReleased
        carregarDados();        // TODO add your handling code here:
    }//GEN-LAST:event_jPlacaKeyReleased

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:

        Carro carro = null;
        Pesado pesado = null;
        Moto moto = null;
        Cliente cliente = null;

        int linha = this.jTable1.getSelectedRow();

        if (linha >= 0) {
            String placa = this.jTable1.getValueAt(linha, 0).toString();

            boolean achei = false;
            for (Carro p : this.carros) {
                if (p.getPlaca().equals(placa)) {
                    carro = p;
                    achei = true;

                    break;
                }
            }
            if (achei == false) {
                for (Moto p : this.motos) {
                    if (p.getPlaca().equals(placa)) {
                        moto = p;
                        achei = true;
                        break;
                    }
                }
            }
            if (achei == false) {
                for (Pesado p : this.pesados) {
                    if (p.getPlaca().equals(placa)) {
                        pesado = p;
                        achei = true;
                        break;
                    }
                }
            }

            if (carro != null) {
                cliente = Achacliente(carro.getCPF());
                //System.out.println("Achei um carro é do "+cliente.getNome()+" modelo "+carro.getModelo()+" \n");

                new EditarCarro(this, cliente, carro);

            } else if (moto != null) {
                cliente = Achacliente(moto.getCPF());
                new EditarMoto(this, cliente, moto);
                //System.out.println("Achei uma moto é do "+cliente.getNome()+" modelo "+moto.getModelo()+" \n");

            } else if (pesado != null) {
                cliente = Achacliente(pesado.getCPF());

                new EditarPesados(this, cliente, pesado);
                //System.out.println("Achei um caminhao é do "+cliente.getNome()+" modelo "+pesado.getModelo()+" \n");

            } else {

            }

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public Cliente Achacliente(String cpf) {
        for (Cliente p : clientes) {
            if (p.getCpf().contains(cpf)) {

                return p;

            }
        }
        return null;
    }

    public void carregar() {

        pesados = b.CarregaPesados();
        carros = b.CarregaCarros();
        motos = b.CarregaMotos();

        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        for (Pesado p : pesados) {
            Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getAno()};
            tabela.addRow(row);
        }
        for (Carro p : carros) {
            Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getAno()};
            tabela.addRow(row);
        }
        for (Moto p : motos) {
            Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getAno()};
            tabela.addRow(row);
        }

    }

    private void carregarDados() {
        DefaultTableModel tabela = (DefaultTableModel) this.jTable1.getModel();

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        String placa = this.jPlaca.getText().toLowerCase();

        for (Pesado p : pesados) {

            if (p.getPlaca().contains(placa)) {
                Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getModelo()};
                tabela.addRow(row);
            }

        }
        for (Carro p : carros) {
            if (p.getPlaca().contains(placa)) {
                Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getModelo()};
                tabela.addRow(row);
            }
        }
        for (Moto p : motos) {
            if (p.getPlaca().contains(placa)) {
                Object[] row = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getModelo()};
                tabela.addRow(row);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPlaca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Listagem() {
        carregar();
    }
}
