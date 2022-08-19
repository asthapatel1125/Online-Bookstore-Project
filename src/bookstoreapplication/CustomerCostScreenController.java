/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import bookstoreapplication.Customer;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
/**
 * FXML Controller class
 *
 * @author DeRya
 */
public class CustomerCostScreenController implements Initializable {
    public double totalPrice;
    @FXML
    Label lbl;
    
    @FXML
    Label lbl2;
    
    @FXML
    Label lbl3;
    
    @FXML
    private Button logoutButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
           
    
    public void initialize(URL url, ResourceBundle rb ) {
    }  
    
    
    @FXML
    void logout(ActionEvent event){
        try
        {
            BookstoreApplication bA= new BookstoreApplication();
            Stage s = new Stage();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception e)
        {
            System.out.println("Could not open window");
        }
    }
   
    public void getTotal(double p){
        lbl.setText("Total Cost: $"+p);
        lbl2.setText("Points : "+Owner.getCustomerList().get(Owner.getInstance()).getPoints());
        lbl3.setText("Status : "+Owner.getCustomerList().get(Owner.getInstance()).getStatus());
    }
    
    
}
