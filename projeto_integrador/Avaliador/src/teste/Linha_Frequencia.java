/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import static java.lang.Math.pow;
import java.text.DecimalFormat;
/**
 *
 * @author Milton
 */
public class Linha_Frequencia {
    private double Xi;
    private double fi;
    private double Fi;
    private double fr;
    private double Fr;
    private double Xi_fi;
    private double Xi_x_fi;
    private double media;
    public double calcula_Xi_x_fi(double media){
        System.out.println("media: " + media);
        System.out.println("Xi: "+ this.Xi);
        System.out.println("fi: "+ this.fi);
        this.Xi_x_fi = pow((this.Xi- media),2)*this.fi;
        return Xi_x_fi;
        
    }
    public void calcula_mediana(double media){
        
    }
    public void calcula_Xi_fi(){
       this.Xi_fi = this.Xi*this.fi;   
    }

    @Override
    public String toString() {
                DecimalFormat df = new DecimalFormat("#.00");

        return "Linha_Frequencia{" + "Xi=" + Xi + ", fi=" + fi + ", Fi=" + Fi + ", fr=" + fr + ", Fr=" + Fr + ", Xi_fi=" + Xi_fi + ", Xi_x_fi=" +df.format(Xi_x_fi) + '}';
    }
    
    /**
     * @return the Xi
     */
    public double getXi() {
        return Xi;
    }

    /**
     * @param Xi the Xi to set
     */
    public void setXi(double Xi) {
        this.Xi = Xi;
    }

    /**
     * @return the fi
     */
    public double getfi() {
        return fi;
    }

    /**
     * @param fi the fi to set
     */
    public void setfi(double fi) {
        this.fi = fi;
    }

    /**
     * @return the Fi
     */
    public double getFi() {
        return Fi;
    }

    /**
     * @param Fi the Fi to set
     */
    public void setFi(double Fi) {
        this.Fi = Fi;
    }

    /**
     * @return the fr
     */
    public double getfr() {
        return fr;
    }

    /**
     * @param fr the fr to set
     */
    public void setfr(double fr) {
        this.fr = fr;
    }

    /**
     * @return the Fr
     */
    public double getFr() {
        return Fr;
    }

    /**
     * @param Fr the Fr to set
     */
    public void setFr(double Fr) {
        this.Fr = Fr;
    }

    /**
     * @return the Xi_fi
     */
    public double getXi_fi() {
        return Xi_fi;
    }

    /**
     * @param Xi_fi the Xi_fi to set
     */
    public void setXi_fi(double Xi_fi) {
        this.Xi_fi = Xi_fi;
    }

    /**
     * @return the Xi_x_fi
     */
    public double getXi_x_fi() {
        return Xi_x_fi;
    }

    /**
     * @param Xi_x_fi the Xi_x_fi to set
     */
    public void setXi_x_fi(double Xi_x_fi) {
        this.Xi_x_fi = Xi_x_fi;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    
    
    
}
