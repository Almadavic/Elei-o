package Entidades;

import java.util.ArrayList;
import java.util.List;

import MinhasExcessoes.Personalizada;

public class Urna implements CRUD {

	private List<Candidato> candidatos = new ArrayList<>();

	@Override
	public void escreverCandidato(Candidato candidato) {
		if (candidatos.contains(candidato)) {
			try {
				throw new Personalizada("Candidato já cadastrado");
			} catch (Personalizada e) {
				System.out.println("Erro :  " + e.getMessage());
			}
		} else {
			candidatos.add(candidato);
			System.out.println("Sucesso ! , Id : " + candidato.getBilhete());
		}

	}

	@Override
	public void consultarCandidatos() {
		if(candidatos.isEmpty()) {
		     System.out.println("Lista vazia");
		} else {
			for (Candidato candidato : candidatos) {
				System.out.println(candidato);
			}
		
		}
	}

	@Override
	public void eliminarCandidato(String bilhete) {
		String numeroBilhete = null;
		for (Candidato candidato : candidatos) {
			if (candidato.getBilhete().equals(bilhete)) {
				numeroBilhete = candidato.getBilhete();
			}
		}
		boolean temCandidato = candidatos.removeIf(c -> c.getBilhete().equals(bilhete));
		if (temCandidato) {
			System.out.println("Candidato : " + numeroBilhete + " removido");

		} else {
			try {
				throw new Personalizada("Não existe candidato com esse número de bilhete");
			} catch (Personalizada e) {
				System.out.println("Erro : " + e.getMessage());
			}
		}
	}

	@Override
	public void actualizarCandidato(String bilhete, Candidato candidato) {
		for (Candidato candidatoUnico : candidatos) {
			if (candidatoUnico.getBilhete().equals(bilhete)) {
				candidatoUnico.setBilhete(candidato.getBilhete());
				candidatoUnico.setCurso(candidato.getCurso());
				candidatoUnico.setIdade(candidato.getIdade());
				candidatoUnico.setNome(candidato.getNome());
				candidatoUnico.setSexo(candidato.getSexo());
			}
		}

	}

	

	public Candidato buscarPorIdade(int idade) {
		for (Candidato candidato : candidatos) {
			if (candidato.getIdade() == idade) {
				return candidato;
			}
		}
		return null;
	}

	public double getEstatisticas() {
		int homens = 0;
		for (Candidato candidato : candidatos) {
			if (candidato.getSexo() == 'M') {
				homens++;
			}

		}

		return (100 * homens) / candidatos.size();
	}

}
