/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import modelo.Grafico_Frequencia;
import org.jfree.ui.RefineryUtilities;
import teste.Linha_Frequencia;
import teste.Resumo_Frequencia;

/**
 *
 * @author milto
 */
public class Frm_Tabela_Frequencia_Detalhe extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Tabela_Frequencia
     */
    public int questionario_item_id = 0;

    public Frm_Tabela_Frequencia_Detalhe(int questionario_item_id) {
        initComponents();
        setSize(950, 500);
        this.questionario_item_id = questionario_item_id;
        Listar_Tabela_Frequencia();

    }

    void Listar_Tabela_Frequencia() {
        ArrayList<Linha_Frequencia> Lista_Frequencia = new ArrayList();
        Linha_Frequencia lf;
        DecimalFormat df = new DecimalFormat("#0.00");

        ArrayList<Grafico_Frequencia> lista = new ArrayList();
        lista = dao.Questionario_DAO.lista_Questionario_Item_Grafico(this.questionario_item_id);
        double[] a_Xi = new double[lista.size()];
        double[] a_fi = new double[lista.size()];
        int indice=0;
        for (Grafico_Frequencia r: lista){
            a_Xi[indice] = r.getValor();
            a_fi[indice] = r.getFrequencia();
            indice++;
        }
        //Criando a Lista_Frequencia
        for (int i = 0; i < a_Xi.length; i++) {

            lf = new Linha_Frequencia();
            lf.setXi(a_Xi[i]);
            lf.setfi(a_fi[i]);
            Lista_Frequencia.add(lf);
        }
        //Calculando 
        for (Linha_Frequencia r : Lista_Frequencia) {
            r.calcula_Xi_fi();
        }
        Resumo_Frequencia rf = new Resumo_Frequencia();
        rf.calcula_media(Lista_Frequencia);
        rf.calcula_mediana(Lista_Frequencia);
           
        for (Linha_Frequencia r : Lista_Frequencia) {
            r.calcula_Xi_x_fi(rf.getMedia());
            System.out.println(r);
        }
        // calcula fr e FI
        double valor_fr = 0;
        double total_fr = 0;
        double total_fi = 0;


        for (Linha_Frequencia r : Lista_Frequencia) {
            valor_fr = (r.getfi() * 100) / rf.getTotal_items();
            r.setfr(valor_fr);
            total_fi = total_fi + r.getfi();
            r.setFi(total_fi);
            total_fr = total_fr + r.getfr();
            r.setFr(total_fr);
        }

        for (Linha_Frequencia r : Lista_Frequencia) {
            r.calcula_Xi_x_fi(rf.getMedia());
            System.out.println(r);
        }

        rf.calcula_variancia(Lista_Frequencia);
        System.out.println("variancia: " + df.format(rf.getVariancia()));
        rf.calcula_desvio_padrao();
        System.out.println("Desvio Padrão: " + df.format(rf.getDesvio_padrao()));

        rf.calcula_variancia(Lista_Frequencia);
        System.out.println("variancia: " + df.format(rf.getVariancia()));
        rf.calcula_desvio_padrao();
        System.out.println("Desvio Padrão: " + df.format(rf.getDesvio_padrao()));
        rf.calcula_total_fr(Lista_Frequencia);
        rf.calcula_total_Xi_x_fi(Lista_Frequencia);

        this.jTextField_Media.setText(String.valueOf(df.format(rf.getMedia())));
        this.jTextField_Mediana.setText(String.valueOf(df.format(rf.getMediana())));
        this.jTextField_Variancia.setText(String.valueOf(df.format(rf.getVariancia())));
        this.jTextField_Desvio_padrao.setText(String.valueOf(df.format(rf.getDesvio_padrao())));

        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Xi");
        model.addColumn("fi");
        model.addColumn("Fi");
        model.addColumn("fr");
        model.addColumn("Fr");
        model.addColumn("Xi.fi");
        model.addColumn("(Xi-x)2.fi");
        String[] data = new String[7];
        for (Linha_Frequencia r : Lista_Frequencia) {
            data[0] = String.valueOf(df.format(r.getXi()));
            data[1] = String.valueOf(df.format(r.getfi()));
            data[2] = String.valueOf(df.format(r.getFi()));
            data[3] = String.valueOf((df.format(r.getfr()) + "%"));
            data[4] = String.valueOf((df.format(r.getFr()) + "%"));
            data[5] = String.valueOf(df.format(r.getXi_fi()));
            data[6] = String.valueOf(df.format(r.getXi_x_fi()));
            model.addRow(data);
        }
            data[0] = String.valueOf("TOTAL: ");
            data[1] = String.valueOf(rf.getTotal_items()); //f90--xi
            data[2] = String.valueOf(""); //r.getFi
            data[3] = String.valueOf(df.format(rf.getTotal_fr()));//r.getfr
            data[4] = String.valueOf("" );//df.format(r.getFr()) + "%")
            data[5] = String.valueOf(df.format(rf.getTotal_valores())); //df.format(r.getXi_fi())
            data[6] = String.valueOf(df.format(rf.getTotal_Xi_x_fi())); //df.format(r.getXi_x_fi()));
            model.addRow(data);
        
//		}
        this.jTable_Tabela_Frequencia.setModel(model);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(0).setMaxWidth(150);

        jTable_Tabela_Frequencia.getColumnModel().getColumn(1).setMaxWidth(150);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(2).setMaxWidth(150);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(3).setMaxWidth(150);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(4).setMaxWidth(150);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(5).setMaxWidth(150);
        jTable_Tabela_Frequencia.getColumnModel().getColumn(6).setMaxWidth(150);
        jTable_Tabela_Frequencia.setDefaultEditor(Object.class, null);
        //	Listar_Questionario_Resposta_item(this.id_questionario_resposta);


        DefaultListModel model_m = new DefaultListModel();
        
        double max_fi = 0;
        for (Linha_Frequencia r : Lista_Frequencia) {
            System.out.println(r);
            if (max_fi < r.getfi()) {
                max_fi = r.getfi();
            }
        }
        this.jList1.clearSelection();
        for (Linha_Frequencia r : Lista_Frequencia) {
            if (max_fi == r.getfi()) {
               model_m.addElement(r.getXi());
            }
        }
        this.jList1.setModel(model_m);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_Tabela_Frequencia = new javax.swing.JScrollPane();
        jTable_Tabela_Frequencia = new javax.swing.JTable();
        jPanel_Totais = new javax.swing.JPanel();
        jLabel_Media = new javax.swing.JLabel();
        jTextField_Media = new javax.swing.JTextField();
        jLabel_Mediana = new javax.swing.JLabel();
        jTextField_Mediana = new javax.swing.JTextField();
        jLabel_Variancia = new javax.swing.JLabel();
        jTextField_Variancia = new javax.swing.JTextField();
        jLabel_Desvio_Padrao = new javax.swing.JLabel();
        jTextField_Desvio_padrao = new javax.swing.JTextField();
        jLabel_Moda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel_botoes = new javax.swing.JPanel();
        jButton_Grafico = new javax.swing.JButton();
        jButton_Confirma = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabela de Frequencia");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(950, 500));
        setMinimumSize(new java.awt.Dimension(950, 500));

        jTable_Tabela_Frequencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "X", "X", "X", "X", "X", "X"
            }
        ));
        jTable_Tabela_Frequencia.setColumnSelectionAllowed(true);
        jTable_Tabela_Frequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Tabela_FrequenciaMouseClicked(evt);
            }
        });
        jScrollPane_Tabela_Frequencia.setViewportView(jTable_Tabela_Frequencia);
        jTable_Tabela_Frequencia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel_Totais.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_Totais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Media.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Media.setText("Media");
        jPanel_Totais.add(jLabel_Media, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jLabel_Media.getAccessibleContext().setAccessibleParent(jLabel_Media);

        jTextField_Media.setEditable(false);
        jTextField_Media.setBackground(new java.awt.Color(0, 255, 204));
        jTextField_Media.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_Media.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MediaActionPerformed(evt);
            }
        });
        jPanel_Totais.add(jTextField_Media, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, -1));

        jLabel_Mediana.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Mediana.setText("Mediana");
        jPanel_Totais.add(jLabel_Mediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jTextField_Mediana.setEditable(false);
        jTextField_Mediana.setBackground(new java.awt.Color(0, 255, 204));
        jTextField_Mediana.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel_Totais.add(jTextField_Mediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, -1));

        jLabel_Variancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Variancia.setText("Variancia");
        jPanel_Totais.add(jLabel_Variancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTextField_Variancia.setEditable(false);
        jTextField_Variancia.setBackground(new java.awt.Color(0, 255, 204));
        jTextField_Variancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField_Variancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_VarianciaActionPerformed(evt);
            }
        });
        jPanel_Totais.add(jTextField_Variancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 90, -1));

        jLabel_Desvio_Padrao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Desvio_Padrao.setText("Desvio Padrão");
        jPanel_Totais.add(jLabel_Desvio_Padrao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTextField_Desvio_padrao.setEditable(false);
        jTextField_Desvio_padrao.setBackground(new java.awt.Color(0, 255, 204));
        jTextField_Desvio_padrao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel_Totais.add(jTextField_Desvio_padrao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, -1));

        jLabel_Moda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Moda.setText("Moda");
        jPanel_Totais.add(jLabel_Moda, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 18));

        jList1.setBackground(new java.awt.Color(0, 255, 204));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jPanel_Totais.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 140, 110));

        jPanel_botoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_Grafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/grafico_32x32.jpeg"))); // NOI18N
        jButton_Grafico.setText("Gráfico");
        jButton_Grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficoActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Grafico);

        jButton_Confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok_32x32.jpg"))); // NOI18N
        jButton_Confirma.setText("Confirma");
        jButton_Confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConfirmaActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Confirma);

        jButton_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Sair.jpg"))); // NOI18N
        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Sair);

        jPanel_Totais.add(jPanel_botoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_Tabela_Frequencia, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addComponent(jPanel_Totais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane_Tabela_Frequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Totais, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(966, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConfirmaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_ConfirmaActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void jButton_GraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficoActionPerformed
        if (this.questionario_item_id <= 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma pergunta para geração do gráfico.");
            this.jTable_Tabela_Frequencia.requestFocus();
        } else {
            Frm_Tabela_Frequencia_Grafico chart = new Frm_Tabela_Frequencia_Grafico("Estatistica", "", this.questionario_item_id);
            chart.questionario_item_id = this.questionario_item_id;
            chart.pack();
            RefineryUtilities.centerFrameOnScreen(chart);
            chart.setVisible(true);
        }

    }//GEN-LAST:event_jButton_GraficoActionPerformed

    private void jTable_Tabela_FrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Tabela_FrequenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Tabela_FrequenciaMouseClicked

    private void jTextField_MediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_MediaActionPerformed

    private void jTextField_VarianciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_VarianciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_VarianciaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Tabela_Frequencia_Detalhe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Tabela_Frequencia_Detalhe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Tabela_Frequencia_Detalhe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Tabela_Frequencia_Detalhe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Tabela_Frequencia_Detalhe(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Confirma;
    private javax.swing.JButton jButton_Grafico;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel_Desvio_Padrao;
    private javax.swing.JLabel jLabel_Media;
    private javax.swing.JLabel jLabel_Mediana;
    private javax.swing.JLabel jLabel_Moda;
    private javax.swing.JLabel jLabel_Variancia;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel_Totais;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_Tabela_Frequencia;
    private javax.swing.JTable jTable_Tabela_Frequencia;
    private javax.swing.JTextField jTextField_Desvio_padrao;
    private javax.swing.JTextField jTextField_Media;
    private javax.swing.JTextField jTextField_Mediana;
    private javax.swing.JTextField jTextField_Variancia;
    // End of variables declaration//GEN-END:variables
}
