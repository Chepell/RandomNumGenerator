import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Artem Voytenko
 * 21.11.2018
 */

public class MainApp extends Application {
	TextField textField;
	CheckBox checkBox;
	Label labelResult;
	Randoms random;

	public static void main(String[] args) {
		// запуск JavaFX
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		random = new Randoms();
		// заголовок окна
		primaryStage.setTitle("RNG");
		// загрузка иконки из папки ресурсов
		Image icon = new Image(getClass().getResourceAsStream("iconRNDM.png"));
		// установка иконки приложения
		primaryStage.getIcons().add(icon);
		// компановка с зазорами
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		Scene scene = new Scene(rootNode, 220, 130);
		// запрет на изменение размера
		primaryStage.setResizable(false);
		// устанавливаю сцену на платформу
		primaryStage.setScene(scene);
		// создаю текстовое поле
		textField = new TextField();
		// создаю кнопку
		Button button = new Button("Generate!");
		// задать подсказку
		textField.setPromptText("Enter a number");
		// задать предпочтительное количество столбцов
		textField.setPrefColumnCount(8);
		// обработчки нажатия кнопки
		button.setOnAction(this::handle);
		// обработчик текстового поля, событие генерируется после нажатия клавиши Enter
		textField.setOnAction(this::handle);
		// создаю чекбокс
		checkBox = new CheckBox();
		// обработчик чекбокса
		checkBox.setOnAction(event -> {
			if (checkBox.isSelected()) {
				textField.setDisable(true);
				labelResult.setText("Нажмите кнопку Generate");
			} else {
				textField.setDisable(false);
				labelResult.setText("Введите верхнюю границу для числа");
			}
		});
		// создаю метку
		Label label = new Label("генерация дробного числа");
		// создать разделитель
		Separator separator = new Separator();
		// длина разделителя
		separator.setPrefWidth(215);
		// метка для результатов
		labelResult = new Label("Введите верхнюю границу для числа");
		Separator separator2 = new Separator();
		// длина разделителя
		separator2.setPrefWidth(215);
		// добавить все элементы в граф сцены
		rootNode.getChildren().addAll(textField, button, separator, checkBox, label, separator2, labelResult);
		// показать платформу
		primaryStage.show();
	}

	private void handle(ActionEvent ae) {
		if (checkBox.isSelected()) {
			labelResult.setText(random.getDouble());
		} else {
			int border;
			try {
				border = Integer.parseInt(textField.getText());
				labelResult.setText(random.getInt(border));
			} catch (Exception e) {
				labelResult.setText("Введите целое число!");
			}
		}
	}
}
