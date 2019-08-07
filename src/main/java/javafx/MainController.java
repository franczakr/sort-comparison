package javafx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sort.SortTypes;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;


public class MainController {
    private SortTypes sortTypes;

    @FXML
    private ListView<SortTypeCheckBox> sortList;
    @FXML
    private Label titleLabel;
    @FXML
    private TextArea logger;
    @FXML
    private TextField lengthField;
    @FXML
    private TextField maxValueField;

    @FXML
    public void initialize() {
        makeNumericField(lengthField, 2000, 100000000);
        makeNumericField(maxValueField, 10, 100000000);
    }

    private void makeNumericField(TextField field, int minValue, int maxValue) {
        field.setText(String.valueOf(minValue));
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            String text = newValue;
            if (!newValue.matches("\\d*")) {
                text = newValue.replaceAll("[^\\d]", "");
            }
            if(!text.isEmpty()) {
                int value = Integer.parseInt(field.getText());
                if(value < minValue) {
                    text = oldValue;
                }
                else if(value > maxValue) {
                    text = String.valueOf(maxValue);
                }
            }
            if(!text.equals(newValue)) {
                field.setText(text);
            }
        });
    }

    public void setSortTypes(SortTypes types) {
        this.sortTypes = types;
        for (SortTypes.SortType type : sortTypes.getSortTypes().stream().sorted(Comparator.comparingInt(s -> s.order)).collect(Collectors.toList())) {
            SortTypeCheckBox checkBox = new SortTypeCheckBox(type);
            checkBox.setSelected(true);
            sortList.getItems().add(checkBox);
        }
    }

    @FXML
    public void onClick() {
        logger.setText("");
        for (SortTypeCheckBox checkBox : sortList.getItems()) {
            checkBox.setDisable(true);
        }
        int length = Integer.parseInt(lengthField.getText());
        int maxValue = Integer.parseInt(maxValueField.getText());
        new Thread(() -> {
            int[] a = new Random().ints(length, 1, maxValue).toArray();
            for (SortTypeCheckBox checkBox : sortList.getItems()) {
                if (checkBox.isSelected()) {
                    if(length >= 1e5)Platform.runLater(() -> titleLabel.setText("Trwa sortowanie: " + checkBox.getSortType().getName()));
                    long start = System.currentTimeMillis();
                    sortTypes.getSortAlgorithm(checkBox.getSortType()).sort(a);
                    long time = System.currentTimeMillis() - start;
                    Platform.runLater(() -> logger.appendText(checkBox.getSortType() + ": " + time + " ms" + System.lineSeparator()));
                }
            }
            Platform.runLater(() -> {
                titleLabel.setText("");
                for (SortTypeCheckBox checkBox : sortList.getItems()) {
                    checkBox.setDisable(false);
                }
            });
        }).start();
    }

}
