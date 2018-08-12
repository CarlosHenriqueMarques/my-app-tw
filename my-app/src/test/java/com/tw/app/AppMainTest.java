package com.tw.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.tw.app.util.FileUtil;

public class AppMainTest {
	
	public static String NOME_ARQUIVO_SUCESSO = "/arquivo_de_input";
	
	public static String NOME_ARQUIVO_ESPERANDO_SUCESSO = "/arquivo_de_input_esperado";
	
	public static String NOME_ARQUIVO_VAZIO = "/arquivo_vazio";
	
	@Test
    public void testeSucessoConferenciaInputEsperado() throws IOException {
    	Conferencia conferenciaTeste = new ConferenciaAgenda()
    			.agenda(FileUtil.getBufferedReaderForResourceFile(NOME_ARQUIVO_SUCESSO, this));
    	
    	assertTrue(FileUtil.contentEquals(NOME_ARQUIVO_ESPERANDO_SUCESSO, conferenciaTeste.toString(), this));
    }


}