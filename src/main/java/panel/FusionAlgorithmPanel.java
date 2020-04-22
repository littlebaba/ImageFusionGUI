package panel;

import algorithms.Algorithm;
import metrics.Metric;
import metrics.PSNR;
import metrics.SSIM;
import listener.SelectFusionMethodListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

public class FusionAlgorithmPanel extends BasePanel {

    private String[] methods = {"NSCT", "NSST", "DTCWT"};
    private JLabel label;
    private JButton button;
    private JComboBox<String> comboBox;
    private SourceImagePanel sourceImagePanel;
    private FusionImagePanel fusionImagePanel;
    private EvaluationMetricPanel evaluationMetricPanel;
    private HashMap<String, Double> evalValue;
    private File fusedImage;

    public FusionAlgorithmPanel(SourceImagePanel sourceImagePanel, FusionImagePanel fusionImagePanel, EvaluationMetricPanel evaluationMetricPanel) {
        this.sourceImagePanel = sourceImagePanel;
        this.fusionImagePanel = fusionImagePanel;
        this.evaluationMetricPanel = evaluationMetricPanel;
        this.label = new JLabel("融合算法：");
        this.button = new JButton("融合");
        this.comboBox = new JComboBox<>(methods);
    }

    public void render() {

        SelectFusionMethodListener selectFusionMethodListener = new SelectFusionMethodListener();
        add(label);
        add(comboBox);
        add(button);

        comboBox.addItemListener(selectFusionMethodListener);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sourceImagePanel.getImages().size() == 0) {
                    JOptionPane.showMessageDialog(FusionAlgorithmPanel.this, "先选择源图像！");
                } else {
                    Algorithm algorithm = selectFusionMethodListener.getAlgorithm();
                    fusedImage = algorithm.fusion(sourceImagePanel.getImages().get(0), sourceImagePanel.getImages().get(1));
                    fusionImagePanel.render();


                    evalValue = new HashMap<>();
                    Metric psnr = new PSNR();
                    evalValue.put("PSNR", psnr.eval(sourceImagePanel.getImages().get(0), fusedImage));
                    Metric ssim = new SSIM();
                    evalValue.put("SSIM", ssim.eval(sourceImagePanel.getImages().get(0), fusedImage));
                    evaluationMetricPanel.render();
                }
            }
        });
    }


    public SourceImagePanel getSourceImagePanel() {
        return sourceImagePanel;

    }

    public File getFusedImage() {
        return fusedImage;
    }

    public HashMap<String, Double> getEvalValue() {
        return evalValue;
    }

    public void setFusionImagePanel(FusionImagePanel fusionImagePanel) {
        this.fusionImagePanel = fusionImagePanel;
    }

    public void setEvaluationMetricPanel(EvaluationMetricPanel evaluationMetricPanel) {
        this.evaluationMetricPanel = evaluationMetricPanel;
    }
}
