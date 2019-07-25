package Secao_12_Trabalhando_com_Arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

		System.out.print("Quantos Produtos Adicionar: ");
		int addProduct = ler.nextInt();
		ler.nextLine();
		for (int cc = 0; cc < addProduct; cc++) {
			System.out.println("==============");
			System.out.printf(" #%d Registro: %n", (cc+1));
			System.out.print("Informe o Produto: ");
			String product = ler.nextLine();
			System.out.print("Valor do produto: ");
			double price = ler.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = ler.nextInt();
			ler.nextLine();
			list.add(new Aula163_Entities_ExercicioFixacao(product, price, quantity));
		}	
		System.out.print("Deseja exportar o arquivo (Y/N) ? ");
		String export = ler.nextLine().toUpperCase();
		if (export.equals("Y")) {
			System.out.println("Enter a folder path: ");
			String strPath = ler.nextLine()+"\\summit.txt"; //Concatenação já adicionao o formato do arquivo e a sua extenção.
			File path = new File(strPath);
			try (BufferedWriter exportY = new BufferedWriter(new FileWriter(path, true))) {
				for (Aula163_Entities_ExercicioFixacao X : list) {
					X.total();// Antes de imprimir já adiciona o total da linha no arquivo gerado.
					exportY.write(X.getProdut() + " - " + String.format("%.2f",X.getTotal()));
					exportY.newLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro" + e.getMessage());
			} catch (IOException e) {
				System.out.println("Erro" + e.getMessage());
				e.printStackTrace();
			}
		}
		ler.close();
	}

}
