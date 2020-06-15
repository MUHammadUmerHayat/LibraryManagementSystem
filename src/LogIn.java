import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogIn extends Application{

	static Stage window;
	static Scene scene00,scene0, scene1, scene2, scene3;
	static Button adminlogin,login,goback,studentlogin,stlogin,stgoback,aboutbt;
	static BookSection booksection;
	static Admin ac;
	 private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: white; -fx-border-color: #2ECC71; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-background-radius: 25px;";
	  private static final String HOVERED_BUTTON_STYLE  = "-fx-background-color:#2ECC71; -fx-text-fill: white; -fx-scale-x: 1.0; -fx-scale-y: 1.0;-fx-border-radius: 25px;-fx-background-radius: 25px; ";
	  
	  private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-text-fill: white; ";
	  private static final String HOVERED_BUTTON = "-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; ";
	  
     String user = "admin", pass = "admin"; 
     
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("IU-Library Management System");
		window.setResizable(false);
		window.getIcons().add(new Image("file:images/IU.PNG"));
		
		Group root = new Group();
		addComponent(root);
		
		addAnimations(root);

	    scene1 = new Scene(root,490,500);
		window.setScene(scene1);
		window.show();
	}
	
	private void addAnimations(Group root) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		}

	public void addComponent(Group root){
		ImageView iv =  new ImageView(new Image("file:images/Capture.PNG")); 
		iv.setFitHeight(100);
		iv.setFitWidth(500);
		
		ImageView iv1 =  new ImageView(new Image("file:images/uni-img.jpg")); 
		iv1.setFitHeight(450);
		iv1.setFitWidth(500);
		iv1.setY(100);
		iv1.setOpacity(0.5);	
		
		
		//Name of Library
			final String content = "IU-LIBRARY MANAGEMENT SYSTEM";
		    final Text labelname = new Text(10, 20, "IU-LIBRARY MANAGEMENT SYSTEM");
		    labelname.setTranslateX(40);
		    labelname.setTranslateY(110);
		    labelname.setFill(Color.BLUE);
		    labelname.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		    final Animation animation = new Transition() {
		        {
		            setCycleDuration(Duration.millis(3000));
		        }
		    
		        protected void interpolate(double frac) {
		            final int length = content.length();
		            final int n = Math.round(length * (float) frac);
		            labelname.setText(content.substring(0, n));
		        }
		    
		    };
		    animation.play();

		//AdminButton
		adminlogin = new Button("Admin Login");
		adminlogin.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; ");
		adminlogin.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		adminlogin.setPrefSize(150, 50);
		adminlogin.setTranslateX(180);
		adminlogin.setTranslateY(180);
		changeBackgroundOnHoverUsingBinding(adminlogin);
		
				 ////////////////////////////
				/// Admin_login Form START//
			   ////////////////////////////
		
			Group adminForm = new Group();
   
	        Label username = new Label("User Name:");
	        username.setTranslateX(65);
	        username.setTranslateY(200);
	        username.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        TextField usertf = new TextField();
	        usertf.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-prompt-text-fill: white;");
	        usertf.setTranslateX(190);
	        usertf.setTranslateY(200);
	        usertf.setPrefWidth(230);
	        usertf.setPrefHeight(35);
	        usertf.setPromptText("Enter User Name");
	        
	        Label passname = new Label("Password:");
	        passname.setTranslateX(75);
	        passname.setTranslateY(265);
	        passname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        PasswordField passtf = new PasswordField();
	        passtf.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-prompt-text-fill: white; ");
	        passtf.setTranslateX(190);
	        passtf.setTranslateY(260);
	        passtf.setPrefWidth(230);
	        passtf.setPrefHeight(35);
	        passtf.setPromptText("Enter Password");
	        
	        login = new Button("Log In");
	        login.setTranslateX(200);
	        login.setTranslateY(320);
	        login.setPrefSize(80, 20);
	        login.setFont(Font.font(15));
	       changeBackgroundOnHover(login);
	        
	        goback = new Button("Go Back");
	        goback.setTranslateX(300);
	        goback.setTranslateY(320);
	        goback.setPrefSize(80, 20);
	        goback.setFont(Font.font(15));
	        changeBackgroundOnHover(goback);   
	
			ImageView logoadmin = new ImageView(new Image("file:images/adminlogo.png"));
			logoadmin.setFitWidth(130);
			logoadmin.setFitHeight(130);
			logoadmin.setTranslateX(190);
			logoadmin.setTranslateY(20);
			
			ImageView logoadmin1 = new ImageView(new Image("file:images/adminlogo1.jpg"));
			logoadmin1.setFitWidth(500);
			logoadmin1.setFitHeight(500);
			logoadmin1.setX(0);
			logoadmin1.setY(0);
			

			adminForm.getChildren().addAll(logoadmin1,logoadmin,goback,login,passtf,passname,usertf,username);
	        scene2 = new Scene(adminForm,490,500,Color.WHITE);
	        
	     ////////////////////////
		//student_login_Button//
	   ////////////////////////     
	        
		studentlogin = new Button("Student Login");
		studentlogin.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; ");
		studentlogin.setPrefSize(150, 50);
		studentlogin.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		studentlogin.setTranslateX(180);
		studentlogin.setTranslateY(250);
		changeBackgroundOnHoverUsingBinding(studentlogin);
		
		aboutbt = new Button("About");
		aboutbt.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; ");
		aboutbt.setPrefSize(150, 40);
		aboutbt.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 16));
		aboutbt.setTranslateX(180);
		aboutbt.setTranslateY(320);
		changeBackgroundOnHoverUsingBinding(aboutbt);
		
		 //////////////////
		//for about info//
	   //////////////////
		
		Group about = new Group();
		scene00 = new Scene(about,490,500,Color.WHITE);
		window.setScene(scene00);
		
		ImageView iv4 =  new ImageView(new Image("file:images/books.jpg"));
		iv4.setOpacity(0.2);
		ImageView iv3 =  new ImageView(new Image("file:images/IU.PNG")); 
		iv3.setFitHeight(100);
		iv3.setFitWidth(100);
		iv3.setY(50);
		iv3.setX(200);
		about.getChildren().addAll(iv4,iv3);
		
		Label lbl = new Label("IU- Library Management System\n\t\tDeveloped By");
		lbl.setStyle("-fx-text-fill: #28864B;");
		lbl.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		lbl.setTranslateX(80);
		lbl.setTranslateY(180);
		about.getChildren().add(lbl);
		
		Label lbl1 = new Label("Muhammad Subhan Naeem Qureshi (48802)\nAbdul Haseeb (46997)\nHamza Nawaz(46683)\nMuhammad Naseer (46631)\nUmair Ahmed (47424)\nRehma Khalid Zaman (50087)");
		lbl1.setStyle("-fx-text-fill: #5B46CC;");
		lbl1.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
		lbl1.setTranslateX(80);
		lbl1.setTranslateY(260);
		about.getChildren().add(lbl1);
		
		Button backfromabout = new Button("Back");
		backfromabout.setStyle("-fx-background-color: #A64DEC; -fx-text-fill: white;");
		backfromabout.setPrefSize(100, 15);
		backfromabout.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
		backfromabout.setTranslateX(200);
		backfromabout.setTranslateY(390);
		about.getChildren().add(backfromabout);
		changeBackgroundOnHoverUsingBinding(backfromabout);
		
		backfromabout.setOnAction(e -> window.setScene(scene1));
		 ////////////////////////////////   
		/// Librarian login Form START//
	   ////////////////////////////////	
		
		Group studentForm = new Group();		
	        
	        Label stusername = new Label("User Name:");
	        stusername.setTranslateX(80);
	        stusername.setTranslateY(220);
	        stusername.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        TextField stuser = new TextField();
	        stuser.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-prompt-text-fill: white;");
	        stuser.setPromptText("Enter User Name");
	        stuser.setTranslateX(190);
	        stuser.setTranslateY(220);
	        stuser.setPrefWidth(190);
	        stuser.setPrefHeight(30);
	        
	        Label stpassname = new Label("Password:");
	        stpassname.setTranslateX(95);
	        stpassname.setTranslateY(270);
	        stpassname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        PasswordField stpass = new PasswordField();
	        stpass.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-prompt-text-fill: white;");
	        stpass.setPromptText("Enter password");
	        stpass.setTranslateX(190);
	        stpass.setTranslateY(270);
	        stpass.setPrefWidth(190);
	        stpass.setPrefHeight(30);
	        
	        stlogin = new Button("Log In");
	        stlogin.setTranslateX(190);
	        stlogin.setTranslateY(320);
	        stlogin.setPrefSize(80, 30);
	        stlogin.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-text-fill: white; ");
	       changeBackgroundOnHover(stlogin);
	        
	        stgoback = new Button("Go Back");
	        stgoback.setTranslateX(290);
	        stgoback.setTranslateY(320);
	        stgoback.setPrefSize(80, 30);
	        stgoback.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-text-fill: white; ");
	       changeBackgroundOnHover(stgoback);
	        
	        scene3 = new Scene(studentForm,490,500);
	        scene3.setFill(Color.WHITE);
	        window.setScene(scene3);
	        
	        ImageView logostudent = new ImageView(new Image("file:images/stlogo.png"));
	        logostudent.setFitWidth(140);
	        logostudent.setFitHeight(140);
			logostudent.setTranslateX(190);
			logostudent.setTranslateY(20);
	        
			
			ImageView logostudnet1 = new ImageView(new Image("file:images/adminlogo1.jpg"));
			logostudnet1.setFitWidth(500);
			logostudnet1.setFitHeight(500);
			logostudnet1.setX(0);
			logostudnet1.setY(0);
		
			
	        studentForm.getChildren().addAll(logostudnet1,logostudent,stgoback,stlogin,stpass,stpassname,stuser,stusername);
	     
	        stlogin.setOnAction(new EventHandler <ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {		

					ObservableList<Librarian> l = Admin.getLibrarians(); 
					boolean check = false;
					
					for (Librarian p : l) {
							if (p.getName().equalsIgnoreCase(stuser.getText()) && p.getPassword().equals(stpass.getText())) {   
								check = true;
								booksection = new BookSection("Book  Section",650,600);
								window.close();
								break;
							}
					}
					if (!check) {
							Alert error =new Alert(AlertType.ERROR);
							error.setHeaderText(null);
							error.setContentText("Enter valid Username OR password!");
							error.showAndWait();
						}
				}				
				
				});
					
	        login.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					
				if(user.equals(usertf.getText().trim()) && pass.equals(passtf.getText().trim())){	
				
					ac = new Admin(" IU - Library Management System", 1100, 600);
					window.close();

					
				} else  
				{
					Alert error =new Alert(AlertType.ERROR);
					error.setHeaderText(null);
					error.setContentText("Enter valid Username OR password!");
					error.showAndWait();
					
				}
				
				}});
	        

	      addActionEventsinLoginClass();
	        
		root.getChildren().addAll(iv,iv1);
		root.getChildren().addAll(labelname,studentlogin,adminlogin,aboutbt);
		
	}
	
		
	static void changeBackgroundOnHover(Button bt) {
		bt.styleProperty().bind(
			      Bindings
			        .when(bt.hoverProperty())
			          .then(
			            new SimpleStringProperty(HOVERED_BUTTON)
			          )
			          .otherwise(
			            new SimpleStringProperty(STANDARD_BUTTON)
			          )
			    );
	}
	
	static void changeBackgroundOnHoverUsingBinding(Button adminlogin2) {
		adminlogin2.styleProperty().bind(
			      Bindings
			        .when(adminlogin2.hoverProperty())
			          .then(
			            new SimpleStringProperty(HOVERED_BUTTON_STYLE)
			          )
			          .otherwise(
			            new SimpleStringProperty(STANDARD_BUTTON_STYLE)
			          )
			    );
	}

	
	public static void addActionEventsinLoginClass(){
		   
        stgoback.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
        	
        });
        
    	adminlogin.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
					window.setScene(scene2);
			}});
    	
        goback.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
        	
        });
        
    	studentlogin.setOnAction(new EventHandler<ActionEvent>(){	
		@Override
		public void handle(ActionEvent event) {
				window.setScene(scene3);
		}});

		aboutbt.setOnAction(new EventHandler <ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene00);
			}
			
		});
	}
	

}
