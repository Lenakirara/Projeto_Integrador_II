/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import dao.Questionario_DAO;
import dao.Questionario_Item_DAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Questionario;
import modelo.Questionario_Item;

/**
 *
 * @author Milton
 */
public class Frm_Questionario extends javax.swing.JFrame {

	/**
	 * Creates new form Frm_Questionario
	 */
	public Frm_Questionario() {
		initComponents();
		configura_botoes(9);   
	        setSize(950,500);

	}
	private void limpar(int p_opcao) {
		if (p_opcao == 0) {
			this.jTextField_questionario_id.setText("");
			this.jTextField_descricao.setText("");
		}
		if (p_opcao == 1 || p_opcao == 0) {
			this.jLabel_questionario_item_id.setText("");
			this.jTextField_ordem.setText("");
			this.jTextField_pergunta.setText("");
		}
		if (p_opcao == 2 || p_opcao == 0) {
			listar_Questionario_Item();
		}
	}

	private void listar_Questionario_Item() {
		try {

			DefaultTableModel model = new DefaultTableModel();
			String headers[] = {"Código", "Ordem", "Descrição"};
			model.setColumnIdentifiers(headers);
			model.setRowCount(0);
			jTable_Questionario_Item.setModel(model);
			int id = Integer.valueOf("0" + this.jTextField_questionario_id.getText());
			if (id > 0) {
				for (Questionario_Item q : Questionario_Item_DAO.listar(id)) {
					Object[] rowData = {q.getQuestionario_item_id(), q.getOrdem(), q.getDescricao()};
					model.addRow(rowData);
				}
				jTable_Questionario_Item.setModel(model);
			}
			jTable_Questionario_Item.getColumnModel().getColumn(0).setMaxWidth(100);
			jTable_Questionario_Item.getColumnModel().getColumn(1).setMaxWidth(100);
			jTable_Questionario_Item.getColumnModel().getColumn(2).setMaxWidth(800);

			jTable_Questionario_Item.setDefaultEditor(Object.class, null);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configura_botoes(int p_opcao) {
		
		jPanel_chave.setEnabled(true);
		jPanel_Questionario.setEnabled(true);
		jPanel_botoes.setEnabled(true);
		jPanel_campos.setEnabled(true);
		jTextField_questionario_id.setEnabled(true);
		jTextField_descricao.setEnabled(true);		
		jTextField_ordem.setEnabled(true);
		jTextField_pergunta.setEnabled(true);
		jTable_Questionario_Item.setEnabled(true);

		jButton_excluir_Pergunta.setEnabled(true);
		jButton_limpar_Pergunta.setEnabled(true);
		jButton_Incluir_Pergunta.setEnabled(true);
		
		jButton_Consultar.setEnabled(true);
		
		jButton_Novo.setEnabled(true);
		jButton_Editar.setEnabled(true);
		jButton_Gravar.setEnabled(true);
		jButton_Excluir.setEnabled(true);
		jButton_Cancelar.setEnabled(true);
		jButton_Listar.setEnabled(true);
		jButton_Sair.setEnabled(true);

		
		switch (p_opcao) {
			case 1: // 1-Novo
				this.jTextField_questionario_id.setText("");				
				this.jTextField_questionario_id.setEnabled(false);
				this.jButton_Novo.setEnabled(false);
				this.jButton_Editar.setEnabled(false);
				this.jButton_Excluir.setEnabled(false);
				this.jTextField_ordem.setEnabled(false);
				this.jTextField_pergunta.setEnabled(false);
				this.jButton_excluir_Pergunta.setEnabled(false);
				this.jButton_limpar_Pergunta.setEnabled(false);
				this.jButton_Incluir_Pergunta.setEnabled(false);
				this.jButton_Listar.setEnabled(false);
				this.jButton_Consultar.setEnabled(false);

				break;
			case 2: // 2-Consulta
				
				this.jTextField_questionario_id.setEnabled(false);
				this.jButton_Novo.setEnabled(false);
				this.jButton_Consultar.setEnabled(false);
				this.jButton_Listar.setEnabled(false);
				
				jPanel_chave.setEnabled(false);
				jPanel_Questionario.setEnabled(false);
				jPanel_botoes.setEnabled(false);
				jTextField_descricao.setEnabled(false);		
				jTextField_ordem.setEnabled(false);
				jTextField_pergunta.setEnabled(false);
				this.jTable_Questionario_Item.setEnabled(false);

				jButton_excluir_Pergunta.setEnabled(false);
				jButton_limpar_Pergunta.setEnabled(false);
				jButton_Incluir_Pergunta.setEnabled(false);
				jButton_Novo.setEnabled(false);				
				jButton_Gravar.setEnabled(false);
				
				break;
			case 3: // 3-Editar

				
				
				this.jTextField_questionario_id.setEnabled(false);
				this.jButton_Novo.setEnabled(false);
				this.jButton_Consultar.setEnabled(false);
				this.jButton_Listar.setEnabled(false);
				
				jButton_Novo.setEnabled(false);				
				jButton_Excluir.setEnabled(false);				
								
 	                        break;			
				
			default: // 9-Cancelar				
				this.jTextField_descricao.setEnabled(false);
				this.jTable_Questionario_Item.setEnabled(false);				
				
				this.jButton_Editar.setEnabled(false);
				this.jButton_Gravar.setEnabled(false);
				this.jButton_Excluir.setEnabled(false);
				this.jButton_Listar.setEnabled(false);
				
				this.jTextField_ordem.setEnabled(false);
				this.jTextField_pergunta.setEnabled(false);
				this.jButton_excluir_Pergunta.setEnabled(false);
				jButton_Cancelar.setEnabled(false);
				this.jButton_limpar_Pergunta.setEnabled(false);
				this.jButton_Incluir_Pergunta.setEnabled(false);
				this.jTextField_questionario_id.requestFocus();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Questionario = new javax.swing.JPanel();
        jPanel_chave = new javax.swing.JPanel();
        jLabel_questionario_id = new javax.swing.JLabel();
        jTextField_questionario_id = new javax.swing.JTextField();
        jButton_Consultar = new javax.swing.JButton();
        jPanel_campos = new javax.swing.JPanel();
        jLabel_descricao = new javax.swing.JLabel();
        jTextField_descricao = new javax.swing.JTextField();
        jPanel_botoes = new javax.swing.JPanel();
        jButton_Novo = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Gravar = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_Listar = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();
        jPanel_Questionario_Item = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Questionario_Item = new javax.swing.JTable();
        jPanel_campos_ordem = new javax.swing.JPanel();
        jLabel_questionario_item_id = new javax.swing.JLabel();
        jLabel_Perguntas = new javax.swing.JLabel();
        jTextField_pergunta = new javax.swing.JTextField();
        lbl_Ordem = new javax.swing.JLabel();
        jTextField_ordem = new javax.swing.JTextField();
        jButton_limpar_Pergunta = new javax.swing.JButton();
        jButton_Incluir_Pergunta = new javax.swing.JButton();
        jButton_excluir_Pergunta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliador - Cadastro de Questionário ");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(950, 420));

        jPanel_Questionario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel_chave.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_questionario_id.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_questionario_id.setText("Código");

        jTextField_questionario_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_questionario_idActionPerformed(evt);
            }
        });

        jButton_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Consultar.png"))); // NOI18N
        jButton_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_chaveLayout = new javax.swing.GroupLayout(jPanel_chave);
        jPanel_chave.setLayout(jPanel_chaveLayout);
        jPanel_chaveLayout.setHorizontalGroup(
            jPanel_chaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_chaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_questionario_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_questionario_id, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_chaveLayout.setVerticalGroup(
            jPanel_chaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_chaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_chaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_questionario_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_questionario_id))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_chaveLayout.createSequentialGroup()
                .addComponent(jButton_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel_campos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_descricao.setForeground(new java.awt.Color(0, 0, 51));
        jLabel_descricao.setText("Descrição:");

        jTextField_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_camposLayout = new javax.swing.GroupLayout(jPanel_campos);
        jPanel_campos.setLayout(jPanel_camposLayout);
        jPanel_camposLayout.setHorizontalGroup(
            jPanel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_camposLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel_descricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_camposLayout.setVerticalGroup(
            jPanel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_descricao)
                    .addComponent(jTextField_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_QuestionarioLayout = new javax.swing.GroupLayout(jPanel_Questionario);
        jPanel_Questionario.setLayout(jPanel_QuestionarioLayout);
        jPanel_QuestionarioLayout.setHorizontalGroup(
            jPanel_QuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_QuestionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_chave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_QuestionarioLayout.setVerticalGroup(
            jPanel_QuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_QuestionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_QuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_chave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_botoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Incluir.png"))); // NOI18N
        jButton_Novo.setText("Novo");
        jButton_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NovoActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Novo);

        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Edit_page.png"))); // NOI18N
        jButton_Editar.setText("Edita");
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Editar);

        jButton_Gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/gravar.png"))); // NOI18N
        jButton_Gravar.setText("Gravar");
        jButton_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GravarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Gravar);

        jButton_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Excluir.png"))); // NOI18N
        jButton_Excluir.setText("Excluir");
        jButton_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcluirActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Excluir);

        jButton_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Cancelar.png"))); // NOI18N
        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Cancelar);

        jButton_Listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Consultar.png"))); // NOI18N
        jButton_Listar.setText("Listar");
        jButton_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Listar);

        jButton_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Sair.jpg"))); // NOI18N
        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_Sair);

        jPanel_Questionario_Item.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable_Questionario_Item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ordem", "Descrição"
            }
        ));
        jTable_Questionario_Item.setColumnSelectionAllowed(true);
        jTable_Questionario_Item.setGridColor(new java.awt.Color(153, 153, 153));
        jTable_Questionario_Item.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable_Questionario_Item.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Questionario_Item.setShowGrid(false);
        jTable_Questionario_Item.getTableHeader().setReorderingAllowed(false);
        jTable_Questionario_Item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Questionario_ItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Questionario_Item);
        jTable_Questionario_Item.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel_campos_ordem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_questionario_item_id.setForeground(java.awt.Color.blue);
        jLabel_questionario_item_id.setName(""); // NOI18N

        jLabel_Perguntas.setForeground(new java.awt.Color(0, 0, 51));
        jLabel_Perguntas.setText("Pergunta:");

        jTextField_pergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_perguntaActionPerformed(evt);
            }
        });

        lbl_Ordem.setForeground(new java.awt.Color(0, 0, 51));
        lbl_Ordem.setText("Ordem");

        jTextField_ordem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ordemActionPerformed(evt);
            }
        });

        jButton_limpar_Pergunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Note_40141.png"))); // NOI18N
        jButton_limpar_Pergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpar_PerguntaActionPerformed(evt);
            }
        });

        jButton_Incluir_Pergunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Down arrow_40122(1).png"))); // NOI18N
        jButton_Incluir_Pergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Incluir_PerguntaActionPerformed(evt);
            }
        });

        jButton_excluir_Pergunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Cancel_40110.png"))); // NOI18N
        jButton_excluir_Pergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_excluir_PerguntaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_campos_ordemLayout = new javax.swing.GroupLayout(jPanel_campos_ordem);
        jPanel_campos_ordem.setLayout(jPanel_campos_ordemLayout);
        jPanel_campos_ordemLayout.setHorizontalGroup(
            jPanel_campos_ordemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel_questionario_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbl_Ordem)
                .addGap(14, 14, 14)
                .addComponent(jTextField_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel_Perguntas)
                .addGap(10, 10, 10)
                .addComponent(jTextField_pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton_Incluir_Pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton_limpar_Pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton_excluir_Pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_campos_ordemLayout.setVerticalGroup(
            jPanel_campos_ordemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel_questionario_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbl_Ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTextField_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel_Perguntas))
            .addGroup(jPanel_campos_ordemLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTextField_pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jButton_Incluir_Pergunta)
            .addComponent(jButton_limpar_Pergunta)
            .addComponent(jButton_excluir_Pergunta)
        );

        javax.swing.GroupLayout jPanel_Questionario_ItemLayout = new javax.swing.GroupLayout(jPanel_Questionario_Item);
        jPanel_Questionario_Item.setLayout(jPanel_Questionario_ItemLayout);
        jPanel_Questionario_ItemLayout.setHorizontalGroup(
            jPanel_Questionario_ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Questionario_ItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Questionario_ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel_campos_ordem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Questionario_ItemLayout.setVerticalGroup(
            jPanel_Questionario_ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Questionario_ItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_campos_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_botoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel_Questionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_Questionario_Item, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel_Questionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel_Questionario_Item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private void jTextField_questionario_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_questionario_idActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_jTextField_questionario_idActionPerformed

        private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
		this.dispose();
        }//GEN-LAST:event_jButton_SairActionPerformed

        private void jButton_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NovoActionPerformed
		this.limpar(0);
		this.configura_botoes(1);

        }//GEN-LAST:event_jButton_NovoActionPerformed

        private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
		this.limpar(0);// TODO add your handling code here:
		this.configura_botoes(9);
        }//GEN-LAST:event_jButton_CancelarActionPerformed

        private void jTextField_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descricaoActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_jTextField_descricaoActionPerformed

        private void jButton_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GravarActionPerformed
		// TODO add your handling code here:
		if (this.jTextField_descricao.getText().length() <= 0){
		   JOptionPane.showMessageDialog(this,"Informe a descrição do questionario!");
		   this.jTextField_descricao.requestFocus();
		   return;
		}
		Questionario q = new Questionario();
		try {
			if (this.jTextField_questionario_id.getText().length() <= 0) {
				this.jTextField_questionario_id.setText("0");
			}
			q.setQuestionario_id(Integer.valueOf(this.jTextField_questionario_id.getText()));
			q.setDescricao(this.jTextField_descricao.getText());
			Questionario_DAO.gravar(q);
			this.jTextField_questionario_id.setText("0" + q.getQuestionario_id());
			this.configura_botoes(2);

			//limpar(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

        }//GEN-LAST:event_jButton_GravarActionPerformed


        private void jButton_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcluirActionPerformed
		// TODO add your handling code here:
		Questionario q = new Questionario();
		try {
			q.setQuestionario_id(Integer.valueOf(this.jTextField_questionario_id.getText()));
			Questionario_DAO.excluir(q);
			configura_botoes(0);
			limpar(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

        }//GEN-LAST:event_jButton_ExcluirActionPerformed

        private void jButton_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConsultarActionPerformed
		if (this.jTextField_questionario_id.getText().length() > 0) {
			Questionario q = new Questionario();
			q.setQuestionario_id(Integer.valueOf(this.jTextField_questionario_id.getText()));
			q = Questionario_DAO.consultar(q);
			if (q != null) {
				this.jTextField_questionario_id.setText(q.getQuestionario_id() + "");
				this.jTextField_descricao.setText(q.getDescricao());
				listar_Questionario_Item();
				configura_botoes(2);

			} else {
				System.out.println("Registro inexistente.");
			}

		} else {
			jButton_ListarActionPerformed(null);
		}

        }//GEN-LAST:event_jButton_ConsultarActionPerformed

        private void jButton_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListarActionPerformed

		Frm_Questionario_Lista frm_questionario_lista = new Frm_Questionario_Lista(this, true,1);
		frm_questionario_lista.setVisible(true);
		if (frm_questionario_lista.questionario_id > 0) {
			this.jTextField_questionario_id.setText(frm_questionario_lista.questionario_id + "");
			jButton_ConsultarActionPerformed(null);
		}


        }//GEN-LAST:event_jButton_ListarActionPerformed

        private void jTextField_perguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_perguntaActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_jTextField_perguntaActionPerformed

        private void jButton_Incluir_PerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Incluir_PerguntaActionPerformed
		// TODO add your handling code here:
		if (this.jTextField_questionario_id.getText().length() <= 0) {					
		   JOptionPane.showMessageDialog(this,"Questionário ainda não gravado!");
		   return;
		}
		
		if (this.jTextField_ordem.getText().length() <= 0) {
		    JOptionPane.showMessageDialog(this,"Informe a ordem para a pergunta.");
		    this.jTextField_ordem.requestFocus();
		    return;
		}		

		if (this.jTextField_pergunta.getText().length() <= 0) {
		   JOptionPane.showMessageDialog(this,"Informe a descrição da pergunta.");
		   this.jTextField_pergunta.requestFocus();
		   return;

		}


		Questionario_Item qi = new Questionario_Item();
		qi.setQuestionario_id(Integer.valueOf(this.jTextField_questionario_id.getText()));
		qi.setDescricao(this.jTextField_pergunta.getText());
		qi.setQuestionario_item_id(Integer.valueOf("0" + this.jLabel_questionario_item_id.getText()));
		qi.setOrdem(Integer.valueOf(this.jTextField_ordem.getText()));
		Questionario_Item_DAO.gravar(qi);
		this.listar_Questionario_Item();
		limpar(1);


        }//GEN-LAST:event_jButton_Incluir_PerguntaActionPerformed

        private void jTextField_ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ordemActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_jTextField_ordemActionPerformed

        private void jButton_excluir_PerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_excluir_PerguntaActionPerformed

		try {
			int id = Integer.parseInt(String.valueOf(this.jLabel_questionario_item_id.getText()));
			if (id > 0) {
				Questionario_Item_DAO.excluir(id);
				listar_Questionario_Item();
				limpar(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


        }//GEN-LAST:event_jButton_excluir_PerguntaActionPerformed

        private void jTable_Questionario_ItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Questionario_ItemMouseClicked
		int row = this.jTable_Questionario_Item.getSelectedRow();
		int col = this.jTable_Questionario_Item.getSelectedColumn();
		limpar(1);

		if (row >= 0) {
			Object id = (Object) this.jTable_Questionario_Item.getValueAt(row, 0);
			Object ordem = (Object) this.jTable_Questionario_Item.getValueAt(row, 1);
			Object descricao = (Object) this.jTable_Questionario_Item.getValueAt(row, 2);
			//JOptionPane.showMessageDialog(null, data);
			this.jLabel_questionario_item_id.setText(String.valueOf(id));
			this.jTextField_ordem.setText(String.valueOf(ordem));
			this.jTextField_pergunta.setText(String.valueOf(descricao));

		}                // TODO add your handling code here:
        }//GEN-LAST:event_jTable_Questionario_ItemMouseClicked

        private void jButton_limpar_PerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpar_PerguntaActionPerformed
		// TODO add your handling code here:
		limpar(1);
        }//GEN-LAST:event_jButton_limpar_PerguntaActionPerformed

        private void jButton_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditarActionPerformed
                // TODO add your handling code here:
		this.configura_botoes(3);
        }//GEN-LAST:event_jButton_EditarActionPerformed

	

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
			java.util.logging.Logger.getLogger(Frm_Questionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Frm_Questionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Frm_Questionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Frm_Questionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				//new Frm_Questionario().setVisible(true);
				Frm_Questionario f = new Frm_Questionario();
				f.setVisible(true);
				f.setLocationRelativeTo(null); 				
				
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Consultar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_Gravar;
    private javax.swing.JButton jButton_Incluir_Pergunta;
    private javax.swing.JButton jButton_Listar;
    private javax.swing.JButton jButton_Novo;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_excluir_Pergunta;
    private javax.swing.JButton jButton_limpar_Pergunta;
    private javax.swing.JLabel jLabel_Perguntas;
    private javax.swing.JLabel jLabel_descricao;
    private javax.swing.JLabel jLabel_questionario_id;
    private javax.swing.JLabel jLabel_questionario_item_id;
    private javax.swing.JPanel jPanel_Questionario;
    private javax.swing.JPanel jPanel_Questionario_Item;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JPanel jPanel_campos;
    private javax.swing.JPanel jPanel_campos_ordem;
    private javax.swing.JPanel jPanel_chave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Questionario_Item;
    private javax.swing.JTextField jTextField_descricao;
    private javax.swing.JTextField jTextField_ordem;
    private javax.swing.JTextField jTextField_pergunta;
    private javax.swing.JTextField jTextField_questionario_id;
    private javax.swing.JLabel lbl_Ordem;
    // End of variables declaration//GEN-END:variables
}
