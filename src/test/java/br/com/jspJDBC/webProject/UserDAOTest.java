package br.com.jspJDBC.webProject;

import br.com.jspJDBC.webProject.entity.User;
import br.com.jspJDBC.webProject.jdbc.UserDAO;

public class UserDAOTest {

	public static void main(String [] args){
		testAuth("Lucas Isabel","321");
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
	
	public static void testExcluir(){
		UserDAO userDao = new UserDAO();
		userDao.excluir(1);
		System.out.println("Excluido com Sucesso");
	}
	
	public static void testSalvar(){
		User user = new User("Vinicius", "mariauser", "123456");
		UserDAO userdao = new UserDAO();
		userdao.save(user);
		System.out.println("Alterado com successo");
	}
	
	public static void testfindById(Integer id){
		UserDAO userdao = new UserDAO();
		User user = userdao.getById(id);

		System.out.println("ID : " + user.getId() + "\n" + 
						   "Name : " + user.getName() + "\n" +
						   "UserName : " + user.getUsername() + "\n" + 
						   "Password : " + user.getPassword());
		
	}
	
	public static void testfindAll(){
		UserDAO userdao = new UserDAO();
		for(User user : userdao.getAll()){
			System.out.println(user.getName() + "\n" + user.getUsername() + "\n" + user.getPassword() + "\n -------");
		}	
	}
	
	public static void testAuth(String name,String password){
		UserDAO userdao = new UserDAO();
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		if(userdao.authentication(user) != null){
			System.out.println("User Authenticated");
		}else{
			System.out.println("User not allowed");
		};
	}
	
}
