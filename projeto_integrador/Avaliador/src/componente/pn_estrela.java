/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.awt.Component;
import javax.swing.ImageIcon;

/**
 *
 * @author Milton
 */
public class pn_estrela extends javax.swing.JPanel {

	/**
	 * @return the numero_estrelas
	 */
	public int getNumero_estrelas() {
		return numero_estrelas;
	}

	/**
	 * @param numero_estrelas the numero_estrelas to set
	 */
	public void setNumero_estrelas(int numero_estrelas) {
		this.numero_estrelas = numero_estrelas;
		proc_conta_estrelas(numero_estrelas);
	}

	/**
	 * Creates new form p_estrela
	 */
	
	private int numero_estrelas;
	
	public pn_estrela() {
		initComponents();
		this.setNumero_estrelas(0);
		proc_conta_estrelas(0);
	}
	
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });
        jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel1PropertyChange(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("00");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok_32x32.jpg"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton7.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);

        jButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton8.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);

        jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton9.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);

        jButton10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton10.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

	        private void proc_conta_estrelas(int qtde_estrelas){
		//this.jButton1.setIcon(null);
	   
		ImageIcon img1 = new ImageIcon(getClass().getResource("estrela_amarela_32x32.jpg"));
		ImageIcon img2 = new ImageIcon(getClass().getResource("estrela_cinza_32x32.jpg"));		
		this.jButton1.setIcon(img2);
		this.jButton2.setIcon(img2);
		this.jButton3.setIcon(img2);
		this.jButton4.setIcon(img2);
		this.jButton5.setIcon(img2);
		this.jButton6.setIcon(img2);
		this.jButton7.setIcon(img2);
		this.jButton8.setIcon(img2);
		this.jButton9.setIcon(img2);
		this.jButton10.setIcon(img2);
		
		if (qtde_estrelas >= 1 ){
                   this.jButton1.setIcon(img1);
		}
		if (qtde_estrelas >= 2 ){
                   this.jButton2.setIcon(img1);
		}
		if (qtde_estrelas >= 3 ){
                   this.jButton3.setIcon(img1);
		}
		if (qtde_estrelas >= 4 ){
                   this.jButton4.setIcon(img1);
		}
		if (qtde_estrelas >= 5 ){
                   this.jButton5.setIcon(img1);
		}

		if (qtde_estrelas >= 6 ){
                   this.jButton6.setIcon(img1);
		}
		if (qtde_estrelas >= 7 ){
                   this.jButton7.setIcon(img1);
		}
		if (qtde_estrelas >= 8 ){
                   this.jButton8.setIcon(img1);
		}
		if (qtde_estrelas >= 9 ){
                   this.jButton9.setIcon(img1);
		}
		if (qtde_estrelas >= 10 ){
                   this.jButton10.setIcon(img1);
		}
		if (qtde_estrelas < 10){
		this.jLabel1.setText("0"+qtde_estrelas );
		} else {
		this.jLabel1.setText(""+ qtde_estrelas );
		}
		//this.setNumero_estrelas(qtde_estrelas);
		this.numero_estrelas = qtde_estrelas;
		
		
	}

        private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
                // TODO add your handling code here:
		this.setNumero_estrelas(0);
                //proc_conta_estrelas(0);
        }//GEN-LAST:event_jLabel1MouseClicked

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                //this.proc_conta_estrelas(1);// TODO add your handling code here:
		this.setNumero_estrelas(1);
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                //this.proc_conta_estrelas(2);// TODO add your handling code here:
		this.setNumero_estrelas(2);
        }//GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(3);// TODO ad
		this.setNumero_estrelas(3);
        }//GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(4);
		this.setNumero_estrelas(4);
        }//GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(5);
		this.setNumero_estrelas(5);
        }//GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(6);
		this.setNumero_estrelas(6);
        }//GEN-LAST:event_jButton6ActionPerformed

        private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(7);
		this.setNumero_estrelas(7);
        }//GEN-LAST:event_jButton7ActionPerformed

        private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(8);
		this.setNumero_estrelas(8);
        }//GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(9);
		this.setNumero_estrelas(9);
        }//GEN-LAST:event_jButton9ActionPerformed

        private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                // TODO add your handling code here:
                //proc_conta_estrelas(10);
		this.setNumero_estrelas(10);
        }//GEN-LAST:event_jButton10ActionPerformed

        private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
                // TODO add your handling code here:
		
//	for(Component c:this.getComponents()){
//			System.out.println(c);
//        }

        }//GEN-LAST:event_jPanel1ComponentResized

        private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange
                // TODO add your handling code here:
        }//GEN-LAST:event_jPanel1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}