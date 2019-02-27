package front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {






    @Override
    public void start(Stage primaryStage) throws Exception {


        //carregar a tela
        Parent root = FXMLLoader.load(getClass().getResource("TelaDeLogin.fxml"));
        //atribui o nome da janela
        primaryStage.setTitle("Tela de Login");
        //atribui o tamanho da janela
        primaryStage.setScene(new Scene(root, 800, 600));
        //deixar a tela sem o botão de redimensionar
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        //exibe a janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}



