/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import dao.Questionario_DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import modelo.Questionario;

/**
 *
 * @author Milton
 */
public class Frm_Resposta_Lista extends javax.swing.JFrame {

	/**
	 * Creates new form Frm_Lista_Resposta
	 */
	int id_questionario_resposta;
        final JFileChooser fc = new JFileChooser();
	
	public Frm_Resposta_Lista() {
		initComponents();
		Listar_Questionario_Resposta();		
		setSize(950,500);			
	}

	void Listar_Questionario_Resposta(){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Questionario");
		model.addColumn("Nome");
		model.addColumn("E-Mail");
		model.addColumn("Tempo");
		model.addColumn("Score");
		model.addColumn("Data");
		String[] data = new String[7];		
		for (modelo.Questionario_Resposta q : dao.Questionario_Reposta_DAO.listar_Questionario_Resposta(0)) {
		     data[0] = String.valueOf(q.getQuestionario_resposta_id());
	             data[1] = String.valueOf(q.getQuestionario_id());
		     data[2] = q.getNome();
		     data[3] = q.getE_mail();
		     data[4] = String.valueOf(q.getTotal_score());
		     data[5] = String.valueOf(q.getTotal_tempo());
		     data[6] = q.getData_lancto();
		     model.addRow(data);
		}
		this.jTable_Questionario_Resposta.setModel(model);
		jTable_Questionario_Resposta.getColumnModel().getColumn(0).setMaxWidth(100);
		jTable_Questionario_Resposta.getColumnModel().getColumn(1).setMaxWidth(100);
		jTable_Questionario_Resposta.getColumnModel().getColumn(2).setMaxWidth(300);
		jTable_Questionario_Resposta.getColumnModel().getColumn(3).setMaxWidth(300);
		jTable_Questionario_Resposta.getColumnModel().getColumn(4).setMaxWidth(100);
		jTable_Questionario_Resposta.getColumnModel().getColumn(5).setMaxWidth(100);
		jTable_Questionario_Resposta.getColumnModel().getColumn(6).setMaxWidth(100);	
		jTable_Questionario_Resposta.setDefaultEditor(Object.class, null);
		Listar_Questionario_Resposta_item(this.id_questionario_resposta);
	}		
	        private void ler_Arquivo() {
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			System.out.println("Arquivo de score selecionado: " + file.getName() + ".");
			try {
				String arquivo = file.getAbsolutePath();
				FileReader arq = new FileReader(arquivo);
				BufferedReader lerArq = new BufferedReader(arq);
				String linha = lerArq.readLine();
				while (linha != null) {
					System.out.printf("%s\n", linha);
					linha = lerArq.readLine(); // lê da segunda até a última linha
				}

				arq.close();
			} catch (IOException e) {
				System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
			}
		} else {
			System.out.println("Nenhum arquivo de score selecionado.");
		}
	}

	void Listar_Questionario_Resposta_item(int Questionario_Resposta_id){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("item");
		model.addColumn("observacao");
		model.addColumn("valor");
		String[] data = new String[4];
                if ( id_questionario_resposta > 0 ) {
		for (modelo.Questionario_Resposta_Item q : dao.Questionario_Resposta_Item_DAO.listar_Questionario_Resposta_Item(Questionario_Resposta_id)){
		     data[0] = String.valueOf(q.getQuestionario_Resposta_id());
	             data[1] = String.valueOf(q.getQuestionario_item_id());
		     data[2] = q.getObservacao();
		     data[3] = String.valueOf(q.getValor());

		     model.addRow(data);
		     }
		} else {
		model.addRow(data);
		}

		this.jTable_Questionario_Resposta_Item.setModel(model);
		this.jTable_Questionario_Resposta_Item.getColumnModel().getColumn(0).setMaxWidth(100);
		this.jTable_Questionario_Resposta_Item.getColumnModel().getColumn(1).setMaxWidth(100);
		this.jTable_Questionario_Resposta_Item.getColumnModel().getColumn(2).setMaxWidth(400);
		this.jTable_Questionario_Resposta_Item.getColumnModel().getColumn(3).setMaxWidth(100);	
		jTable_Questionario_Resposta.setDefaultEditor(Object.class, null);
	}		
	

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_questionario = new javax.swing.JScrollPane();
        jTable_Questionario_Resposta = new javax.swing.JTable();
        jScrollPane_Questionario_Resposta_Item = new javax.swing.JScrollPane();
        jTable_Questionario_Resposta_Item = new javax.swing.JTable();
        jPanel_botoes = new javax.swing.JPanel();
        jButton_Listar = new javax.swing.JButton();
        jButton_score = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avaliador - Lista de Respostas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane_questionario.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane_questionario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_questionario.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_questionario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jScrollPane_questionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane_questionarioMouseClicked(evt);
            }
        });

        jTable_Questionario_Resposta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Código", "Descrição"
            }
        ));
        jTable_Questionario_Resposta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Questionario_RespostaMouseClicked(evt);
            }
        });
        jScrollPane_questionario.setViewportView(jTable_Questionario_Resposta);

        getContentPane().add(jScrollPane_questionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 830, 150));

        jTable_Questionario_Resposta_Item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Title 3"
            }
        ));
        jTable_Questionario_Resposta_Item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Questionario_Resposta_ItemMouseClicked(evt);
            }
        });
        jScrollPane_Questionario_Resposta_Item.setViewportView(jTable_Questionario_Resposta_Item);
        jTable_Questionario_Resposta_Item.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane_Questionario_Resposta_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 830, 160));

        jPanel_botoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_Listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Recycle_40148.png"))); // NOI18N
        jButton_Listar.setText("Listar");
        jButton_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Listar);

        jButton_score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Game_40128.png"))); // NOI18N
        jButton_score.setText("Score");
        jButton_score.setEnabled(false);
        jButton_score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_scoreActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_score);

        jButton_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Sair.jpg"))); // NOI18N
        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Sair);

        getContentPane().add(jPanel_botoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private void jTable_Questionario_RespostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Questionario_RespostaMouseClicked
                // TODO add your handling code here:
		int row = jTable_Questionario_Resposta.getSelectedRow();
                int col = jTable_Questionario_Resposta.getSelectedColumn();
                Object data = (Object)jTable_Questionario_Resposta.getValueAt(row, 0);
		
		this.id_questionario_resposta = 0;
		
                if (data != null){
		   this.id_questionario_resposta =  Integer.parseInt(String.valueOf(data));
                }
		Listar_Questionario_Resposta_item(this.id_questionario_resposta);

        }//GEN-LAST:event_jTable_Questionario_RespostaMouseClicked

        private void jTable_Questionario_Resposta_ItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Questionario_Resposta_ItemMouseClicked
                // TODO add your handling code here:
        }//GEN-LAST:event_jTable_Questionario_Resposta_ItemMouseClicked

        private void jButton_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListarActionPerformed
                // TODO add your handling code here:
                Listar_Questionario_Resposta();
        }//GEN-LAST:event_jButton_ListarActionPerformed

        private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
                this.dispose();
        }//GEN-LAST:event_jButton_SairActionPerformed

        private void jScrollPane_questionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane_questionarioMouseClicked
                // TODO add your handling code here:
		int row = jTable_Questionario_Resposta.getSelectedRow();
                int col = jTable_Questionario_Resposta.getSelectedColumn();
                Object data = (Object)jTable_Questionario_Resposta.getValueAt(row, 0);
		
		this.id_questionario_resposta = 0;
		
                if (data != null){
		   this.id_questionario_resposta =  Integer.parseInt(String.valueOf(data));
                }
		
		this.dispose();		
        }//GEN-LAST:event_jScrollPane_questionarioMouseClicked

    private void jButton_scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_scoreActionPerformed
        // TODO add youer handling code here:
        ler_Arquivo();
    }//GEN-LAST:event_jButton_scoreActionPerformed

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
			java.util.logging.Logger.getLogger(Frm_Resposta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Frm_Resposta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Frm_Resposta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Frm_Resposta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Frm_Resposta_Lista().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Listar;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_score;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JScrollPane jScrollPane_Questionario_Resposta_Item;
    private javax.swing.JScrollPane jScrollPane_questionario;
    private javax.swing.JTable jTable_Questionario_Resposta;
    private javax.swing.JTable jTable_Questionario_Resposta_Item;
    // End of variables declaration//GEN-END:variables
}
