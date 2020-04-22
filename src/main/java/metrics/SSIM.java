package metrics;

import java.io.File;

public class SSIM extends Metric{
    @Override
    public double eval(File sourceImage, File fusedImage) {
        return 0.5;
    }
}
