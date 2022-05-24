package utilisateur;

public class Utilisateur {
	private Long id_utilisateur;
	private String nom;
	private String Prenom;
	private String adresse;
	private int numero;
	private int cin;
	private String password;
	private int id_candidat;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom, String adresse, int numero, String password, int cin) {
		super();
		this.nom = nom;
		Prenom = prenom;
		this.adresse = adresse;
		this.numero = numero;
		this.cin = cin;
		this.password = password;
		this.id_candidat = id_candidat;
	}

	public Long getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_candidat() {
		return id_candidat;
	}

	public void setId_candidat(int id_candidat) {
		this.id_candidat = id_candidat;
	}
}
