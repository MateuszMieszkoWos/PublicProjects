package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class ModuleSelectionRootPane extends BorderPane {

	//create Profile Pane
	private CreateProfilePane newProfilePane;
	
	private OverviewPane newOverviewPane;
	
	private ReserveModulesPane newReservePane;
	
	private SelectModulesPane newSelectPane;
	
	//create Module Selection Menu Bar
	private ModuleSelectionMenuBar newModuleSelectionMenuBar;
	
	//create Tab Pane
	private TabPane newTabPane;
	
	


	public ModuleSelectionRootPane() 
	{
		
		//create tab pane and disable tabs from being closed
		newTabPane = new TabPane();
		newTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//create panes
		newProfilePane = new CreateProfilePane();
		
		newSelectPane = new SelectModulesPane();
		
		newReservePane = new ReserveModulesPane();
		
		newOverviewPane = new OverviewPane();
		
		
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", newProfilePane);
		
		Tab t2 = new Tab("SelectModules", newSelectPane);
		
		Tab t3 = new Tab("ReserveModules", newReservePane);
		
		Tab t4 = new Tab("Overwiev Selection",newOverviewPane);
		
		//add tabs to tab pane
		newTabPane.getTabs().addAll(t1);
		newTabPane.getTabs().addAll(t2);
		newTabPane.getTabs().addAll(t3);
		newTabPane.getTabs().addAll(t4);
		
		//create menu bar
		newModuleSelectionMenuBar = new ModuleSelectionMenuBar();
		
		//add menu bar and tab pane to this root pane
		this.setTop( newModuleSelectionMenuBar);
		this.setCenter(newTabPane);
		
	}
	
	//creating view instances in the MODULE,SELECTION,CONTROLLER
	
	public CreateProfilePane getCreateProfilePane() {
		return newProfilePane;
	}
	
	public ModuleSelectionMenuBar getModuleSelectionMenuBar() {
		return  newModuleSelectionMenuBar;
	}
	
	public OverviewPane getOverviewPane() {
		return  newOverviewPane;
	}
	
	
	public ReserveModulesPane getReserveModulesPane() {
		return  newReservePane;
	}
	
	
	public SelectModulesPane getSelectModulesPane() {
		return  newSelectPane;
	}
		
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		newTabPane.getSelectionModel().select(index);
	}
	
	public void changeAccordPage1(){		
		newReservePane.getrTerm1().setExpanded(true);
	}
	public void changeAccordPage2(){		
		newReservePane.getrTerm2().setExpanded(true);
	} 

}
