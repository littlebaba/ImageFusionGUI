package listener;

import other.DealImageIcon;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class AddImageListener extends MouseAdapter {
    private JLabel jLabel;
    private JFileChooser fileChooser;
    private DealImageIcon dealImageIcon;
    private ArrayList<File> images;

    public AddImageListener(JLabel label, ArrayList<File> images) {
        this.jLabel = label;
        this.images=images;
        this.fileChooser = new JFileChooser(new File("F:\\paper2visio图\\实验数据"));
        this.dealImageIcon= new DealImageIcon();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount() == 2) {
            int i = fileChooser.showOpenDialog(jLabel);
            if (i == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (images.size()==2){
                    images.clear();
                }
                images.add(selectedFile);
                ImageIcon imageIcon = dealImageIcon.getImageIcon(selectedFile.getAbsolutePath());
                jLabel.setText("");
                jLabel.setIcon(imageIcon);
                jLabel.repaint();
            }
        }
    }
}
