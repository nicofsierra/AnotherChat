package unlam.prograva.taller.graphics;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import unlam.prograva.taller.sala.Sala;

public class Principal extends Application {

	Sala salas = new Sala();
	String sala;

	@Override
	public void start(Stage stage) {

		salas.CrearSala("nico");

		Pane pane = new Pane();

		// Label for education
		Label label = new Label("Educational qualification:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		// list View for educational qualification
		ObservableList<String> names = FXCollections.observableArrayList(salas.getSalas());
		ListView<String> listView = new ListView<String>(names);
		listView.setMaxSize(200, 160);

		Button okBtn = new Button();
		okBtn.setText("Crear Sala");
		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sala = crearSala();
				listView.getItems().add(sala);
				System.out.println(salas.toString());
			}
		});
		Button salir = new Button();
		salir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		salir.setText("Salir");

		// Creating the layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(5, 5, 5, 50));
		layout.getChildren().addAll(label, listView);
		layout.setStyle("-fx-background-color: BEIGE");
		layout.getChildren().addAll(okBtn, salir);

		// Setting the stage
		Scene scene = new Scene(layout, 595, 200);
		stage.setTitle("List View Example");

		stage.setScene(scene);
		stage.show();

	}

	public String crearSala() {
		TextInputDialog nombre = new TextInputDialog();
		nombre.setTitle("Crear Sala");
		nombre.setHeaderText("Ingrese Nombre de la Sala");
		Optional<String> respuesta = nombre.showAndWait();
		salas.CrearSala(respuesta.get());
		return respuesta.get();
	}

	public static void main(String[] args) {
		// ,javafx.media
		launch();
	}
}
