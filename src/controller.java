import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller {

    @FXML
    private Label celciusLabel;

    @FXML
    private TextField celciusTf;

    @FXML
    private Label fahrenheitLabel;

    @FXML
    private TextField fahrenheitTf;

    @FXML
    private TextField resultTf;

    public void initialize() {
        resultTf.setDisable(true);

        fahrenheitTfSettings(false);
    }

    @FXML
    void convertBtn(ActionEvent event) {
        if (fahrenheitTf.isVisible()) {
            // convert fahrenheit to celcius
            double d;

            if (fahrenheitTf.getText() == null) {
                setAlert("Please enter a numeric value");
                return;
            }

            try {
                d = Double.parseDouble(fahrenheitTf.getText());
            } catch (NumberFormatException nfe) {
                setAlert("Please enter a numeric value");
                return;
            }

            double celcius = (d - 32) * 5 / 9;

            resultTf.setText("°C " + String.format("%.2f", celcius));

            fahrenheitTf.setText(null);

        } else {
            // convert celcius to fahrenheit
            double d;

            if (celciusTf.getText() == null) {
                setAlert("Please enter a numeric value");
                return;
            }

            try {
                d = Double.parseDouble(celciusTf.getText());
            } catch (NumberFormatException nfe) {
                setAlert("Please enter a numeric value");
                return;
            }

            double fahrenheit = (d * 9 / 5) + 32;

            resultTf.setText("°F " + String.format("%.2f", fahrenheit));

            celciusTf.setText(null);
        }
    }

    @FXML
    void switchBtn(ActionEvent event) {
        resultTf.setText(null);

        fahrenheitTf.setText(null);
        celciusTf.setText(null);

        if (fahrenheitTf.isVisible()) {
            celciusTfSettings(true);

            fahrenheitTfSettings(false);
        } else {
            celciusTfSettings(false);

            fahrenheitTfSettings(true);
        }
    }

    private void fahrenheitTfSettings(boolean value) {
        fahrenheitTf.setVisible(value);
        fahrenheitLabel.setVisible(value);
    }

    private void celciusTfSettings(boolean value) {
        celciusTf.setVisible(value);
        celciusLabel.setVisible(value);
    }

    private void setAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
