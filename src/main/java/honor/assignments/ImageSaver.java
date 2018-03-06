package honor.assignments;

import edu.duke.*;
import org.junit.Test;

import java.io.*;

public class ImageSaver {
    @Test
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "copy-" + fName;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
}
