/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class OwnerCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Owner owner = new Owner();
    private ArrayList<Customer> customerList = owner.getCustomerList();
    private ObservableList<Customer> customerData;
    
    
    @FXML
    private TableColumn<Customer, String>username;
    @FXML
    private TableColumn<Customer, String>password;
    @FXML
    private TableColumn<Customer, Integer>points;
    @FXML 
    private TableColumn<Customer, String> select;
    
    @FXML
    TableView<Customer> customerTable;
    
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerData = FXCollections.<Customer>observableArrayList(customerList);   
        username.setCellValueFactory(new PropertyValueFactory<Customer,String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<Customer,String>("password"));
        points.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("points"));
        select.setCellValueFactory(new PropertyValueFactory<Customer,String>("select"));
        customerTable.getItems().setAll(customerData);
    }    

    @FXML
    public void handleAdd(ActionEvent event){
        for(Customer c : customerTable.getItems()){
            if(c.getUsername().equals(usernameField.getText())){
                System.out.println("username already exist!");
                return;
            }
        }
        customerList.add(new Customer(usernameField.getText(),passwordField.getText(),0));
        customerData.setAll(customerList);
        customerTable.getItems().setAll(customerData);
        usernameField.clear();
        passwordField.clear();
        customerTable.refresh();
    }
    
    @FXML
    public void handleDelete(ActionEvent event){
        for(Customer c : customerTable.getItems()){
            if(c.getSelect().isSelected()){
                Platform.runLater(() ->{
                    customerTable.getItems().remove(c);
                    customerList.remove(c);
                });
            }
        }
    }
    
    @FXML
    public void handleBack(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerScreen.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Owner Screen");
                stage.setScene(new Scene(root));
                stage.show();
        
                ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(Exception c)
        {
            System.out.println("Could not open window");
                    
        }
    }
    
}
