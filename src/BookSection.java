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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BookSection {

	static Stage window;
	static  Scene scene11,scene12,scene13,scene14,scene15,scene16;
    Button libLogout,returnbook,viewissuedbook,issuebook,viewbook,addbook,addbookbt,backbt,savebookbt,backbuttonoftbaleview,dltbtfrombookview,issubookbt,issuegobackbt,returnbookbt,returngobackbt,backbuttonoftbaleview1,dltbtfrombookview1,savebookbt1;
    Group addstudentlayout,veiwstudentlayout,issubooklayout,returnbooklayout;
    TextField callnotf,booknametf,authornametf,publishernametf,quantitytf,issubooknametf,issueidtf,issuestudenttf,issubookcallnotf,returnbookcallnotf,returnidtf;
    TableView<Booksdata> viewtable;
    TableView<Booksdata> viewissuedbookstable;
    
    ObservableList<Booksdata> booksdata = FXCollections.observableArrayList();
    
    //for addbook
    private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: white; -fx-background-image: url('file:images/adbookimg.PNG');";
    private static final String HOVERED_BUTTON_STYLE  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/adbookimg.PNG');-fx-border-color: green;";
	//for viewbook
    private static final String STANDARD_BUTTON_STYLE1 = "-fx-background-color: white; -fx-background-image: url('file:images/viewbookimg.PNG');";
    private static final String HOVERED_BUTTON_STYLE1  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/viewbookimg.PNG');-fx-border-color: green;";
	//for issue book
    private static final String STANDARD_BUTTON_STYLE2 = "-fx-background-color: white; -fx-background-image: url('file:images/issuebookimg.PNG');";
    private static final String HOVERED_BUTTON_STYLE2  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/issuebookimg.PNG');-fx-border-color: green;";
	//for viewissued book
    private static final String STANDARD_BUTTON_STYLE3 = "-fx-background-color: white; -fx-background-image: url('file:images/viewissuedbtimg.png');";
    private static final String HOVERED_BUTTON_STYLE3  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/viewissuedbtimg.png');-fx-border-color: green;";
	//for return book
    private static final String STANDARD_BUTTON_STYLE4 = "-fx-background-color: white; -fx-background-image: url('file:images/returnbookimg.png');";
    private static final String HOVERED_BUTTON_STYLE4  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/returnbookimg.png');-fx-border-color: green;";
	//for logout
    private static final String STANDARD_BUTTON_STYLE5 = "-fx-background-color: white; -fx-background-image: url('file:images/logoutimg.PNG');";
    private static final String HOVERED_BUTTON_STYLE5  = "-fx-background-color:#0BA0F6; -fx-text-fill: white; -fx-scale-x: 1.1; -fx-scale-y: 1.1; -fx-background-image: url('file:images/logoutimg.PNG');-fx-border-color: green;";
	
    //for buttons
	 private static final String STANDARD_BUTTON_STYLE0 = "-fx-background-color: white; -fx-border-color: #2ECC71; -fx-border-width: 2px; -fx-border-radius: 25px; -fx-background-radius: 25px;";
	  private static final String HOVERED_BUTTON_STYLE0  = "-fx-background-color:#2ECC71; -fx-text-fill: white; -fx-scale-x: 1.0; -fx-scale-y: 1.0;-fx-border-radius: 25px;-fx-background-radius: 25px; ";

    
    
	BookSection(String title, int width, int height){
		window = new Stage();
		window.setTitle(title);
		window.setWidth(width);
		window.setHeight(height);
		window.setResizable(false);
		window.getIcons().add(new Image("file:images/IU.PNG"));
		
		Group libroot = new Group();
		addlib(libroot);

		
		scene11 = new Scene(libroot);
		window.setScene(scene11);
		window.show();
	}
	
public  void addlib(Group libroot){

    addbook = new Button("");
	addbook.setStyle("-fx-background-image: url('file:images/adbookimg.PNG');-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: green; ");
	addbook.setFont(Font.font(15));
	addbook.setPrefSize(190, 200);
	addbook.setTranslateX(20);
	addbook.setTranslateY(20);
	changeBackgroundOnHover(addbook);
	
	Label addbklbl = new Label("ADD BOOKS");
	addbklbl.setFont(Font.font(15));
	addbklbl.setTranslateX(70);
	addbklbl.setTranslateY(230);
	addbklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
    viewbook = new Button("");
	viewbook.setStyle("-fx-background-image: url('file:images/viewbookimg.PNG');-fx-background-color: transparent; -fx-text-fill: white; ");
	viewbook.setFont(Font.font(15));
	viewbook.setPrefSize(160, 180);
	viewbook.setTranslateX(240);
	viewbook.setTranslateY(20);
	changeBackgroundOnHover1(viewbook);
	
	Label viewbklbl = new Label("View BOOKS");
	viewbklbl.setFont(Font.font(15));
	viewbklbl.setTranslateX(275);
	viewbklbl.setTranslateY(220);
	viewbklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
	
    issuebook = new Button("");
	issuebook.setStyle("-fx-background-image: url('file:images/issuebookimg.PNG');-fx-background-color: transparent; -fx-text-fill: white; ");
	issuebook.setFont(Font.font(15));
	issuebook.setPrefSize(170, 195);
	issuebook.setTranslateX(440);
	issuebook.setTranslateY(20);
	changeBackgroundOnHover2(issuebook);
	
	Label issuebklbl = new Label("ISSUE BOOKS");
	issuebklbl.setFont(Font.font(15));
	issuebklbl.setTranslateX(490);
	issuebklbl.setTranslateY(227);
	issuebklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
	
    viewissuedbook = new Button(""); 
	viewissuedbook.setStyle("-fx-background-image: url('file:images/viewissuedbtimg.png');-fx-background-color: transparent; -fx-text-fill: white; ");
	viewissuedbook.setFont(Font.font(15));
	viewissuedbook.setPrefSize(165, 180);
	viewissuedbook.setTranslateX(23);
	viewissuedbook.setTranslateY(308);
	changeBackgroundOnHover3(viewissuedbook);
	viewissuedbook.setOnAction(e -> window.setScene(scene16));
	
	Label viewissuebklbl = new Label("VIEW ISSUED BOOKS");
	viewissuebklbl.setFont(Font.font(15));
	viewissuebklbl.setTranslateX(40);
	viewissuebklbl.setTranslateY(500);
	viewissuebklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
	
    returnbook = new Button(""); 
	returnbook.setStyle("-fx-background-image: url('file:images/returnbookimg.png');-fx-background-color: transparent; -fx-text-fill: white; ");
	returnbook.setFont(Font.font(15));
	returnbook.setPrefSize(170, 180);
	returnbook.setTranslateX(250);
	returnbook.setTranslateY(310);
	changeBackgroundOnHover4(returnbook);
	
	Label returnbklbl = new Label("RETURN BOOKS");
	returnbklbl.setFont(Font.font(15));
	returnbklbl.setTranslateX(275);
	returnbklbl.setTranslateY(500);
	returnbklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
	
	libLogout = new Button(""); 
	libLogout.setStyle("-fx-background-image: url('file:images/logoutimg.PNG');-fx-background-color: transparent; -fx-text-fill: white; ");
	libLogout.setFont(Font.font(15));
	libLogout.setPrefSize(150, 160);
	libLogout.setTranslateX(440);
	libLogout.setTranslateY(330);
	changeBackgroundOnHover5(libLogout);
	
	Label logoutbklbl = new Label("LOGOUT");
	logoutbklbl.setFont(Font.font(15));
	logoutbklbl.setTranslateX(490);
	logoutbklbl.setTranslateY(500);
	logoutbklbl.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: green;");
	
	
	
	libroot.getChildren().addAll(addbook,addbklbl,viewbook,viewbklbl,issuebook,issuebklbl,viewissuedbook,viewissuebklbl,returnbook,returnbklbl,libLogout,logoutbklbl);
	
	FadeTransition ft1 = new FadeTransition(Duration.millis(1000), libroot);
	ft1.setFromValue(0.0);
	ft1.setToValue(1.0);
	ft1.play();
	
	  ///////////////////////////
	 ///ADD Book DATA////////
	//////////////////////////
	
	addstudentlayout =  new Group();
	scene12 = new Scene(addstudentlayout,600,500);
	window.setScene(scene12);
	
	
    Label addbooklabel = new Label("Add Book");
    addbooklabel.setTranslateX(260);
    addbooklabel.setTranslateY(20);
    addbooklabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));

	
    Label addcallnolabel = new Label("Call No: ");
    addcallnolabel.setTranslateX(120);
    addcallnolabel.setTranslateY(80);
    addcallnolabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	callnotf = new TextField();
	callnotf.setTranslateX(230);
	callnotf.setPromptText("Enter the Serial no.");
	callnotf.setTranslateY(80);
	callnotf.setPrefSize(200, 30);

	
	Label addnbookamelabel = new Label("Name: ");
	addnbookamelabel.setTranslateX(120);
	addnbookamelabel.setTranslateY(127);
	addnbookamelabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	booknametf = new TextField();
	booknametf.setTranslateX(230);
	booknametf.setPromptText("Enter the Book Name");
	booknametf.setTranslateY(127);
	booknametf.setPrefSize(200, 30);

	
	Label addauthorlabel = new Label("Author: ");
	addauthorlabel.setTranslateX(120);
	addauthorlabel.setTranslateY(170);
	addauthorlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	authornametf = new TextField();
	authornametf.setTranslateX(230);
	authornametf.setPromptText("Enter the Author Name");
	authornametf.setTranslateY(170);
	authornametf.setPrefSize(200, 30);

	
	Label addpublisherlabel = new Label("Publisher: ");
	addpublisherlabel.setTranslateX(120);
	addpublisherlabel.setTranslateY(210);
	addpublisherlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	publishernametf = new TextField();
	publishernametf.setTranslateX(230);
	publishernametf.setPromptText("Enter the Publisher Name");
	publishernametf.setTranslateY(210);
	publishernametf.setPrefSize(200, 30);
	
	Label addquantitylabel = new Label("Quantity: ");
	addquantitylabel.setTranslateX(120);
	addquantitylabel.setTranslateY(250);
	addquantitylabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	quantitytf = new TextField();
	quantitytf.setTranslateX(230);
	quantitytf.setPromptText("Enter the quantity ");
	quantitytf.setTranslateY(250);
	quantitytf.setPrefSize(200, 30);
	
	addbookbt = new Button("Add Book"); 
	addbookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	addbookbt.setFont(Font.font(15));
	addbookbt.setPrefSize(100, 10);
	addbookbt.setTranslateX(230);
	addbookbt.setTranslateY(300);
	changeBackgroundOnHoverUsingBinding(addbookbt);

	addbookbt.setOnAction(e ->addStudentButtonClicked());
	
	
	backbt = new Button("Back"); 
	backbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	backbt.setFont(Font.font(15));
	backbt.setPrefSize(80, 10);
	backbt.setTranslateX(340);
	backbt.setTranslateY(300);
	changeBackgroundOnHoverUsingBinding(backbt);
	
	ImageView bookimg = new ImageView(new Image("file:images/books.jpg"));
	bookimg.setFitHeight(600);
	bookimg.setFitWidth(650);
    bookimg.setOpacity(0.3f);
	
	addstudentlayout.getChildren().addAll(bookimg,addbooklabel,addcallnolabel,callnotf,addnbookamelabel,booknametf,addauthorlabel,authornametf,addpublisherlabel,publishernametf,addquantitylabel,quantitytf,addbookbt,backbt);
	
	FadeTransition ft2 = new FadeTransition(Duration.millis(1000), addstudentlayout);
	ft2.setFromValue(0.0);
	ft2.setToValue(1.0);
	ft2.play();
	
	 /////////////////////////
	//viewBook Layout start//
   /////////////////////////
	
	veiwstudentlayout = new Group();
	scene13 = new Scene(veiwstudentlayout,500,500);
	window.setScene(scene13);
	
	
	//Callno column
    TableColumn<Booksdata, String> callnoColumn = new TableColumn<>("Callno");
    callnoColumn.setMinWidth(80);
    callnoColumn.setCellValueFactory(new PropertyValueFactory<>("callno"));
	
    //Name column
    TableColumn<Booksdata, String> booknameColumn = new TableColumn<>("Bookname");
    booknameColumn.setMinWidth(140);
    booknameColumn.setCellValueFactory(new PropertyValueFactory<>("bookname"));

    //Author column
    TableColumn<Booksdata, String> authorColumn = new TableColumn<>("Author");
    authorColumn.setMinWidth(160);
    authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    
    //publisher column
    TableColumn<Booksdata, String> publisherColumn = new TableColumn<>("Publisher");
    publisherColumn.setMinWidth(160);
    publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
	
    //quantity column
    TableColumn<Booksdata, String> quantityColumn = new TableColumn<>("Quantity");
    quantityColumn.setMinWidth(100);
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

	viewtable = new TableView<>();
	viewtable.setPrefHeight(460);
	viewtable.setPrefWidth(650);
	viewtable.setItems(getBooksData());
	viewtable.getColumns().addAll(callnoColumn,booknameColumn,authorColumn,publisherColumn,quantityColumn);


	backbuttonoftbaleview = new Button("Back");
	backbuttonoftbaleview.setTranslateY(495);
	backbuttonoftbaleview.setTranslateX(120);
	backbuttonoftbaleview.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	backbuttonoftbaleview.setFont(Font.font(15));
	backbuttonoftbaleview.setPrefSize(100, 7);
	changeBackgroundOnHoverUsingBinding(backbuttonoftbaleview);
	
	dltbtfrombookview = new Button("Delete");
	dltbtfrombookview.setTranslateY(495);
	dltbtfrombookview.setTranslateX(240);
	dltbtfrombookview.setStyle("-fx-background-color:#A15CF8; -fx-text-fill: white;");
	dltbtfrombookview.setFont(Font.font(15));
	dltbtfrombookview.setPrefSize(100, 7);
	changeBackgroundOnHoverUsingBinding(dltbtfrombookview);
	
	dltbtfrombookview.setOnAction(e -> bookViewdeleteButton());
	
	savebookbt = new Button("Save"); 
	savebookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	savebookbt.setFont(Font.font(15));
	savebookbt.setPrefSize(100, 10);
	savebookbt.setTranslateX(370);
	savebookbt.setTranslateY(495);
	changeBackgroundOnHoverUsingBinding(savebookbt);
	savebookbt.setOnAction(e -> saveButtonClicked());
	
	   Rectangle  rect2 = new Rectangle(0,430,7,150);
       rect2.setFill(Color.SKYBLUE);
       rect2.setOpacity(0.6f);
       
      ScaleTransition sc = new ScaleTransition(Duration.millis(5000),rect2);
      sc.setToX(200);
      sc.setCycleCount(1);
      sc.play(); 
       
	veiwstudentlayout.getChildren().addAll(rect2,viewtable,backbuttonoftbaleview,dltbtfrombookview,savebookbt);

	
	FadeTransition ft4 = new FadeTransition(Duration.millis(1000), veiwstudentlayout);
	ft4.setFromValue(0.0);
	ft4.setToValue(1.0);
	ft4.play();
	
	 //////////////////
	//for Issue Book//
   //////////////////
	
	issubooklayout = new Group();
	scene14 = new Scene(issubooklayout);
	window.setScene(scene14);
	
	ImageView bkimg1 = new ImageView(new Image("file:images/books.jpg"));
	bkimg1.setFitHeight(600);
	bkimg1.setFitWidth(650);
    bkimg1.setOpacity(0.4f);
	
	 Label issuebooklabel = new Label("Issue Book");
	 issuebooklabel.setTranslateX(220);
	 issuebooklabel.setTranslateY(20);
	 issuebooklabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));

	 
		Label issubookcallnolabel = new Label("Book Serial No: ");
		issubookcallnolabel.setTranslateX(120);
		issubookcallnolabel.setTranslateY(87);
		issubookcallnolabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
       
		
		issubookcallnotf = new TextField();
		issubookcallnotf.setTranslateX(240);
		issubookcallnotf.setPromptText("Enter the Serial No");
		issubookcallnotf.setTranslateY(87);
		issubookcallnotf.setPrefSize(200, 30);

	 
	
		Label issubooknamelabel = new Label("Book Name: ");
		issubooknamelabel.setTranslateX(120);
		issubooknamelabel.setTranslateY(132);
		issubooknamelabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
        
		issubooknametf = new TextField();
		issubooknametf.setTranslateX(240);
		issubooknametf.setPromptText("Enter the Book Name");
		issubooknametf.setTranslateY(132);
		issubooknametf.setPrefSize(200, 30);

		
		Label issueidlabel = new Label("Student ID: ");
		issueidlabel.setTranslateX(120);
		issueidlabel.setTranslateY(177);
		issueidlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

		issueidtf = new TextField();
		issueidtf.setTranslateX(240);
		issueidtf.setPromptText("Enter the Id:");
		issueidtf.setTranslateY(177);
		issueidtf.setPrefSize(200, 30);

		Label issuestnamelabel = new Label("Student Name: ");
		issuestnamelabel.setTranslateX(110);
		issuestnamelabel.setTranslateY(227);
		issuestnamelabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

		issuestudenttf = new TextField();
		issuestudenttf.setTranslateX(240);
		issuestudenttf.setPromptText("Enter the  Name:");
		issuestudenttf.setTranslateY(227);
		issuestudenttf.setPrefSize(200, 30);
		
		issubookbt = new Button("Issue Book");
		issubookbt.setTranslateX(240);
		issubookbt.setTranslateY(287);
		issubookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
		issubookbt.setFont(Font.font(15));
		issubookbt.setPrefSize(100, 7);
		changeBackgroundOnHoverUsingBinding(issubookbt);
		
		issubookbt.setOnAction(e ->{
		ObservableList<Booksdata> bk = getBooksData(); 
		
		for(Booksdata n : bk){
			if(true){

				Alert al = new Alert(AlertType.INFORMATION);
				al.setHeaderText(null);
				al.setContentText("Book is issued SuccessFully");
				al.showAndWait();
		} 
			/*else{
			
			Alert al = new Alert(AlertType.ERROR);
			al.setHeaderText("please check the Call no!");
			al.setContentText("OR TextFields are Empty");
			al.showAndWait();
		}
		*/	
		}
		
		});
		
		issuegobackbt = new Button("Back");
		issuegobackbt.setTranslateX(360);
		issuegobackbt.setTranslateY(287);
		issuegobackbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
		issuegobackbt.setFont(Font.font(15));
		issuegobackbt.setPrefSize(80, 7);
		changeBackgroundOnHoverUsingBinding(issuegobackbt);
		issuegobackbt.setOnAction(e ->window.setScene(scene11));

	issubooklayout.getChildren().addAll(bkimg1,issuebooklabel,issubooknamelabel,issubookcallnolabel,issubookcallnotf,issubooknametf,issueidlabel,issueidtf,issuestnamelabel,issuestudenttf,issubookbt,issuegobackbt);

					/////////////////////////////
					////FOR View Issued BOOKS ///
					/////////////////////////////
						
	Group viewissuedbookslayout = new Group();
	scene16 = new Scene(viewissuedbookslayout);
	window.setScene(scene16);
	
	
	 //id column
    TableColumn<Booksdata, String> idColumn = new TableColumn<>("ID");
    booknameColumn.setMinWidth(100);
    booknameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
	//Callno column
    TableColumn<Booksdata, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setMinWidth(100);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    
    
  //Callno column
    TableColumn<Booksdata, String> callnoColumn1 = new TableColumn<>("Callno");
    callnoColumn1.setMinWidth(80);
    callnoColumn1.setCellValueFactory(new PropertyValueFactory<>("callno"));
	
    //Name column
    TableColumn<Booksdata, String> booknameColumn1 = new TableColumn<>("Bookname");
    booknameColumn1.setMinWidth(140);
    booknameColumn1.setCellValueFactory(new PropertyValueFactory<>("bookname"));

    //Author column
    TableColumn<Booksdata, String> authorColumn1 = new TableColumn<>("Author");
    authorColumn1.setMinWidth(120);
    authorColumn1.setCellValueFactory(new PropertyValueFactory<>("author"));
    
    //publisher column
    TableColumn<Booksdata, String> publisherColumn1 = new TableColumn<>("Publisher");
    publisherColumn1.setMinWidth(120);
    publisherColumn1.setCellValueFactory(new PropertyValueFactory<>("publisher"));
	
    
    viewissuedbookstable = new TableView();
    viewissuedbookstable.setPrefWidth(650);
	viewissuedbookstable.getColumns().addAll(idColumn,nameColumn,callnoColumn1,booknameColumn1,authorColumn1,publisherColumn1);
	
	backbuttonoftbaleview1 = new Button("Back");
	backbuttonoftbaleview1.setTranslateY(495);
	backbuttonoftbaleview1.setTranslateX(120);
	backbuttonoftbaleview1.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	backbuttonoftbaleview1.setFont(Font.font(15));
	backbuttonoftbaleview1.setPrefSize(100, 7);
	changeBackgroundOnHoverUsingBinding(backbuttonoftbaleview1);
	backbuttonoftbaleview1.setOnAction(e ->window.setScene(scene11));
	
	dltbtfrombookview1 = new Button("Delete");
	dltbtfrombookview1.setTranslateY(495);
	dltbtfrombookview1.setTranslateX(240);
	dltbtfrombookview1.setStyle("-fx-background-color:#A15CF8; -fx-text-fill: white;");
	dltbtfrombookview1.setFont(Font.font(15));
	dltbtfrombookview1.setPrefSize(100, 7);
	changeBackgroundOnHoverUsingBinding(dltbtfrombookview1);
	
	savebookbt1 = new Button("Save"); 
	savebookbt1.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	savebookbt1.setFont(Font.font(15));
	savebookbt1.setPrefSize(100, 10);
	savebookbt1.setTranslateX(370);
	savebookbt1.setTranslateY(495);
	changeBackgroundOnHoverUsingBinding(savebookbt1);
	
	
	viewissuedbookslayout.getChildren().addAll(viewissuedbookstable,backbuttonoftbaleview1,dltbtfrombookview1,savebookbt1);
	
	 /////////////////////////////
	////FOR RETURN BOOKS /////////
   /////////////////////////////
	
	 Label returnbooklabel = new Label("Return Issued Books");
	 returnbooklabel.setTranslateX(180);
	 returnbooklabel.setTranslateY(40);
	 returnbooklabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));

	 
	returnbooklayout = new Group();
	scene15 = new Scene(returnbooklayout);
	window.setScene(scene15);
	returnbook.setOnAction(e ->window.setScene(scene15));
		
	ImageView bkimg4 = new ImageView(new Image("file:images/books.jpg"));
	bkimg4.setFitHeight(600);
	bkimg4.setFitWidth(650);
    bkimg4.setOpacity(0.4f);
	
    Label returnbookcallnolabel = new Label("Book Serial No: ");
	returnbookcallnolabel.setTranslateX(120);
	returnbookcallnolabel.setTranslateY(150);
	returnbookcallnolabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
   
	returnbookcallnotf = new TextField();
	returnbookcallnotf.setTranslateX(240);
	returnbookcallnotf.setPromptText("Enter the Serial No");
	returnbookcallnotf.setTranslateY(150);
	returnbookcallnotf.setPrefSize(200, 30);

 
	Label returnidlabel = new Label("Student ID: ");
	returnidlabel.setTranslateX(120);
	returnidlabel.setTranslateY(200);
	returnidlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));

	returnidtf = new TextField();
	returnidtf.setTranslateX(240);
	returnidtf.setPromptText("Enter the Id:");
	returnidtf.setTranslateY(200);
	returnidtf.setPrefSize(200, 30);
    
	returnbookbt = new Button("Return Book");
	returnbookbt.setTranslateX(240);
	returnbookbt.setTranslateY(277);
	returnbookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	returnbookbt.setFont(Font.font(15));
	returnbookbt.setPrefSize(110, 7);
	changeBackgroundOnHoverUsingBinding(returnbookbt);
	
	returnbookbt.setOnAction(e ->{
		if(returnBookValidation()){
			
		}
	});
	
	
	returngobackbt = new Button("Back");
	returngobackbt.setTranslateX(360);
	returngobackbt.setTranslateY(277);
	returngobackbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	returngobackbt.setFont(Font.font(15));
	returngobackbt.setPrefSize(80, 7);
	changeBackgroundOnHoverUsingBinding(returngobackbt);
	returngobackbt.setOnAction(e ->window.setScene(scene11));
	
    returnbooklayout.getChildren().addAll(bkimg4,returnbookcallnolabel,returnbookcallnotf,returnidlabel,returnidtf,returnbooklabel,returnbookbt,returngobackbt);
    
    
    
    
	// Action Event Handling start
	
	issuebook.setOnAction(e ->window.setScene(scene14));

	viewbook.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			
			window.setScene(scene13);
			
			
		}
		
	});
	backbt.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			
			window.setScene(scene11);
		}
		
	});
	
	libLogout.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			window.close();
		}
		
	});
	

	addbook.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			window.setScene(scene12);
						
		}
		
	});
	
	backbuttonoftbaleview.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			
			window.setScene(scene11);
		}
		
	});
}

private boolean returnBookValidation() {
	
	if(returnbookcallnotf.getText().isEmpty() || returnidtf.getText().isEmpty()){
	
		Alert savealert1 = new Alert(AlertType.ERROR);
		savealert1.setHeaderText("TextFields are Empty!");
		savealert1.setContentText("Please check the Call No to Return the Book!");
		savealert1.showAndWait();
		
		return false;
	}
	
	return true;
}

private void saveButtonClicked() {
	Alert savealert1 = new Alert(AlertType.INFORMATION);
	savealert1.setHeaderText(null);
	savealert1.setContentText("Your data has been saved successfully!");
	savealert1.showAndWait();
	
	try {	
    	FileOutputStream fos = new FileOutputStream("data/booksdata.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new ArrayList<Booksdata>(booksdata));
		oos.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

private ObservableList<Booksdata> getBooksData() {
	try {
		FileInputStream FIS = new FileInputStream("data/booksdata.ser");
		ObjectInputStream FOU = new ObjectInputStream(FIS);
		@SuppressWarnings("unchecked")
		List<Booksdata> list = (List<Booksdata>) FOU.readObject();
		booksdata = FXCollections.observableList(list);

		FOU.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
    return booksdata;
}

private void bookViewdeleteButton() {
	Alert alert9 = new Alert(AlertType.CONFIRMATION,"Are you sure to delete?",ButtonType.YES,ButtonType.NO);
	alert9.setHeaderText(null);

	Optional<ButtonType> result = alert9.showAndWait();
	
if(result.get() == ButtonType.YES){	
    ObservableList<Booksdata> booksdataSelected;
	ObservableList<Booksdata> allbooksdata;
	allbooksdata = viewtable.getItems();
	booksdataSelected = viewtable.getSelectionModel().getSelectedItems();
	booksdataSelected.forEach(allbooksdata::remove);
} else{
	alert9.close();
}
}
	

private boolean  bookValidation() {

	if(callnotf.getText().isEmpty() || booknametf.getText().isEmpty()||
			authornametf.getText().isEmpty() || publishernametf.getText().isEmpty()||
			quantitytf.getText().isEmpty()){
		
		Alert warningalert3 = new Alert(AlertType.WARNING);
		warningalert3.setHeaderText("TextFields are empty!");
		warningalert3.setContentText("Please input the data");
		warningalert3.showAndWait();
		
		
		return false;
	} else{
		
		Alert warningalert3 = new Alert(AlertType.INFORMATION);
		warningalert3.setHeaderText(null);
		warningalert3.setContentText("Data has been successfully added!");
		warningalert3.showAndWait();
		
	}
	
	return true;
}

private void addStudentButtonClicked() {
	if(bookValidation()){
	Booksdata booksdata = new Booksdata();
	booksdata.setCallno(callnotf.getText());
	booksdata.setBookname(booknametf.getText());
	booksdata.setAuthor(authornametf.getText());
	booksdata.setPublisher(publishernametf.getText());
	booksdata.setQuantity(Integer.parseInt(quantitytf.getText()));
	
	viewtable.getItems().add(booksdata);
	
	callnotf.clear();
	booknametf.clear();
	authornametf.clear();
	publishernametf.clear();
	quantitytf.clear();
	
}
}
//for add Button
private void changeBackgroundOnHover(Button addbutton) {
	addbutton.styleProperty().bind(
		      Bindings
		        .when(addbutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE)
		          )
		    );
}

//for view Button
private void changeBackgroundOnHover1(Button viewbutton) {
	viewbutton.styleProperty().bind(
		      Bindings
		        .when(viewbutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE1)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE1)
		          )
		    );
}
private void changeBackgroundOnHover2(Button issuebutton) {
	issuebutton.styleProperty().bind(
		      Bindings
		        .when(issuebutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE2)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE2)
		          )
		    );
}
private void changeBackgroundOnHover3(Button viewissuedbutton) {
	viewissuedbutton.styleProperty().bind(
		      Bindings
		        .when(viewissuedbutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE3)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE3)
		          )
		    );
}
private void changeBackgroundOnHover4(Button returnbutton) {
	returnbutton.styleProperty().bind(
		      Bindings
		        .when(returnbutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE4)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE4)
		          )
		    );
}
private void changeBackgroundOnHover5(Button logoutbutton) {
	logoutbutton.styleProperty().bind(
		      Bindings
		        .when(logoutbutton.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE5)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE5)
		          )
		    );
}
private void changeBackgroundOnHoverUsingBinding(Button books) {
	books.styleProperty().bind(
		      Bindings
		        .when(books.hoverProperty())
		          .then(
		            new SimpleStringProperty(HOVERED_BUTTON_STYLE0)
		          )
		          .otherwise(
		            new SimpleStringProperty(STANDARD_BUTTON_STYLE0)
		          )
		    );
}

}
