/**
 * 
 */
package com.tw.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author carlo
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Eaa, digite qualquer coisa ai. Se for pra sair digite q : ");
				String input = br.readLine();

				if ("q".equals(input)) {
					System.out.println("Saiuuu pae!");
					System.exit(0);
				}

				System.out.println("Você digitou isso pai : " + input);
				System.out.println("-----------\n");
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

	}
}
