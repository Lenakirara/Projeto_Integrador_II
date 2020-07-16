/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Grafico_Frequencia;
import modelo.Questionario;
import modelo.Questionario_Item;
import modelo.Questionario_Resposta;
import modelo.Questionario_Resposta_Item;

/**
 *
 * @author Milton
 */
public class Teste {
    

	/**
	 * @param args the command line arguments
	 */
    public static void main(String[] args) {
        
//		// TODO code application logic here
//		Connection cn = dao.ConnectionFactory.getConnection();
//		Questionario lista = new Questionario();
////		System.out.println(lista.listar());
//		for (Questionario q : Questionario_DAO.listar()) {
//			System.out.println(q);
//		}
//		for (Questionario_Item q : Questionario_Item_DAO.listar(1)) {
//			System.out.println(q);
//		}

//		Questionario_Resposta qr = new Questionario_Resposta();
//		
//		qr.setQuestionario_resposta_id(0);		
//		qr.setQuestionario_id(1);
//		qr.setNome("teste");
//		qr.setE_mail("teste")
//		dao.Questionario_Reposta_DAO.inserir(qr);
         	//Questionario_Item qi = new Questionario_Item();
		
                //ArrayList <Questionario_Resposta_Item> lista = new ArrayList();
//		ArrayList <Questionario_Item> lista = new ArrayList();
//		lista = dao.Questionario_Item_DAO.listar_Questionario_Resposta(3);
//		if (lista == null){
//		   System.out.println("Nao existe");	
//		} else {
//		for (Questionario_Item r:  lista){
//		    System.out.println(r);
//		}
//		}
		
//		for (modelo.Questionario_Resposta q : dao.Questionario_Reposta_DAO.listar_Questionario_Resposta(0)) {;
//			System.out.println(q);
//		}
//
//                for (modelo.Questionario_Resposta_Item q : dao.Questionario_Resposta_Item_DAO.listar_Questionario_Resposta_Item(0)){
//			System.out.println(q);
//		}


//                for (modelo.Questionario_Grafico q : dao.Questionario_DAO.lista_Questionario_Grafico(1)){
//			System.out.println(q);
//		}
		
		

/*	}

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package teste;

/**
 *
 * @author Milton
 */
////import org.apache.commons.io.IOUtils;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;

//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.StringWriter;
 
//mport org.apache.commons.io.IOUtils;
//import dao.Utils;

////public class Teste1 {
//static String convertStreamToString(java.io.InputStream is) {
//    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
//    return s.hasNext() ? s.next() : "";
//}
    //@DisplayName("Test loading XML")
    //@Test

     //   ClassLoader classLoader = getClass().getClassLoader();
//	public static void main(String[] args) {
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dao/questionario.txt");
		
//		System.out.println(convertStreamToString(is));
//		System.out.println(dao.Utils.ReadResource("dao/questionario.txt"));
//		  InputStream is = ClassLoader.getSystemClassLoader.getResourceAsStream("myconfig.txt");
//		if(is == null){
//		  System.out.println("input stream is null");
//		else
//			System.out.println("input stream is NOT null :-)");
//    }		

//        InputStream c = classLoader.getResourceAsStream("dao/questionario.txt");
	
	
//	    
//           // String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//            //System.out.println(result);
//
//        } catch (IOException e) {
//            e.printStackTrace();
      //ArrayLlist <Grafico_Frequencia> lista = dao.Questionario_DAO.lista_Questionario_Item_Grafico(1);
      ArrayList<Grafico_Frequencia> lista = new ArrayList();
      lista = dao.Questionario_DAO.lista_Questionario_Item_Grafico(1);
      for (modelo.Grafico_Frequencia  q : lista){
			System.out.println(q);
                        System.out.println("q.getValor(): "+q.getValor());
                        System.out.println("q.getFrequencia(): "+q.getFrequencia());
      }
//		}
      }
}


