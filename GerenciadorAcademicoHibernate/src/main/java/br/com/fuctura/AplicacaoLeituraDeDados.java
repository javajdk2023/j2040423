package br.com.fuctura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AplicacaoLeituraDeDados {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Digite um ou mais palavras :");
		
		String texto = reader.readLine();

		System.out.println("Texto digitado: " + texto);

		System.out.println("Digite um número inteiro: ");

		texto = reader.readLine();

		int textoComoInteiro = Integer.parseInt(texto);

		System.out.println("O número digitado foi: " + textoComoInteiro);

		System.out.println("Digite um número real: ");

		texto = reader.readLine();

		double textoComoReal = Double.parseDouble(texto);

		System.out.println("O número digitado foi: " + textoComoReal);
		
		System.out.println("Digite um boleano (true ou false): ");

		texto = reader.readLine();

		boolean textoComoBoleano = Boolean.parseBoolean(texto);

		System.out.println("O boleano digitado foi: " + textoComoBoleano);

	}
}
