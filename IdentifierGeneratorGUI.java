import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class IdentifierGeneratorGUI extends Application { 
   
   private TextField bookTitleField;
   private TextField minCharsField;
   private Text result;
   
   public void start (Stage primaryStage) {        
      // ********** Add ONE line of source code here (at this place in the start method):    

      
      Label bookTitleLabel = new Label ("Enter the book title:");
      bookTitleField = new TextField ();
      bookTitleField.setPrefWidth (400);
      
      Label minCharsLabel = new Label ("Enter the minimum number of characters:");
      minCharsField = new TextField ();
      minCharsField.setPrefWidth (40);

      Button generateButton = new Button ("Generate ID"); 
		// ********** Add ONE line of source code here (at this place in the start method): 
      
      
      result = new Text ("Ready to generate a book ID!");  
  
      FlowPane pane = new FlowPane (bookTitleLabel, bookTitleField, 
			minCharsLabel, minCharsField, generateButton, result); 
      pane.setAlignment (Pos.CENTER);
      pane.setHgap (10);
      pane.setVgap (20);
      
      Scene scene = new Scene (pane, 500, 200);
      
		primaryStage.setScene (scene);
      
		// ********** Add ONE line of source code here (at this place in the start method):
      
      
   }//end start method


   public void generateID (ActionEvent event) { 
   	// ********** Complete the body of this generateID method:
      // (Add as many lines as you need inside this method.)
      
      
      
      
   }//end generateID method
              
}