package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JavaWebApplication.Beans.PrenotaBean;
import com.JavaWebApplication.Beans.RegisterBean;
import com.JavaWebApplication.Beans.User;

	public class insertUser {

		
	    public String InserUser(RegisterBean rb) {
		    String verify = null;
			MyDb db = new MyDb();
			Connection con = db.getCon();
			try {
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO Persons(Nome,Cognome,email,password) values("
						+ "'"+rb.getNome()+"',"
						+ "'"+rb.getCognome()+"',"
						+ "'"+rb.getEmail()+"',"
						+ "'"+rb.getPassword()+"')");
				verify = "Data inserted correctly";
				return verify;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				verify= "Data insertion failure";
				e.printStackTrace();
				return verify;
			}
		}
    
	 public User readUser(String email, String password) {
		User user = new User();
		MyDb db = new MyDb();
		Connection con = db.getCon();
		
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Persons WHERE email="
					+ "'"+email+"' AND password="
					+ "'"+password+"'");
			while (rs.next()) {
				user.setName("Nome = "+rs.getString("nome"));
				user.setCognome("Cognome = "+rs.getString("cognome"));
				user.setEmail("Email = "+rs.getString("email"));
				user.setPassword("Password = "+rs.getString("password"));
				user.setFound(true);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			user.setFound(false);
			e.printStackTrace();
			return null;
		}
		 return user;
	 }
	 
	 public String InserPrenotazione(PrenotaBean pb) {
		 
		    String verify = null;
			MyDb db = new MyDb();
			Connection con = db.getCon();
			try {
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO Visite(NomePaziente,DataPrenotazione,Genere,TipoVisita,CodicePrenotazione) values("
						+ "'"+pb.getNomePaziente()+"',"
						+ "'"+pb.getDataPrenotazione()+"',"
						+ "'"+pb.getGenere()+"',"
						+ "'"+pb.getTipologiaVisita()+"',"
						+ "'"+pb.getCodicePrenotazione()+"')");
				verify = " Prenotazione andata a buon fine";
				return verify;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				verify= " Errore in fase di prenotazione";
				e.printStackTrace();
				return verify;
			}
	 }
	 
}
