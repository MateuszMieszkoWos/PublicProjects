package view;
import java.time.LocalDate;
import java.util.Observable;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import model.Course;
import model.Name;
import model.Module;

public class ReserveModulesPane extends VBox {
	
	
	private ListView<Module> unselTerm1List, reservTerm1List, unselTerm2List, reservTerm2List;
	
	private Button rAdd1Btn, rRemove1Btn, rConfirm1Btn, rAdd2Btn, rRemove2Btn, rConfirm2Btn;

	private VBox Term1Pane;
	private VBox Term2Pane;
	private HBox Term1Pane1;
	private VBox Term1Pane1_1;
	private VBox Term1Pane1_2;
	private HBox Term1Pane2;	
	private HBox Term2Pane1;
	private VBox Term2Pane1_1;
	private VBox Term2Pane1_2;
	private HBox Term2Pane2;	
	private Accordion rAccor;	
	private TitledPane rTerm1;
	private TitledPane rTerm2;
	
	public ReserveModulesPane()
	{
		
		//term1	
		Term1Pane = new VBox();
		Term1Pane1 = new HBox();
		Term1Pane1_1 = new VBox();
		Term1Pane1_2 = new VBox();
		Term1Pane2 = new HBox();
		
		//term2
		Term2Pane = new VBox();
		Term2Pane1 = new HBox();
		Term2Pane1_1 = new VBox();
		Term2Pane1_2 = new VBox();
		Term2Pane2 = new HBox();
		
		rAccor = new Accordion();
		rTerm1 = new TitledPane();
		rTerm2 = new TitledPane();
		
		
		
		Label rUnselected1 = new Label("Unselected Term1 Modules");
		
		unselTerm1List = new ListView<Module>();
		unselTerm1List.setPrefWidth(350.0);
		unselTerm1List.setPrefHeight(300.0);
		
		Term1Pane1_1.getChildren().add(rUnselected1);
		Term1Pane1_1.getChildren().add(unselTerm1List);
		
		
		Label rReserved1 = new Label("Reserved Term1 Modules");
			
		reservTerm1List = new ListView<Module>();
	     reservTerm1List.setPrefWidth(350.0);
	     reservTerm1List.setPrefHeight(300.0);
		
	     
	    Term1Pane1_2.getChildren().add(rReserved1);
		Term1Pane1_2.getChildren().add(reservTerm1List);
		
		
		Term1Pane1.getChildren().add(Term1Pane1_1);
		Term1Pane1.getChildren().add(Term1Pane1_2);
		
		Term1Pane1.setAlignment(Pos.CENTER);
		Term1Pane1.setSpacing(30);
	
	    
		Label rCredit1 = new Label("Reserve 30 Credits worth term 1 modules");

		
		rAdd1Btn = new Button("Add");
		
		
		rRemove1Btn = new Button("Remove");
		
		
		rConfirm1Btn = new Button("Confirm");
		Term1Pane2.getChildren().add(rCredit1);
		Term1Pane2.getChildren().add(rAdd1Btn);
		Term1Pane2.getChildren().add(rRemove1Btn);
		Term1Pane2.getChildren().add(rConfirm1Btn);
		Term1Pane2.setAlignment(Pos.CENTER);
		Term1Pane2.setSpacing(30);
		
		Term1Pane.getChildren().add(Term1Pane1);
		Term1Pane.getChildren().add(Term1Pane2);
		Term1Pane.setAlignment(Pos.CENTER);
		Term1Pane.setSpacing(30);
		Term1Pane.setPadding(new Insets(30, 30, 30, 30));
		rTerm1.setContent(Term1Pane);
		
		Label rUnselected2 = new Label("Unselected Term2 Modules");
		
		unselTerm2List = new ListView<Module>();
		unselTerm2List.setPrefWidth(350.0);
		unselTerm2List.setPrefHeight(300.0);
		
		Term2Pane1_1.getChildren().add(rUnselected2);
		Term2Pane1_1.getChildren().add(unselTerm2List);
		
		
		Label rReserved2 = new Label("Reserved Term2 Modules");
			
		
	     reservTerm2List = new ListView<Module>();
	     reservTerm2List.setPrefWidth(350.0);
	     reservTerm2List.setPrefHeight(300.0);
		
	     
	    Term2Pane1_2.getChildren().add(rReserved2);
		Term2Pane1_2.getChildren().add(reservTerm2List);
		
		
		Term2Pane1.getChildren().add(Term2Pane1_1);
		Term2Pane1.getChildren().add(Term2Pane1_2);
		Term2Pane1.setAlignment(Pos.CENTER);
		Term2Pane1.setSpacing(30);
	
	    
		Label rCredit2 = new Label("Reserve 30 Credits worth term 2 modules");

		
		rAdd2Btn = new Button("Add");
		
		
		rRemove2Btn = new Button("Remove");
		
		
		rConfirm2Btn = new Button("Confirm");
		Term2Pane2.getChildren().add(rCredit2);
		Term2Pane2.getChildren().add(rAdd2Btn);
		Term2Pane2.getChildren().add(rRemove2Btn);
		Term2Pane2.getChildren().add(rConfirm2Btn);
		Term2Pane2.setAlignment(Pos.CENTER);
		Term2Pane2.setSpacing(30);
		
		Term2Pane.getChildren().add(Term2Pane1);
		Term2Pane.getChildren().add(Term2Pane2);
		Term2Pane.setAlignment(Pos.CENTER);
		Term2Pane.setSpacing(30);
		Term2Pane.setPadding(new Insets(30, 30, 30, 30));
		rTerm2.setContent(Term2Pane);
		
				
		
		rTerm1.setText("Term1 modules");
		rTerm2.setText("Term2 modules");
		rTerm1.setAnimated(false);
		rTerm2.setAnimated(false);
		rAccor.getPanes().add(rTerm1);		
		rAccor.getPanes().add(rTerm2);
		
		this.getChildren().add(rAccor);
		
      }

	public void setrAdd1Btn(EventHandler<ActionEvent> e) {
		this.rAdd1Btn.setOnAction(e);;
	}

	public void setrRemove1Btn(EventHandler<ActionEvent> e) {
		this.rRemove1Btn.setOnAction(e);;
	}

	public void setrConfirm1Btn(EventHandler<ActionEvent> e) {
		this.rConfirm1Btn.setOnAction(e);;
	}

	public void setrAdd2Btn(EventHandler<ActionEvent> e) {
		this.rAdd2Btn.setOnAction(e);;
	}

	public void setrRemove2Btn(EventHandler<ActionEvent> e) {
		this.rRemove2Btn.setOnAction(e);;
	}

	public void setrConfirm2Btn(EventHandler<ActionEvent> e) {
		this.rConfirm2Btn.setOnAction(e);;
	}	

	public Button getrAdd1Btn() {
		return rAdd1Btn;
	}

	public Button getrRemove1Btn() {
		return rRemove1Btn;
	}

	public Button getrConfirm1Btn() {
		return rConfirm1Btn;
	}

	public Button getrAdd2Btn() {
		return rAdd2Btn;
	}

	public Button getrRemove2Btn() {
		return rRemove2Btn;
	}

	public Button getrConfirm2Btn() {
		return rConfirm2Btn;
	}

	public ListView<Module> getUnselTerm1List() {
		return unselTerm1List;
	}

	public ListView<Module> getReservTerm1List() {
		return reservTerm1List;
	}

	public ListView<Module> getUnselTerm2List() {
		return unselTerm2List;
	}

	public ListView<Module> getReservTerm2List() {
		return reservTerm2List;
	}

	public void setUnselTerm1List(ObservableList<Module> unselTerm1List) {
		this.unselTerm1List.setItems(unselTerm1List);
	}

	public void setReservTerm1List(ObservableList<Module> reservTerm1List) {
		this.reservTerm1List.setItems(reservTerm1List);;
	}

	public void setUnselTerm2List(ObservableList<Module> unselTerm2List) {
		this.unselTerm2List.setItems(unselTerm2List);;
	}

	public void setReservTerm2List(ObservableList<Module> reservTerm2List) {
		this.reservTerm2List.setItems(reservTerm2List);;
	}

	public Accordion getrAccor() {
		return rAccor;
	}

	public void setrAccor(Accordion rAccor) {
		this.rAccor = rAccor;
	}

	public TitledPane getrTerm1() {
		return rTerm1;
	}

	public void setrTerm1(TitledPane rTerm1) {
		this.rTerm1 = rTerm1;
	}

	public TitledPane getrTerm2() {
		return rTerm2;
	}

	public void setrTerm2(TitledPane rTerm2) {
		this.rTerm2 = rTerm2;
	}
	
	
}
