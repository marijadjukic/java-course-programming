package stringThirdAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;
import org.junit.Test;

public class Part3Test {

    @Test
    public void testProcessGenes1() {
        final Part3 part3 = new Part3();
        final FileResource fr = new FileResource("brca1line.fa");
        final String dna = fr.asString().toUpperCase();
        final StorageResource genes = part3.getAllGenes(dna);
        System.out.println("Found genes number: " + genes.size());

        part3.processGenes(genes);
    }

    @Test
    public void testProcessGenes2() {
        final Part3 part3 = new Part3();
        final FileResource fr = new FileResource("brca1.fa");
        final String dna = fr.asString().toUpperCase();
        final StorageResource genes = part3.getAllGenes(dna);
        System.out.println("Found genes number: " + genes.size());

        part3.processGenes(genes);
    }

    @Test
    public void testProcessGenes3() {
        final Part3 part3 = new Part3();
        final FileResource fr = new FileResource("Axl2p.fa");
        final String dna = fr.asString().toUpperCase();
        final StorageResource genes = part3.getAllGenes(dna);
        System.out.println("Found genes number: " + genes.size() );

        part3.processGenes(genes);
    }

    @Test
    public void testProcessGenes4() {
        final Part3 part3 = new Part3();
        final FileResource fr = new FileResource("GRch38dnapart.fa");
        final String dna = fr.asString().toUpperCase();
        final StorageResource genes = part3.getAllGenes(dna);
        System.out.println("Found genes number: " + genes.size() );
        System.out.println("CTG appears in dna " + part3.countCTG(dna) + " times");

        part3.processGenes(genes);
    }
    @Test
    public void testProcessGenes5() {
        final Part3 part3 = new Part3();
        final FileResource fr = new FileResource("mansmall.fa");
        final String dna = fr.asString().toUpperCase();
        final StorageResource genes = part3.getAllGenes(dna);
        System.out.println("Found genes number: " + genes.size() );

        part3.processGenes(genes);
    }

}
