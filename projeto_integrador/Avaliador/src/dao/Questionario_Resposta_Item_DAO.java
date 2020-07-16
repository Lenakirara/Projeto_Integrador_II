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
import modelo.Questionario_Resposta_Item;

/**
 *
 * @author Milton
 */
public class Questionario_Resposta_Item_DAO {

	public static void inserir(Questionario_Resposta_Item Questionario_Resposta_Item) {
		try {
			String sql = "insert into questionario_resposta_item(questionario_resposta_id, questionario_item_id, observacao, valor) values(?,?,?,?)";
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, Questionario_Resposta_Item.getQuestionario_Resposta_id());
			ps.setDouble(2, Questionario_Resposta_Item.getQuestionario_item_id());
			ps.setString(3, Questionario_Resposta_Item.getObservacao());
			ps.setDouble(4, Questionario_Resposta_Item.getValor());
			ps.executeUpdate();
			ps.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void alterar(Questionario_Resposta_Item Questionario_Resposta_Item) {
		String sql = "update Questionario_Resposta_Item set observacao = ?, valor = ?  where questionario_respota = ? and Questionario_Item_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Questionario_Resposta_Item.getObservacao());
			ps.setDouble(2, Questionario_Resposta_Item.getValor());
			ps.setDouble(3, Questionario_Resposta_Item.getQuestionario_Resposta_id());
			ps.setDouble(3, Questionario_Resposta_Item.getQuestionario_item_id());
			
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static void excluir(int Questionario_Resposta_id, int questionario_item_id) {
		String sql = "delete from Questionario_Resposta_Item where Questionario_Resposta_id = ? and id_questionario_item_id = ? ";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, Questionario_Resposta_id);
			ps.setDouble(2, questionario_item_id);
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static Questionario_Resposta_Item consultar(int Questionario_Resposta_id, int Questionario_item_id ) {
		String sql = "select questionario_resposta_id, questionario_item_id, observacao, valor from Questionario_Resposta_Item where questionario_resposta_id = ? and questionario_item_id = ?";
		Questionario_Resposta_Item q = new Questionario_Resposta_Item();
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, Questionario_Resposta_id);
			ps.setDouble(1, Questionario_item_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				q.setQuestionario_Resposta_id(rs.getInt(1));
				q.setQuestionario_item_id(rs.getInt(2));
				q.setObservacao(rs.getString(3));
				q.setValor(rs.getInt(4));
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

	

	
	public static boolean existe(int questionario_resposta_id, int questionario_item_id ) {
		String sql = "select Questionario_Resposta_Item_id from Questionario_Resposta_Item where questionario_resposta_id = ? and questionario_item_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,questionario_resposta_id);
			ps.setDouble(2, questionario_item_id);
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

	public static ArrayList<Questionario_Resposta_Item> listar_Questionario_Resposta_Item(int Questionario_Resposta_id) {
		ArrayList<Questionario_Resposta_Item> lista = new ArrayList();
		Questionario_Resposta_Item obj;
		String sql;
		if (Questionario_Resposta_id > 0) {
		   sql = "select Questionario_Resposta_id,questionario_item_id,observacao, valor from Questionario_Resposta_Item where questionario_resposta_id = ?   order by Questionario_Resposta_id,questionario_item_id";
		} else {
		  sql = "select Questionario_Resposta_id,questionario_item_id,observacao, valor from Questionario_Resposta_Item  order by Questionario_Resposta_id,questionario_item_id";
		}
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (Questionario_Resposta_id > 0) {
				ps.setDouble(1, Questionario_Resposta_id);
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Questionario_Resposta_Item();
				obj.setQuestionario_Resposta_id(rs.getInt(1));
				obj.setQuestionario_Resposta_id(rs.getInt(2));
				obj.setObservacao(rs.getString(3));
				obj.setValor(rs.getInt(4));
//				obj.setValor(rs.getDouble(4));
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
