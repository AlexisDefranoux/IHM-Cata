package fr.polytech.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Incidents {

	private static Incidents instance = new Incidents();
	private ObservableList<Incident> mishaps;
	//private FilteredList<Incident> mishapFilteredList;


	private Incidents(){
		mishaps = FXCollections.observableArrayList();
		//mishapFilteredList = new FilteredList<>(mishaps);
	}

//	public FilteredList<Incident> getMishapFilteredList() {
//		return mishapFilteredList;
//	}

	public void addMishap(Incident mishap) {
		mishaps.add(mishap);
	}


	public ObservableList<Incident> getMishaps() {
		return mishaps;
	}

	public static Incidents getInstance(){
		return instance;
	}
}
