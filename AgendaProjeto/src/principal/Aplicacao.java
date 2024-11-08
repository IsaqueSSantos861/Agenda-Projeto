package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import util.Compromisso;

public class Aplicacao {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Compromisso> lista = new ArrayList<Compromisso>();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Quantos eventos voce deseja criar? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("AGENDA");
			System.out.println("Criar compromisso " + (i + 1));
			System.out.println("Nome do evento: ");

			String nome = sc.nextLine();
			System.out.println("Data do evento: dd/MM/yyyy");
			String dataEvento = sc.nextLine();
			LocalDate data = LocalDate.parse(dataEvento, fmt);

			Compromisso comp = new Compromisso(nome, data);
			lista.add(comp);
		}

		for (Compromisso compromisso : lista) {
			System.out.println(compromisso.toString());
		}

		System.out.println("Deseja ir para o menu principal? Sim/Nao");
		String resp = sc.nextLine();

		while (resp.equalsIgnoreCase("Sim")) {
			System.out.println("Criar agendamento - 1");
			System.out.println("Consultar eventos - 2");
			System.out.println("Remover eventos - 3");
			System.out.println("Fechar Lista - 4");
			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("AGENDA");
				System.out.println("Quantos eventos voce deseja criar? ");
				n = sc.nextInt();
				sc.nextLine();

				for (int i = 0; i < n; i++) {
					System.out.println("AGENDA " + i++);
					System.out.println("Criar outro compromisso ");
					System.out.println("Nome do evento: ");
					String nome = sc.nextLine();
					System.out.println("Data do evento: dd/MM/yyyy");
					String dataEvento = sc.nextLine();
					LocalDate data = LocalDate.parse(dataEvento, fmt);

					Compromisso comp = new Compromisso(nome, data);
					lista.add(comp);
				}

				for (Compromisso compromisso : lista) {
					System.out.println(compromisso);
				}
				break;

			case 2:
				System.out.println("LISTANDO EVENTOS ");
				System.out.println("Digite a data do evento: ");
				String dataAgd = sc.nextLine();
				LocalDate listar = LocalDate.parse(dataAgd, fmt);

				listarCompromissosPorData(lista, listar);

				break;

			case 3:
				System.out.println("Qual evento deseja remover? ");
				String dataAgd1 = sc.nextLine();
				LocalDate listar2 = LocalDate.parse(dataAgd1, fmt);
				removerCompromissosPorData(lista, listar2);

				for (Compromisso compromisso : lista) {
					System.out.println(compromisso);
				}
				break;
			case 4:
				System.out.println("Agenda Fechada!");
				return;
			}

			System.out.println("Deseja ir para o menu principal? Sim/Nao");
			resp = sc.nextLine();
		}

		System.out.println("Agenda fechada!");

		sc.close();
	}

	public static void listarCompromissosPorData(List<Compromisso> lista, LocalDate data) {
		boolean encontrou = false;
		for (Compromisso compromisso : lista) {
			if (compromisso.getData().equals(data)) {
				System.out.println(compromisso);
				encontrou = true;
			}
		}
		if (!encontrou) {
			System.out.println("Nenhum compromisso encontrado para essa data.");
		}
	}

	public static void removerCompromissosPorData(List<Compromisso> lista, LocalDate data) {
		boolean encontrou = lista.removeIf(compromisso -> compromisso.getData().equals(data));
		if (!encontrou) {
			System.out.println("Nenhum compromisso encontrado para a data especificada.");
		} else {
			System.out.println("Compromissos removidos com sucesso.");
		}
	}
}