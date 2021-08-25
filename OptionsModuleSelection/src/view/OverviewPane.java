package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import model.Module;
import model.StudentProfile;

public class OverviewPane extends VBox {
	
   private Button btnSaveOverview;
   private TextArea studentDetailText;
   private TextArea selModulesText;
   private TextArea resModulesText;
   
	public OverviewPane() 
	{
		HBox modulesPane = new HBox();
		// studentDetailText
		studentDetailText = new TextArea();
		studentDetailText.setEditable(false);
		studentDetailText.setPadding(new Insets(5, 5, 5, 5));
		studentDetailText.setPrefWidth(700.0);
		studentDetailText.setPrefHeight(300.0);
		
		// selected Modules ListView
		selModulesText = new TextArea();
		selModulesText.setPrefWidth(400.0);
		selModulesText.setPrefHeight(400.0);
		
		// reserved Modules ListView
		resModulesText = new TextArea();
		resModulesText.setPrefWidth(400.0);
		resModulesText.setPrefHeight(400.0);
		
		modulesPane.getChildren().add(selModulesText);
		modulesPane.getChildren().add(resModulesText);
		modulesPane.setSpacing(30);
		modulesPane.setAlignment(Pos.CENTER);
		
		// save overview button
		btnSaveOverview = new Button("SaveOverview");
		
		this.getChildren().add(studentDetailText);
		this.getChildren().add(modulesPane);
		this.getChildren().add(btnSaveOverview);
		this.setSpacing(30);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(50, 50, 50, 50));
		
	}
	
	public void setSaveOverviewButtonAction(EventHandler<ActionEvent> e) {
		btnSaveOverview.setOnAction(e);
	}

	public String getStudentProfile() {
		return studentDetailText.getText();
	}

	public void setStudentProfile(String studentProfile) {
		this.studentDetailText.setText(studentProfile);
	}

	public String getSelModulesText() {
		return selModulesText.getText();
	}

	public void setSelModulesText(String moduleList) {
		this.selModulesText.setText(moduleList);
	}

	public String  getResModulesText() {
		return resModulesText.getText();
	}

	public void setResModulesText(String moduleList) {
		this.resModulesText.setText(moduleList);
	}
	
}
