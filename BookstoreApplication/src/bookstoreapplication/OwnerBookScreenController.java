/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class OwnerBookScreenController implements Initializable{

    /**
     * Initializes the controller class.
     */
    private Owner owner = new Owner();
     
    private ArrayList<Book> bookList = owner.getBookList();
    private ObservableList<Book> bookData;
            
    @FXML
    TableView<Book> ownerBookTable;

    @FXML
    private TableColumn<Book, String> bookName;
    @FXML
    private TableColumn<Book, Double> bookPriceVal;
    @FXML
    private TableColumn<Book, String>checkBoxColumn;
        
    @FXML
    TextField bookNameField, bookPriceField;
    
    @FXML
    public void handleAdd(ActionEvent event)
    {
        double bookPrice;
       bookPrice = Double.parseDouble(bookPriceField.getText());
       bookList.add(new Book(bookNameField.getText(), bookPrice ));
       
       bookData.setAll(bookList);
        ownerBookTable.getItems().setAll(bookData);
        bookNameField.clear();
        bookPriceField.clear();
        ownerBookTable.refresh();
    }
    
    @FXML
    public void handleDelete(ActionEvent event)
    {
        ArrayList<Book> toDelete = new ArrayList();
        for(int i = 0; i<bookList.size(); i++)
        {
            if(bookList.get(i).getSelection().isSelected())
            {
                toDelete.add(bookList.get(i));
            }
           
        }
        bookList.removeAll(toDelete);
        bookData.setAll(bookList);
        ownerBookTable.getItems().setAll(bookData);
        ownerBookTable.refresh();
      
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
       bookData = FXCollections.<Book>observableArrayList(bookList);
      
        
                
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookPriceVal.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<>("selection"));
        ownerBookTable.getItems().setAll(bookData);
       

        
       
        
        
    }
}