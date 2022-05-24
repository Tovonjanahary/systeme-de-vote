package dao;

import java.util.List;

import candidat.Candidat;

public interface CandidatDao {
	public Candidat save( Candidat c);
	public List<Candidat> candidatParMc(String mc);
	public List<Candidat> listeCandidat();
	public Candidat getCandidat(Long id_candidat);
	public Candidat countCandidat(Long id);
	public Candidat UpdateCandidat(Candidat c);
	public void deleteCandidat(Long id);
}
