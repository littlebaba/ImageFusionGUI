package algorithms;

import java.io.File;

public class NSCT extends Algorithm{
    @Override
    public File fusion(File firstSourceImage, File secondSourceImage) {
        System.out.println(NSCT.class.getName());
        return firstSourceImage;
    }
}
