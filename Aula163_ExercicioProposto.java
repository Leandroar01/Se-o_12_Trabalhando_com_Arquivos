package Secao_12_Trabalhando_com_Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula163_ExercicioProposto {

	/**
	 * Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de
	 * itens vendidos. Cada item possui um nome, preço unitário e quantidade,
	 * separados por vírgula. Você deve gerar um novo arquivo * chamado
	 * "summary.csv", localizado em uma subpasta chamada "out" a partir da pasta
	 * original do arquivo de origem, contendo apenas o nome e o valor total para
	 * aquele item (preço unitário multiplicado pela quantidade.
	 */

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		List<Aula163_Entities_ExercicioFixacao> list = new ArrayList<>();

		System.out.println("Enter file Path: ");
		String sourceFileStr = ler.nextLine(); // Entrar com o Caminho
		File sourceFile = new File(sourceFileStr); // Abrir um Arquivo a partir do endereço passado na variavel
		String sourceFolderStr = sourceFile.getParent();

		@SuppressWarnings("unused")
		boolean sucess = new File(sourceFolderStr + "\\out").mkdir();
		@SuppressWarnings("unused")
		String targetFileStr = sourceFileStr+ "\\out\\sumary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				list.add(new Aula163_Entities_ExercicioFixacao(name, price, quantity));
				itemCsv = br.readLine();
			}
					System.out.println(list);
//			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
//				for (Aula163_Entities_ExercicioFixacao item : list) {
//					bw.write(item.getProdut() + ", " +String.format("%.2f", item.total()));
//				}
//			} catch (IOException e) {
//				System.out.println("Error wrinting file: " + e.getMessage());
//
//			}
		} catch (IOException e) {
			System.out.println("Erro reading file: " + e.getMessage());
		}

		ler.close();
	}

}
