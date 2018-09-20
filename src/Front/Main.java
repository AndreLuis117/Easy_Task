package Front;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {






    @Override
    public void start(Stage primaryStage) throws Exception {
        //carregar a tela
        Parent root = FXMLLoader.load(getClass().getResource("TelaDeLogin.fxml"));
        primaryStage.setTitle("Tela de Login");
        //atribui o nome da janela
        //atribui o tamanho da janela
        primaryStage.setScene(new Scene(root, 1366, 768));
        //exibe a janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}



