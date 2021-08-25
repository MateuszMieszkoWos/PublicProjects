package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;



public class ModuleSelectionMenuBar extends MenuBar {

	private MenuItem loadStudentDataItem, saveStudentDataItem,exitItem,aboutItem;

	public ModuleSelectionMenuBar() { 

	    ///menu variable for menus
		Menu menu;
		//build the first menu on the MenuBar
		menu = new Menu("_File");

		//2
		//ADD a "AddItem"
		loadStudentDataItem = new MenuItem("_LoadStudentData");
		loadStudentDataItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(loadStudentDataItem);

		//3
		//ADD a "RemoveItem"
		saveStudentDataItem = new MenuItem("_SaveStudentData");
		saveStudentDataItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(saveStudentDataItem);

		//4
		//ADD a "SubmitItem"
		exitItem = new MenuItem("_Exit");
		exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menu.getItems().add(exitItem);

		this.getMenus().add(menu); //add the menu to this menu bar


		//----------Build the second menu on the menu bar.--------------------
		menu = new Menu("_Help");

		//'About' menu item
		aboutItem = new MenuItem("_About");
		aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		menu.getItems().add(aboutItem);

		this.getMenus().add(menu); //add the menu to this menubar

	}

	//these methods allow handlers to be externally attached to this menubar and used by the controller
	//7
	public void addSaveStudentDataHandler(EventHandler<ActionEvent> handler) {
		saveStudentDataItem.setOnAction(handler);
	}

	//8
	public void addLoadStudentDataHandler(EventHandler<ActionEvent> handler) {
		loadStudentDataItem.setOnAction(handler);
	}

	//9
	public void addExitHandler(EventHandler<ActionEvent> handler) {
		exitItem.setOnAction(handler);
	}
	//9
	public void addAboutHandler(EventHandler<ActionEvent> handler) {
			aboutItem.setOnAction(handler);
	}

	
	//11-->maybe


}
