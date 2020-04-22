package metrics;

import java.io.File;

public abstract class Metric {
    public abstract double eval(File sourceImage,File fusedImage);

}
