package Entidades;

import java.util.Objects;

import MinhasExcessoes.Personalizada;

public class Candidato {

	private String nome;
	private String curso;
	private Character sexo;
	private String bilhete;
	private Integer idade;

	public Candidato() {

	}

	public Candidato(String nome, String curso, Character sexo, Integer idade) {
		this.nome = nome;
		this.curso = curso;
		this.idade = idade;
		this.sexo = sexo;

	}

	public Candidato(String nome, String curso, Character sexo, String bilhete, Integer idade) {
		this.nome = nome;
		this.curso = curso;
		this.sexo = sexo;
		this.bilhete = bilhete;
		this.idade = idade;
	}

	public void setAtributos(String nome, String curso, String bilhete, Integer idade) {
		this.nome = nome;
		this.curso = curso;
		this.bilhete = bilhete;
		this.idade = idade;
	}

	public void validarSexo() {
		try {
			if (sexo != 'M' && sexo != 'F') {
				this.sexo = null;
				throw new Personalizada("Sexo não definido");
			}

		} catch (Personalizada e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getBilhete() {
		return bilhete;
	}

	public void setBilhete(String bilhete) {
		this.bilhete = bilhete;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bilhete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(bilhete, other.bilhete);
	}

	@Override
	public String toString() {
		return "Nome do Candidato : " + nome + ", Curso : " + curso + ", Bilhete : " + bilhete;
	}

}
