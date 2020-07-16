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
public class Questionario_Resposta_Item {
	private int Questionario_Resposta_id;
	private int questionario_item_id;
	private String Observacao;
	private int valor;
	

	public int getQuestionario_Resposta_id() {
		return Questionario_Resposta_id;
	}

	public void setQuestionario_Resposta_id(int Questionario_Resposta_id) {
		this.Questionario_Resposta_id = Questionario_Resposta_id;
	}

	public int getQuestionario_item_id() {
		return questionario_item_id;
	}

	public void setQuestionario_item_id(int questionario_item_id) {
		this.questionario_item_id = questionario_item_id;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String Observacao) {
		this.Observacao = Observacao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Questionario_Resposta_Item{" + "Questionario_Resposta_id=" + Questionario_Resposta_id + ", questionario_item_id=" + questionario_item_id + ", Observacao=" + Observacao + ", valor=" + valor + '}';
	}


	
}
