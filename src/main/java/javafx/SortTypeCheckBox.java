package javafx;

import javafx.scene.control.CheckBox;
import sort.SortTypes;

public class SortTypeCheckBox extends CheckBox {

    private SortTypes.SortType sortType;

    public SortTypeCheckBox(SortTypes.SortType type) {
        super(type.getName());
        this.sortType = type;
        this.getStyleClass().add("check-box");
    }

    public SortTypes.SortType getSortType() {
        return sortType;
    }
}
