package panel;

import other.LabelManager;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class SourceImagePanel extends BasePanel {
    private ArrayList<File> images;
    private LabelManager labelManager;

    public SourceImagePanel() {
        this.images = new ArrayList<>();
        this.labelManager = new LabelManager(images);
    }

    public void render() {
        add(labelManager.getFilledLabelWithText("双击面板选择源图像", true));
        add(labelManager.getFilledLabelWithText("双击面板选择源图像", true));
    }

    public void initializeLayout() {
        GridLayout gridLayout = new GridLayout(1, 2);
        gridLayout.setHgap(10);
        setLayout(gridLayout);
    }


    public ArrayList<File> getImages() {
        return images;
    }
}
