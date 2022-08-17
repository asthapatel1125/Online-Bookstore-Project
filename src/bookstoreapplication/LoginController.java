/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class LoginController implements Initializable {
    Owner owner = new Owner();
  
    @FXML
    private TextField tf1;
    
    @FXML
    private TextField tf2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
    @FXML
    public void handleLogin(ActionEvent event) {
        if((tf1.getText().equals("admin"))&&(tf2.getText().equals("admin")))
        {   
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Owner screen");
                stage.setScene(new Scene(root1));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                
                    @Override
                    public void handle(WindowEvent e) {
                     owner.updateBookList();
                     
                    }
                });
                ((Node)(event.getSource())).getScene().getWindow().hide();
        
        
            }catch(Exception e){
                System.out.println("Can't load new Window");
            }
        }
        for(int i=0;i<owner.getCustomerList().size();i++){
            if(tf1.getText().equals(owner.getCustomerList().get(i).getUsername())&&tf2.getText().equals(owner.getCustomerList().get(i).getPassword())){
                try
                    {

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerStartScreen.fxml"));
                        Parent root2 = (Parent) fxmlLoader.load();
                        Stage stage2 = new Stage();
                        Owner.setInstance(i);
                        stage2.setTitle("Customer Start Screen");
                        stage2.setScene(new Scene(root2));
                        stage2.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                    }catch(Exception e){
                        System.out.println("Can't Load New Window");
                    }
                }
            }
        }
}