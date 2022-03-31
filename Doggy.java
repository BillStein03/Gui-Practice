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

/**
 * @author Bill Stein 3714982
 */
public class Doggy extends Application{
    private TextField ownerName;
    private TextField numMods;
    private TextField numSess;
    private Text Bottom1;
    private Text Bottom2;
    int max = 6;
    int min = 2;
    double price;

        public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("6-Month Pass Calculator");    
    
        Label Label1 = new Label("Owner Name: ");
        ownerName = new TextField();
        ownerName.setPrefWidth(75);
        Label Label2 = new Label("Number of Training Modules:");
        numMods = new TextField();
        numMods.setPrefWidth(40);
        Label Label3 = new Label("Number of Grooming Sessions:");
        numSess = new TextField();
        numSess.setPrefWidth(40);

        Button halfDay = new Button ("Half-Day");
        Button fullDay = new Button("Full-Day");
        Button clear = new Button("Clear");

        halfDay.setOnAction (this::halfDayReq);
        fullDay.setOnAction (this::fullDayReq);
        clear.setOnAction (this::clearReq);

        Bottom1 = new Text ("Welcome to Barks & Recreation!");
        Bottom2 = new Text ("Enter your pass information.");

        FlowPane pane = new FlowPane(Label1, ownerName, Label2, numMods, Label3, numSess,halfDay,fullDay,clear,Bottom1,Bottom2);
            pane.setAlignment(Pos.CENTER);
            pane.setHgap(10);
            pane.setVgap(20);

        Scene scene = new Scene (pane, 250,400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void halfDayReq (ActionEvent event){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);


        double trainingMod = Double.parseDouble(numMods.getText());
        double groomingSes = Double.parseDouble(numSess.getText());

        int lot = (int)Math.floor(Math.random()*(max-min+1)+min);
        if (trainingMod == 1){
             price = 1944 + (65*groomingSes) + 85;
        }
        else {
             price = 1944 + (65*groomingSes) + (70 * (trainingMod -1 )) + 85;
        }

        Bottom1.setText("Caining Cottage Number: " + lot + "\n");
        Bottom2.setText("Total Cost of Pass: $" + nf.format(price));
    }
    public void fullDayReq (ActionEvent event){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);


        double trainingMod = Double.parseDouble(numMods.getText());
        double groomingSes = Double.parseDouble(numSess.getText());

        int lot = 1;

        price = 2916 + ((groomingSes *65) -65) + (60*trainingMod);

        Bottom1.setText("Caining Cottage Number: " + lot + "\n");
        Bottom2.setText("Total Cost of Pass: $" + nf.format(price));

    }
    public void clearReq (ActionEvent event){
        Bottom1.setText("Welcome to Barks & Recreation!");
        Bottom2.setText("Enter your pass information.");
        ownerName.setText("");
        numMods.setText("");
        numSess.setText("");

    }


 }