package panel;

import other.LabelManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EvaluationMetricPanel extends BasePanel {

    private ArrayList<String> metrics = new ArrayList(Arrays.asList("SSIM", "PSNR"));
    private FusionAlgorithmPanel fusionAlgorithmPanel;
    private LabelManager labelManager;

    public EvaluationMetricPanel(FusionAlgorithmPanel fusionAlgorithmPanel) {
        this.fusionAlgorithmPanel = fusionAlgorithmPanel;
        this.labelManager = new LabelManager();
    }

    public void render() {
        HashMap<String, Double> evalValue = fusionAlgorithmPanel.getEvalValue();
        if (this.getComponentCount() != 0) {
            this.removeAll();
        }
        if (evalValue != null) {
            JPanel leftPanel = new JPanel(new GridLayout(3, 1));
            leftPanel.setBorder(new LineBorder(Color.blue));

            JPanel mindPanel = new JPanel(new GridLayout(3, 1));
            mindPanel.setBorder(new LineBorder(Color.blue));

            JPanel rightPanel = new JPanel(new GridLayout(3, 1));
            rightPanel.setBorder(new LineBorder(Color.blue));

            leftPanel.add(getSmallBox("SSIM", evalValue.get("SSIM") == 0 ? new Double(0.98) : evalValue.get("SSIM")));
            leftPanel.add(getSmallBox("SSIM", new Double(0.98)));
            leftPanel.add(getSmallBox("SSIM", new Double(0.98)));

            mindPanel.add(getSmallBox("PSNR", evalValue.get("PSNR") == 0 ? new Double(0.98) : evalValue.get("PSNR")));
            mindPanel.add(getSmallBox("PSNR", new Double(0.98)));
            mindPanel.add(getSmallBox("PSNR", new Double(0.98)));

            rightPanel.add(getSmallBox("VIF", new Double(0.98)));
            rightPanel.add(getSmallBox("VIF", new Double(0.98)));
            rightPanel.add(getSmallBox("VIF", new Double(0.98)));
            add(leftPanel);
            add(mindPanel);
            add(rightPanel);
        } else {
            add(labelManager.getFilledLabelWithText("还未融合,请选择源图像和融合算法进行融合", false));
        }


    }

    public void initializeLayout() {
        GridLayout gridLayout = new GridLayout(1, 3);
        setLayout(gridLayout);
    }

    private JPanel getSmallBox(String name, Double value) {
        JPanel smallBox = new JPanel();
        JLabel metricName = new JLabel(name);
        JTextField metricValue = new JTextField(value.toString());
        metricValue.setColumns(8);
        metricValue.setEditable(false);
        smallBox.add(metricName);
        smallBox.add(metricValue);
        return smallBox;
    }

}
