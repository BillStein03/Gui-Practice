import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent; 

/**
 * @author Bill Stein #3714982
 */

public class ConverterApp extends Application {
    private TextField TF;
    private Text head;
    private Text bot;



    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle ("Converter App");
        
        TF = new TextField();
        TF.setPrefWidth(150);

        Button B2D = new Button ("Binary to Decimal");
        Button E2E = new Button ("English to Encrypted");
        
        B2D.setOnAction(this::B2BR);
        E2E.setOnAction(this::E2ER);
        head = new Text ("Enter a binary value or English word/prase");
        bot = new Text ("Welcome to the Converter App!");        


        FlowPane pane = new FlowPane(head,TF,B2D,E2E,bot);

            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(20);

        Scene scene = new Scene (pane,250,350);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void B2BR (ActionEvent event){
        String a = TF.getText();
        String b = Converter.bin2decimal(a);
        bot.setText(b);
        

    }
    public void E2ER (ActionEvent event){
        
        String a = TF.getText();
        String b = Converter.english2encrypted(a);
        bot.setText(b);
        
        
        
    }

}
