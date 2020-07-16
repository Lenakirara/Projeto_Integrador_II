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
public class Questionario_Grafico {
	private int questionario_id;
	private String descricao;
	private int questionario_item_id;
	private String descricao_pergunta;
	private double media_valor;

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

	public int getQuestionario_item_id() {
		return questionario_item_id;
	}

	public void setQuestionario_item_id(int questionario_item_id) {
		this.questionario_item_id = questionario_item_id;
	}

	public String getDescricao_pergunta() {
		return descricao_pergunta;
	}

	public void setDescricao_pergunta(String descricao_pergunta) {
		this.descricao_pergunta = descricao_pergunta;
	}

	public double getMedia_valor() {
		return media_valor;
	}

	public void setMedia_valor(double media_valor) {
		this.media_valor = media_valor;
	}

	@Override
	public String toString() {
		return "Questionario_Grafico{" + "questionario_id=" + questionario_id + ", descricao=" + descricao + ", questionario_item_id=" + questionario_item_id + ", descricao_pergunta=" + descricao_pergunta + ", media_valor=" + media_valor + '}';
	}
	
	
}
