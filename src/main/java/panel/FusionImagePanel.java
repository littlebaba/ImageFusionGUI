package panel;

import other.DealImageIcon;
import other.LabelManager;

import javax.swing.*;

public class FusionImagePanel extends BasePanel{

    private DealImageIcon dealImageIcon;
    private LabelManager labelManager;
    private FusionAlgorithmPanel fusionAlgorithmPanel;

    public FusionImagePanel(FusionAlgorithmPanel fusionAlgorithmPanel) {
        this.fusionAlgorithmPanel = fusionAlgorithmPanel;
        this.dealImageIcon = new DealImageIcon();
        this.labelManager = new LabelManager();
    }

    public void render() {
        JLabel filledLabelWithImage;
        if (fusionAlgorithmPanel.getFusedImage() != null) {
            filledLabelWithImage = labelManager.getFilledLabelWithImage(dealImageIcon.getImageIcon(fusionAlgorithmPanel.getFusedImage().getAbsolutePath()), false);
        } else {
            filledLabelWithImage = labelManager.getFilledLabelWithImage(null, false);
        }
        if (this.getComponentCount()!=0){
            this.removeAll();
        }
        this.revalidate();
        add(filledLabelWithImage);
    }

}
