/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.awt.Component;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;


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

       for(Book b : ownerBookTable.getItems()){
            if(b.getBookName().equals(bookNameField.getText())){
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "This book already exists in the table!","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(bookNameField.getText().equals("")||bookPriceField.getText().equals("")){
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "One of the textfields is empty!","ERROR", JOptionPane.ERROR_MESSAGE);
        }else{

            try{
        bookPrice = Double.parseDouble(bookPriceField.getText());
            }
            catch(Exception p)
            {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Invalid Book Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
       bookList.add(new Book(bookNameField.getText(), bookPrice ));



       bookData.setAll(bookList);
        ownerBookTable.getItems().setAll(bookData);
        bookNameField.clear();
        bookPriceField.clear();
        ownerBookTable.refresh();
        }
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
                stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                
                    @Override
                    public void handle(WindowEvent e) {
                      owner.updateBookList();
                      owner.updateCustomerList();
                    }
                });
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