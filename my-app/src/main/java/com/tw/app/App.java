/**
 * 
 */
package com.tw.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.tw.app.util.Logger;

/**
 * @author carlo
 *
 */
public class App {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.println("Digite w para a leitura do arquivo certo : ");
				System.out.println("Digite q para sair : ");
				String input = br.readLine();
				System.out.println("-----------\n");
				System.out.println("O comando que você digitou foi : " + input);
				System.out.println("-----------\n");

				if ("q".equals(input)) {
					System.out.println("Você saiu, obrigado !!");
					System.exit(0);
				}

				if ("w".equals(input)) {
					String fileName = "C:/Users/carlo/Desktop/TW/my-app-tw/my-app/src/test/resources/arquivo_de_input";
					BufferedReader reader = new BufferedReader(new FileReader(fileName));
					Conferencia conference = new ConferenciaAgenda().schedule(reader);
					logger.info(conference);
				}

			}
		} catch (Exception e) {
			logger.fatal("Ocorreu um erro" + e);
			System.exit(1);
		}
	}
}
