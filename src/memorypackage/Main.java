package memorypackage;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
import memorypackage.model.BoardModel;
import memorypackage.view.startscherm.StartScreenPresenter;
import memorypackage.view.startscherm.StartScreenView;
/**
 * This class isn't responsible for launching the game, this happens in the Launcher class.
 * @author Niels Verstrepen, Kai Ekkart
 * @version 1.0
 * @version JDK 11.08
 * @since 25 March 2022
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BoardModel model = new BoardModel(4, 5);
        StartScreenView view = new StartScreenView();

        StartScreenPresenter presenter = new StartScreenPresenter(model, view);
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MemoryStartScherm");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(200);

        //Min & max hoogte & breedte van startscherm

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
