package Entidades;



public interface CRUD {

    void escreverCandidato(Candidato candidato);

	void consultarCandidatos();

	void eliminarCandidato(String bilhete);

	void actualizarCandidato(String bilhete,Candidato candidato);

}
