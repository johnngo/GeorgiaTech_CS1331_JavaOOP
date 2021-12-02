import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Stage;

  public class DollarsToPounds extends Application {

      final static double EXCHANGE_RATE = 0.81;

      public void Start(Stage stage) {

      Label valueLbl = new Label("Input Value: ");

      Label poundsLbl = new Label();

      Label dollarsTxt = new Label();

      Button btn = new Button();

      exchangeBtn.setText("Exchange");

      exchangeBtn.setOnAction(event -> {
         String dollarsStr = userInput.getCharacters().toString();
         try {
              double dollars = Double.parseDouble(dollarsStr);
              double pounds = exchange(dollars);
              poundsLbl.setText(String.format("%.2f", pounds));
             } catch (NumberFormatException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                     a.setTitle("Error");
                     a.setHeaderText("Invalid Dollar Amount");
                     a.setContentText("Please only use digits.");
                     a.showAndWait();
            }
        });

        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren(valueLbl, poundsLbl);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(8);
        root.getChildren(input, scales, convertButton, result);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Dollars to Pounds");
        stage.setScene(scene);
        stage.show();
    }
    private double exchange(double dollars) {
       return dollars*EXCHANGE_RATE;
    }
}