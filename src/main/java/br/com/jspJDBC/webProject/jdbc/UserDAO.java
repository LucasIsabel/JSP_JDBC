package br.com.jspJDBC.webProject.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jspJDBC.webProject.entity.User;

public class UserDAO {

	private Connection con = ConexaoFactory.getConnection();

	/**
	 * 
	 * This method register a new user
	 * 
	 * @param user
	 */

	public void register(User user) {
		String sql = "insert into usuario (name, username, password) values (?,?,md5(?))";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setString(1, user.getName());
			prepare.setString(2, user.getUsername());
			prepare.setString(3, user.getPassword());
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method update the user in database
	 * 
	 * @param user
	 */

	public void update(User user) {
		String sql = "update usuario set name = ?, username = ?, password = md5(?) where id = ?";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setString(1, user.getName());
			prepare.setString(2, user.getUsername());
			prepare.setString(3, user.getPassword());
			prepare.setInt(4, user.getId());
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method delete the user in database
	 * 
	 * @param id
	 */

	public void delete(Integer id) {
		String sql = "delete from usuario where id = ?";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, id);
			prepare.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will check if the id exist in database if don't i'll register
	 * the user now if do it'll update
	 * 
	 * @param user
	 */

	public void save(User user) {
		if (user.getId() != null && user.getId() != 0) {
			update(user);
		} else {
			register(user);
		}
	}

	/**
	 * 
	 * This method return the User data searched by id
	 * 
	 * @param id
	 *            Integer value that represent the id user searched
	 * @return Null if not find and Object User if find
	 */

	public User getById(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, id);
			ResultSet list = prepare.executeQuery();

			if (list.next()) {
				User user = new User();
				user.setId(list.getInt("id"));
				user.setName(list.getString("name"));
				user.setUsername(list.getString("username"));
				user.setPassword(list.getString("password"));
				return user;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This method return all users in database
	 * 
	 * @return a List that contains all users in database
	 */

	public List<User> getAll() {
		String sql = "SELECT * FROM usuario";
		List<User> list = new ArrayList<>();

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				list.add(new User(result.getInt("id"), result.getString("name"), result.getString("username"),
						result.getString("password")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 
	 * This method i'll check if the user requested exist
	 * 
	 * @param user
	 * @return a User
	 */

	public User authentication(User user) {
		String sql = "SELECT id,name,username,password from usuario where username = ? and password = md5(?)";

		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setString(1, user.getUsername());
			prepare.setString(2, user.getPassword());
			ResultSet result = prepare.executeQuery();

			if (result.next()) {
				User getUser = new User();
				getUser.setId(result.getInt("id"));
				getUser.setName(result.getString("name"));
				getUser.setPassword(result.getString("password"));
				getUser.setUsername(result.getString("username"));
				return getUser;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
