package dao;

import java.util.List;

import utilisateur.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur save(Utilisateur u);
	public List<Utilisateur> utilisateurparMc(String mc);
	public Utilisateur getUser(Long id);
	public Utilisateur updateUser(Long id);
	public void deleteUser(Long id);
}
