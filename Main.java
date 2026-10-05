package app;

import app.controller.NotasController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TextField input = new TextField();
        input.setPromptText("Escribe una nota y presiona Enter...");

        Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");

        Label lblContador = new Label("0 notas");

        ListView<String> lista = new ListView<>();

        NotasController controller =
                new NotasController(input, lista, lblContador);

        // Evento de botón
        btnAgregar.setOnAction(controller::manejarAgregar);

        // Evento de botón
        btnEliminar.setOnAction(controller::manejarEliminar);

        // Evento de teclado
        input.setOnKeyPressed(controller::manejarTeclado);

        // Evento de ratón
        lista.setOnMouseClicked(controller::manejarMouse);

        HBox barra = new HBox(
                8,
                input,
                btnAgregar,
                btnEliminar,
                lblContador
        );

        barra.setPadding(new Insets(10));

        HBox.setHgrow(
                input,
                Priority.ALWAYS
        );

        BorderPane root = new BorderPane();

        root.setTop(barra);
        root.setCenter(lista);

        BorderPane.setMargin(
                lista,
                new Insets(0, 10, 10, 10)
        );

        Scene scene =
                new Scene(root, 650, 400);

        stage.setTitle(
                "Notas Rápidas - JavaFX"
        );

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}