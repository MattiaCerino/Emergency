package it.polito.tdp.Emergency.model;

import java.time.LocalTime;

public class Event implements Comparable<Event>{
	
	public enum EventType {
		ARRIVAL,		// Arriva un nuovo paziente
		TRIAGE,			// E' stato assegnato codice colore e vado in sala d'attesa
		FREE_STUDIO,	// Si libera uno studio e chiamo un paziente
		TREATED,		// Paziente trattato e dimesso
		TIMEOUT,		// Attesa eccessiva in sala d'aspetto
		TICK,			// Evento periodico per verificare se ci sono studi vuoti
	}
	
	private LocalTime time ;
	private EventType type ;
	private Paziente paziente ;
	

	/**
	 * @param time
	 * @param type
	 */
	public Event(LocalTime time, EventType type, Paziente paziente) {
		super();
		this.time = time;
		this.type = type;
		this.paziente = paziente;
	}

	// Non metto i setTime() e setType() perché sono valori preassegnati e fondamentali per la loro posizione nella coda prioritaria
	public LocalTime getTime() {
		return time;
	}

	public EventType getType() {
		return type;
	}

	@Override
	public int compareTo(Event other) {
		return this.time.compareTo(other.time);
	}

	public Paziente getPaziente() {
		return paziente;
	}
	
	@Override
	public String toString() {
		return "Event ["+time + ", " + type + ", " + paziente + "]";
	}

}
