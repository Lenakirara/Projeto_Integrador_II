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
import modelo.Questionario_Item;
import modelo.Questionario_Resposta;

/**
 *
 * @author Milton
 */
public class Questionario_Reposta_DAO {

	public static Questionario_Resposta questionario_resposta;

	public static void inserir(Questionario_Resposta questionario_reposta) {
		System.out.println("inclusao");
		System.out.println(questionario_reposta);
		try {
			String sql = "INSERT INTO questionario_resposta(questionario_resposta_id,questionario_id,nome, e_mail,total_score, total_tempo) VALUES(?,?,?,?,?,?)";
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_reposta.getQuestionario_resposta_id());
			ps.setDouble(2, questionario_reposta.getQuestionario_id());
			ps.setString(3, questionario_reposta.getNome());
			ps.setString(4, questionario_reposta.getE_mail());			
			ps.setDouble(5, questionario_reposta.getTotal_score());
			ps.setDouble(6, questionario_reposta.getTotal_tempo());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alterar(Questionario_Resposta questionario_reposta) {
		String sql = "update questionario_resposta set questionario_id = ?, nome = ?, e_mail = ?, total_score = ?, total_tempo = ?   where questionario_resposta_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_reposta.getQuestionario_id());
			ps.setString(2, questionario_reposta.getNome());
			ps.setString(3, questionario_reposta.getE_mail());
			ps.setDouble(4, questionario_reposta.getQuestionario_resposta_id());
			ps.setDouble(5, questionario_reposta.getTotal_score());
			ps.setDouble(6, questionario_reposta.getTotal_tempo());
			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static void excluir(int questionario_resposta_id) {
		String sql = "delete from questionario_resposta where questionario_resposta_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_resposta_id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static int Questionario_Resposta_Id_Novo() {
		String sql = "select max(Questionario_Resposta_Id) from Questionario_Resposta";
		int id = 0;
		try (
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = (rs.getInt(1));

				System.out.println("Existe");
			} else {
				System.out.println("nao Existe");
			}
			rs.close();
			ps.close();

			return id + 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return id + 1;
		}
	}

	public static boolean existe(int questionario_resposta_id) {
		String sql = "select questionario_resposta_id from questionario_resposta where questionario_resposta_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_resposta_id);
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

	public static void gravar(Questionario_Resposta questionario_resposta) {

		if (questionario_resposta.getQuestionario_resposta_id() <= 0) {
			questionario_resposta.setQuestionario_resposta_id(Questionario_Resposta_Id_Novo());
			inserir(questionario_resposta);
		} else {
			alterar(questionario_resposta);
		}
	}

	public static ArrayList<Questionario_Resposta> listar_Questionario_Resposta(int questionario_resposta_id) {
		ArrayList<Questionario_Resposta> lista = new ArrayList();
		Questionario_Resposta obj;
		String sql;
		if (questionario_resposta_id > 0) {
		   sql = "select questionario_resposta_id,questionario_id, nome,e_mail,total_score, total_tempo, data_lancamento from questionario_resposta where questionario_resposta_id = ? order by questionario_resposta_id ";
		} else {
		  sql = "select questionario_resposta_id,questionario_id, nome,e_mail,total_score, total_tempo ,data_lancamento from questionario_resposta  order by questionario_resposta_id";
		}
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (questionario_resposta_id > 0) {
				ps.setDouble(1, questionario_resposta_id);
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Questionario_Resposta();
				obj.setQuestionario_resposta_id(rs.getInt(1));
				obj.setQuestionario_id(rs.getInt(2));
				obj.setNome(rs.getString(3));
				obj.setE_mail(rs.getString(4));
				obj.setTotal_score(rs.getDouble(5));
				obj.setTotal_tempo(rs.getDouble(6));				
				obj.setData_lancto(rs.getString(7));						
				lista.add(obj);
			}
			ps.close();
			rs.close();		
		        return lista;
	        } catch (SQLException e){
		  System.out.println(e.getMessage());
		  return lista; 
	}


}

 


}
        

