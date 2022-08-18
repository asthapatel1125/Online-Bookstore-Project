/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class OwnerScreenController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleOwnerBook(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerBookScreen.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Owner Books Screen");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception c)
        {
            System.out.println("Could not open window");
            c.printStackTrace();
                    
        }
    }
   
    @FXML
    public void handleOwnerCustomer(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerCustomerScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Owner Customer Screen");
                stage.setScene(new Scene(root1));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception c)
        {
            System.out.println("Could not open window");
            c.printStackTrace();
                    
        }
    }
    
    public void handleLogout(ActionEvent event)
    {
        try
        {
            BookstoreApplication bA= new BookstoreApplication();
            Stage s = new Stage();
            bA.start(s);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception e)
        {
            System.out.println("Could not open window");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

    
    
    
    
   
    

