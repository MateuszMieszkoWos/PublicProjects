package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.glass.ui.Window;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Course;
import model.Delivery;
import model.Module;
import model.Name;
import model.StudentProfile;
import view.CreateProfilePane;
import view.ModuleSelectionMenuBar;
import view.ModuleSelectionRootPane;
import view.OverviewPane;
import view.ReserveModulesPane;
import view.SelectModulesPane;


public class ModuleSelectionController {
	//---------------------------------------------------------------------------------------------------------
	//MODEL INSTANCES
    //----------------------------------------------------------------------------------------------------------
	
	//COURSE, course
	private Course course;
	//DELIVERY, module
	private Delivery delivery;
	//MODULE, name
	private Module module;
	//DELIVERY, module
	private Name name;
	//STUDENTPROFILE, studentProfile
	private StudentProfile studentProfile;
	
	//----------------------------------------------------------------------------------------------------------
	//VIEW INSTANCES
    //----------------------------------------------------------------------------------------------------------
	//1
	private ModuleSelectionRootPane rootPane;
	//2
	private CreateProfilePane createProfilePane;
	
	//3
	private ModuleSelectionMenuBar moduleSelectionMenuBar;
	//4
	private OverviewPane overviewPane;
	//5
	private ReserveModulesPane reserveModulesPane;
	//6
	private SelectModulesPane selectModulesPane;
	

	private Button btnCreate;
	
	private String overviewText;
	
	
	//----------------------------------------------------------------
	//CONSTRUCTOR -------------->MODEL and VIEW instances
	//----------------------------------------------------------------
	
/*	public ModuleSelectionController(Course course, Delivery delivery, Module module ,Name name, StudentProfile studentProfile ,ModuleSelectionRootPane rootPane) {

		//Initialize MODEL 
		this.course = course;
		this.delivery = delivery;
		this.module = module;
		this.name = name;
		this.studentProfile = studentProfile;
		//1
		this.rootPane = rootPane;
		//2 	
		createProfilePane = rootPane.getCreateProfilePane();
		//3
		
		//moduleSelectionMenuBar.addModuleSelectionMenuBarHandler(new ModuleSelectionMenuBarHandler());
		//moduleSelectionMenuBar.addExitHandler(e -> System.exit(0));

		//4
		overviewPane = rootPane.getOverviewPane();
		//5
		reserveModulesPane = rootPane.getReserveModulesPane();
		//6
		selectModulesPane = rootPane.getSelectModulesPane();

		//TO BE DONE
		//add BAOUT HANDLER and SELECTION CHANGE LISTENER
		
	}*/
	
	
	public ModuleSelectionController(ModuleSelectionRootPane rootPane) {
		
		//1
		this.rootPane = rootPane;
		
		moduleSelectionMenuBar=rootPane.getModuleSelectionMenuBar();
		moduleSelectionMenuBar.addSaveStudentDataHandler(new SaveProfileHandler());
		moduleSelectionMenuBar.addLoadStudentDataHandler(new LoadStudentDataHandler());
		moduleSelectionMenuBar.addExitHandler(new ExitHandler());
		moduleSelectionMenuBar.addAboutHandler(new AboutHandler());
		//2 	
		createProfilePane = rootPane.getCreateProfilePane();
		//3
		createProfilePane.setCreateButtonAction(new CreateProfileHandler());

		//6
		selectModulesPane = rootPane.getSelectModulesPane();
		
		selectModulesPane.setResetBtn(new ResetHandler());
				
		selectModulesPane.setTerm1AddBtn(new AddHandlers());
		selectModulesPane.setTerm2AddBtn(new AddHandlers());
		selectModulesPane.setTerm1RemoveBtn(new RemoveHandlers());
		selectModulesPane.setTerm2RemoveBtn(new RemoveHandlers());
		selectModulesPane.setsSubmitBtnAction(new SubmitHandler());
		//5
		reserveModulesPane = rootPane.getReserveModulesPane();
		
		reserveModulesPane.setrAdd1Btn(new AddHandlers());
		reserveModulesPane.setrAdd2Btn(new AddHandlers());
		reserveModulesPane.setrRemove1Btn(new RemoveHandlers());
		reserveModulesPane.setrRemove2Btn(new RemoveHandlers());
		reserveModulesPane.setrConfirm1Btn(new ConfirmHandlers());
		reserveModulesPane.setrConfirm2Btn(new ConfirmHandlers());
		
		//4
		overviewPane = rootPane.getOverviewPane();
		overviewPane.setSaveOverviewButtonAction(new SaveOverviewHandler());
		
		populateCourseComboBox();

		//TO BE DONE
		//add BAOUT HANDLER and SELECTION CHANGE LISTENER

	}
	
	private Collection<Module> allModules;
						
	private ObservableList<Module> allModulesList = FXCollections.observableArrayList();				
	private ObservableList<Module> selTerm1List = FXCollections.observableArrayList();
	private ObservableList<Module> selTerm2List = FXCollections.observableArrayList();
	private ObservableList<Module> selLongTermList = FXCollections.observableArrayList();
	private ObservableList<Module> unSelTerm1List = FXCollections.observableArrayList();
	private ObservableList<Module> unSelTerm2List = FXCollections.observableArrayList();
	private ObservableList<Module> reserveTerm1List = FXCollections.observableArrayList();
	private ObservableList<Module> reserveTerm2List = FXCollections.observableArrayList();


//-----------------------------------------------
//ATTACHING EVENT HANLDERS
//----------------------------------------------

	private void attachEventHandlers() {
		
		/*createProfilePane.addCreateProfileHandler(new ProfileHandler);
		moduleSelectionMenuBar.addModuleSelectionMenuBarHandler(new ModuleHandler());
		overviewPane.addLoadHandler(new LoadHandler());
		reserveModulesPane.addSaveHandler(new SaveHandler());
		selectModulesPane.addExitHandler(new ExitHandler());
*/

	}

	
//--------------------------------------------	
//PROFILE HANDLERS
//--------------------------------------------
	
	//
	private class CreateProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			studentProfile=new StudentProfile();
			
			course=createProfilePane.getCourseComboBoxValue();
			String firstName=createProfilePane.getFirstName();
			String familyName=createProfilePane.getFamilyName();
			String pNumber=createProfilePane.getTxtPnumber();
			String email=createProfilePane.getTxtEmail();
			LocalDate date=createProfilePane.getInputDate();
			
			name=new Name();
			name.setFirstName(firstName);
			name.setFamilyName(familyName);
				
			studentProfile.setCourse(course);
			studentProfile.setStudentName(name);
			studentProfile.setpNumber(pNumber);
			studentProfile.setEmail(email);
			studentProfile.setSubmissionDate(date);
			
			if(course==null || name.getFullName()=="" || pNumber=="" || email=="" || date==null ) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setContentText("Please enter your information correctly");
				alert.show();
			} else {
				initSelectModulesPane();
				rootPane.changeTab(1);
			}
		}
	}

	//2
	private class ResetHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			initSelectModulesPane();

		}
	}

	//3
	private class AddHandlers implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
				int limitCredit1 = displayCredit1();
				int limitCredit2 = displayCredit2();
				int limitReserveCredit1 = displayReserveCredit1();
				int limitReserveCredit2 = displayReserveCredit2();
				
				Button button = (Button)e.getSource();
				if(selectModulesPane.getTerm1AddBtn()==button) {
					if(selectModulesPane.getTerm1List().getSelectionModel().getSelectedItem()!=null) {
						if(limitCredit1!=60){
							
							selTerm1List.add(selectModulesPane.getTerm1List().getSelectionModel().getSelectedItem());
							for(int i = 0; i<unSelTerm1List.size(); i++){
								if(selectModulesPane.getTerm1List().getSelectionModel().getSelectedItem().toString().equals(unSelTerm1List.get(i).toString())){
									unSelTerm1List.remove(i);						
								}
							}	
							selectModulesPane.setSelTerm1List(selTerm1List);
							selectModulesPane.setTerm1List(unSelTerm1List);
							selectModulesPane.getTerm1List().getSelectionModel().clearSelection();
						}else{
												
						}						
					}
					
				} else if(selectModulesPane.getTerm2AddBtn()==button) {
					if(selectModulesPane.getTerm2List().getSelectionModel().getSelectedItem()!=null) {
						if(limitCredit2!=60){
							
							selTerm2List.add(selectModulesPane.getTerm2List().getSelectionModel().getSelectedItem());
							for(int k = 0; k<unSelTerm2List.size(); k++){
								if(selectModulesPane.getTerm2List().getSelectionModel().getSelectedItem().toString().equals(unSelTerm2List.get(k).toString())){
									unSelTerm2List.remove(k);						
								}
							}	
							selectModulesPane.setSelTerm2List(selTerm2List);
							selectModulesPane.setTerm2List(unSelTerm2List);
							selectModulesPane.getTerm2List().getSelectionModel().clearSelection();
						}else{
							
						}
					}
					
				}else if(reserveModulesPane.getrAdd1Btn()==button){
					if(reserveModulesPane.getUnselTerm1List().getSelectionModel().getSelectedItem()!=null){
						if(limitReserveCredit1!=30){
						
						reserveTerm1List.add(reserveModulesPane.getUnselTerm1List().getSelectionModel().getSelectedItem());
						for(int l = 0; l<unSelTerm1List.size(); l++){
							if(reserveModulesPane.getUnselTerm1List().getSelectionModel().getSelectedItem().toString().equals(unSelTerm1List.get(l).toString())){
								unSelTerm1List.remove(l);							
							}
						}	
					}
					reserveModulesPane.setUnselTerm1List(unSelTerm1List);
					reserveModulesPane.setReservTerm1List(reserveTerm1List);
					reserveModulesPane.getUnselTerm1List().getSelectionModel().clearSelection();
					}else{
					
					}
				}else if(reserveModulesPane.getrAdd2Btn()==button){
					if(reserveModulesPane.getUnselTerm2List().getSelectionModel().getSelectedItem()!=null){
						if(limitReserveCredit2!=30){
							
							reserveTerm2List.add(reserveModulesPane.getUnselTerm2List().getSelectionModel().getSelectedItem());
							for(int m = 0; m<unSelTerm2List.size(); m++){
								if(reserveModulesPane.getUnselTerm2List().getSelectionModel().getSelectedItem().toString().equals(unSelTerm2List.get(m).toString())){
									unSelTerm2List.remove(m);							
								}
							}	
						}
						reserveModulesPane.setUnselTerm2List(unSelTerm2List);
						reserveModulesPane.setReservTerm2List(reserveTerm2List);
						reserveModulesPane.getUnselTerm2List().getSelectionModel().clearSelection();
						}else{
							
						}
				}
				
				
				displayCredit1();
				displayCredit2();
				displayReserveCredit1();
				displayReserveCredit2();
			
		}
	}


	//4
	private class RemoveHandlers implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Button button = (Button)e.getSource();
			if(selectModulesPane.getTerm1RemoveBtn()==button) {
				if(selectModulesPane.getSelTerm1List().getSelectionModel().getSelectedItem()!=null) {
					
					unSelTerm1List.add(selectModulesPane.getSelTerm1List().getSelectionModel().getSelectedItem());
				for(int i = 0; i<selTerm1List.size(); i++){
					if(selectModulesPane.getSelTerm1List().getSelectionModel().getSelectedItem().toString().equals(selTerm1List.get(i).toString())){
						
						selTerm1List.remove(i);
					}
				}	
				selectModulesPane.setSelTerm1List(selTerm1List);
				selectModulesPane.setTerm1List(unSelTerm1List);
				selectModulesPane.getSelTerm1List().getSelectionModel().clearSelection();
				}
				
			} else if(selectModulesPane.getTerm2RemoveBtn()==button) {
				if(selectModulesPane.getSelTerm2List().getSelectionModel().getSelectedItem()!=null) {
					unSelTerm2List.add(selectModulesPane.getSelTerm2List().getSelectionModel().getSelectedItem());
				for(int k = 0; k<selTerm2List.size(); k++){
					if(selectModulesPane.getSelTerm2List().getSelectionModel().getSelectedItem().toString().equals(selTerm2List.get(k).toString())){
						selTerm2List.remove(k);
					}
				}	
				selectModulesPane.setSelTerm2List(selTerm2List);
				selectModulesPane.setTerm2List(unSelTerm2List);
				selectModulesPane.getSelTerm2List().getSelectionModel().clearSelection();
				}
				
			}else if(reserveModulesPane.getrRemove1Btn()==button){
				if(reserveModulesPane.getReservTerm1List().getSelectionModel().getSelectedItem()!=null){
					unSelTerm1List.add(reserveModulesPane.getReservTerm1List().getSelectionModel().getSelectedItem());
				
						for(int l = 0; l<reserveTerm1List.size(); l++){
						if(reserveModulesPane.getReservTerm1List().getSelectionModel().getSelectedItem().toString().equals(reserveTerm1List.get(l).toString())){
							
							reserveTerm1List.remove(l);						
							}
						}	
					
					
				}
				reserveModulesPane.setUnselTerm1List(unSelTerm1List);
				reserveModulesPane.setReservTerm1List(reserveTerm1List);
				reserveModulesPane.getReservTerm1List().getSelectionModel().clearSelection();
				
			}else if(reserveModulesPane.getrRemove2Btn()==button){
				if(reserveModulesPane.getReservTerm2List().getSelectionModel().getSelectedItem()!=null){
					unSelTerm2List.add(reserveModulesPane.getReservTerm2List().getSelectionModel().getSelectedItem());
					
						for(int l = 0; l<reserveTerm2List.size(); l++){
							if(reserveModulesPane.getReservTerm2List().getSelectionModel().getSelectedItem().toString().equals(reserveTerm2List.get(l).toString())){
								reserveTerm2List.remove(l);						
								}
							}	
						
					
					}
				reserveModulesPane.setUnselTerm2List(unSelTerm2List);
				reserveModulesPane.setReservTerm2List(reserveTerm2List);
				reserveModulesPane.getReservTerm2List().getSelectionModel().clearSelection();
				
			}
			
			displayCredit1();
			displayCredit2();
		}
	}

	//5
	private class SubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			for(int i=0;i<selTerm1List.size();i++) {
				studentProfile.addSelectedModule(selTerm1List.get(i));
			}
			for(int i=0;i<selTerm2List.size();i++) {
				studentProfile.addSelectedModule(selTerm2List.get(i));
			}
			for(int i=0;i<selLongTermList.size();i++) {
				studentProfile.addSelectedModule(selLongTermList.get(i));
			}
			
			if(displayCredit1()==60 && displayCredit2()==60){
				initReserveModulesPane();
				rootPane.changeTab(2);
				rootPane.changeAccordPage1();
			}else{
				
			}

		}
	}

	//6
	private class ConfirmHandlers implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Button button = (Button)e.getSource();
			if(reserveModulesPane.getrConfirm1Btn()==button) {
				for(int i=0;i<reserveTerm1List.size();i++) {
					studentProfile.addReservedModule(reserveTerm1List.get(i));
				}
				if(displayReserveCredit1() == 30){
					rootPane.changeAccordPage2();
				}
				
			
			} else if(reserveModulesPane.getrConfirm2Btn()==button) {
				
				for(int i=0;i<reserveTerm2List.size();i++) {
					studentProfile.addReservedModule(reserveTerm2List.get(i));
				}
				if(displayReserveCredit2() == 30){
					rootPane.changeTab(3);
					initOverviewPane();
				}		
			}
			
			/*Button button = (Button)e.getSource();
			if(reserveModulesPane.getrConfirm1Btn()==button) {
				for(int i=0;i<reserveTerm1List.size();i++) {
					studentProfile.addReservedModule(reserveTerm1List.get(i));
				}
				rootPane.changeAccordPage2();
			
			} else if(reserveModulesPane.getrConfirm2Btn()==button) {
				
				for(int i=0;i<reserveTerm2List.size();i++) {
					studentProfile.addReservedModule(reserveTerm2List.get(i));
				}
				rootPane.changeTab(3);
				initOverviewPane();
			}*/
		}
	}

	//7
	private class SaveOverviewHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			/*String result=overviewPane.getStudentProfile()+"\n"+
						overviewPane.getSelModulesText()+"\n"+
						overviewPane.getResModulesText();*/
			try {
				writeOverViewToFile(overviewText);
				Alert alert=new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Success!");
				alert.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	//8
	private class SaveProfileHandler  implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			try {
				saveStudentPofile();
				Alert alert=new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Success!");
				alert.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	//9
	private class LoadStudentDataHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			try {
				loadStudentPofile();
				populateCourseComboBox();
				rootPane.changeTab(0);
				initCreateProfilePane();
				
				initSelectModulesPaneFromLoadData();
				initReserveModulesPane();
				initOverviewPane();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setContentText("Fail!");
				alert.show();
			}
		}
	}


	//10
	private class AboutHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Stage aboutStage = new Stage();
			aboutStage.setTitle("About...");
			TextArea aboutField = new TextArea("Name");
			String about="version: 1.0"+"\r\n";
			aboutField.setText("version: 1.0");
			Scene stageScene = new Scene(aboutField, 300, 300);
			aboutStage.setScene(stageScene);
			aboutStage.show();
		}
	}



	//11
	private class ExitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			System.exit(0);
		}
	}

	//12
	private class NewModuleSelectionMenuBarHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {


		}
	}



	//-------------------------------------------------------------------------------
	//METHOD ----> used to generate the courses
	//--------------------------------------------------------------------------------
	private Course[] setupAndGetCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Delivery.TERM_1);
		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Delivery.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Delivery.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Delivery.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Delivery.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Delivery.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Delivery.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Delivery.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Delivery.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Delivery.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Delivery.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Delivery.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Delivery.TERM_1);
		Module imat3611 = new Module("IMAT3611", "Computer Ethics and Privacy", 15, false, Delivery.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Delivery.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Delivery.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Delivery.TERM_2);

		Course compSci = new Course("Computer Science");
		compSci.addModule(imat3423);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3902_CompSci);
		compSci.addModule(ctec3110);
		compSci.addModule(ctec3605);
		compSci.addModule(ctec3606);
		compSci.addModule(ctec3410);
		compSci.addModule(ctec3904);
		compSci.addModule(ctec3905);
		compSci.addModule(ctec3906);
		compSci.addModule(imat3410);
		compSci.addModule(imat3406);
		compSci.addModule(imat3611);
		compSci.addModule(imat3613);
		compSci.addModule(imat3614);
		compSci.addModule(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(imat3423);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3902_SoftEng);
		softEng.addModule(ctec3110);
		softEng.addModule(ctec3605);
		softEng.addModule(ctec3606);
		softEng.addModule(ctec3410);
		softEng.addModule(ctec3904);
		softEng.addModule(ctec3905);
		softEng.addModule(ctec3906);
		softEng.addModule(imat3410);
		softEng.addModule(imat3406);
		softEng.addModule(imat3611);
		softEng.addModule(imat3613);
		softEng.addModule(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}

	//TO BE DONE-> 
	//helper method to build dialogs
	//MAYBE
	private void saveStudentPofile() throws FileNotFoundException, IOException  {
		 ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("studentProfile.dat"));
	     output.writeObject(studentProfile);
	     output.close();
	}
	
	private void loadStudentPofile() throws IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("studentProfile.dat"));
		studentProfile= (StudentProfile) input.readObject();
	    input.close();
	}
	
	private void writeOverViewToFile(String result) throws IOException {
		 new File ("overView.txt");
		 PrintWriter printWriter = new PrintWriter ("overView.txt");
		 printWriter.println (result);
		 printWriter.close ();       

	}
	
	private void populateCourseComboBox() {
		Course[] courses=setupAndGetCourses();
		ObservableList<Course> courseList=FXCollections.observableArrayList(courses);
		createProfilePane.setCourseComboBoxValue(courseList);
	}
	
	private void initSelectModulesPane() {
		selectModulesPane.getSelLongMList().getItems().clear();
		selectModulesPane.getSelTerm1List().getItems().clear();
		selectModulesPane.getSelTerm2List().getItems().clear();
		selectModulesPane.getTerm1List().getItems().clear();
		selectModulesPane.getTerm2List().getItems().clear();
		setInitValues();
		selectModulesPane.setSelTerm1List(selTerm1List);
		selectModulesPane.setSelTerm2List(selTerm2List);
		selectModulesPane.setSelLongMList(selLongTermList);
		selectModulesPane.setTerm1List(unSelTerm1List);
		selectModulesPane.setTerm2List(unSelTerm2List);
		
		displayCredit1();
		displayCredit2();
		
		
	}
	private void initSelectModulesPaneFromLoadData() {
		selectModulesPane.getSelLongMList().getItems().clear();
		selectModulesPane.getSelTerm1List().getItems().clear();
		selectModulesPane.getSelTerm2List().getItems().clear();
		selectModulesPane.getTerm1List().getItems().clear();
		selectModulesPane.getTerm2List().getItems().clear();
		getValuesFromData();
		selectModulesPane.setSelTerm1List(selTerm1List);
		selectModulesPane.setSelTerm2List(selTerm2List);
		selectModulesPane.setSelLongMList(selLongTermList);
		selectModulesPane.setTerm1List(unSelTerm1List);
		selectModulesPane.setTerm2List(unSelTerm2List);
		
		displayCredit1();
		displayCredit2();
		
		
	}
	private void initReserveModulesPane() {
		reserveModulesPane.getUnselTerm1List().getItems().clear();
		reserveModulesPane.getUnselTerm2List().getItems().clear();
		reserveModulesPane.getReservTerm1List().getItems().clear();
		reserveModulesPane.getReservTerm2List().getItems().clear();
		
		reserveModulesPane.setUnselTerm1List(unSelTerm1List);		
		reserveModulesPane.setUnselTerm2List(unSelTerm2List);
		reserveModulesPane.setReservTerm1List(reserveTerm1List);
		reserveModulesPane.setReservTerm2List(reserveTerm2List);
	
	
	
	}	
	
	private void initOverviewPane() {
		
		ArrayList<Module> selModuleList=new ArrayList<Module>(studentProfile.getAllSelectedModules());
		ArrayList<Module> resModuleList=new ArrayList<Module>(studentProfile.getAllReservedModules());
		String selModuleText="Selected modules:\r\n"+"==========\r\n";
		String resModuleText="Reserved modules:\r\n"+"==========\r\n";
		for(int i=0;i<selModuleList.size();i++) {
			selModuleText+=selModuleList.get(i).actualToString()+"\r\n";
		}
		for(int i=0;i<resModuleList.size();i++) {
			resModuleText+=resModuleList.get(i).actualToString()+"\r\n";
		}
		
		overviewPane.setStudentProfile(studentProfile.toString());
		overviewPane.setSelModulesText(selModuleText);
		overviewPane.setResModulesText(resModuleText);
		overviewText=studentProfile.toString()+selModuleText+resModuleText;
	}
	
	private void initCreateProfilePane() {
		course=studentProfile.getCourse();
		createProfilePane.setCourseComboBoxDefaltValue(course);
		createProfilePane.setTxtFirstName(studentProfile.getStudentName().getFirstName());
		createProfilePane.setTxtFamilyName(studentProfile.getStudentName().getFirstName());
		createProfilePane.setTxtEmail(studentProfile.getEmail());
		createProfilePane.setTxtPnumber(studentProfile.getpNumber());
		createProfilePane.setInputDate(studentProfile.getSubmissionDate());
	}
	
	
	private int displayCredit1(){
		//display credit term1.
				int longTermCredit = 0;
				int Term1Credit = 0;
				for(int j = 0; j<selLongTermList.size(); j++){			
					longTermCredit += selLongTermList.get(j).getCredits();
				}
				for(int k = 0; k<selTerm1List.size(); k++){			
					Term1Credit += selTerm1List.get(k).getCredits();
				}
				int credit1 = longTermCredit + Term1Credit;
				
				selectModulesPane.setCreditTerm1TF(String.valueOf(credit1));
				return credit1;
	}
	private int displayCredit2(){
		//display credit term2;
				int longTermCredit1 = 0;
				int Term2Credit = 0;
				for(int j = 0; j<selLongTermList.size(); j++){			
					longTermCredit1 += selLongTermList.get(j).getCredits();
				}
				for(int k = 0; k<selTerm2List.size(); k++){			
					Term2Credit += selTerm2List.get(k).getCredits();
				}
				int credit2 = longTermCredit1 + Term2Credit;
				
				selectModulesPane.setCreditTerm2TF(String.valueOf(credit2));
				
				return credit2;
				
	}
	
	private void setInitValues() {
		allModules = course.getAllModulesOnCourse();
		allModulesList = FXCollections.observableArrayList(allModules);
	
			for (int i = 0; i < allModulesList.size(); i++){
			if(allModulesList.get(i).isMandatory()==true){
				if(allModulesList.get(i).getRunPlan()==Delivery.TERM_1){
					selTerm1List.add(allModulesList.get(i));
				}else if(allModulesList.get(i).getRunPlan()==Delivery.TERM_2){
					selTerm2List.add(allModulesList.get(i));
				}else{
					selLongTermList.add(allModulesList.get(i));
				}
			}else{
				if(allModulesList.get(i).getRunPlan()==Delivery.TERM_1){	
					unSelTerm1List.add(allModulesList.get(i));
				}else{
					unSelTerm2List.add(allModulesList.get(i));
				}
			}
			
		}
		
		
	}
	
	private void getValuesFromData() {
		allModules = course.getAllModulesOnCourse();
		allModulesList = FXCollections.observableArrayList(allModules);
		Collection<Module> selectedModules = studentProfile.getAllSelectedModules();
		Collection<Module> reservedModules = studentProfile.getAllReservedModules();
		ObservableList<Module> selModulesList = FXCollections.observableArrayList(selectedModules);
		ObservableList<Module> resModulesList = FXCollections.observableArrayList(reservedModules);
		
		for (int i = 0; i < selModulesList.size(); i++){
				if(selModulesList.get(i).getRunPlan()==Delivery.TERM_1){
					selTerm1List.add(selModulesList.get(i));
				} else if(selModulesList.get(i).getRunPlan()==Delivery.TERM_2){
					selTerm2List.add(selModulesList.get(i));
				}else{
					selLongTermList.add(selModulesList.get(i));
				}
		}
		for (int i = 0; i < resModulesList.size(); i++){
			if(resModulesList.get(i).getRunPlan()==Delivery.TERM_1){
				reserveTerm1List.add(resModulesList.get(i));
			} else if(resModulesList.get(i).getRunPlan()==Delivery.TERM_2){
				reserveTerm2List.add(resModulesList.get(i));
			}
		}
		
		for (int i = 0; i < allModulesList.size(); i++){
			
				if(allModulesList.get(i).getRunPlan()==Delivery.TERM_1){
					unSelTerm1List.add(allModulesList.get(i));
				}else if(allModulesList.get(i).getRunPlan()==Delivery.TERM_2){
					unSelTerm2List.add(allModulesList.get(i));
				}
		}
		
		for (int i = 0; i < unSelTerm1List.size(); i++){
			for(int j=0; j<selTerm1List.size();j++) {
				if(selTerm1List.get(j).equals(unSelTerm1List.get(i))) {
					unSelTerm1List.remove(j);
				}
			}
		}
		
		for (int i = 0; i < unSelTerm2List.size(); i++){
			for(int j=0; j<selTerm2List.size();j++) {
				if(selTerm2List.get(j).equals(unSelTerm2List.get(i))) {
					unSelTerm2List.remove(j);
				}
			}
		}
		
		
		/*unSelTerm1List=
		unSelTerm2List =
		*/
		
	}
	private int displayReserveCredit1(){
		//display reserved credit of term1;
				
				int reservedTerm1Credit = 0;
				for(int j = 0; j<reserveTerm1List.size(); j++){			
					reservedTerm1Credit += reserveTerm1List.get(j).getCredits();
				}
				
				return reservedTerm1Credit;
				
	}
	
	private int displayReserveCredit2(){
		//display reserved credit of term1;
				
				int reservedTerm2Credit = 0;
				for(int j = 0; j<reserveTerm2List.size(); j++){			
					reservedTerm2Credit += reserveTerm2List.get(j).getCredits();
				}
				
				return reservedTerm2Credit;
				
	}

	

}
