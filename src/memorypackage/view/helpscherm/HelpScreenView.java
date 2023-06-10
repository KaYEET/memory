package memorypackage.view.helpscherm;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HelpScreenView extends BorderPane {
    private Label helpLabel;

    public HelpScreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        helpLabel = new Label("Hoe werkt memory?\n\nHet spelletje Memory is wereldberoemd en ook gelijk één van de simpelste gezelschapsspellen ooit. Het doel is om setjes te maken van twee identieke kaarten. Er zijn 20 kaarten op het scherm en de speler moet deze omkeren.\nJe mag telkens twee kaarten omdraaien. Het is belangrijk om de plaats van de kaartjes te onthouden! Als je een setje hebt gevonden worden deze kaartjes gelocked en kan je verder zoeken naar de resterende kaartjes" +
                "\n\nControls:\n\nJe kan kaartjes aanklikken met de muis, of ze selecteren met de pijltjestoetsen en bevestigen met enter. Je kan ook door het hele raster van kaartjes lopen door tab te gebruiken. Het de-selecteren gebeurt automatisch!" +
                "\n\nTips:\n\nJe kan een tip krijgen door eerst een vakje aan te klikken en dan ergens op het scherm te klikken met je rechtermuisknop.\nDeze zal dan het andere kaartje laten zien.");

    }

    private void layoutNodes() {
        this.setCenter(helpLabel);
    }
}
