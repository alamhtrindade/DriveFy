package telasCadastratos;

import Classes.Cliente;
import Classes.Carro;
import Classes.Banco;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamtrindade
 */
public class CadastrarCarro extends javax.swing.JFrame {

    Banco b = new Banco();
    ArrayList<Cliente> clientes = b.CarregarCliente();

    /**
     * Creates new form CadastrarCliente
     */
    public CadastrarCarro() {
        initComponents();

        carregaClientes(clientes);

        this.setVisible(true);
    }

    public void carregaClientes(ArrayList<Cliente> clientes) {

        for (Cliente c : clientes) {

            comboCliente.addItem(c.getNome() + "=>" + c.getCpf());
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

        jLabel2 = new javax.swing.JLabel();
        inputMarca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputModelo = new javax.swing.JTextField();
        inputCor = new javax.swing.JTextField();
        inputCategoria = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inputPlaca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        infoCPF = new javax.swing.JLabel();
        infoEndereco = new javax.swing.JLabel();
        infoTel = new javax.swing.JLabel();
        inputAno = new javax.swing.JFormattedTextField();
        inputPortas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons/veiculos.png"))); // NOI18N
        jLabel2.setText("Cadastrar Carro");

        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });

        jLabel1.setText("Marca:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Ano:");

        jLabel5.setText("Cor:");

        jLabel6.setText("Categoria:");

        inputModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputModeloActionPerformed(evt);
            }
        });

        inputCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCorActionPerformed(evt);
            }
        });

        inputCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCategoriaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel7.setText("N. Portas:");

        jLabel8.setText("Placa:");

        jLabel9.setText("Cliente:");

        comboCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClienteItemStateChanged(evt);
            }
        });

        jLabel10.setText("CPF: ");

        jLabel11.setText("Endereço:");

        jLabel12.setText("Telefone:");

        infoCPF.setText("---");

        infoEndereco.setText("---");

        infoTel.setText("---");

        try {
            inputAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        inputPortas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)))
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCliente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(infoCPF)
                                    .addComponent(infoEndereco)
                                    .addComponent(infoTel))
                                .addGap(0, 219, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputPortas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputPlaca)
                                    .addComponent(inputMarca)
                                    .addComponent(inputModelo)
                                    .addComponent(inputCor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inputCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addComponent(inputAno))
                                .addGap(7, 7, 7))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(infoCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(infoEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(infoTel))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(inputAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

    private void inputModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputModeloActionPerformed

    private void inputCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCorActionPerformed

    private void inputCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCategoriaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        boolean gravar = false;
        if ((!inputPlaca.getText().isBlank() || !inputPlaca.getText().isEmpty())
                && (!inputMarca.getText().isBlank() || !inputMarca.getText().isEmpty())
                && (!inputModelo.getText().isBlank() || !inputModelo.getText().isEmpty())
                && (!inputAno.getText().isBlank() || !inputAno.getText().isEmpty())
                && (!inputCor.getText().isBlank() || !inputCor.getText().isEmpty())) {

            gravar = true;

        }
        //implementar bloqueio de duplicitdade de placa
        if (b.veiculoJaExiste(inputPlaca.getText())) {
            gravar = false;
        }

        if (gravar == true) {
            String placa = inputPlaca.getText();
            String marca = inputMarca.getText();
            String modelo = inputModelo.getText();
            String cor = inputCor.getText();
            int ano = Integer.parseInt(inputAno.getText());
            String categoria = inputCategoria.getText();
            int portas = Integer.parseInt(inputPortas.getValue().toString());

            //capturar por certeza o cliente
            Carro carro = new Carro(placa, marca, modelo, ano, cor, portas, categoria, infoCPF.getText());

            if (b.cadastrarCarro(carro)) {
                JOptionPane.showMessageDialog(rootPane, "Veiculo " + carro.getPlaca() + " cadastrado com sucesso!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Veiculo " + carro.getPlaca() + " não cadastrado, validar se já não existe ou se os campos estão corretos!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Veiculo não cadastrado, validar se os campos requisitados estão corretos!");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClienteItemStateChanged
        // TODO add your handling code here:
        String[] dados = ((String) comboCliente.getSelectedItem()).split("=>");
        for (Cliente c : clientes) {
            if (c.getNome().equals(dados[0]) && c.getCpf().equals(dados[1])) {
                infoCPF.setText(c.getCpf());
                infoEndereco.setText(c.getEndereco());
                infoTel.setText(c.getTelefone());
                break;

            }
        }


    }//GEN-LAST:event_comboClienteItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JLabel infoCPF;
    private javax.swing.JLabel infoEndereco;
    private javax.swing.JLabel infoTel;
    private javax.swing.JFormattedTextField inputAno;
    private javax.swing.JTextField inputCategoria;
    private javax.swing.JTextField inputCor;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputModelo;
    private javax.swing.JTextField inputPlaca;
    private javax.swing.JSpinner inputPortas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
