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
    ComboBox<String> unitFromComboBox = new ComboBox<>();
    ComboBox<String> unitToComboBox = new ComboBox<>();
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
    unitFromComboBox = new ComboBox<>();
    unitFromComboBox.getItems().addAll("km", "m", "kg", "lb", "ft", "mi", "mph", "kph" );
    //unitFromComboBox.getItems().addAll("Kilometers", "Meters", "Kilograms", "Pounds", "Feet", "Miles", "Miles/Hour", "kilometer/hour" );
    gridPane.add(unitFromComboBox, 1, 0);

    gridPane.add(new Label("Imperial Unit"), 0, 1);
    unitToComboBox = new ComboBox<>();
    unitToComboBox.getItems().addAll("km", "m", "kg", "lb", "ft", "mi", "mph", "kph");
    //unitToComboBox.getItems().addAll("Kilometers", "Meters", "Kilograms", "Pounds", "Feet", "Miles", "Miles/Hour", "kilometer/hour");
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

    String fromUnit = unitFromComboBox.getValue();
    String toUnit = unitToComboBox.getValue();
    double value = Double.parseDouble(tfEntry.getText());

    System.out.println("fromUnit: " + fromUnit);
    System.out.println("toUnit: " + toUnit);
    System.out.println("value: " + value);

    try {
        value = Double.parseDouble(tfEntry.getText());
    } catch (NumberFormatException e) {
        tfResult.setText("Invalid input");
        return;
    }
    if (value < 0) {
        tfResult.setText("Invalid input");
        return;
    }

    double result = 0;
    switch (fromUnit + toUnit) {
        case "kmm":
            result = value * 1000;
            break;
        case "mkm":
            result = value / 1000;
            break;
        case "kglb":
            result = value * 2.20462;
            break;
        case "lbkg":
            result = value / 2.20462;
            break;
        case "ftm":
            result = value * .3048;
            break;
        case "mft":
            result = value / .3048;
            break;
        case "mikm":
            result = value * 1.609344;
            break;
        case "kmmi":
            result = value / 1.609344;
            break;
        case "mphkph":
            result = value * 1.609344;
            break;
        case "kphmph":
            result = value / 1.609344;
            break;
        default:
            tfResult.setText("Invalid input");
            return;
    }

    // Display result
    tfResult.setText(String.format("%.2f %s = %.2f %s", value, fromUnit, result, toUnit));
    }

}
