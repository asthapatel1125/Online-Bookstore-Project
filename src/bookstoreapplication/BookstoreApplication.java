/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Brian
 */
public class BookstoreApplication extends Application {
    private static Owner owner = new Owner();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Bookstore App");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                
                    @Override
                    public void handle(WindowEvent e) {
                       owner.updateBookList();
                       owner.updateCustomerList();
                    }
                });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        owner.fillBookList();
        owner.readCustomerList();
        launch(args);
        
        
        
    }
    
}