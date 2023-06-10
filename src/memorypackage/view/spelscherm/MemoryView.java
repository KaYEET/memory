package memorypackage.view.spelscherm;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import memorypackage.model.BoardModel;

public class MemoryView extends GridPane {

    private Button[] btn = new Button[20];
    private Label minutes;
    private Label seconds;
    private Label colon;
    //Bij het maken van ons bord gebruiken we een array vanuit het model om zo 2 kaartjes te kunnen linken met elkaar
    BoardModel boardModel = new BoardModel(4, 5);

    public MemoryView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        int counterx = 0;
        int countery = 0;
        Image backgroundImage = new Image("backgroundCard.png");

        //Het plaatsen van de buttons hoeft niet in een andere forloop in de layoutNodes(), en mag hier dus blijven staan.
        for (int i = 0; i < 20; i++) {
            btn[i] = new Button("", new ImageView(backgroundImage));
            btn[i].setMaxSize(120, 120);
            btn[i].setId(Integer.toString(boardModel.getNumberCard()[countery][counterx]));
            add(btn[i], counterx, countery);
            counterx++;
            if (counterx == 4) {
                counterx = 0;
                countery++;
            }
        }
        seconds = new Label("00");
        minutes = new Label("00");
        colon = new Label(":");
    }

    private void layoutNodes() {
        add(seconds, 8, 0);
        add(minutes, 6, 0);
        add(colon, 7, 0);

        // Kan niet in for loop, sommige buttons hebben andere insets nodig dan andere
        GridPane.setMargin(btn[0], new Insets(5, 5, 5, 5));
        GridPane.setMargin(btn[1], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[2], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[3], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[4], new Insets(0, 5, 5, 5));
        GridPane.setMargin(btn[5], new Insets(0, 5, 5, 0));
        GridPane.setMargin(btn[6], new Insets(0, 5, 5, 0));
        GridPane.setMargin(btn[7], new Insets(0, 5, 5, 0));
        GridPane.setMargin(btn[8], new Insets(5, 5, 5, 5));
        GridPane.setMargin(btn[9], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[10], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[11], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[12], new Insets(5, 5, 5, 5));
        GridPane.setMargin(btn[13], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[14], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[15], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[16], new Insets(5, 5, 5, 5));
        GridPane.setMargin(btn[17], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[18], new Insets(5, 5, 5, 0));
        GridPane.setMargin(btn[19], new Insets(5, 5, 5, 0));
    }

    //getters:
    public Button[] getBtn() {
        return btn;
    }

    public Label getMinutes() {
        return minutes;
    }

    public Label getSeconds() {
        return seconds;
    }

    public Label getColon() {
        return colon;
    }
}
