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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
		
		
		BorderPane borderPane = new BorderPane();
		
		// Label for education
		Label label = new Label("Salas Activas:");
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		label.setFont(font);
		// list View for educational qualification
		ObservableList<String> names = FXCollections.observableArrayList(salas.getSalas());
		ListView<String> listView = new ListView<String>(names);
		listView.setMaxSize(900, 500);

		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent mouseEvent) {

	            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
	                if (mouseEvent.getClickCount() == 2) {
	                    String item = listView.getSelectionModel()
	                            .getSelectedItem();
	                    if (item != null) {
	                        StackPane pane = new StackPane();
	                        Scene scene = new Scene(pane);
	                        Stage stage = new Stage();
	                        stage.setScene(scene);

	                        pane.getChildren().add(
	                                new TextField(item));

	                        stage.show();
	                    }

	                }
	            }
	        }
	    });
		
		
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
		
		borderPane.setCenter(layout);
		
		
		HBox layout2 = new HBox(10);
		layout2.setPadding(new Insets(5, 5, 5, 50));
		layout2.getChildren().addAll(okBtn, salir);
		
		borderPane.setBottom(layout2);
		
		// Setting the stage
		Scene scene = new Scene(borderPane, 1024, 780);

		
		stage.setTitle("Another Chat - Lobby");

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
