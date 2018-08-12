package com.tw.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.tw.app.util.FileUtil;

public class AppMainTest {

	public static String NOME_ARQUIVO_SUCESSO = "/arquivo_de_input";

	public static String NOME_ARQUIVO_ESPERANDO_SUCESSO = "/arquivo_de_input_esperado";

	public static String NOME_ARQUIVO_SO_PARA_UM_DIA = "/arquivo_so_para_um_dia";

	public static String NOME_ARQUIVO_SO_PARA_UM_DIA_ESPERADO_SUCESSO = "/arquivo_so_para_um_dia_esperado";

	public static String NOME_ARQUIVO_SO_PARA_UM_DIA_E_MEIO = "/arquivo_um_dia_e_meio";

	public static String NOME_ARQUIVO_SO_PARA_UM_DIA_E_MEIO_ESPERADO_SUCESSO = "/arquivo_um_dia_e_meio_esperado";

	@Test
	public void testeSucessoConferenciaInputEsperado() throws IOException {
		Conferencia conferenciaTeste = new ConferenciaAgenda()
				.agenda(FileUtil.getBufferedReaderForResourceFile(NOME_ARQUIVO_SUCESSO, this));

		assertTrue(FileUtil.contentEquals(NOME_ARQUIVO_ESPERANDO_SUCESSO, conferenciaTeste.toString(), this));
	}
	
//	@Test
//	public void testeSucessoArquivoDeUmDia() throws IOException {
//		Conferencia conferenciaTeste = new ConferenciaAgenda()
//				.agenda(FileUtil.getBufferedReaderForResourceFile(NOME_ARQUIVO_SO_PARA_UM_DIA, this));
//
//		assertTrue(FileUtil.contentEquals(NOME_ARQUIVO_SO_PARA_UM_DIA_ESPERADO_SUCESSO, conferenciaTeste.toString(), this));
//	}
//	
//	@Test
//	public void testeSucessoArquivoDeUmDiaEMeio() throws IOException {
//		Conferencia conferenciaTeste = new ConferenciaAgenda()
//				.agenda(FileUtil.getBufferedReaderForResourceFile(NOME_ARQUIVO_SO_PARA_UM_DIA_E_MEIO, this));
//
//		assertTrue(FileUtil.contentEquals(NOME_ARQUIVO_SO_PARA_UM_DIA_E_MEIO_ESPERADO_SUCESSO, conferenciaTeste.toString(), this));
//	}

}