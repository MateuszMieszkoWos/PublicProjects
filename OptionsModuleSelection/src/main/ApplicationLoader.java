 package main;




import controller.ModuleSelectionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Name;
import model.StudentProfile;
import view.CreateProfilePane;
import view.ModuleSelectionRootPane;
import model.Course;
import model.Delivery;
import model.Module;

public class ApplicationLoader extends Application {

	private ModuleSelectionRootPane rootPane;
	private ModuleSelectionController moduleSelectionController;
	@Override
	public void init() {
		
		
		rootPane = new ModuleSelectionRootPane();
		new ModuleSelectionController(rootPane);
		
		
	
		/*//VIEW initialization
		rootPane = new ModuleSelectionRootPane();
		
		//MODEL, initialization
		Course course = new Course();
		Delivery model1 = new Delivery();
		Module model2 = new Module();
		Name model3 = new Name();
		StudentProfile model4 = new StudentProfile ();
		
		//adding instances to the controller
		
		*/
		
		
		/*
		//MODEL, initialization
		Course course = new Course();
		Delivery model1 = new Delivery();
		Module model2 = new Module();
		Name model3 = new Name();
		StudentProfile model4 = new StudentProfile ();
		
		//adding instances to the controller
		
		new ModuleSelectionController(model,model1,model2,model3,model4,rootPane);
		*/
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//sets minimum width and height for the stage window
		stage.setMinWidth(600); 
		stage.setMinHeight(600);
		stage.setWidth(800); 
		stage.setHeight(800);
		stage.setTitle("Final Year Module Selection Tool");
		stage.setScene(new Scene(rootPane));
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
