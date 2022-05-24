package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.SingletonConnexion;
import utilisateur.Utilisateur;

public class UtilisateurImp implements UtilisateurDAO{

	@Override
	public Utilisateur save(Utilisateur u) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("INSERT INTO utilisateur(nom,prenom,adresse,numero,password,cin) VALUES(?,?,?,?,?,?)");
			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getAdresse());
			ps.setInt(4, u.getNumero());
			ps.setString(5, u.getPassword());
			ps.setInt(6, u.getCin());	
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Utilisateur> utilisateurparMc(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
