/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Grafico_Frequencia;
import modelo.Questionario;
import modelo.Questionario_Grafico;

/**
 *
 * @author Milton
 */

public class Questionario_DAO {

	public static void inserir(Questionario questionario) {
		String sql = "INSERT INTO questionario(questionario_id,descricao) VALUES(?,?)";
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, questionario.getQuestionario_id());
			ps.setString(2, questionario.getDescricao());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static void alterar(Questionario questionario) {
		String sql = "update questionario set descricao = ? where questionario_id = ?";
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, questionario.getDescricao());
			ps.setDouble(2, questionario.getQuestionario_id());
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static void excluir(Questionario questionario) {
		
		try {
			Connection conn = dao.Persistencia.getConnection();
			String sql1 = "delete from questionario_item where questionario_id = ?";			
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setDouble(1, questionario.getQuestionario_id());			
			ps1.executeUpdate();
			
			String sql2 = "delete from questionario where questionario_id = ?";			
			PreparedStatement ps2 = conn.prepareStatement(sql2); 
			ps2.setDouble(1, questionario.getQuestionario_id());			
			ps2.executeUpdate();
			ps1.close();
			ps2.close();			
			
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static Questionario consultar(Questionario questionario) {
		String sql = "select questionario_id, descricao from questionario where questionario_id = ?";
		Questionario q = new Questionario();
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, questionario.getQuestionario_id());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				q.setQuestionario_id(rs.getInt(1));
				q.setDescricao(rs.getString(2));
				System.out.println("Existe");
			} else {
				System.out.println("nao Existe");
			}
			rs.close();
			ps.close();
		
			return q;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void gravar(Questionario questionario) {
		if (questionario.getQuestionario_id() == 0) {
			questionario.setQuestionario_id(Questionario_DAO.Questionario_Id_Novo());
			Questionario_DAO.inserir(questionario);
		} else {
			Questionario_DAO.alterar(questionario);
		}
	}

	public static int Questionario_Id_Novo() {
		String sql = "select max(questionario_id) from questionario";
		int questionario_id = 0;
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				questionario_id = (rs.getInt(1));

				System.out.println("Existe");
			} else {
				System.out.println("nao Existe");
			}
			rs.close();
			ps.close();
			
			return questionario_id + 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return questionario_id + 1;
		}
	}

	public static boolean existe(int quetionario_id) {
		String sql = "select questionario_id from questionario where questionario_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, quetionario_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Existe");
				return true;
			} else {
				System.out.println("nao Existe");
				return false;
			}
	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static ArrayList<Questionario> listar() {
		ArrayList<Questionario> lista = new ArrayList();
		Questionario questionario;
		String sql = "select questionario_id,descricao from questionario order by questionario_id";
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				questionario = new Questionario();
				questionario.setQuestionario_id(rs.getInt(1));
				questionario.setDescricao(rs.getString(2));
				lista.add(questionario);
			}
			rs.close();
			ps.close();
			
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return lista;
		}

	}
	
	public static ArrayList<Questionario_Grafico> lista_Questionario_Grafico(int questionario_id) {
		ArrayList<Questionario_Grafico> lista = new ArrayList();
		Questionario_Grafico obj;
String sql  = "	select "
	+ "	   questionario.QUESTIONARIO_ID,  "
	+ "	   QUESTIONARIO.DESCRICAO, "
	+ "	   QUESTIONARIO_ITEM.QUESTIONARIO_ID, "
	+ "	   QUESTIONARIO_ITEM.DESCRICAO , "
	+ "	   round(avg(questionario_resposta_item.valor),2) as media_valor"
	+ "	from     questionario, 	 "
	+ "	   questionario_item, 	 "
	+ "	   QUESTIONARIO_RESPOSTA_ITEM "
	+ "	where questionario.QUESTIONARIO_ID = QUESTIONARIO_ITEM.QUESTIONARIO_ID  "
	+ "	and QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID = QUESTIONARIO_RESPOSTA_ITEM.QUESTIONARIO_ITEM_ID "
	+ "	and questionario.questionario_id = ? "
	+ "	group by questionario.QUESTIONARIO_ID, "       
	+ "	   QUESTIONARIO.DESCRICAO, 	       "
	+ "	   QUESTIONARIO_ITEM.QUESTIONARIO_ID, "
	+ "	   QUESTIONARIO_ITEM.DESCRICAO ";
			
			
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, questionario_id);
			ResultSet rs = ps.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
				obj = new Questionario_Grafico();
				obj.setQuestionario_id(rs.getInt(1));
				obj.setDescricao(rs.getString(2));
				obj.setQuestionario_item_id(rs.getInt(3));
				obj.setDescricao_pergunta(rs.getString(4));
				obj.setMedia_valor(rs.getDouble(5));
				//obj.getMedia_valor(rs.getDouble(5));
				lista.add(obj);
			}
			rs.close();
			ps.close();
			
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return lista;
		}

	}
        
        	public static ArrayList<Grafico_Frequencia> lista_Questionario_Item_Grafico(int questionario_item_id) {
		ArrayList<Grafico_Frequencia> lista = new ArrayList();
		Grafico_Frequencia obj;
                    String sql = " SELECT QUESTIONARIO_ITEM.QUESTIONARIO_ID,"                            
                            + "           QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID,"
                            + "           QUESTIONARIO_ITEM.DESCRICAO,"                            
                            + "           QUESTIONARIO_RESPOSTA_ITEM.VALOR,"
                            + "           COUNT(1) AS QTDE_VALOR"
                            + "      FROM QUESTIONARIO_ITEM,"
                            + "           QUESTIONARIO_RESPOSTA_ITEM"
                            + "     WHERE QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID = QUESTIONARIO_RESPOSTA_ITEM.QUESTIONARIO_ITEM_ID"
                            + "       and QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID = ? "
                            + "  GROUP BY QUESTIONARIO_ITEM.QUESTIONARIO_ID,"
                            + "           QUESTIONARIO_ITEM.DESCRICAO,"
                            + "           QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID,"
                            + "           QUESTIONARIO_RESPOSTA_ITEM.VALOR "
                            + "  ORDER BY QUESTIONARIO_ITEM.QUESTIONARIO_ID,"
                            + "           QUESTIONARIO_ITEM.QUESTIONARIO_ITEM_ID,"
                            + "           QUESTIONARIO_ITEM.DESCRICAO,"
                            + "           QUESTIONARIO_RESPOSTA_ITEM.VALOR";
                    System.out.println(sql);
			
			
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, questionario_item_id);
			ResultSet rs = ps.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
				obj = new Grafico_Frequencia();
				obj.setQuestionario_id(rs.getInt(1));
                                obj.setQuestionario_item_id(rs.getInt(2));
				obj.setDescricao(rs.getString(3));				
				obj.setValor(rs.getDouble(4));
                                obj.setFrequencia(rs.getDouble(5));
				//obj.getMedia_valor(rs.getDouble(5));
				lista.add(obj);
			}
			rs.close();
			ps.close();
			
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return lista;
		}

	}

}
