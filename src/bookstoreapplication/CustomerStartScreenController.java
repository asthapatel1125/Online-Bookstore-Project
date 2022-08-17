/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CustomerStartScreenController implements Initializable {
    Customer c;
    
    private ObservableList<Book> bookData = FXCollections.observableArrayList();
    private String bookName;
    private double bookPrice;
    
    
    public void passCustomer(Customer c){
        this.c=c;
    }

   

    @FXML
    private TableView<Book> bookTable;  
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, Double> priceColumn;
    @FXML
    private TableColumn<Book, String> checkBoxColumn;
    
 
    @FXML
    private Button buy;
    @FXML
    private Button RPnB;
    @FXML
    private Button logout;
    
  

    
   @FXML
    void handleBuy(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerCostScreen.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Customer Cost Screen");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(IOException e)
        {
            System.out.println("Could not open window");
        }
    }

    @FXML
    void handleLogout(ActionEvent event)
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

    @FXML
    void handleRPnBuy(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerCostScreen.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Customer Cost Screen");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch(IOException e)
        {
            System.out.println("Could not open window");
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<>("selection"));
        
        
        bookData.setAll(Owner.getBookList());
        bookTable.getItems().setAll(bookData);
        
       
    }    
    
}
