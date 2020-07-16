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
public class Questionario_Item {
       private int questionario_item_id;
       private int questionario_id;
       private int ordem;
       private String descricao;

	public int getQuestionario_item_id() {
		return questionario_item_id;
	}

	public void setQuestionario_item_id(int questionario_item_id) {
		this.questionario_item_id = questionario_item_id;
	}

	public int getQuestionario_id() {
		return questionario_id;
	}

	public void setQuestionario_id(int questionario_id) {
		this.questionario_id = questionario_id;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Questionario_Item{" + "questionario_item_id=" + questionario_item_id + ", questionario_id=" + questionario_id + ", ordem=" + ordem + ", descricao=" + descricao + '}';
	}

       
	
}
