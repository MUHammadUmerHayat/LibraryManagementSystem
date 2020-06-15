import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Admin {
	
	 static Stage window;
     static Scene  scene4, scene5,scene6;
      Button addstudent,deletestudent,Logout,savebt;
     TableView<Librarian> table;
     DatePicker datep;
     static TextField libtf,libaddresstf,libcontacttf,libcitytf,libpasstf,libemailtf,libidtf;
     static ObservableList<Librarian> librarians = FXCollections.observableArrayList();
     
     private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: white; -fx-border-color: #2ECC71; -fx-border-radius: 25px; -fx-border-width: 2px; -fx-background-radius: 25px;";
	  private static final String HOVERED_BUTTON_STYLE  = "-fx-background-color:#2ECC71; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1;-fx-border-radius: 25px;-fx-background-radius: 25px; ";
	
	
     
    Admin(String title, int width, int height){
    	window = new Stage();
    	window.getIcons().add(new Image("file:IU.PNG"));
    	window.setTitle(title);
    	window.setWidth(width);
    	window.setHeight(height);
    	window.getIcons().add(new Image("file:images/IU.PNG"));
       
        Group adminlayout = new Group();
        
        
        FadeTransition ft = new FadeTransition(Duration.millis(500), adminlayout);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		
	    addstudent = new Button("Add Student");
		addstudent.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		addstudent.setFont(Font.font(15));
		addstudent.setPrefSize(130, 25);
		addstudent.setTranslateX(900);
		addstudent.setTranslateY(370);
		changeBackgroundOnHoverg(addstudent);
		addstudent.setOnAction(e -> addButtonClicked());
		
		deletestudent = new Button("Delete Student");
		deletestudent.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		deletestudent.setFont(Font.font(15));
		deletestudent.setPrefSize(130, 25);
		deletestudent.setTranslateX(900);
		deletestudent.setTranslateY(410);
		changeBackgroundOnHoverg(deletestudent);
		deletestudent.setOnAction( e -> deleteButtonClicked());
		

		savebt = new Button("Save"); 
		savebt.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		savebt.setFont(Font.font(15));
		savebt.setPrefSize(130, 25);
		savebt.setTranslateX(900);
		savebt.setTranslateY(450);
		changeBackgroundOnHoverg(savebt);
		savebt.setOnAction( e -> saveButtonClicked());
		
	
		Logout = new Button("Log Out"); 
		Logout.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		Logout.setFont(Font.font(15));
		Logout.setPrefSize(130, 25);
		Logout.setTranslateX(900);
		Logout.setTranslateY(490);
		changeBackgroundOnHoverg(Logout);
		
		//for Adding Librarian
			Label labelname = new Label("Add Student");
			labelname.setFont(Font.font(25));
			labelname.setTranslateX(890);
						
			Label idlabel = new Label("ID: ");
			idlabel.setFont(Font.font(18));
			idlabel.setTranslateX(820);
			idlabel.setTranslateY(50);
						
			libidtf = new TextField();
			libidtf.setTranslateX(870);
			libidtf.setPromptText("Enter ID");
			libidtf.setTranslateY(50);
			libidtf.setPrefWidth(200);
	
			Label datelabel = new Label("Date: ");
			datelabel.setFont(Font.font(18));
			datelabel.setTranslateX(810);
			datelabel.setTranslateY(90);
					
			datep = new DatePicker();
			datep.setTranslateX(870);
			datep.setPromptText("Enter Date");
			datep.setTranslateY(90);
			datep.setPrefWidth(200);
						
			Label libname = new Label("Name: ");
			libname.setTranslateX(803);
			libname.setTranslateY(130);
			libname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
			libtf = new TextField();
			libtf.setTranslateX(870);
			libtf.setPromptText("Enter the Name:");
			libtf.setTranslateY(130);
			libtf.setPrefSize(200, 10);
	        
			Label libpass = new Label("Password: ");
			libpass.setTranslateX(790);
			libpass.setTranslateY(170);
			libpass.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
						 
			libpasstf = new TextField();
			libpasstf.setTranslateX(870);
			libpasstf.setTranslateY(170);
			libpasstf.setPromptText("Enter Password");
			libpasstf.setPrefSize(200, 10);
		
			Label libemail = new Label("Email: ");
			libemail.setTranslateX(790);
			libemail.setTranslateY(210);
			libemail.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
						 
			libemailtf = new TextField();
			libemailtf.setTranslateX(870);
			libemailtf.setTranslateY(210);
			libemailtf.setPromptText("Enter Email");
			libemailtf.setPrefSize(200, 10);
			
			Label libaddress = new Label("Address: ");
			libaddress.setTranslateX(790);
			libaddress.setTranslateY(250);
			libaddress.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			
			libaddresstf = new TextField();
			libaddresstf.setTranslateX(870);
			libaddresstf.setTranslateY(250);
			libaddresstf.setPromptText("Enter Address");
			libaddresstf.setPrefSize(200, 10);
			
			Label libcity = new Label("City: ");
			libcity.setTranslateX(790);
			libcity.setTranslateY(290); 
			libcity.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
						
			libcitytf = new TextField();
			libcitytf.setTranslateX(870);
			libcitytf.setTranslateY(290);
			libcitytf.setPromptText("Enter City");
			libcitytf.setPrefSize(200, 10);
			
			Label libcontact = new Label("Contact: ");
			libcontact.setTranslateX(790);
			libcontact.setTranslateY(330);
			libcontact.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			
			libcontacttf = new TextField();
			libcontacttf.setTranslateX(870);
			libcontacttf.setTranslateY(330);
			libcontacttf.setPromptText("Enter Contact Number");
			libcontacttf.setPrefSize(200, 10);
			
			
			 //ID column
	        TableColumn<Librarian, Integer> idColumn = new TableColumn<>("Id");
	        idColumn.setMinWidth(50);
	        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	        
	        //Date column
	        TableColumn<Librarian, String> dateColumn = new TableColumn<>("Date");
	        dateColumn.setMinWidth(80);
	        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
			
	        //Name column
	        TableColumn<Librarian, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setMinWidth(100);
	        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

	        //password column
	        TableColumn<Librarian, String> passwordColumn = new TableColumn<>("Password");
	        passwordColumn.setMinWidth(100);
	        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
	        
	        //email column
	        TableColumn<Librarian, String> emailColumn = new TableColumn<>("Email");
	        emailColumn.setMinWidth(150);
	        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
			
	        //City column
	        TableColumn<Librarian, String> cityColumn = new TableColumn<>("City");
	        cityColumn.setMinWidth(100);
	        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

	        //Address column
	        TableColumn<Librarian, String> addressColumn = new TableColumn<>("Address");
	        addressColumn.setMinWidth(100);
	        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

	        //contact column
	        TableColumn<Librarian, String> contactColumn = new TableColumn<>("Contact");
	        contactColumn.setMinWidth(100);
	        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
			
			table = new TableView<>();
			table.setEditable(true);
			table.setPrefHeight(570);
			table.setPrefWidth(780);
			table.setItems(getLibrarians());
	        table.getColumns().addAll(idColumn,dateColumn,nameColumn,passwordColumn,emailColumn,cityColumn,addressColumn,contactColumn);

	        Rectangle  rect1 = new Rectangle(780,0,400,6);
	        rect1.setFill(Color.ORANGERED);
	        rect1.setOpacity(0.8f);
	        
	       ScaleTransition sc = new ScaleTransition(Duration.millis(3000),rect1);
	       sc.setToY(200);
	       sc.setCycleCount(1);
	       sc.play(); 
	        
	        adminlayout.getChildren().addAll(table,rect1);        
			adminlayout.getChildren().addAll(idlabel,libidtf,datep,datelabel,labelname,libname,libtf,libpass,libemail,libaddress,libcity,libcontact,libaddresstf,libcontacttf,libcitytf,libpasstf,libemailtf);
			adminlayout.getChildren().addAll(addstudent,deletestudent,Logout,savebt);
			addActionEvents();
		
			scene5 = new Scene(adminlayout,900,700);
			window.setScene(scene5);
			window.show();
			window.setResizable(false);
    }


	private void saveButtonClicked() {

    	Alert savealert = new Alert(AlertType.INFORMATION);
    	savealert.setHeaderText(null);
    	savealert.setContentText("Your data has been saved successfully!");
    	savealert.showAndWait();
    	
		try {	
	    	FileOutputStream fos = new FileOutputStream("data/librarians.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<Librarian>(librarians));
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
    
	public static ObservableList<Librarian> getLibrarians() {
		try {
			FileInputStream fis = new FileInputStream("data/librarians.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Librarian> list = (List<Librarian>) ois.readObject();
			librarians = FXCollections.observableList(list);

			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
       
    	return librarians;
	}

	private boolean validateInput(){
		
		if( libidtf.getText().isEmpty() ||libtf.getText().isEmpty() || libpasstf.getText().isEmpty() ||
			libemailtf.getText().isEmpty() || libcitytf.getText().isEmpty() || 
				libaddresstf.getText().isEmpty()){
			
			Alert warningalert = new Alert(AlertType.WARNING);
			warningalert.setHeaderText("TextFields are empty!");
			warningalert.setContentText("Please input the data");
			warningalert.showAndWait();
			
			return false;
			
		}
			
		return true;
	}
	
	
	public void addButtonClicked() {
		
		if(validateInput()){
		Librarian librarian = new Librarian();
		librarian.setId(Integer.parseInt(libidtf.getText()));
		librarian.setDate(java.sql.Date.valueOf(datep.getValue()));
		librarian.setName(libtf.getText());
		librarian.setPassword(libpasstf.getText());
		librarian.setEmail(libemailtf.getText());
		librarian.setAddress(libaddresstf.getText());
		librarian.setCity(libcitytf.getText());
		librarian.setContact((libcontacttf.getText()));
		
		table.getItems().add(librarian);
		libidtf.clear();
		libtf.clear();
		libpasstf.clear();
		libemailtf.clear();
		libaddresstf.clear();
		libcitytf.clear();
		libcontacttf.clear();
		
	}
	}
    public void deleteButtonClicked() {
  
    	Alert alert = new Alert(AlertType.CONFIRMATION,"Are you sure to delete?",ButtonType.YES,ButtonType.NO);
    	alert.setHeaderText(null);
  
    	Optional<ButtonType> result = alert.showAndWait();
    	
    if(result.get() == ButtonType.YES){	
        ObservableList<Librarian> librarianSelected, alllibrarian;
    	alllibrarian = table.getItems();
    	librarianSelected = table.getSelectionModel().getSelectedItems();
    	librarianSelected.forEach(alllibrarian::remove);
    } else{
    	alert.close();
    }
	}

	public  void addActionEvents(){
		
    	Logout.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
    		
    	});
    	        	    	
    	
    }
	private void changeBackgroundOnHoverg(Button add) {
		add.styleProperty().bind(
			      Bindings
			        .when(add.hoverProperty())
			          .then(
			            new SimpleStringProperty(HOVERED_BUTTON_STYLE)
			          )
			          .otherwise(
			            new SimpleStringProperty(STANDARD_BUTTON_STYLE)
			          )
			    );
	}
}


