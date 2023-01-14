package telas.Vender.Agendar;

import Classes.Agenda;
import Classes.Servico;
import Classes.Cliente;
import Classes.Profissional;
import Classes.Pesado;
import Classes.Carro;
import Classes.Banco;
import Classes.Moto;
import interfaces.iAgendamento;
import interfaces.iListaAgenda;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamtrindade
 */
public class EditarAgendar extends javax.swing.JFrame {

    iListaAgenda agendamentos;
    Banco b = new Banco();
    ArrayList<Cliente> clientes = b.CarregarCliente();
    ArrayList<Carro> carros = b.CarregaCarros();
    ArrayList<Moto> motos = b.CarregaMotos();
    ArrayList<Pesado> pesados = b.CarregaPesados();
    ArrayList<Servico> servicos = b.CarregarServico();
    ArrayList<Profissional> profissionais = b.CarregaProfissional();
    Agenda agenda;

    /**
     * Creates new form Agendar
     *
     * @param agendamento
     * @param agendas
     */
    public EditarAgendar(iListaAgenda agendamento, Agenda agendas) {
        initComponents();

        carregarServicos();

        carregarProfissional();
        carregaData();

        agendamentos = agendamento;
        agenda = agendas;
        inputObservacoes.setText(agenda.getObservacoes());
        
        
        carregarDadosComboNome(this.agenda.getCPFCliente());
        carregaHoraPer(agenda.getHora());
        carregaDataPer(agenda.getData());
        inputTipoServico.getModel().setSelectedItem(agenda.getServico());
        ComboProfissional.getModel().setSelectedItem(achaProfissional(agenda.getCPFProfissional()));
        
        if(agenda.isStatus() == true){
            Atendido.setSelected(true);
        }else{
            Pendente.setSelected(true);
        }

        this.setVisible(true);
    }

    public void carregarProfissional() {

        ComboProfissional.removeAllItems();
        ComboProfissional.setEnabled(false);

        if (!profissionais.isEmpty()) {
            for (Profissional p : profissionais) {

                ComboProfissional.addItem(p.getNome() + "=>" + p.getCpf());
                ComboProfissional.setEnabled(true);
            }
        }

    }

    public void carregarDadosComboNome(String cpf) {

        ComboNome.removeAllItems();

        for (Cliente p : clientes) {
            if (p.getCpf().toLowerCase().contains(cpf)) {

                ComboNome.addItem(p.getNome() + "=>" + p.getCpf());

            }
        }

    }

    private void carregarDadosComboveiculos(String cpf) {

        jComboveiculos.removeAllItems();
        jComboveiculos.setEnabled(false);

        if (cpf != null) {
            for (Carro p : carros) {
                if (p.getCPF().toLowerCase().contains(cpf)) {

                    jComboveiculos.addItem(p.getPlaca());

                }
            }
            for (Moto p : motos) {
                if (p.getCPF().toLowerCase().contains(cpf)) {

                    jComboveiculos.addItem(p.getPlaca());

                }
            }
            for (Pesado p : pesados) {
                if (p.getCPF().toLowerCase().contains(cpf)) {

                    jComboveiculos.addItem(p.getPlaca());

                }
            }

        }

        if (jComboveiculos.getSelectedItem() == null) {
            //JOptionPane.showMessageDialog(rootPane, "Gentileza, cadastrar ao menos um veiculo para o cliente selecionado.");

        } else {
            jComboveiculos.setEnabled(true);

        }
    }

    public static boolean isValidaData(String dataStr) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); //Formate a data do jeito que for necessário, outro exemplo: ("dd/MM/yyyy")
        try {
            java.sql.Date data = new java.sql.Date(format.parse(dataStr).getTime());
            return true;
        } catch (ParseException ex) {
            return false;
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

        Atendimento = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        inputCpf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ComboNome = new javax.swing.JComboBox<>();
        inputTelefone = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        inputMarca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        inputAno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        inputModelo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboveiculos = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        inputObservacoes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        inputTipoServico = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        ComboProfissional = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        inputPreco = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        Atendido = new javax.swing.JRadioButton();
        Pendente = new javax.swing.JRadioButton();
        inputData = new com.toedter.calendar.JDateChooser();
        Hora = new javax.swing.JSpinner();
        Min = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(84, 170, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/drivefylogo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 80));

        jLabel2.setFont(new java.awt.Font("Avenir Next", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agendar Lavagem");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputCpf.setEnabled(false);
        inputCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCpfKeyReleased(evt);
            }
        });
        jPanel2.add(inputCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 190, 30));

        jLabel5.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 170, 231));
        jLabel5.setText("Nome:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 170, 231));
        jLabel6.setText("Cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(84, 170, 231));
        jLabel7.setText("CPF:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(84, 170, 231));
        jLabel8.setText("Telefone:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        inputEndereco.setEditable(false);
        inputEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEnderecoActionPerformed(evt);
            }
        });
        jPanel2.add(inputEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 310, 30));

        jLabel9.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(84, 170, 231));
        jLabel9.setText("Endereço:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        ComboNome.setEnabled(false);
        ComboNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboNomeItemStateChanged(evt);
            }
        });
        ComboNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboNomeMouseClicked(evt);
            }
        });
        ComboNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNomeActionPerformed(evt);
            }
        });
        jPanel2.add(ComboNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 280, 30));

        inputTelefone.setEditable(false);
        inputTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelefoneActionPerformed(evt);
            }
        });
        jPanel2.add(inputTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 640, 120));

        jPanel3.setBackground(new java.awt.Color(84, 170, 231));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputMarca.setEditable(false);
        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });
        jPanel3.add(inputMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 280, 30));

        jLabel12.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Marca:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel13.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Modelo:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ano:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        inputAno.setEditable(false);
        inputAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAnoActionPerformed(evt);
            }
        });
        jPanel3.add(inputAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 140, 30));

        jLabel11.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Placa:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        inputModelo.setEditable(false);
        inputModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputModeloActionPerformed(evt);
            }
        });
        jPanel3.add(inputModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 350, 30));

        jLabel18.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Veículo");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jComboveiculos.setEnabled(false);
        jComboveiculos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboveiculosItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboveiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 52, 200, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 640, 140));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(84, 170, 231));
        jLabel17.setText("Preço:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, 30));

        inputObservacoes.setEditable(false);
        inputObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputObservacoesActionPerformed(evt);
            }
        });
        jPanel4.add(inputObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 480, 40));

        jLabel15.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(84, 170, 231));
        jLabel15.setText("Serviço");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(84, 170, 231));
        jLabel16.setText("Tipo de Serviço:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        inputTipoServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lavagem Simples", "Lavagem Normal", "Lavagem Completa", "Gariba", " " }));
        inputTipoServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputTipoServicoItemStateChanged(evt);
            }
        });
        inputTipoServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTipoServicoMouseClicked(evt);
            }
        });
        inputTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTipoServicoActionPerformed(evt);
            }
        });
        jPanel4.add(inputTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 480, 40));

        jLabel21.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(84, 170, 231));
        jLabel21.setText("Observação:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jPanel4.add(ComboProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 260, 40));

        jLabel22.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(84, 170, 231));
        jLabel22.setText("Profissional:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        inputPreco.setEditable(false);
        inputPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrecoActionPerformed(evt);
            }
        });
        jPanel4.add(inputPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 140, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 640, 180));

        jPanel5.setBackground(new java.awt.Color(84, 170, 231));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hora:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel19.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText(":");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 49, 10, 30));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 90, 50));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(0, 51, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 90, 50));

        jLabel20.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Data:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Atendimento.add(Atendido);
        Atendido.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Atendido.setForeground(new java.awt.Color(255, 255, 255));
        Atendido.setText("Sim");
        jPanel5.add(Atendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        Atendimento.add(Pendente);
        Pendente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Pendente.setForeground(new java.awt.Color(255, 255, 255));
        Pendente.setSelected(true);
        Pendente.setText("Não");
        Pendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendenteActionPerformed(evt);
            }
        });
        jPanel5.add(Pendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        inputData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputDataMousePressed(evt);
            }
        });
        jPanel5.add(inputData, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 190, 30));

        Hora.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        jPanel5.add(Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 52, 80, 30));

        Min.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        jPanel5.add(Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 52, 80, 30));

        jLabel23.setFont(new java.awt.Font("Avenir Next", 3, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Ja atendido?");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 640, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrecoActionPerformed

    private void inputEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEnderecoActionPerformed

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

    private void inputModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputModeloActionPerformed

    private void inputAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAnoActionPerformed

    private void inputObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputObservacoesActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_inputObservacoesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void inputCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCpfKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_inputCpfKeyReleased

    private void ComboNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNomeActionPerformed
        // TODO add your handling code here:

        if (ComboNome.getSelectedItem() == null) {
            inputEndereco.setText("");
            inputPreco.setText("");
            jComboveiculos.removeAllItems();
        } else {
            String[] dados = ((String) ComboNome.getSelectedItem()).split("=>");
            for (Cliente c : clientes) {
                if (c.getNome().equals(dados[0]) && c.getCpf().equals(dados[1])) {
                    inputEndereco.setText(c.getEndereco());
                    inputTelefone.setText(c.getTelefone());
                    carregarDadosComboveiculos(c.getCpf());
                    break;

                }

            }

        }


    }//GEN-LAST:event_ComboNomeActionPerformed

    private void ComboNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboNomeItemStateChanged
        // TODO add your handling code here:
        if (ComboNome.getSelectedItem() == null) {
            inputEndereco.setText("");
            inputPreco.setText("");
            jComboveiculos.removeAllItems();
        } else {
            String[] dados = ((String) ComboNome.getSelectedItem()).split("=>");
            for (Cliente c : clientes) {
                if (c.getNome().equals(dados[0]) && c.getCpf().equals(dados[1])) {
                    inputEndereco.setText(c.getEndereco());
                    inputTelefone.setText(c.getTelefone());
                    carregarDadosComboveiculos(c.getCpf());
                    break;

                }

            }

        }
    }//GEN-LAST:event_ComboNomeItemStateChanged

    private void jComboveiculosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboveiculosItemStateChanged
        // TODO add your handling code here:
        boolean achei = false;
        if (jComboveiculos.getSelectedItem() == null) {
            inputMarca.setText("");
            inputModelo.setText("");
            inputAno.setText("");
        } else {
            String dados = ((String) jComboveiculos.getSelectedItem());

            for (Carro p : carros) {
                if (p.getPlaca().equals(dados)) {

                    achei = true;
                    inputMarca.setText(p.getMarca());
                    inputModelo.setText(p.getModelo());
                    inputAno.setText(Integer.toString(p.getAno()));

                    break;
                }
            }
            if (achei == false) {
                for (Moto p : motos) {
                    if (p.getPlaca().equals(dados)) {

                        inputMarca.setText(p.getMarca());
                        inputModelo.setText(p.getModelo());
                        inputAno.setText(Integer.toString(p.getAno()));
                        achei = true;
                        break;
                    }
                }
            }
            if (achei == false) {
                for (Pesado p : pesados) {
                    if (p.getPlaca().equals(dados)) {

                        inputMarca.setText(p.getMarca());
                        inputModelo.setText(p.getModelo());
                        inputAno.setText(Integer.toString(p.getAno()));
                        achei = true;
                        break;
                    }
                }
            }
        }


    }//GEN-LAST:event_jComboveiculosItemStateChanged

    private void inputTipoServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputTipoServicoItemStateChanged
        // TODO add your handling code here:

        if (inputTipoServico.getSelectedItem() == null) {
            inputObservacoes.setText("");

        } else {
            String servico = ((String) inputTipoServico.getSelectedItem());

            for (Servico p : servicos) {

                if (p.getNome_servico().contains(servico)) {

                    inputObservacoes.setText(p.getDescricao_servico());
                    inputPreco.setText(p.getPreco().toString());
                    break;
                }
            }
        }


    }//GEN-LAST:event_inputTipoServicoItemStateChanged

    private void inputTipoServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputTipoServicoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_inputTipoServicoMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        boolean gravar = false;

        Cliente cliente = null;
        Carro carros = null;
        Moto motos = null;
        Pesado pesados = null;
        Profissional profissional = null;
        Servico servico = null;
        String hora = null;
        String data = null;
        boolean status;
//valida nome
        if (ComboNome.getSelectedItem() != null) {
            String[] dados = ((String) ComboNome.getSelectedItem()).split("=>");
            for (Cliente c : clientes) {
                if (c.getNome().equals(dados[0]) && c.getCpf().equals(dados[1])) {
                    cliente = c;
                    gravar = true;
                    break;
                }
            }
        }

//valida veiculo
        if (jComboveiculos.getSelectedItem() != null && gravar == true) {
            String placa = ((String) jComboveiculos.getSelectedItem());
            boolean achei = false;
            for (Carro p : this.carros) {
                if (p.getPlaca().equals(placa)) {
                    carros = p;
                    achei = true;

                    break;
                }
            }
            if (achei == false) {
                for (Moto p : this.motos) {
                    if (p.getPlaca().equals(placa)) {
                        motos = p;
                        achei = true;
                        break;
                    }
                }
            }
            if (achei == false) {
                for (Pesado p : this.pesados) {
                    if (p.getPlaca().equals(placa)) {
                        pesados = p;
                        achei = true;
                        break;
                    }
                }
            }
        } else {
            gravar = false;
        }

//valida sevico
        if (inputTipoServico.getSelectedItem() != null && gravar == true) {
            String dados = ((String) inputTipoServico.getSelectedItem());
            for (Servico c : servicos) {
                if (c.getNome_servico().equals(dados)) {
                    servico = c;
                    break;
                }
            }
        } else {
            gravar = false;
        }

//valida profissional
        if (ComboProfissional.getSelectedItem() != null && gravar == true) {
            String[] dados = ((String) ComboProfissional.getSelectedItem()).split("=>");
            System.out.println(dados[1]);
            for (Profissional c : profissionais) {
                if (c.getNome().equals(dados[0]) && c.getCpf().equals(dados[1])) {
                    profissional = c;
                    gravar = true;
                    break;
                }
            }
        } else {
            gravar = false;
        }

//valida data
        data = entrega_data();

        hora = entrega_hora();

//valida status de atendimento
        if (Atendido.isSelected()) {
            status = true;
        } else {
            status = false;
        }

//valida a placa
        if (gravar == true) {
            String placaSelecionada = "";
            if (carros != null) {
                placaSelecionada = carros.getPlaca();
            } else if (motos != null) {
                placaSelecionada = motos.getPlaca();
            } else if (pesados != null) {
                placaSelecionada = pesados.getPlaca();
            }
//valida e grava tudo se gravar for verdadeiro
            agenda.setCPFCliente(cliente.getCpf());
            agenda.setPlacaVeiculo(placaSelecionada);
            agenda.setCPFProfissional(profissional.getCpf());
            agenda.setData(data);
            agenda.setHora(hora);
            agenda.setServico(servico.getNome_servico());
            agenda.setStatus(status);
            agenda.setPreco(servico.getPreco());
           
            if (b.atualizarAgenda(agenda)) {
                JOptionPane.showMessageDialog(rootPane, "Agendamento para " + cliente.getNome() + " e placa " + placaSelecionada + " atualizado com sucesso!");
                agendamentos.atualizarTabela();

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Agendamento para " + cliente.getNome() + " não atualizado, validar se já não existe ou se os campos estão corretos!");
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não é possivel atualizar agendamento com os dados atuais, gentileza verificar os dados imputados!");
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void ComboNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboNomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNomeMouseClicked

    private void inputTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelefoneActionPerformed

    private void inputDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputDataMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_inputDataMousePressed

    private void PendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PendenteActionPerformed

    private void inputTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTipoServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTipoServicoActionPerformed

    public String entrega_hora() {
        String hora;
        hora = (String) Hora.getModel().getValue();
        hora += ":";
        hora += (String) Min.getModel().getValue();

        return hora;
    }

    public String entrega_data() {
        try {
            Calendar data = inputData.getCalendar();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String agendadata = df.format(data.getTime());
            return agendadata;

        } catch (NullPointerException e) {
            System.out.println("Algo de errado não esta certo!");
        }
        return null;

    }

    public void carregaHora() {
        String hora = "00:00";
        Calendar data = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm");
        hora = df.format(data.getTime());
        String horamin[] = hora.split(":");
        Hora.getModel().setValue(horamin[0]);
        Min.getModel().setValue(horamin[1]);

    }

    public void carregaHoraPer(String hora) {

        //Calendar data = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm");
        //hora = df.format(data.getTime());
        String horamin[] = hora.split(":");
        Hora.getModel().setValue(horamin[0]);
        Min.getModel().setValue(horamin[1]);

    }

    public void carregaData() {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            java.util.Date data = new SimpleDateFormat("dd/MM/yyyy").parse(df.format(Calendar.getInstance().getTime()).toString());

            inputData.setDate(data);

        } catch (ParseException ex) {
            Logger.getLogger(Agendar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregaDataPer(String dataAgendada) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            java.util.Date data;
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataAgendada);

            inputData.setDate(data);

        } catch (ParseException ex) {
            Logger.getLogger(Agendar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarServicos() {
        inputTipoServico.removeAllItems();

        for (Servico p : servicos) {

            inputTipoServico.addItem(p.getNome_servico());

        }

    }

    public String achaProfissional(String profissional) {
        Profissional pro = null;
        for (Profissional c : profissionais) {
            if (c.getCpf().equals(profissional)) {
                pro = c;
                break;
            }
        }
        return pro.getNome() + "=>" + pro.getCpf();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Atendido;
    private javax.swing.ButtonGroup Atendimento;
    private javax.swing.JComboBox<String> ComboNome;
    private javax.swing.JComboBox<String> ComboProfissional;
    private javax.swing.JSpinner Hora;
    private javax.swing.JSpinner Min;
    private javax.swing.JRadioButton Pendente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField inputAno;
    private javax.swing.JTextField inputCpf;
    private com.toedter.calendar.JDateChooser inputData;
    private javax.swing.JTextField inputEndereco;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputModelo;
    private javax.swing.JTextField inputObservacoes;
    private javax.swing.JTextField inputPreco;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JComboBox<String> inputTipoServico;
    private javax.swing.JComboBox<String> jComboveiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}