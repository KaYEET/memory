package memorypackage.view.startscherm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StartScreenView extends BorderPane {
    private Button startGameButton;
    private Button helpButton;
    private TextField nameField;
    private Image memoryImage;
    private BackgroundImage backgroundImage;
    private Background background;

    public StartScreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        startGameButton = new Button("Start");
        helpButton = new Button("Help");
        nameField = new TextField();
        nameField.setPromptText("Naam:");
        nameField.setMaxWidth(100);

        //alles voor achtergrondfoto:
        memoryImage = new Image("/memoryBanner.png", 390, 180, false, false);
        backgroundImage = new BackgroundImage(memoryImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, true));
        background = new Background(backgroundImage);
    }

    private void layoutNodes() {
        setTop(nameField);
        setCenter(startGameButton);
        setBottom(helpButton);
        setBackground(background);

        BorderPane.setAlignment(nameField, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(startGameButton, Pos.CENTER);

        BorderPane.setAlignment(helpButton, Pos.TOP_CENTER);
        BorderPane.setMargin(nameField, new Insets(10, 0, 0, 0));
        BorderPane.setMargin(helpButton, new Insets(0, 0, 10, 0));
    }

    public Button getStartGameButton() {
        return startGameButton;
    }

    public Button getHelpButton() {
        return helpButton;
    }

    public String getPlayerName() {
        return nameField.getText();
    }
}
