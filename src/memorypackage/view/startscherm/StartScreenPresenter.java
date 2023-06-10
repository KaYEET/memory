package memorypackage.view.startscherm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import memorypackage.model.BoardModel;
import memorypackage.view.helpscherm.HelpScreenPresenter;
import memorypackage.view.helpscherm.HelpScreenView;
import memorypackage.view.spelscherm.MemoryPresenter;
import memorypackage.view.spelscherm.MemoryView;

public class StartScreenPresenter {
    BoardModel model;
    StartScreenView view;

    public StartScreenPresenter(BoardModel model, StartScreenView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getStartGameButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                MemoryView memoryView = new MemoryView();
                model.setPlayerName(view.getPlayerName());
                MemoryPresenter memoryPresenter = new MemoryPresenter(model, memoryView);
                view.getScene().setRoot(memoryView);
                memoryView.getScene().getWindow().sizeToScene();
                memoryView.getScene().getWindow().setWidth(625);
                memoryView.getScene().getWindow().centerOnScreen();
            }
        });

        view.getHelpButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HelpScreenView helpScreenView = new HelpScreenView();
                HelpScreenPresenter presenter = new HelpScreenPresenter(model, helpScreenView);
                Stage helpScreenStage = new Stage();
                helpScreenStage.initOwner(view.getScene().getWindow());
                helpScreenStage.initModality(Modality.APPLICATION_MODAL);
                helpScreenStage.setScene(new Scene(helpScreenView));
                helpScreenStage.setTitle("Help");
                helpScreenStage.setHeight(400);
                helpScreenStage.setWidth(1400);
                helpScreenStage.showAndWait();
            }
        });
    }

    private void updateView() {
    }
}
