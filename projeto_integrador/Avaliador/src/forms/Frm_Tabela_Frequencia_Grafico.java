/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;


import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.Grafico_Frequencia;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class Frm_Tabela_Frequencia_Grafico extends JFrame {
   public int questionario_item_id = 1;

   
   public Frm_Tabela_Frequencia_Grafico( String applicationTitle , String chartTitle,int questionario_item_id ) {
        super( applicationTitle );  
	this.questionario_item_id = questionario_item_id;
	setAutoRequestFocus(true);
	setLocationRelativeTo(null);
	setSize(950,500);	
		
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Notas",            
         "",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 950 , 500) );        
      setContentPane( chartPanel ); 
      setVisible(true);
   }
   
   private CategoryDataset createDataset( ) {
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      System.out.println("questionario_item_id:" + this.questionario_item_id);
      ArrayList<Grafico_Frequencia> lista = new ArrayList();
      lista = dao.Questionario_DAO.lista_Questionario_Item_Grafico(this.questionario_item_id);
 
      for (Grafico_Frequencia q : lista){
		System.out.println(q);
		dataset.addValue( q.getFrequencia(), q.getValor() +"" , q.getDescricao());        
	
	}

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   
      Frm_Tabela_Frequencia_Grafico chart = new Frm_Tabela_Frequencia_Grafico("Estatistica", "Gráfico da Tabela de Frequencia",1);
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );           
      chart.setVisible( true ); 
   }
}
