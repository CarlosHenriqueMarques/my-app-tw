package com.tw.app;

import java.util.ArrayList;
import java.util.List;

import com.tw.app.util.Constant;
import com.tw.app.util.Time;

public class Vaga {

	private List<Evento> Eventos;
	private int tempoSobra; 
	private int tempoInicio; 
	private Vaga vaga;

	public Vaga(int duracao, int tempoInicio) {
		this.tempoSobra = duracao;
		this.tempoInicio = tempoInicio;
		Eventos = new ArrayList<Evento>();
	}

	public void addEvento(Evento Evento) {
		if (tempoSobra < Evento.getDuracaoEmMinutos()) {
			throw new IllegalStateException(
					"Não há mais sessão para esse evento: '" + Evento.getNome() + "'");
		}
		Eventos.add(Evento);
		tempoSobra -= Evento.getDuracaoEmMinutos();
	}

	public boolean temVagaPara(Evento Evento) {
		return tempoSobra >= Evento.getDuracaoEmMinutos();
	}

	public void addVagaRestante(Vaga vaga) {
		this.vaga = vaga;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int horaInicialDoProximoEvento = addEventosAgenda(Eventos, tempoInicio, str);
		if (vaga != null) {
			int horaInicioRestante = vaga.tempoInicio;
			if (horaInicialDoProximoEvento > vaga.tempoInicio) {
				horaInicioRestante = horaInicialDoProximoEvento;
			}
			horaInicialDoProximoEvento = addEventosAgenda(vaga.Eventos, horaInicioRestante, str);
		}
		return str.toString();
	}

	/**
	 * Faz o controle da hora inicial e final dos eventos
	 *
	 * @param Eventos
	 *            Lista de eventos para ser adicionado no StringBuilder.
	 * @param horaInicio
	 *            Hora inicial do Evento.
	 * @param str
	 *            StringBuilder.
	 * @return Hora final do evento ou hora inicial do próximo evento.
	 */
	private int addEventosAgenda(List<Evento> Eventos, int horaInicio, StringBuilder str) {
		int horaInicialDoProximoEvento = horaInicio;
		for (Evento Evento : Eventos) {
			str.append(Time.minutesToDisplayTime(horaInicialDoProximoEvento) + " " + Evento + Constant.NOVA_LINHA);
			horaInicialDoProximoEvento += Evento.getDuracaoEmMinutos();
		}

		return horaInicialDoProximoEvento;
	}

}
