package view;

import java.time.LocalDate;
import java.util.Collection;

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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Course;
import model.Name;
import model.Module;
import view.ModuleSelectionRootPane;
import model.StudentProfile;


public class SelectModulesPane extends VBox {
	
	public Button getTerm1AddBtn() {
		return term1AddBtn;
	}


	public void setTerm1AddBtn(Button term1AddBtn) {
		this.term1AddBtn = term1AddBtn;
	}


	public Button getTerm2AddBtn() {
		return term2AddBtn;
	}


	public void setTerm2AddBtn(Button term2AddBtn) {
		this.term2AddBtn = term2AddBtn;
	}


	public Button getTerm1RemoveBtn() {
		return term1RemoveBtn;
	}


	public void setTerm1RemoveBtn(Button term1RemoveBtn) {
		this.term1RemoveBtn = term1RemoveBtn;
	}


	public Button getTerm2RemoveBtn() {
		return term2RemoveBtn;
	}


	public void setTerm2RemoveBtn(Button term2RemoveBtn) {
		this.term2RemoveBtn = term2RemoveBtn;
	}


	public Button getsResetBtn() {
		return sResetBtn;
	}


	public void setsResetBtn(Button sResetBtn) {
		this.sResetBtn = sResetBtn;
	}


	public Button getsSubmitBtn() {
		return sSubmitBtn;
	}


	public void setsSubmitBtnAction(EventHandler<ActionEvent> e) {
		this.sSubmitBtn.setOnAction(e);
	}


	private Button term1AddBtn, term2AddBtn, term1RemoveBtn, term2RemoveBtn, sResetBtn, sSubmitBtn;
	private TextField creditTerm1TF, creditTerm2TF;
	private ListView<Module> term1List, term2List, selTerm1List, selLongMList, selTerm2List;



	private HBox disp;
	private HBox credit;
	private HBox btn;
	private VBox disp1;
	private VBox disp2;
	private HBox term1btn;
	private HBox term2btn;
	private HBox credit1;
	private HBox credit2;
	
	public SelectModulesPane() {	
		
	this.setSpacing(10);	
		
	disp = new HBox();
	credit = new HBox();
	btn = new HBox();
	disp1 = new VBox();	
	disp2 = new VBox();
	credit1 = new HBox();
	credit2 = new HBox();
	
	//1
	Label term1Title = new Label("Unselected Term 1 Modules");
	
	
	//2
	term1List = new ListView<Module>();
	
	
	term1List.setPrefWidth(350.0);
	term1List.setPrefHeight(150.0);	
	
	
	//3
	Label term1 = new Label("Term1");
	
	//4
	term1AddBtn = new Button("Add");
	
	//5
	term1RemoveBtn = new Button("Remove");
	
	term1btn = new HBox();
	term1btn.getChildren().add(term1);
	term1btn.getChildren().add(term1AddBtn);
	term1btn.getChildren().add(term1RemoveBtn);
	term1btn.setSpacing(20);
	term1btn.setAlignment(Pos.CENTER);
	term1btn.setPadding(new Insets(20, 0, 0, 20));
	
	disp1.getChildren().add(term1Title);
	disp1.getChildren().add(term1List);
	disp1.getChildren().add(term1btn);
	
	
    //6	
	Label term2Title = new Label("Unselected Term 2 Modules");

	//7
	term2List = new ListView<Module>();
	term2List.setPrefWidth(350.0);
	term2List.setPrefHeight(150.0);
	
	

	//12
	Label term2 = new Label("Term2");
	
	//11
	term2AddBtn = new Button("Add");
	
	//12
	term2RemoveBtn = new Button("Remove");
	
	
	term2btn = new HBox();
	term2btn.getChildren().add(term2);
	term2btn.getChildren().add(term2AddBtn);
	term2btn.getChildren().add(term2RemoveBtn);
	term2btn.setSpacing(20);
	term2btn.setAlignment(Pos.CENTER);
	term2btn.setPadding(new Insets(20, 0, 0, 20));
	
	
	
	disp1.getChildren().add(term2Title);
	disp1.getChildren().add(term2List);
	disp1.getChildren().add(term2btn);
	disp.getChildren().add(disp1);
	disp.setAlignment(Pos.CENTER);
	disp.setSpacing(10);

	//13
    Label creditTerm1 = new Label("Current Term 1 Credits");
	
	
    //14
    creditTerm1TF = new TextField();
    creditTerm1TF.setMaxWidth(50);
    
    credit1.getChildren().add(creditTerm1);
    credit1.getChildren().add(creditTerm1TF);
    
    //15
    sResetBtn = new Button("Reset");
    
    //16
    sSubmitBtn = new Button("Submit");
    
    btn.getChildren().add(sResetBtn);
    btn.getChildren().add(sSubmitBtn);
    btn.setAlignment(Pos.CENTER);
    btn.setSpacing(30);
    btn.setPadding(new Insets(10, 10, 10, 10));
        
    
     //10
  	Label selLong = new Label("Selected Year Long Modules");
  	
  	
  	//11
  	selLongMList = new ListView<Module>();
  	selLongMList.setPrefWidth(350.0);
  	selLongMList.setPrefHeight(100.0);
  	selLongMList.setPadding(new Insets(0, 10, 10, 30));
  //12
  	Label selTerm1 = new Label("Selected Term1 Modules");
  	
  	
  	//13
  	selTerm1List = new ListView<Module>();
  	selTerm1List.setPrefWidth(350.0);
  	selTerm1List.setPrefHeight(150.0);
	selTerm1List.setPadding(new Insets(0, 10, 10, 30));
  	
  //14
  	Label selTerm2 = new Label("Selected Term 2 Modules");
  	
  	
  	//15
  	//PROBABLY THE ARRAY LIST FROM STUDENTPROFILE
  	selTerm2List = new ListView<Module>();
  	selTerm2List.setPrefWidth(350.0);
  	selTerm2List.setPrefHeight(150.0);
  	selTerm2List.setPadding(new Insets(0, 10, 10, 30));
  	
  	disp2.getChildren().add(selLong);
  	disp2.getChildren().add(selLongMList);
  	disp2.getChildren().add(selTerm1);
  	disp2.getChildren().add(selTerm1List);
  	disp2.getChildren().add(selTerm2);
  	disp2.getChildren().add(selTerm2List);
  	disp2.setSpacing(5);
  	disp.getChildren().add(disp2);
  	disp.setAlignment(Pos.CENTER);
  	disp.setSpacing(20);
  	disp.setPadding(new Insets(0, 10, 10, 30));
  	//16
  	Label creditTerm2 = new Label("Current term 2 credits");
  	
  	//17
  	creditTerm2TF = new TextField();
  	creditTerm2TF.setMaxWidth(50);
  	
    credit1.getChildren().add(creditTerm2);
    credit1.getChildren().add(creditTerm2TF);
    credit1.setSpacing(20);
	credit2.getChildren().add(creditTerm2);
	credit2.getChildren().add(creditTerm2TF);
	credit2.setSpacing(20);
	credit.getChildren().add(credit1);
	credit.getChildren().add(credit2);	
	credit.setAlignment(Pos.CENTER);
	credit.setSpacing(50);
  	
  	this.getChildren().add(disp);
  	this.getChildren().add(credit);
  	this.getChildren().add(btn);
  	this.setPadding(new Insets(20, 20, 20, 20));	
  	
	}
	

	public void setTerm1AddBtn(EventHandler<ActionEvent> e) {
		term1AddBtn.setOnAction(e);
	}

	public void setTerm2AddBtn(EventHandler<ActionEvent> e) {
		term2AddBtn.setOnAction(e);
	}

	public void setTerm1RemoveBtn(EventHandler<ActionEvent> e) {
		term1RemoveBtn.setOnAction(e);
	}

	public void setTerm2RemoveBtn(EventHandler<ActionEvent> e) {
		term2RemoveBtn.setOnAction(e);
	}
	
	public void setResetBtn(EventHandler<ActionEvent> e) {
		sResetBtn.setOnAction(e);
	}
	
	public void setSaveBtn(EventHandler<ActionEvent> e) {
		sSubmitBtn.setOnAction(e);
	}

	public TextField getCreditTerm1TF() {
		return creditTerm1TF;
	}

	public TextField getCreditTerm2TF() {
		return creditTerm2TF;
	}
	
	

	public void setCreditTerm1TF(String creditTerm1TF) {
		this.creditTerm1TF.setText(creditTerm1TF);
	}


	public void setCreditTerm2TF(String creditTerm2TF) {
		this.creditTerm2TF.setText(creditTerm2TF);
	}
	
	


	public ListView<Module> getSelTerm1List() {
		return selTerm1List;
	}


	public void setSelTerm1List(ListView<Module> selTerm1List) {
		this.selTerm1List = selTerm1List;
	}


	public ListView<Module> getSelTerm2List() {
		return selTerm2List;
	}


	public void setSelTerm2List(ListView<Module> selTerm2List) {
		this.selTerm2List = selTerm2List;
	}


	public ListView<Module> getSelLongMList() {
		return selLongMList;
	}


	public void setSelLongMList(ListView<Module> selLongMList) {
		this.selLongMList = selLongMList;
	}


	public void setTerm1List( ObservableList<Module> term1List) {
		this.term1List.setItems(term1List);
	}


	public void setTerm2List(ObservableList<Module> term2List) {
		this.term2List.setItems(term2List);
	}
	


	public ListView<Module> getTerm1List() {
		return term1List;
	}


	public void setTerm1List(ListView<Module> term1List) {
		this.term1List = term1List;
	}


	public ListView<Module> getTerm2List() {
		return term2List;
	}


	public void setSelTerm1List(ObservableList<Module> selTerm1List) {
		this.selTerm1List.setItems(selTerm1List);
	}


	public void setSelLongMList(ObservableList<Module> selLongMList) {
		this.selLongMList.setItems(selLongMList);
	}


	public void setSelTerm2List(ObservableList<Module> selTerm2List) {
		this.selTerm2List.setItems(selTerm2List);
	}





}