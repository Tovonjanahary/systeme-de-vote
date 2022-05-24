package candidat;

public class Candidat {
	private Long id_candidat;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private int numero;
	private int cin;
	
	public Candidat() {
		super();
	}
	
	public Candidat(String nom, String prenom, String email, String adresse, int numero, int cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.numero = numero;
		this.cin = cin;
	}

	public Long getId_candidat() {
		return id_candidat;
	}

	public void setId_candidat(Long id_candidat) {
		this.id_candidat = id_candidat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Candidat [id_candidat=" + id_candidat + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", numero=" + numero + ", cin=" + cin + "]";
	}
}
