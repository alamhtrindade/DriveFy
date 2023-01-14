package telasListar;

import Classes.Agenda;
import Classes.Banco;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Classes.Carro;
import Classes.Cliente;
import Classes.Moto;
import Classes.Pesado;
import interfaces.iAgendamento;
import interfaces.iListaAgenda;
import interfaces.iVeiculo;
import javax.swing.JOptionPane;
import telas.Vender.Agendar.EditarAgendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamtrindade
 */
public class ListarAgenda extends javax.swing.JFrame implements iListaAgenda {
    iAgendamento atualizaprincipal;
    Banco b = new Banco();
    ArrayList<Agenda> agendas;

    /**
     * Creates new form ListarClientes
     */
    public ListarAgenda(iAgendamento atualizaprincipal) {
        initComponents();
        carregar();
        this.setVisible(true);
        this.atualizaprincipal = atualizaprincipal;
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnEditar.setEnabled(jTable1.getSelectedRow() >= 0);
                btnExcluir.setEnabled(jTable1.getSelectedRow() >= 0);
            }

        });
    }

    public void carregar() {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        agendas = b.CarregarAgendamentos();

        for (Agenda p : agendas) {
            Object[] row = {p.getId(), p.getCPFCliente(), p.getPlacaVeiculo(), p.getCPFProfissional(), p.getServico(), p.getData(), p.getHora(), (p.isStatus() ? "feito" : "pendente")};
            tabela.addRow(row);
        }

    }

    private void carregarDados() {
        DefaultTableModel tabela = (DefaultTableModel) this.jTable1.getModel();

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        String data = this.jData.getText();;
        agendas = b.CarregarAgendamentos();

        for (Agenda p : agendas) {
            if (p.getData().contains(data)) {
                Object[] row = {p.getId(), p.getCPFCliente(), p.getPlacaVeiculo(), p.getCPFProfissional(), p.getServico(), p.getData(), p.getHora(), (p.isStatus() == true ? "feito" : "pendente")};

                tabela.addRow(row);
            }
        }
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
        jData = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(84, 170, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF", "Placa", "Profissional", "Serviço", "Dia", "Hora", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 340));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 660, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/drivefylogo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 70));

        jLabel2.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Listar Agenda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 40, 20));

        jData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDataActionPerformed(evt);
            }
        });
        jData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDataKeyReleased(evt);
            }
        });
        jPanel1.add(jData, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 130, 30));

        btnSair.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(84, 170, 231));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 90, 30));

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

        btnExcluir1.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        btnExcluir1.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir1.setText("Excluir");
        btnExcluir1.setEnabled(false);
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDataActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:

        Agenda agenda = null;

        int linha = this.jTable1.getSelectedRow();

        if (linha >= 0) {
            int id = Integer.parseInt(this.jTable1.getValueAt(linha, 0).toString());

            for (Agenda a : agendas) {
                if (a.getId() == id) {
                   
                    new EditarAgendar(this, a);
                    break;
                } 

            }

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Agenda agenda = null;

        int linha = this.jTable1.getSelectedRow();
        if (linha >= 0) {
            int id = Integer.parseInt(this.jTable1.getValueAt(linha, 0).toString());

            for (Agenda a : agendas) {
                if (a.getId() == id) {

                    Object[] options = {"Prosseguir com exclusão!", "Cancelar exclusão!"};
                    int n = JOptionPane.showOptionDialog(null,
                            "Deseja excluir o agendamento do veiculo placa " + a.getPlacaVeiculo()+ " para data " + a.getData()+ " e hora "+a.getHora()+"? ",
                            "Excluir", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    if (n == 0) {

                        if (b.apagarAgenda(a)) {
                            JOptionPane.showMessageDialog(rootPane, "Agendamento apagado com sucesso!");
                            carregar();
                            atualizaprincipal.atualizarTabela();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possivel excluir agendamento!");
                        }
                    }
                } else {

                    JOptionPane.showMessageDialog(rootPane, "A selecao atual não encontrou nenhum agendamento!");
                }

            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDataKeyReleased
        // TODO add your handling code here:
        carregarDados();

    }//GEN-LAST:event_jDataKeyReleased

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField jData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


    @Override
    public void atualizarTabela() {
        carregar();
    }
}
