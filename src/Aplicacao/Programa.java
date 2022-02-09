package Aplicacao;

import java.util.Scanner;

import Entidades.Candidato;
import Entidades.Urna;

public class Programa {

	public static String menu() {
		StringBuilder bd = new StringBuilder();
		bd.append("-----MENU DE OPCOES-----\n");
		bd.append("1-) Escrever Candidato : \n");
		bd.append("2-) Consultar Candidatos : \n");
		bd.append("3-) Eliminar Candidato : \n");
		bd.append("4-) Actualizar Candidato : \n");
		bd.append("5-) Estatística : \n");
		bd.append("6-) Sair : \n");
		bd.append("-----MENU DE OPCOES-----\n");
		return bd.toString();
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Urna urna = new Urna();

		System.out.println(menu());

		int opcao = sc.nextInt();

		while (opcao != 6) {

			if (opcao > 0 && opcao < 6) {

				if (opcao == 1) {
					Candidato candidato = new Candidato();
					System.out.println("---Escrevendo Candidato----");
					System.out.print("Nome : ");
					String nomeCandidato = sc.next();
					System.out.print("Curso : ");
					String cursoCandidato = sc.next();
					System.out.print("Sexo (M/F) :  ");
					Character sexoCandidato = sc.next().toUpperCase().charAt(0);
					candidato.setSexo(sexoCandidato);
					candidato.validarSexo();
					if(candidato.getSexo()!=null) {
					System.out.print("Número de bilhete : ");
					String bilheteCandidato = sc.next();
					System.out.print("Idade : ");
					Integer idadeCandidato = sc.nextInt();
					candidato.setAtributos(nomeCandidato, cursoCandidato, bilheteCandidato, idadeCandidato);
					urna.escreverCandidato(candidato);
					}
				} else if (opcao == 2) {
					System.out.println("---Consultando Candidatos----");
					urna.consultarCandidatos();
				} else if (opcao == 3) {
					System.out.println("---Eliminando Candidato----");
					System.out.println("Informe o número do Bilhete : ");
					String bilhete = sc.next();
					urna.eliminarCandidato(bilhete);
				} else if (opcao == 4) {
					System.out.println("---Atualizar Candidato----");
					System.out.println("Digite o numero do bilhete para atualizar : ");
					String bilhete = sc.next();
					System.out.print("Nome : ");
					String nomeCandidato = sc.next();
					System.out.print("Curso : ");
					String cursoCandidato = sc.next();
					System.out.print("Sexo (M/F) :  ");
					Character sexo = sc.next().toUpperCase().charAt(0);
					System.out.print("Idade : ");
					Integer idade = sc.nextInt();
					Candidato candidato = new Candidato(nomeCandidato, cursoCandidato, sexo, idade);
					urna.actualizarCandidato( bilhete,candidato);

				} else if (opcao==5) {
					double estatisticas = urna.getEstatisticas();
					System.out.println("Homens : "+estatisticas+"%");
				}

			} else {

				System.out.println("Digito incorreto, Tente Novamente");

			}

			System.out.println(menu());
			opcao = sc.nextInt();
		}

		System.out.println("Programa Finalizado");

	}

}
