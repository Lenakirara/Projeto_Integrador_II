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
 * @author milto
 */
public class teste_frequencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Linha_Frequencia> Lista_Frequencia = new ArrayList();
        Linha_Frequencia lf;
        DecimalFormat df = new DecimalFormat("#.00");
        double[] a_Xi = new double[]{13,14,15,16,20,23,24,27,31,32,35,40,41,42,43};
        double[] a_fi = new double[]{1,5,1,2,1,2,1,2,1,1,1,1,1,1,1};

        for (int i = 0; i < a_Xi.length; i++) {
//            System.out.println(a_Xi[i]);
//            System.out.println(a_fi[i]);
            lf = new Linha_Frequencia();
            lf.setXi(a_Xi[i]);
            lf.setfi(a_fi[i]);
            Lista_Frequencia.add(lf);
        }
        
           for(Linha_Frequencia r:Lista_Frequencia){
                 r.calcula_Xi_fi();
            System.out.println(r);
        }   
        Resumo_Frequencia rf = new Resumo_Frequencia();
        rf.calcula_media(Lista_Frequencia);
        rf.calcula_mediana(Lista_Frequencia);
        System.out.println(rf);
//        for(Linha_Frequencia r:Lista_Frequencia){           
//            r.calcula_Xi_fi();
//            System.out.println(r);
//        }   
      for(Linha_Frequencia r:Lista_Frequencia){
      r.calcula_Xi_x_fi(rf.getMedia());
          System.out.println(r);
      }
        
      rf.calcula_variancia(Lista_Frequencia);
        System.out.println("variancia: " + df.format(rf.getVariancia()));
      rf.calcula_desvio_padrao();
        System.out.println("Desvio Padrão: "+ df.format(rf.getDesvio_padrao()));
      double max_fi = 0;
      for(Linha_Frequencia r:Lista_Frequencia){
          System.out.println(r);
         if (max_fi < r.getfi()){
             max_fi = r.getfi();
         }
      }
      
      for(Linha_Frequencia r:Lista_Frequencia){
         if (max_fi == r.getfi()){
             System.out.println("Moda(s): " + r.getXi());
         }
      }
      
//      double [][]Valores = new double [2][Lista_Frequencia.size()];
//      for(Linha_Frequencia r:Lista_Frequencia){
//          for (int i = 0;i<= Lista_Frequencia.size();i++){
//              if (valores[i] == r.getXi()) {}
//              
//          }
//      }
 
              
   
                
        
        // TODO code application logic here
    }
    
}
