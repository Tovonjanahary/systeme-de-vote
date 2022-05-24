package web;

import java.util.ArrayList;
import java.util.List;

import candidat.Candidat;

public class CandidatModel {
	private String motCle;
	private List<Candidat> candidat= new ArrayList<Candidat>();

	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Candidat> getCandidat() {
		return candidat;
	}
	public void setCandidat(List<Candidat> candidat) {
		this.candidat = candidat;
	}
}
