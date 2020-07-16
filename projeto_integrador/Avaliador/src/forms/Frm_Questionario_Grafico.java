/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class Frm_Questionario_Grafico extends JFrame {
   public int questionario_id;

   
   public Frm_Questionario_Grafico( String applicationTitle , String chartTitle,int questionario_id ) {
        super( applicationTitle );  
	this.questionario_id = questionario_id;
	setAutoRequestFocus(true);
	setLocationRelativeTo(null);
	setSize(950,500);	
		
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Perguntas",            
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
      System.out.println("createDataset this.questionario_id:" + this.questionario_id);
      for (modelo.Questionario_Grafico q : dao.Questionario_DAO.lista_Questionario_Grafico(this.questionario_id)){
		System.out.println(q);
		dataset.addValue( q.getMedia_valor() ,q.getDescricao_pergunta() ,"Notas");        
	
	}

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   
      Frm_Questionario_Grafico chart = new Frm_Questionario_Grafico("Estatistica", "Questionário",1);
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );           
      chart.setVisible( true ); 
   }
}
