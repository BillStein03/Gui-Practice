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
import java.text.NumberFormat;

import javax.swing.Action;

/**
 * @author Bill Stein 3714982
 */

public class FrequentLetter extends Application{
    private TextField phrasetf;
    private Text bot;


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Most Frequent Letter Identifier");

        Label Label1 = new Label("Enter a Word of Phrase: ");
        phrasetf = new TextField();
        phrasetf.setPrefWidth(225);
        Button Submit = new Button("Submit");
        Submit.setOnAction(this::submitButton);
        bot = new Text ("Let me help you identify the most frequently ued letter!");


        FlowPane pane = new FlowPane (Label1, phrasetf, Submit, bot);
            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(20);


        Scene scene = new Scene (pane, 350, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void submitButton (ActionEvent event){


    String phrase = phrasetf.getText();

    int[] freq = new int [phrase.length()];
    char maxChar = phrase.charAt(0);
    int i, b, max;
    char string[] = phrase.toCharArray();
    for (i = 0; i < string.length; i++)
    {
        freq[i] = 1;
        for (b = i+1; b < string.length; b++)
        {
            if ((string[i] == string[b]) && string[i] != ' ' && string[i] != '0')
            {
                freq[i]++;
                string[b] = '0';

            }


        }

    }
    max = freq[0];
    for (i = 0; i < freq.length; i++)
    {
        if (max < freq[i]){
            max = freq[1];
            maxChar = string[i];
        }

    }
    bot.setText("The most frequently occuring letter is: " + maxChar);
    }

}
