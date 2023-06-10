package memorypackage.view.helpscherm;

import memorypackage.model.BoardModel;

public class HelpScreenPresenter {
    BoardModel model;
    HelpScreenView view;

    public HelpScreenPresenter(BoardModel model, HelpScreenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {
    }

}
