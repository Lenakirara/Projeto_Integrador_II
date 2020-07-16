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
public class Grafico_Frequencia {
	private int questionario_id;
        private int questionario_item_id;
	private String descricao;
	private double valor;
        private double frequencia;

    public int getQuestionario_id() {
        return questionario_id;
    }

    public void setQuestionario_id(int questionario_id) {
        this.questionario_id = questionario_id;
    }

    public int getQuestionario_item_id() {
        return questionario_item_id;
    }

    public void setQuestionario_item_id(int questionario_item_id) {
        this.questionario_item_id = questionario_item_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Grafico_Frequencia{" + "questionario_id=" + questionario_id + ", questionario_item_id=" + questionario_item_id + ", descricao=" + descricao + ", valor=" + valor + ", frequencia=" + frequencia + '}';
    }

	
	
	
}
