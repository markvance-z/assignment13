import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverter extends Application {
  private TextField tfEntry = new TextField();
  private TextField tfResult = new TextField();

  private Button btCalculate = new Button("Calculate");


  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    gridPane.add(new Label("Metric Unit"), 0, 0);
    ComboBox<String> unitFromComboBox = new ComboBox<>();
    unitFromComboBox.getItems().addAll("Meters", "Centimeters");
    gridPane.add(unitFromComboBox, 1, 0);

    gridPane.add(new Label("Imperial Unit"), 0, 1);
    ComboBox<String> unitToComboBox = new ComboBox<>();
    unitToComboBox.getItems().addAll("Feet", "Inches");
    gridPane.add(unitToComboBox, 1, 1);

    gridPane.add(new Label("Enter value:"), 0, 2);
    gridPane.add(tfEntry, 1, 2);
    gridPane.add(new Label("Result:"), 0, 3);
    gridPane.add(tfResult, 1, 3);

    gridPane.add(btCalculate, 1, 5);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfEntry.setAlignment(Pos.BOTTOM_RIGHT);
    tfResult.setAlignment(Pos.BOTTOM_RIGHT);
    tfResult.setStyle("-fx-background-color: rgba(211, 211, 211, 0.5)");
    tfResult.setEditable(false);
 
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    // Process events
    btCalculate.setOnAction(e -> calculate());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Metric Converter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  private void calculate() {
    // Get values from text fields

    

    // Display result


  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
