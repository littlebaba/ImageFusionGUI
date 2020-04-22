package other;

import listener.AddImageListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class LabelManager {


    private ArrayList<File> images;

    public LabelManager() {
    }

    public LabelManager(ArrayList<File> images) {
        this.images = images;
    }

    public JLabel getFilledLabelWithImage(ImageIcon imageIcon, boolean isListen) {
        JLabel label;
        if (imageIcon == null) {
            label = getFilledLabelWithText("还未融合,请选择源图像和融合算法进行融合", isListen);
        } else {
            label = createJLabel(isListen);
            label.setIcon(imageIcon);
        }
        return label;
    }

    public JLabel getFilledLabelWithText(String text, boolean isListen) {
        JLabel label = createJLabel(isListen);
        label.setText(text);
        return label;
    }


    private JLabel createJLabel(boolean isListen) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new LineBorder(Color.RED));
        if (isListen) {
            AddImageListener addImageListener = new AddImageListener(label, images);
            label.addMouseListener(addImageListener);
        }
        return label;
    }

}
