package algorithms;

import java.io.File;

public class NSST extends Algorithm{
    @Override
    public File fusion(File firstSourceImage, File secondSourceImage) {
        System.out.println(NSST.class.getName());
        return firstSourceImage;
    }
}
