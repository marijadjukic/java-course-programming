package honor.assignments;
import edu.duke.*;
import java.io.*;
import org.junit.Test;


public class GrayScaleConverterTest {
    @Test
    public void testGray(){
        GrayScaleConverter gsc = new GrayScaleConverter();
        ImageResource ir = new ImageResource();
        ImageResource gray = gsc.makeGray(ir);
        while (true){
        gray.draw();
        }
    }
    @Test
    public void selectAndConvert(){
        GrayScaleConverter gsc = new GrayScaleConverter();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = gsc.makeGray(inImage);
            String fName = inImage.getFileName();
            String newName = "gray-" + fName;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
