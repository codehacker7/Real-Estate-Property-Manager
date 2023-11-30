package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.entity.Listing;

import java.util.Arrays;

/**
 * This is the main controller class that will orchestrate everything.
 */
public class ListingsViewer {
	private DatabaseConnectionHandler dbHandler;

	public ListingsViewer() {
		dbHandler = new DatabaseConnectionHandler();
	}

	private void start() {
		dbHandler.login("ora_jean9739", "a81824658");
		dbHandler.databaseSetup();
	}
    
    public void databaseSetup() {
		dbHandler.databaseSetup();
	}

	/**
	 * Main method called at launch time
	 */
	public static void main(String[] args) {
		ListingsViewer listingsViewer = new ListingsViewer();
		listingsViewer.start();
	}
}
