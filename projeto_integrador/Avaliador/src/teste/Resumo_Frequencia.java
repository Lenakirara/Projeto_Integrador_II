/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Milton
 */
public class Resumo_Frequencia {
    private double variancia;
    private double media;
    private double mediana;
    private double desvio_padrao;
    private double moda;
    private double total_valores;
    private double total_fr;
    private double total_Xi_x_fi;

    public double getTotal_valores() {
        return total_valores;
    }

    public double getTotal_items() {
        return total_items;
    }
    private double total_items;
    public void calcula_desvio_padrao(){
        DecimalFormat df = new DecimalFormat("#.00");

        this.desvio_padrao =Math.sqrt(this.variancia);
        
    }
    public void calcula_variancia(ArrayList<Linha_Frequencia> lista_frequencia){
        double total_variancia = 0;
        this.variancia = 0;
        for (Linha_Frequencia r : lista_frequencia) {
            total_variancia = total_variancia + r.getXi_x_fi();
            
        }
        this.variancia = total_variancia / ( this.total_items - 1 );
        
    }
  
    
    public double calcula_media(ArrayList<Linha_Frequencia> lista_frequencia){
        double total_valores  = 0;
        double total_items = 0;
        this.media = 0;
        for (Linha_Frequencia r : lista_frequencia) {
            total_valores = total_valores + r.getXi_fi();
            total_items = total_items + r.getfi();
            
        }
       this.total_valores = total_valores;
       this.total_items = total_items;
       this.media = total_valores / total_items ;
        return this.media;
        
    }
    
//public double calcula_media(ArrayList<Linha_Frequencia> lista_frequencia){
//        double total_valores  = 0;
//        double total_items = 0;
//        this.media = 0;
//        for (Linha_Frequencia r : lista_frequencia) {
//            total_valores = total_valores + r.getXi_fi();
//            total_items = total_items + r.getfi();
//            
//        }
//       this.total_valores = total_valores;
//       this.total_items = total_items;
//       this.media = total_valores / total_items ;
//       return this.media;
//        
//    }

   public double calcula_mediana(ArrayList<Linha_Frequencia> lista_frequencia){
        this.mediana = 0;
        if (lista_frequencia.size() % 2 == 0){
           Linha_Frequencia lf;           
           int p1 = (lista_frequencia.size() / 2) - 1 ;
           int p2 = (p1+1);
           System.out.println("p1 " + p1);
           System.out.println("p2 " + p2);
           System.out.println("lista_frequencia.size()" + lista_frequencia.size());
           lf =lista_frequencia.get(p1);
           double v1 = lf.getXi();       
           System.out.println(lf);
           lf = lista_frequencia.get(p2);
           System.out.println(lf);
           double v2 = lf.getXi();
           this.mediana = (v1 + v2 ) / 2;           
        } else {
           Linha_Frequencia lf;           
           int p1 = ((lista_frequencia.size() ) +1 )/ 2  ;
           System.out.println("p1 " + p1);
           System.out.println("lista_frequencia.size()" + lista_frequencia.size());
           lf =lista_frequencia.get(p1);           
           double v1 = lf.getXi();       
           this.mediana = v1;
            
        }
        return this.mediana;

    }
    public double calcula_total_fr(ArrayList<Linha_Frequencia> lista_frequencia){
        this.total_fr = 0;
        for (Linha_Frequencia r : lista_frequencia) {
            this.total_fr = this.total_fr + r.getfr();
        }
        return this.total_fr;
    }
        
    public void calcula_total_Xi_x_fi(ArrayList<Linha_Frequencia> lista_frequencia){
        this.total_Xi_x_fi = 0;
        for (Linha_Frequencia r : lista_frequencia) {
            this.total_Xi_x_fi = this.total_Xi_x_fi + r.getXi_x_fi();
        }
     
    }
    /**
     * @return the variancia
     */
    public double getVariancia() {
        return variancia;
    }

    /**
     * @param variancia the variancia to set
     */
    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }

    /**
     * @return the media
     */
    public double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(double media) {
        this.media = media;
    }

    /**
     * @return the mediana
     */
    public double getMediana() {
        return mediana;
    }

    /**
     * @param mediana the mediana to set
     */
    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    /**
     * @return the desvio_padrao
     */
    public double getDesvio_padrao() {
        return desvio_padrao;
    }

    /**
     * @param desvio_padrao the desvio_padrao to set
     */
    public void setDesvio_padrao(double desvio_padrao) {
        this.desvio_padrao = desvio_padrao;
    }

    /**
     * @return the moda
     */
    public double getModa() {
        return moda;
    }

    /**
     * @param moda the moda to set
     */
    public void setModa(double moda) {
        this.moda = moda;
    }

    public double getTotal_fr() {
        return total_fr;
    }

    public double getTotal_Xi_x_fi() {
        return total_Xi_x_fi;
    }

    @Override
    public String toString() {
        return "Resumo_Frequencia{" + "variancia=" + variancia + ", media=" + media + ", mediana=" + mediana + ", desvio_padrao=" + desvio_padrao + ", moda=" + moda + ", total_valores=" + total_valores + ", total_items=" + total_items + '}';
    }


            
    
}
