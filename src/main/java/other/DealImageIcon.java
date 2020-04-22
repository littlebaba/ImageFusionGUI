package other;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DealImageIcon {

    public ImageIcon getImageIcon(String imagePath) {
        File file = new File(imagePath);
        if (file.exists()){
            int imageSize = 145;
            ImageIcon imageIcon = new ImageIcon(imagePath);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT));
            return imageIcon;
        }else{
            return null;
        }

    }

}
