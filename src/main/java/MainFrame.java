import panel.EvaluationMetricPanel;
import panel.FusionAlgorithmPanel;
import panel.FusionImagePanel;
import panel.SourceImagePanel;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{

    private  SourceImagePanel sourceImagePanel;
    private  FusionAlgorithmPanel fusionAlgorithmPanel;
    private FusionImagePanel fusionImagePanel;
    private EvaluationMetricPanel evaluationMetricPanel;

    public MainFrame() {
        sourceImagePanel = new SourceImagePanel();
        fusionAlgorithmPanel = new FusionAlgorithmPanel(sourceImagePanel,fusionImagePanel,evaluationMetricPanel);
        fusionImagePanel = new FusionImagePanel(fusionAlgorithmPanel);
        evaluationMetricPanel = new EvaluationMetricPanel(fusionAlgorithmPanel);
    }

    public void render() {

        sourceImagePanel.initializeLayout();
        sourceImagePanel.render();
        add(sourceImagePanel);

        fusionAlgorithmPanel.render();
        add(fusionAlgorithmPanel);

        fusionAlgorithmPanel.setFusionImagePanel(fusionImagePanel);
        fusionImagePanel.render();
        add(fusionImagePanel);

        evaluationMetricPanel.initializeLayout();
        fusionAlgorithmPanel.setEvaluationMetricPanel(evaluationMetricPanel);
        evaluationMetricPanel.render();
        add(evaluationMetricPanel);
    }


    public void initializeLayout() {
        GridLayout gridLayout = new GridLayout(4, 1);
        gridLayout.setVgap(2);
        setLayout(gridLayout);
    }

    public void initializeStyle() {
        setTitle("图像融合");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(getRectanle());
    }


    public Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public Rectangle getRectanle() {
        int x = (int) (getScreenSize().getWidth() * 2 / 7);
        int y = (int) (getScreenSize().getHeight() / 20);
        int width = (int) (getScreenSize().getWidth() * 3 / 7);
        int height = (int) (getScreenSize().getHeight() * 17 / 20);
        return new Rectangle(x, y, width, height);
    }

}
