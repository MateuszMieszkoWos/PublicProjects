package view;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;
import model.Name;
import model.Module;

public class CreateProfilePane extends GridPane {
	

	//MAIN INSTANCE

	private ComboBox<Course> courseComboBox;

	private TextField txtFamilyName, txtFirstName, txtPnumber, txtEmail;

	private DatePicker inputDate;

	private Button btnCreate;

	public CreateProfilePane() 
	{
	
	//styling
	this.setVgap(15);
	this.setHgap(20);
	this.setAlignment(Pos.CENTER);

	ColumnConstraints column0 = new ColumnConstraints();
	column0.setHalignment(HPos.RIGHT);

	this.getColumnConstraints().addAll(column0);
	
	//create labels
	Label lblTitle = new Label("Select course: ");
	Label lblPnumber = new Label("Input P number: ");
	Label lblFirstName = new Label("Input first name: ");
	Label lblSurname = new Label("Input surname: ");
	Label lblEmail = new Label("Input email: ");
	Label lblDate = new Label("Input date: ");
	
	//setup comboBox
	courseComboBox = new ComboBox<Course>(); //will be populated via method towards end of class
	
	//setup text fields
	txtFirstName = new TextField();
	txtFamilyName = new TextField();
	txtPnumber = new TextField();
	txtEmail = new TextField();
	
	inputDate = new DatePicker();
	
	//Initialize create button
	btnCreate = new Button("Create Profile");
	btnCreate.setId("btnCreate");
	//add controls and labels to container
	this.add(lblTitle, 0, 0);
	this.add(courseComboBox, 1, 0);
	this.add(lblPnumber, 0, 1);
	this.add(txtPnumber, 1, 1);
	
	this.add(lblFirstName, 0, 2);
	this.add(txtFirstName, 1, 2);

	this.add(lblSurname, 0, 3);
	this.add(txtFamilyName, 1, 3);
	
	this.add(lblEmail, 0, 4);
	this.add(txtEmail, 1, 4);
	
	this.add(lblDate, 0, 5);
	this.add(inputDate, 1, 5);
		
	this.add(new HBox(), 0, 6);
	this.add(btnCreate, 1, 6);
	
	}
	
	
	
	public void setCreateButtonAction(EventHandler<ActionEvent> e) {
		btnCreate.setOnAction(e);
	}
	
	public String getFirstName() {
		return txtFirstName.getText();
	}

	public TextField getTxtFamilyName() {
		return txtFamilyName;
	}



	public void setTxtFamilyName(String in) {
		this.txtFamilyName.setText(in);
	}



	public TextField getTxtFirstName() {
		return txtFirstName;
	}



	public void setTxtFirstName(String in) {
		this.txtFirstName.setText(in);
	}



	public void setTxtPnumber(String in) {
		this.txtPnumber.setText(in);
	}



	public void setTxtEmail(String in) {
		this.txtEmail.setText(in);
	}



	public void setInputDate(LocalDate inputDate) {
		this.inputDate.setValue(inputDate);
	}



	public Course getCourseComboBoxValue() {
		return courseComboBox.getValue();
	}


	public void setCourseComboBoxValue(ObservableList<Course> courseList) {
		this.courseComboBox.setItems(courseList);
	}
	public void setCourseComboBoxDefaltValue(Course course) {
		this.courseComboBox.setValue(course);
	}

	public String getFamilyName() {
		return txtFamilyName.getText();
	}


	public String getTxtPnumber() {
		return txtPnumber.getText();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public LocalDate getInputDate() {
		return inputDate.getValue();
	}

}
