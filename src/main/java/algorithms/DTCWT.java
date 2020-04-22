package algorithms;

import java.io.File;

public class DTCWT extends Algorithm{
    @Override
    public File fusion(File firstSourceImage, File secondSourceImage) {
        System.out.println(DTCWT.class.getName()+" "+firstSourceImage.getAbsolutePath()+" "+secondSourceImage.getAbsolutePath());
        return firstSourceImage;
    }
}
