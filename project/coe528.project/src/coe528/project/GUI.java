package coe528.project;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage){ 
        
        primaryStage.setTitle("BankApp");
        
        Button login = new Button("Login");
        
         
        GridPane layout = new GridPane();
        
        layout.add(login, 0, 3);
       
        TextField user = new TextField("Username");
        
        Label userField = new Label("Username: ");
        
        TextField pw = new TextField("Password");
        
        Label pwField = new Label("Password: ");
        
        Label welcome = new Label("Bank of Money");
        
        welcome.setFont(Font.font("Copperplate", FontWeight.NORMAL, 25));
        
        Label invalid = new Label("Invalid Login");
        
        
        //positioning on the grid
        layout.setAlignment(Pos.CENTER);
        
        //layout.add(userField, 0 ,1);
        layout.add(user, 0, 1);
        
        layout.add(pw, 0, 2);
        
        //layout.add(pwField, 0, 2);
        layout.add(welcome , 0 , 0);
        
        
        
        //We create a manager to authenticate the initial logins
        Manager alex = new Manager();
        
        login.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent event){
                
                String username = user.getText();
                
                String password = pw.getText();

                if (username.equals("admin") && password.equals("admin")){
                    
                    managerWindow(primaryStage, alex); //if a manager logs in this takes them to the manager screen
                    
                    System.out.println("An Admin has logged in.");
                    
                } else if (alex.verify(username, password)){ //will create a verify method in the manager class to check for login credentials
                    
                    customerWindow(primaryStage, alex);
                    
                    System.out.println("A Customer has logged in.");
                } 
                  else{
                    System.out.println("Invalid Login");
                    
                    layout.add(invalid, 1, 3);
                }
            }
        });
        
        Scene scene = new Scene(layout, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    
    public void managerWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        Label welcomeManager = new Label("Manager Use Only");
        
        Label optionText = new Label("Manager Options: ");
        
        Button addButton = new Button("Add Customer");
        
        Button deleteButton = new Button("Delete Customer");
        
        Button logoutButton = new Button("Logout");
        
        welcomeManager.setFont(Font.font("Copperplate", FontWeight.NORMAL, 25));

        
        GridPane managerPane = new GridPane();
        
        managerPane.setAlignment(Pos.CENTER);
        
        managerPane.add(welcomeManager ,0 ,0);
        
        managerPane.add(optionText, 0, 1);
        
        managerPane.add(addButton, 0, 2);
        
        managerPane.add(deleteButton, 0, 3);
        
        managerPane.add(logoutButton, 0, 4);
        
        addButton.setOnAction((ActionEvent e)->{
            
        addCustomerWindow(primaryStage, alex);
        });
        
        deleteButton.setOnAction((ActionEvent e)->{
            
        deleteCustomerWindow(primaryStage, alex); 
        });
       
        logoutButton.setOnAction((ActionEvent e) -> {
            
            start(primaryStage);
        });
        
        Scene scene = new Scene(managerPane, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
       
        
    }
    
    public void addCustomerWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        Label user = new Label("Username: ");
        
        TextField userField = new TextField();
        
        Label pass = new Label("Password: ");
        
        TextField passField = new TextField();
        
        Button addC = new Button("Add");
        
        Button backButton = new Button("Back");
        
        Label addedText = new Label("Customer has been Added!");
        
        GridPane addPane = new GridPane();
        
        addC.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String username = userField.getText();
                
                String password = passField.getText();
                
                if (username != null && password != null) {
                    
                  alex.addCustomer(username, password);
                  
                    addPane.add(addedText, 1, 3);
                }
                else {
                    System.out.println("Username and/or Password is incorrect.");
                }
            }
        });
        
        backButton.setOnAction((ActionEvent e) -> {
            
            managerWindow(primaryStage, alex);
        });
        
        
        addPane.setAlignment(Pos.CENTER);
        
        addPane.add(user, 0, 1);
        
        addPane.add(userField, 1, 1);
        
        addPane.add(pass, 0, 2);
        
        addPane.add(passField, 1, 2);
        
        addPane.add(addC, 0,3);
        
        addPane.add(backButton, 0, 4);
        
        Scene scene = new Scene(addPane, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void deleteCustomerWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        Label user = new Label("Username: ");
        
        TextField userField = new TextField();
        
        Label pass = new Label("Password: ");
        
        TextField passField = new TextField();
        
        Button deleteC = new Button("Delete");
        
        Button backButton = new Button("Back");
        
        Label deleteText = new Label("Customer Deleted");
        
        GridPane addPane = new GridPane();

        
        deleteC.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String username = userField.getText();
                
                String password = passField.getText();
                
                if (username != null && password != null) {
                    
                    alex.deleteCustomer(username, password);
                    
                    addPane.add(deleteText, 1, 3);
                }
                else {
                    System.out.println("Username and/or Password is incorrect.");
                }
            }
        });
        
        backButton.setOnAction((ActionEvent e) -> {
            
            managerWindow(primaryStage, alex);
        });
        
        addPane.setAlignment(Pos.CENTER);
        
        addPane.add(user, 0, 1);
        
        addPane.add(userField, 1, 1);
        
        addPane.add(pass, 0, 2);
        
        addPane.add(passField, 1, 2);
        
        addPane.add(deleteC, 0,3);
        
        addPane.add(backButton, 0, 4);
        
        Scene scene = new Scene(addPane, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void customerWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        Button logoutButton = new Button("Logout");
        
        Button depositButton = new Button("Deposit");
        
        Button withdrawButton = new Button("Withdraw");
        
        Button purchaseButton = new Button("Purchase");
        
        Label welcomeText = new Label("Welcome  " + alex.getCustomerUserName());
        
        Label balLabel = new Label("Balance: "+ alex.getBalance());
        
        Label levLabel = new Label("Account Level: " + alex.level());
        
        welcomeText.setFont(Font.font("Copperplate", FontWeight.NORMAL, 15));

        
        GridPane customerGrid = new GridPane();
        
        customerGrid.add(logoutButton, 0,4);
        
        withdrawButton.setOnAction((ActionEvent e) -> { 
            
            withdrawWindow(primaryStage, alex);
        });
        
        depositButton.setOnAction((ActionEvent e) -> {
            
            depositWindow(primaryStage, alex);
        });
        
        purchaseButton.setOnAction((ActionEvent e) -> {
            
            purchaseWindow(primaryStage, alex);
        });
        
        logoutButton.setOnAction((ActionEvent e) -> {
            
            start(primaryStage);
        });
        
        
         balLabel.setFont(Font.font("Copperplate", FontWeight.NORMAL, 15));

        customerGrid.setAlignment(Pos.CENTER);
        
        customerGrid.add(welcomeText, 0,0);
        
        customerGrid.add(depositButton, 0,1);
        
        customerGrid.add(withdrawButton, 0, 2);
        
        customerGrid.add(purchaseButton, 0, 3);
        
        customerGrid.add(balLabel, 2, 1);
        
        customerGrid.add(levLabel, 2, 2);
        
        
        Scene scene = new Scene(customerGrid, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }
    
    public void withdrawWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        GridPane withdrawPane = new GridPane();
        
        Label withdrawText = new Label("Enter Amount:");
                
        
        Button back = new Button("Back");
        
        Button withdraw = new Button("Widthdraw");
        
        TextField withdrawField = new TextField();
        
        Label levelLabel = new Label("     Account Level: " + alex.level());
        
        Label balLabel = new Label("Balance: "+ alex.getBalance());
        
        Label errLabel = new Label("");
        
        withdraw.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
              int amount = Integer.parseInt(withdrawField.getText());
              
              if (alex.withdraw(amount)){
                  levelLabel.setText("     Account Level: " + alex.level());
                  balLabel.setText("Balance: " + alex.getBalance());   
                  errLabel.setText("Withdawal of $"+ amount + " has been made.");
                  
              }else{
                 errLabel.setText("Error: Insufficient Funds.");
              }  
            }
        });
   
        back.setOnAction((ActionEvent e) -> {
            
            customerWindow(primaryStage, alex);
        });
        
        withdrawPane.setAlignment(Pos.CENTER);
        
        withdrawPane.add(back, 0, 7);
        
        withdrawPane.add(withdraw,0,1);
        
        withdrawPane.add(withdrawText, 1, 0);
        
        withdrawPane.add(withdrawField, 1,1);
        
        withdrawPane.add(levelLabel, 2, 1);
        
        withdrawPane.add(balLabel, 1, 2);
        
        withdrawPane.add(errLabel, 1, 4);
        
        
        Scene scene = new Scene(withdrawPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void depositWindow(Stage primaryStage, Manager a){
        Manager alex = a;
        GridPane depositPane = new GridPane();
        
        Label depositText = new Label("Enter Amount:");
                
        
        Button back = new Button("Back");
        
        Button deposit = new Button("Deposit");
        
        TextField depositField = new TextField();
        
        Label levelLabel = new Label("     Account Level: " + alex.level());
        
        Label balLabel = new Label("Balance: "+ alex.getBalance());
        
        Label errorLabel = new Label("");
        
        deposit.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
              int amount = Integer.parseInt(depositField.getText());
              
                       if(alex.deposit(amount)){
              levelLabel.setText("     Account Level: "+ alex.level());
              balLabel.setText("Account Balance: " + alex.getBalance());
              errorLabel.setText("$" +  amount +" has been deposited to your account.");
              }else{
                  errorLabel.setText("Error: Invalid Amount.");
              }
              
            } 
            });
        
        
        
        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, alex);
        });
        
        depositPane.setAlignment(Pos.CENTER);
        
        depositPane.add(back, 0, 7);
        
        depositPane.add(deposit,0,1);
        
        depositPane.add(depositText, 1, 0);
        
        depositPane.add(depositField, 1,1);
        
        depositPane.add(levelLabel, 2, 1);
        
        depositPane.add(balLabel, 1, 2);
        
        depositPane.add(errorLabel, 1, 4);
        
        Scene scene = new Scene(depositPane, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void purchaseWindow(Stage primaryStage, Manager a){
        
        Manager alex = a;
        
        GridPane purchasePane = new GridPane();
        
        Label purchaseText = new Label("Amount of Purchase:");
                
        
        Button back = new Button("Back");
        
        Button purchase = new Button("Purchase");
        
        TextField purchaseField = new TextField();
        
        Label levelLabel = new Label("     Account Level: " + alex.level());
        
        Label balLabel = new Label("Balance: "+ alex.getBalance());
       
        Label purLabel = new Label("");
        
        purchase.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
              int amount = Integer.parseInt(purchaseField.getText());
              
              if (alex.purchase(amount)){
                  
                  levelLabel.setText("     Account Level: " + alex.level());
                  
                  balLabel.setText("Balance: " + alex.getBalance()); 
                  
                  switch(alex.level()){
                      case "Silver":
                          purLabel.setText("A purchase has been made for $" + amount + "\nWith a purchase fee of $20.");
                          break;
                      case "Gold":
                          purLabel.setText("A purchase has been made for $" + amount + "\nWith a purchase fee of $10.");
                          break;
                      case "Platinum":
                          purLabel.setText("A purchase has been made for $" + amount + ".");
                          break;
                  }
                  
                  
              }else{
                  
                 purLabel.setText("Error: Price under $50, or Insufficient Funds.");
              }
            }
        });
        
        back.setOnAction((ActionEvent e) -> {
            
            customerWindow(primaryStage, alex);
        });
        
        purchasePane.setAlignment(Pos.CENTER);
        
        purchasePane.add(back, 0, 7);
        
        purchasePane.add(purchase,0,1);
        
        purchasePane.add(purchaseText, 1, 0);
        
        purchasePane.add(purchaseField, 1,1);
        
        purchasePane.add(levelLabel, 2, 1);
        
        purchasePane.add(balLabel, 1, 2);
        
        purchasePane.add(purLabel, 1, 4);
        
        Scene scene = new Scene(purchasePane, 600, 300);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();  
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    
    
}
