package honor.assignments;
import edu.duke.*;
import org.junit.Test;

import java.io.*;

public class BatchInversionsTest {
    @Test
    public void selectAndCovert(){
        BatchInversions bi = new BatchInversions();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource inverse = bi.makeInversion(inImage);
            String fName = inImage.getFileName();
            String newName = "inverted-" + fName;
            inverse.setFileName(newName);
            inverse.draw();
            inverse.save();
        }

    }
}
