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
public class TaxiFare extends Application{
    private TextField tripDistance;
    private TextField numPassengers;
    private Text Summary;
    private Text fareTotal;
    private Text shiftTotal;
    double shiftTot = 0;
    Double fareTot = 0.00;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle ("Taxi Fare Tracker");
    
        Label Label1 = new Label("Trip Distance (In Km)");
        tripDistance = new TextField();
        tripDistance.setPrefWidth(50);
        Label Label2 = new Label("Number Of Passengers");
        numPassengers = new TextField();
        numPassengers.setPrefWidth(50);
        Button calcButton = new Button ("Calculate");
        Button resetButton = new Button ("Reset");
        calcButton.setOnAction (this::processCalcReq);
        resetButton.setOnAction (this::processResetReq);
        Summary = new Text ("Taxi Fare Summary Report:");
        fareTotal = new Text ("   Taxi Fare for this trip:\t ");
        shiftTotal = new Text ("Shift Total (All Trips)");
        
    
        FlowPane pane = new FlowPane (Label1,tripDistance,
            Label2, numPassengers, calcButton,resetButton
            ,Summary, fareTotal, shiftTotal);
            
            pane.setAlignment(Pos.CENTER);
            pane.setHgap (10);
            pane.setVgap(20);
    
        Scene scene = new Scene (pane, 250,450);
    
        primaryStage.setScene (scene);
        primaryStage.show();
    
    }
    
    public void processCalcReq (ActionEvent event){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        
        double tripDist = Double.parseDouble(tripDistance.getText());
        Double numPas = Double.parseDouble(numPassengers.getText());
        
        if (numPas > 1){
            fareTot = 4.95 + (2*numPas - 2) +  (1.5 * tripDist);
            shiftTot = shiftTot + fareTot;
        }
        else {
            fareTot = 4.95 + (1.5*tripDist);
            shiftTot = shiftTot + fareTot;
        }

    
    fareTotal.setText("Taxi Fare for this trip: $" + nf.format(fareTot) + "\n");
    shiftTotal.setText("Shift Total (All Trips): $" + nf.format(shiftTot));
    }
    public void processResetReq (ActionEvent event){
        fareTotal.setText("Taxi Fare for this trip: $");
        shiftTotal.setText("Shift Total (All Trips): $");
        shiftTot = 0;
        fareTot = 0.00;
        numPassengers.setText("");
        tripDistance.setText("");
    }
    }
    
        


