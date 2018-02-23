package fr.polytech.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Incidents {

	private static Incidents instance = new Incidents();
	private ObservableList<Incident> incidents;

	private Incidents(){
		incidents = FXCollections.observableArrayList();
	}

	public void addIncident(Incident incident) {
		incidents.add(incident);
	}

	public ObservableList<Incident> getIncidents() {
		return incidents;
	}

	public static Incidents getInstance(){
		return instance;
	}
}
