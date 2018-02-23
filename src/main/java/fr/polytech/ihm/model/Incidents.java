package fr.polytech.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Incidents {

	private static Incidents instance = new Incidents();
	private ObservableList<Incident> incidentsAfficher;
	private ArrayList<Incident> incidentsAll;

	private Incidents(){
		incidentsAfficher = FXCollections.observableArrayList();
		incidentsAll = new ArrayList<>();
	}

	public void addIncident(Incident incident) {
		incidentsAfficher.add(incident);
		incidentsAll.add(incident);
	}

	public ObservableList<Incident> getIncidentsAfficher() {
		return incidentsAfficher;
	}

	public void setIncidentsAfficher(ObservableList<Incident> incidentsAfficher) {
		this.incidentsAfficher = incidentsAfficher;
	}

	public ArrayList<Incident> getIncidentsAll() {
		return incidentsAll;
	}

	public static Incidents getInstance(){
		return instance;
	}
}
