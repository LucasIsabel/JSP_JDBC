package br.com.jspJDBC.webProject.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.jspJDBC.webProject.entity.User;

public class UserDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void register(User user) {
		String sql = "insert into usuario (name, username, password) values (?,?,?)";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setString(1, user.getName());
			prepare.setString(2, user.getUsername());
			prepare.setString(3, user.getPassword());
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(User user) {
		String sql = "update usuario set name = ?, username = ?, password = ? where id = ?";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setString(1, user.getName());
			prepare.setString(2, user.getUsername());
			prepare.setString(3, user.getPassword());
			prepare.setInt(4, 1);
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Integer id) {
		String sql = "delete from usuario where id = ?";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, 1);
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
