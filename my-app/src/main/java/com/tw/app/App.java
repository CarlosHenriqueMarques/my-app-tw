/**
 * 
 */
package com.tw.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
		String fileName = "C:/Users/carlo/Desktop/TW/my-app-tw/my-app/src/main/resoucers/arquivo_esperado";
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
