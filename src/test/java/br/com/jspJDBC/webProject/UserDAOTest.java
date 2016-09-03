package br.com.jspJDBC.webProject;

import br.com.jspJDBC.webProject.entity.User;
import br.com.jspJDBC.webProject.jdbc.UserDAO;

public class UserDAOTest {

	public static void main(String [] args){
		Excluir();
	}
	
	public static void testRegister(){
		User user = new User("lucas","Lucas Isabel","321");
		UserDAO userDao = new UserDAO();
		userDao.register(user);
		System.out.println("Cadastrado com Sucesso");
	}
	
	public static void testUpdate(){
		User user = new User("Vivian","Isabel","321");
		UserDAO userDao = new UserDAO();
		userDao.update(user);
		System.out.println("Alterado co mSucesso");
	}
	
	public static void Excluir(){
		UserDAO userDao = new UserDAO();
		userDao.excluir(1);
		System.out.println("Excluido com Sucesso");
	}
	
}
