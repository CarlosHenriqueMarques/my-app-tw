package com.tw.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import com.tw.app.util.Config;
import com.tw.app.util.Logger;

public class ConferenciaAgenda {
	public ConferenciaAgenda() {
	}

	private static Logger logger = Logger.getLogger();

	public Conferencia agenda(BufferedReader input) throws IOException {
		List<Evento> eventos = new ArrayList<Evento>();
		for (String linha; (linha = input.readLine()) != null;) {
			linha = linha.trim();
			Evento evento = parseInputLinha(linha);
			if (evento == null) {
				continue;
			}
			eventos.add(evento);
		}

		Conferencia conferencia = new Conferencia();
		while (eventos.size() != 0) {
			
			Vaga sessaoManha = new Vaga(Config.SESSAO_MANHA, Config.HORARIO_INICIO_SESSAO_MANHA);
			preencherSessaoComEventos(sessaoManha, eventos); 
			
			Vaga sessaoAlmoco = new Vaga(Config.HORARIO_ALMOCO, Config.HORARIO_INICIO_ALMOCO);
			sessaoAlmoco.addEvento(new Evento("Lunch", Config.HORARIO_ALMOCO, Duracao.MINUTOS));

			Vaga sessaoTarde = new Vaga(Config.SESSAO_TARDE, Config.HORARIO_INICIO_SESSAO_TARDE);
			preencherSessaoComEventos(sessaoTarde, eventos);
			
			Evento networkingEvent = new Evento(Config.NETWORK_EVENT, Config.DURACA_NETWORK_EVENT,
					Config.DURACAO_NETWORK_EVENT);
			Vaga networkingSlot = new Vaga(networkingEvent.getDuracaoEmMinutos(),
					Config.HORARIO_INICIO_NETWORK_EVENT);
			
			networkingSlot.addEvento(networkingEvent);
			sessaoTarde.addVagaRestante(networkingSlot);
			
			Track track = new Track();
			track.addSessao(sessaoManha);
			track.addSessao(sessaoAlmoco);
			track.addSessao(sessaoTarde);
			conferencia.addTrack(track);
		}

		return conferencia;
	}

	private static void preencherSessaoComEventos(Vaga sessao, List<Evento> eventos) {
		for (Iterator<Evento> iter = eventos.iterator(); iter.hasNext();) {
			Evento evento = iter.next();
			if (sessao.temVagaPara(evento)) {
				sessao.addEvento(evento);
				iter.remove();
			}
		}
	}

	private static Evento parseInputLinha(String linha) {
		if (linha.length() == 0) {
			return null;
		}

		Matcher match = Config.INPUT_LINHA_REGEX.matcher(linha);
		if (match.find() == false) {
			logger.warn("Linha inválida: " + linha);
			return null;
		}

		Duracao unidade;
		if (match.group(Config.UNIDADE_DO_EVENTO).equalsIgnoreCase("min")) {
			unidade = Duracao.MINUTOS;
		} else {
			unidade = Duracao.LIGHTENING;
		}

		String nome = match.group(Config.NOME_DO_EVENTO);
		String durationInString = match.group(Config.DURACAO_DO_EVENTO);
		if (durationInString == null) {
			durationInString = "1";
		}
		int duracao = Integer.parseInt(durationInString);

		Evento event = new Evento(nome, duracao, unidade);
		if (event.getDuracaoEmMinutos() > Config.MAX_EVENTO_DURACAO) {
			logger.warn("O tempo do evento '" + nome + "' está acima do permitido.");
			return null;
		}

		return event;
	}

}
