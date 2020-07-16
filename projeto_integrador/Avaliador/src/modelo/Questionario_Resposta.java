/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Milton
 */
public class Questionario_Resposta {
	private int questionario_resposta_id;
	private int questionario_id;
        private String  nome;
        private String e_mail;        
	private double total_tempo;
	private double total_score;
	private String data_lancto;
	

	public int getQuestionario_resposta_id() {
		return questionario_resposta_id;
	}

	public void setQuestionario_resposta_id(int questionario_resposta_id) {
		this.questionario_resposta_id = questionario_resposta_id;
	}

	public int getQuestionario_id() {
		return questionario_id;
	}

	public void setQuestionario_id(int questionario_id) {
		this.questionario_id = questionario_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getData_lancto() {
		return data_lancto;
	}

	public void setData_lancto(String data_lancto) {
		this.data_lancto = data_lancto;
	}

	public double getTotal_tempo() {
		return total_tempo;
	}

	public void setTotal_tempo(double total_tempo) {
		this.total_tempo = total_tempo;
	}

	public double getTotal_score() {
		return total_score;
	}

	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}

	@Override
	public String toString() {
		return "Questionario_Resposta{" + "questionario_resposta_id=" + questionario_resposta_id + ", questionario_id=" + questionario_id + ", nome=" + nome + ", e_mail=" + e_mail + ", data_lancto=" + data_lancto + ", total_tempo=" + total_tempo + ", total_score=" + total_score + '}';
	}

	

	
}
