/**
 * 
 */
package com.tw.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.tw.app.util.Logger;

/**
 * @author carlos
 *
 */
public class ConferenciaMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.println(
						"Digite o caminho para o app ler o arquivo da conferência, por favor adicione o nome do arquivo sem extensão : ");
				System.out.println("Digite q para sair : ");
				String input = br.readLine();
				System.out.println("-----------\n");

				if ("q".equals(input)) {
					System.out.println("Você saiu, obrigado !!");
					System.exit(0);
				}
				
				String fileName = input.toString();
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				if(reader.readLine() == null){
					System.out.println("Você solicitou a leitura de um arquivo vazio.");
				}else{
					Conferencia conference = new ConferenciaAgenda().agenda(reader);
					logger.info(conference);
				}
			}
		} catch (Exception e) {
			logger.fatal("Ocorreu um erro na digitação ou comando, por favor tente novamente.");
			System.exit(1);
		}
	}
}
