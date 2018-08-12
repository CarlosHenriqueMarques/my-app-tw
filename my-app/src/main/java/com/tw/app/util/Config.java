package com.tw.app.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import com.tw.app.Duracao;

public class Config {
	private Config() {
	}

	public static final Pattern INPUT_LINHA_REGEX = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");

	public static final int NOME_DO_EVENTO = 1;
	public static final int DURACAO_DO_EVENTO = 2;
	public static final int UNIDADE_DO_EVENTO = 3;

	public static final int SESSAO_MANHA = 180;
	public static final int HORARIO_ALMOCO = 60;
	public static final int SESSAO_TARDE = 240;

	public static final int HORARIO_INICIO_SESSAO_MANHA = 9 * 60;
	public static final int HORARIO_INICIO_ALMOCO = HORARIO_INICIO_SESSAO_MANHA + SESSAO_MANHA;
	public static final int HORARIO_INICIO_SESSAO_TARDE = HORARIO_INICIO_ALMOCO + HORARIO_ALMOCO;

	public static final int MAX_EVENTO_DURACAO = Collections
			.max(Arrays.asList(SESSAO_MANHA, HORARIO_ALMOCO, SESSAO_TARDE));

	public static final Duracao LUNCH_SLOT_DURATION_UNIT = Duracao.MINUTOS;
	public static final String ALMOCO = "Lunch";
	public static final String NETWORK_EVENT = "Networking Event";
	public static final int DURACA_NETWORK_EVENT = 60;
	public static final Duracao DURACAO_NETWORK_EVENT = Duracao.MINUTOS;
	public static final int HORARIO_INICIO_NETWORK_EVENT = (12 * 60) + (4 * 60); 
																					
}
