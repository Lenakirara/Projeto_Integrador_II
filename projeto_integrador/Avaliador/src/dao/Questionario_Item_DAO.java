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

/**
 *
 * @author Milton
 */
public class Questionario_Item_DAO {

	public static void inserir(Questionario_Item questionario_item) {
		try {
			String sql = "INSERT INTO questionario_item(questionario_item_id,questionario_id, ordem, descricao) VALUES(?,?,?,?)";
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_item.getQuestionario_item_id());
			ps.setDouble(2, questionario_item.getQuestionario_id());
			ps.setDouble(3, questionario_item.getOrdem());
			ps.setString(4, questionario_item.getDescricao());
			ps.executeUpdate();
			ps.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void alterar(Questionario_Item questionario_item) {
		String sql = "update questionario_item set descricao = ?, ordem = ?  where questionario_item_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, questionario_item.getDescricao());
			ps.setDouble(2, questionario_item.getOrdem());
			ps.setDouble(3, questionario_item.getQuestionario_item_id());
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static void excluir(int questionario_item_id) {
		String sql = "delete from questionario_item where questionario_item_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_item_id);
			ps.executeUpdate();
			ps.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		};
	}

	public static Questionario_Item consultar(int questionario_item_id) {
		String sql = "select questionario_item_id ,questionario_id, ordem, descricao from questionario_item where questionario_item_id = ?";
		Questionario_Item q = new Questionario_Item();
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_item_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				q.setQuestionario_item_id(rs.getInt(1));
				q.setQuestionario_id(rs.getInt(2));
				q.setOrdem(rs.getInt(3));
				q.setDescricao(rs.getString(4));
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

	public static void gravar(Questionario_Item questionario_item) {
	
		if (questionario_item.getQuestionario_item_id() <= 0) {
			questionario_item.setQuestionario_item_id(Questionario_Item_DAO.Questionario_Id_Novo());
			Questionario_Item_DAO.inserir(questionario_item);
		} else {
			Questionario_Item_DAO.alterar(questionario_item);
		}
	}

	public static int Questionario_Id_Novo() {
		String sql = "select max(questionario_item_id) from questionario_item";
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

	public static boolean existe(int questionario_item_id) {
		String sql = "select questionario_item_id from questionario_item where questionario_item_id = ?";
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, questionario_item_id);
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

	
	public static ArrayList<Questionario_Item> listar(int questionario_item_id) {
		ArrayList<Questionario_Item> lista = new ArrayList();
		Questionario_Item obj;
		String sql;
		if (questionario_item_id > 0 ){
		 sql = "select questionario_item_id,questionario_id, ordem, descricao from questionario_item where questionario_id = ? order by questionario_id, ordem, questionario_item_id ";
		} else {
			sql = "select questionario_item_id,questionario_id, ordem, descricao from questionario_item order by questionario_id, ordem, questionario_item_id ";		
		}
		
		try {
			Connection conn = dao.Persistencia.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (questionario_item_id > 0 ){
				ps.setDouble(1, questionario_item_id);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Questionario_Item();
				obj.setQuestionario_item_id(rs.getInt(1));
				obj.setQuestionario_id(rs.getInt(2));
				obj.setOrdem(rs.getInt(3));
				obj.setDescricao(rs.getString(4));
				lista.add(obj);
			}
			ps.close();
			rs.close();
	
			return lista;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return lista;
		}
	}
	


	
	public static ArrayList<Questionario_Item> listar_Questionario_Resposta(int questionario_id) {
		ArrayList<Questionario_Item> lista = new ArrayList();
		Questionario_Item obj;
		String sql;
			if (questionario_id > 0) {
			sql = "select questionario_item_id,questionario_id, ordem, descricao from questionario_item where questionario_id = ? order by questionario_id, ordem, questionario_item_id ";
			try {
				Connection conn = dao.Persistencia.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				if (questionario_id > 0) {
					ps.setDouble(1, questionario_id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						obj = new Questionario_Item();
						obj.setQuestionario_item_id(rs.getInt(1));
						obj.setQuestionario_id(rs.getInt(2));
						obj.setOrdem(rs.getInt(3));
						obj.setDescricao(rs.getString(4));
						lista.add(obj);
					}
					ps.close();
					rs.close();
				}

				return lista;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return lista;
			}
		} else {
			return null;
		}

	}

	
}
