package memorypackage.view.spelscherm;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import memorypackage.model.BoardModel;
import memorypackage.model.HighscoresModel;
import memorypackage.model.TimerModel;
import memorypackage.view.startscherm.StartScreenPresenter;
import memorypackage.view.startscherm.StartScreenView;

import java.util.Optional;
/**
 * This class is responsible for visualizing the board.
 * @author Niels Verstrepen, Kai Ekkart
 * @version 1.0
 * @version JDK 11.08
 * @since 25 March 2022
 */
public class MemoryPresenter {
    //afbeeldingen:
    Image blueDragon = new Image("kaartjes/blueDragon.png");
    Image greenDragon = new Image("kaartjes/greenDragon.png");
    Image orangeDragon = new Image("kaartjes/orangeDragon.png");
    Image purpleDragon = new Image("kaartjes/purpleDragon.png");
    Image redDragon = new Image("kaartjes/redDraak.png");
    Image cookieMonster = new Image("kaartjes/cookieMonster.png");
    Image jellyMonster = new Image("kaartjes/jellyMonster.png");
    Image catMonster = new Image("kaartjes/catMonster.png");
    Image brainMonster = new Image("kaartjes/brainMonster.png");
    Image ghostMonster = new Image("kaartjes/ghostMonster.png");
    Image backGroundCard = new Image("backgroundCard.png");

    //main view & model:
    BoardModel model;
    MemoryView view;

    //variabelen voor check:
    int firstPressedButtonValue, secondPressedButtonValue;
    int countClicks = 0;
    int countTotalClicks = 0;
    int firstPressedButtonPlace;
    int secondPressedButtonPlace;
    int counterCorrectMatches;

    //alles voor timer:
    TimerModel timerModel;
    private Timeline timerTimeline;

    public MemoryPresenter(BoardModel model, MemoryView view) {
        this.model = model;
        this.view = view;

        setupTimeline();
        timerModel = new TimerModel();

        timerTimeline.play();
        timerModel.tick();

        timerModel.setTimer(System.currentTimeMillis());
        addEventHandlers();
        updateView();
    }

    /**
     * This addEventHandlers is responsible for turning around the cards.
     */
    private void addEventHandlers() {
        for (int i = 0; i < 20; i++) {
            int buttonNumber = i;
            view.getBtn()[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    countClicks++;
                    countTotalClicks++;

                    view.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                                for (int j = 0; j < 20; j++) {
                                    if (model.CompareButtonOneWithButtonTwo(Integer.parseInt(view.getBtn()[buttonNumber].getId()), Integer.parseInt(view.getBtn()[j].getId()))) {
                                        switch (Integer.parseInt(view.getBtn()[buttonNumber].getId())) {
                                            case 1:
                                            case 11:
                                                view.getBtn()[j].setGraphic(new ImageView(blueDragon));
                                                break;
                                            case 2:
                                            case 12:
                                                view.getBtn()[j].setGraphic(new ImageView(greenDragon));
                                                break;
                                            case 3:
                                            case 13:
                                                view.getBtn()[j].setGraphic(new ImageView(orangeDragon));
                                                break;
                                            case 4:
                                            case 14:
                                                view.getBtn()[j].setGraphic(new ImageView(purpleDragon));
                                                break;
                                            case 5:
                                            case 15:
                                                view.getBtn()[j].setGraphic(new ImageView(redDragon));
                                                break;
                                            case 6:
                                            case 16:
                                                view.getBtn()[j].setGraphic(new ImageView(cookieMonster));
                                                break;
                                            case 7:
                                            case 17:
                                                view.getBtn()[j].setGraphic(new ImageView(jellyMonster));
                                                break;
                                            case 8:
                                            case 18:
                                                view.getBtn()[j].setGraphic(new ImageView(catMonster));
                                                break;
                                            case 9:
                                            case 19:
                                                view.getBtn()[j].setGraphic(new ImageView(brainMonster));
                                                break;
                                            case 10:
                                            case 20:
                                                view.getBtn()[j].setGraphic(new ImageView(ghostMonster));
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    });

                    switch (Integer.parseInt(view.getBtn()[buttonNumber].getId())) {
                        case 1:
                        case 11:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(blueDragon));
                            break;
                        case 2:
                        case 12:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(greenDragon));
                            break;
                        case 3:
                        case 13:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(orangeDragon));
                            break;
                        case 4:
                        case 14:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(purpleDragon));
                            break;
                        case 5:
                        case 15:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(redDragon));
                            break;
                        case 6:
                        case 16:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(cookieMonster));
                            break;
                        case 7:
                        case 17:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(jellyMonster));
                            break;
                        case 8:
                        case 18:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(catMonster));
                            break;
                        case 9:
                        case 19:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(brainMonster));
                            break;
                        case 10:
                        case 20:
                            view.getBtn()[buttonNumber].setGraphic(new ImageView(ghostMonster));
                            break;
                    }

                    if (countClicks == 3) {
                        countClicks = 1;
                        if (model.CompareButtonOneWithButtonTwo(firstPressedButtonValue, secondPressedButtonValue)) {
                            view.getBtn()[firstPressedButtonPlace].setDisable(true);
                            view.getBtn()[secondPressedButtonPlace].setDisable(true);
                            counterCorrectMatches++;
                        } else {
                            view.getBtn()[firstPressedButtonPlace].setDisable(false);
                            view.getBtn()[secondPressedButtonPlace].setDisable(false);
                            view.getBtn()[firstPressedButtonPlace].setGraphic(new ImageView(backGroundCard));
                            view.getBtn()[secondPressedButtonPlace].setGraphic(new ImageView(backGroundCard));
                        }
                    }

                    if (countClicks == 1) {
                        firstPressedButtonValue = Integer.parseInt(view.getBtn()[buttonNumber].getId());
                        firstPressedButtonPlace = buttonNumber;
                        view.getBtn()[firstPressedButtonPlace].setDisable(true);
                    } else if (countClicks == 2) {
                        secondPressedButtonValue = Integer.parseInt(view.getBtn()[buttonNumber].getId());
                        secondPressedButtonPlace = buttonNumber;
                        view.getBtn()[secondPressedButtonPlace].setDisable(true);
                        if (counterCorrectMatches == 9) {
                            StartScreenView startScreenView = new StartScreenView();
                            StartScreenPresenter startScreenPresenter = new StartScreenPresenter(model, startScreenView);
                            final Alert endGame = new Alert(Alert.AlertType.INFORMATION);

                            String playerName = model.getPlayerName();
                            HighscoresModel highscoresModel = new HighscoresModel();
                            highscoresModel.saveToFile(String.format("%s %s %s%n", playerName, countTotalClicks, timerModel.calculateTimer()));
                            timerTimeline.stop();
                            endGame.setHeaderText("Gefeliciteerd " + playerName + ", u bent gewonnen, in " + countTotalClicks + " kliks en in " + timerModel.calculateTimer() + " seconden!");

                            endGame.setContentText("Wilt u terug gaan naar het startscherm?");
                            boolean clickedCorrect = false;
                            while (!clickedCorrect) {
                                try {
                                    Optional<ButtonType> keuze = endGame.showAndWait();
                                    if (keuze.get().getText().equalsIgnoreCase("OK")) {

                                        view.getScene().setRoot(startScreenView);
                                        startScreenView.getScene().getWindow().sizeToScene();
                                        startScreenView.getScene().getWindow().centerOnScreen();
                                        startScreenView.getScene().getWindow().setHeight(200);
                                        startScreenView.getScene().getWindow().setWidth(400);
                                        clickedCorrect = true;
                                    }

                                } catch (Exception e) {
                                    try {
                                        Thread.sleep(5000);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    clickedCorrect = false;
                                }
                            }
                        }
                    }
                }
            });

        }
    }

    private void updateView() {
        view.getMinutes().setText(String.format("%02d", timerModel.getMinutes()));
        view.getSeconds().setText(String.format("%02d", timerModel.getSeconds()));

    }

    private void setupTimelineBasis() {
        timerTimeline = new Timeline(new KeyFrame(
                Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timerModel.tick();
                updateView();
            }
        }));
        timerTimeline.setCycleCount(Animation.INDEFINITE);
    }

    private void setupTimeline() {
        timerTimeline = new Timeline();
        timerTimeline.setCycleCount(Animation.INDEFINITE);
        updateClockSpeed();
    }

    private void updateClockSpeed() {
        timerTimeline.getKeyFrames().clear();
        timerTimeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timerModel.tick();
                updateView();
            }
        }));
    }

    public int getCountTotalClicks() {
        return countTotalClicks;
    }
}
