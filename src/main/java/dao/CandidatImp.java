package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnexion;
import candidat.Candidat;

public class CandidatImp implements CandidatDao{

	@Override
	public Candidat save(Candidat c) {
		// TODO Auto-generated method stub
		try {
			Connection connexion = SingletonConnexion.getConnexion();
			PreparedStatement ps = connexion.prepareStatement
					("INSERT INTO candidats(nom,prenom,email,adresse,numero,cin) VALUES(?,?,?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getAdresse());
			ps.setInt(5, c.getNumero());
			ps.setInt(6, c.getCin());	
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Candidat> candidatParMc(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidat> listeCandidat() {
		// TODO Auto-generated method stub
		List<Candidat> candidats = new ArrayList<Candidat>();
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("SELECT * FROM CANDIDATS");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Candidat p = new Candidat();
				p.setId_candidat(rs.getLong("id_candidat"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setEmail(rs.getString("email"));
				p.setAdresse(rs.getString("adresse"));
				p.setNumero(rs.getInt("numero"));
				p.setCin(rs.getInt("cin"));
				candidats.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidats;
	}

	@Override
	public Candidat getCandidat(Long id_candidat) {
		Candidat c = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("SELECT * FROM CANDIDATS WHERE id_candidat=?");
			ps.setLong(1, id_candidat);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new Candidat();
				c.setId_candidat(rs.getLong("id_candidat"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setAdresse(rs.getString("adresse"));
				c.setNumero(rs.getInt("numero"));
				c.setCin(rs.getInt("cin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public Candidat countCandidat(Long id_candidat) {
		// TODO Auto-generated method stub
		Candidat c = null;
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("SELECT COUNT(id_utilisateur) as id from utilisateur where id_candidat=?");
			ps.setLong(1, id_candidat);
			ResultSet rs = ps.executeQuery();
			c = new Candidat();
			if(rs.next()) {
				c.setId_candidat(rs.getLong("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Candidat UpdateCandidat(Candidat c) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("UPDATE candidats SET nom=?,prenom=?,email=?,adresse=?,numero=?,cin=? WHERE id_candidat=?");
			
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getAdresse());
			ps.setInt(5, c.getNumero());
			ps.setInt(6, c.getCin());	
			ps.setLong(7, c.getId_candidat());
			
			ps.executeUpdate();
			
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteCandidat(Long id) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = connexion.prepareStatement
					("DELETE FROM candidats where id_candidat = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
