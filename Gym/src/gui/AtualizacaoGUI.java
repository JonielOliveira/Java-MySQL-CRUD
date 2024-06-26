
package gui;

import dao.AlunoDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.HistoricoPeso;
import utils.DateConverter;

public class AtualizacaoGUI extends javax.swing.JFrame {

    /**
     * Creates new form AtualizacaoGUI
     */
    public AtualizacaoGUI(Aluno aluno) {
        
        
        setTitle("Gym: atualizar cadastro");
        setSize(842,435);
        setResizable(false);
        //setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(AtualizacaoGUI.EXIT_ON_CLOSE);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/gym.png"));
        setIconImage(icon.getImage());
        
        initComponents();
        
        jTxtNome.setText(aluno.getNome());
        jTxtCpf.setText(aluno.getCpf());
        jTxtDataNascimento.setText(aluno.getDataNascFormatada());
        jTxtPeso.setText(String.valueOf(aluno.getPeso()));
        jTxtAltura.setText(String.valueOf(aluno.getAltura()));
        jTxtIdAluno.setText(String.valueOf(aluno.getId()));
        jTxtDataRegistro.setText(DateConverter.today("dd/MM/yyyy"));
        jTxtPesoHist.setText("");
        
        atualizacaoDoHistorico();
        
    }
    
    public AtualizacaoGUI() {
        initComponents(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnBackToConsulta = new javax.swing.JButton();
        jBtnAtualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListHistoricos = new javax.swing.JList<>();
        jLblDataRegistro = new javax.swing.JLabel();
        jTxtDataRegistro = new javax.swing.JTextField();
        jBtnAdicionar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jTxtPesoHist = new javax.swing.JTextField();
        jLblPesoHist = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLblNome = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLblCpf = new javax.swing.JLabel();
        jTxtCpf = new javax.swing.JTextField();
        jLblDataNascimento = new javax.swing.JLabel();
        jTxtDataNascimento = new javax.swing.JTextField();
        jLblPeso = new javax.swing.JLabel();
        jTxtPeso = new javax.swing.JTextField();
        jLblAltura = new javax.swing.JLabel();
        jTxtAltura = new javax.swing.JTextField();
        jLblIdAluno = new javax.swing.JLabel();
        jTxtIdAluno = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Consulta");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("CPF :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gym");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Atualização");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtnBackToConsulta.setText("Voltar para Consulta");
        jBtnBackToConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackToConsultaActionPerformed(evt);
            }
        });

        jBtnAtualizar.setText("Atualizar");
        jBtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histórico de Peso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setToolTipText("");

        jScrollPane1.setViewportView(jListHistoricos);

        jLblDataRegistro.setText("Data de Registro:");

        jTxtDataRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDataRegistroActionPerformed(evt);
            }
        });

        jBtnAdicionar.setText("Adicionar");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jLblPesoHist.setText("Peso :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLblDataRegistro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLblPesoHist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtPesoHist, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jBtnAdicionar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jBtnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnAlterar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDataRegistro)
                    .addComponent(jTxtDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAdicionar)
                    .addComponent(jLblPesoHist)
                    .addComponent(jTxtPesoHist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLblNome.setText("Nome :");

        jLblCpf.setText("CPF :");

        jTxtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCpfActionPerformed(evt);
            }
        });

        jLblDataNascimento.setText("Data de Nascimento :");

        jTxtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDataNascimentoActionPerformed(evt);
            }
        });

        jLblPeso.setText("Peso :");

        jTxtPeso.setEditable(false);

        jLblAltura.setText("Altura :");

        jLblIdAluno.setText("Código :");

        jTxtIdAluno.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLblNome)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLblCpf)
                            .addGap(31, 31, 31)
                            .addComponent(jTxtCpf))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLblAltura, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLblPeso, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLblDataNascimento, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtAltura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblIdAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtIdAluno)
                .addGap(223, 223, 223))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblIdAluno)
                    .addComponent(jTxtIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNome)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCpf)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDataNascimento)
                    .addComponent(jTxtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPeso)
                    .addComponent(jTxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblAltura)
                    .addComponent(jTxtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnBackToConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAtualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAtualizar)
                    .addComponent(jBtnBackToConsulta))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBackToConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackToConsultaActionPerformed
        ConsultaGUI NovaInstanciaConsultaGUI = new ConsultaGUI();
        NovaInstanciaConsultaGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnBackToConsultaActionPerformed

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        
        if ((jTxtNome.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo NOME nao pode retornar vazio");
        }     
        else if ((jTxtCpf.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo CPF nao pode retornar vazio");
        }
        else if ((jTxtDataNascimento.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo DATA DE NASCIMENTO nao pode retornar vazio");
        }
        else if ((jTxtPeso.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo PESO nao pode retornar vazio");
        }
        else if ((jTxtAltura.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo ALTURA nao pode retornar vazio");
        }
        else {
            Aluno aluno = new Aluno();
            
            int AlunoId = Integer.valueOf(jTxtIdAluno.getText());
            String AlunoNome = jTxtNome.getText();
            String AlunoCpf = "";
            if(aluno.verificaCpf(jTxtCpf.getText())){
                AlunoCpf = jTxtCpf.getText();
            }
            LocalDate Data = LocalDate.of(2000,1,1);
            if(aluno.verificaDataNasc(jTxtDataNascimento.getText())){
                String componentes[] = (jTxtDataNascimento.getText()).split("/");
                int dia = Integer.valueOf(componentes[0]);
                int mes = Integer.valueOf(componentes[1]);
                int ano = Integer.valueOf(componentes[2]);
                Data = Data.withYear(ano);
                Data = Data.withMonth(mes);
                Data = Data.withDayOfMonth(dia);
            }
            
            aluno.setId(AlunoId);
            aluno.setNome(AlunoNome);
            aluno.setCpf(AlunoCpf);
            aluno.setDataNasc(Date.valueOf(Data));
            aluno.setPeso(Float.valueOf(jTxtPeso.getText()));
            aluno.setAltura(Float.valueOf(jTxtAltura.getText()));
            
            AlunoDAO dao = new AlunoDAO();
            dao.atualizar(aluno);
            JOptionPane.showMessageDialog(this, "Aluno(a) " + jTxtNome.getText() + " atualizado(a) com sucesso!");
        }    
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jTxtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCpfActionPerformed

    private void jTxtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDataNascimentoActionPerformed

    private void jTxtDataRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDataRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDataRegistroActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
    
        if ((jTxtDataRegistro.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo DATA DE REGISTRO nao pode retornar vazio");
        }
        else if ((jTxtPesoHist.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "O campo PESO nao pode retornar vazio");
        }
        else {
            
            HistoricoPeso historicoPeso = new HistoricoPeso();   
            String formato = "dd/MM/yyyy";
            java.sql.Date data = DateConverter.transformToSqlDate(jTxtDataRegistro.getText(), formato);
            if(data == null){
                JOptionPane.showMessageDialog(this, "O campo DATA DE REGISTRO deve possuir o formato: " + formato);
            }
            else{
                try {
                    float peso = Float.parseFloat(jTxtPesoHist.getText());
                    
                    historicoPeso.setAlunoId(Integer.parseInt(jTxtIdAluno.getText()));
                    historicoPeso.setDataRegistro(data);
                    historicoPeso.setPeso(peso);

                    AlunoDAO dao = new AlunoDAO();
                    dao.adicionaHistorico(historicoPeso);
                    JOptionPane.showMessageDialog(this, "Histórico inserido com sucesso!");
                    
                    atualizacaoDoHistorico();
                    
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Verifique o campo PESO! Utilize ponto em vez de vírgula!");
                }
            }

        }
        
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    public void atualizacaoDoHistorico(){
        
        AlunoDAO dao = new AlunoDAO();
        
        List<HistoricoPeso> listaDeHistoricos = dao.consultaHistoricoByAluno(Integer.parseInt(jTxtIdAluno.getText()));

        int n = listaDeHistoricos.size();
        String[] modeloLista = new String[n];

        int i = 0;
        for(HistoricoPeso hp : listaDeHistoricos){
            modeloLista[i] = hp.toString();
            i++;
        }

        jListHistoricos.setListData(modeloLista);

        if(n > 0){
            if(listaDeHistoricos.getLast().getPeso() != Float.parseFloat(jTxtPeso.getText())){

                jTxtPeso.setText(String.valueOf(listaDeHistoricos.getLast().getPeso()));

                new Thread(() -> {
                    try {
                        Thread.sleep(1000); // Esperar 1 segundo
                    } 
                    catch(InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    jBtnAtualizar.doClick(); // "Apertar" o botão
                }).start();

            }
        }
  
    }
    
    
    
    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        
        AlunoDAO dao = new AlunoDAO();
        
        int exclusoesRealizadas = 0;
        int exclusoesNaoRealizadas = 0;
        int errosDeExecucao = 0;
        
        List<Integer> listaIds = Aluno.extractId(jListHistoricos.getSelectedValuesList());

        List<Integer> resultados = dao.excluirVariosHistorico(listaIds);
        
        for(Integer resultado : resultados){
            if(resultado == 1){
                exclusoesRealizadas++;
            }
            else if(resultado == 0){
                exclusoesNaoRealizadas++;
            }
            else if(resultado == -1){
                errosDeExecucao++;
            }
        }
        
        if(exclusoesRealizadas == listaIds.size()){
            if(exclusoesRealizadas == 0){
                JOptionPane.showMessageDialog(this, "Selecione um item para excluir!");
            }
            else if (exclusoesRealizadas == 1){
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(this, "Registros excluídos com sucesso!");
            }
            // System.out.println("OK"); 
        }
        else{
            // System.out.println("Not OK");
        }
        
        atualizacaoDoHistorico();

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        
        AlunoDAO dao = new AlunoDAO();
        int itensSelecionados = jListHistoricos.getSelectedValuesList().size();
        
        if(itensSelecionados  <= 0){
            JOptionPane.showMessageDialog(this, "Selecione um item para atualizar!");
        }
        else{
            List<Integer> listaIds = Aluno.extractId(jListHistoricos.getSelectedValuesList());   
            System.out.println(listaIds.get(0));
            List<HistoricoPeso> listaDeHistoricos = dao.consultaHistorico(listaIds.get(0));
            
            if(listaDeHistoricos.size() > 0){
                HistoricoPeso historicoPeso = listaDeHistoricos.get(0);
                
                AlteracaoGUI novaInstanciaAlteracaoGUI = new AlteracaoGUI(historicoPeso, this);
                novaInstanciaAlteracaoGUI.setVisible(true);
                atualizacaoDoHistorico();
                //this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Registro não encontrado no banco de dados!");
            }   
        }
        
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtualizacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizacaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizacaoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnBackToConsulta;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblAltura;
    private javax.swing.JLabel jLblCpf;
    private javax.swing.JLabel jLblDataNascimento;
    private javax.swing.JLabel jLblDataRegistro;
    private javax.swing.JLabel jLblIdAluno;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JLabel jLblPeso;
    private javax.swing.JLabel jLblPesoHist;
    private javax.swing.JList<String> jListHistoricos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTxtAltura;
    private javax.swing.JTextField jTxtCpf;
    private javax.swing.JTextField jTxtDataNascimento;
    private javax.swing.JTextField jTxtDataRegistro;
    private javax.swing.JTextField jTxtIdAluno;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPeso;
    private javax.swing.JTextField jTxtPesoHist;
    // End of variables declaration//GEN-END:variables
}
