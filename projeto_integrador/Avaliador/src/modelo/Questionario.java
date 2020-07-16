/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Milton
 */
public class Questionario {
	private int questionario_id;
	private String descricao;
	
	public int getQuestionario_id() {
		return questionario_id;
	}

	public void setQuestionario_id(int questionario_id) {
		this.questionario_id = questionario_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return "Questionario{" + "questionario_id=" + questionario_id + ", descricao=" + descricao + '}';
	}
	
	
	
	
}