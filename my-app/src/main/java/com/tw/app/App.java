/**
 * 
 */
package com.tw.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.tw.app.util.Logger;

/**
 * @author carlo
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Logger logger = Logger.getLogger();
		
		try {
			while (true) {
				System.out.println("Digite w para a leitura do arquivo certo : ");
				System.out.println("Digite q para sair : ");
				String input = br.readLine();
				System.out.println("-----------\n");
				System.out.println("Você digitou isso pai : " + input);
				System.out.println("-----------\n");

				if ("q".equals(input)) {
					System.out.println("Você saiu, obrigado !!");
					System.exit(0);
				}
				
				if("w".equals(input)){
					String fileName = "C:/Users/carlo/Desktop/TW/my-app-tw/my-app/src/main/resoucers/arquivo_esperado";
					
					try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
						stream.forEach(System.out::println);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
		//File inputFile = new File("C:/Users/carlo/Desktop/TW/my-app-tw/my-app/src/main/resoucers/arquivo_esperado");
		
		
		
//		try {
//            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//            //Conference conference = new ConferenceScheduler().schedule(reader);
//             logger.info(reader);
//             if(reader.lines() != null){
//            	 while (reader.ready()) {
//            		 System.out.println(reader.ready());
//            	 }
//            	 
//             }
//        } catch (IOException e) {
//            logger.fatal("Não foi possível ler esse arquivo: " + inputFile.getAbsolutePath());
//            System.exit(1);
//        }
		
		/*
		 * 
		 * String fileName = "c://lines.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		 * 
		 * 
		 */
		
//		try {
//			br = new BufferedReader(new InputStreamReader(System.in));
//
//			while (true) {
//
//				System.out.print("Eaa, digite qualquer coisa ai. Se for pra sair digite q : ");
//				String input = br.readLine();
//
//				if ("q".equals(input)) {
//					System.out.println("Saiuuu pae!");
//					System.exit(0);
//				}
//
//				System.out.println("Você digitou isso pai : " + input);
//				System.out.println("-----------\n");
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
	}
}
