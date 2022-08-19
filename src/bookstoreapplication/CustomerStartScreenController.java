/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import bookstoreapplication.Customer;
import java.awt.Component;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

public class CustomerStartScreenController implements Initializable {
    
    private ObservableList<Book> bookData = FXCollections.observableArrayList();
    private String bookName;
    private double bookPrice;
    
    

    @FXML
    private TableView<Book> bookTable;  
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, Double> priceColumn;
    @FXML
    private TableColumn<Book, String> checkBoxColumn;
    
    @FXML
    private Text text;
    @FXML
    private Button buy;
    @FXML
    private Button RPnB;
    @FXML
    private Button logout;

    @FXML
    private Label label;
    
   @FXML
    void handleBuy(ActionEvent event)
    {
        try
        {
            for(Book b : bookTable.getItems()){
                if(b.getSelection().isSelected()){
                    Owner.getCustomerList().get(Owner.getInstance()).selectBook(b);
                }
            }
            if((Owner.getCustomerList().get(Owner.getInstance()).getShopping().size())==0){
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Nothing selected!","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerCostScreen.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                CustomerCostScreenController c1 = fxmlLoader.getController();
                c1.getTotal(Owner.getCustomerList().get(Owner.getInstance()).buyBook());
                Stage stage = new Stage();
                stage.setTitle("Customer Cost Screen");
                stage.setScene(new Scene(root));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                    @Override
                    public void handle(WindowEvent e) {
                      Owner.updateBookList();
                      Owner.updateCustomerList();
                    }
                });
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        }
        catch(Exception e)
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
            for(Book b : bookTable.getItems()){
                if(b.getSelection().isSelected()){
                    Owner.getCustomerList().get(Owner.getInstance()).selectBook(b);
                }
            }
            if((Owner.getCustomerList().get(Owner.getInstance()).getShopping().size())==0){
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Nothing selected!","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerCostScreen.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                CustomerCostScreenController c1 = fxmlLoader.getController();
                c1.getTotal(Owner.getCustomerList().get(Owner.getInstance()).redeemPointsAndBuy());
                Stage stage = new Stage();
                stage.setTitle("Customer Cost Screen");
                stage.setScene(new Scene(root));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                    @Override
                    public void handle(WindowEvent e) {
                      Owner.updateBookList();
                      Owner.updateCustomerList();
                    }
                });
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        }
        catch(Exception e)
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
        int instance = Owner.getInstance();
        label.setText("Welcome "+Owner.getCustomerList().get(instance).getUsername()+", you have "+Owner.getCustomerList().get(instance).getPoints()+" points and are "
                +Owner.getCustomerList().get(instance).getStatus()+" status");
    }    
    
}
