package org.leviatanplatform.life.engineimpl.matrix;

import org.junit.jupiter.api.Test;
import org.leviatanplatform.life.engine.Phenotype;

public class PhenotypeMatrixTest {

    @Test
    void testWrongGenomeSequencePhenotypeMatrix() {

        GenomeMatrix genome = new GenomeMatrix("qwerty");
        Phenotype phenotype = genome.getPhenotype();

        boolean hasCorrectFormation = phenotype.hasCorrectFormation();
        System.out.println("hasCorrectFormation = " + hasCorrectFormation);
        assert !hasCorrectFormation;
    }

    @Test
    void testPhenotypeMatrix() {

        GenomeMatrix genome = new GenomeMatrix("UUUUUUUU");
        Phenotype phenotype = genome.getPhenotype();

        boolean hasCorrectFormation = phenotype.hasCorrectFormation();
        assert hasCorrectFormation;

        String printableRepresentationPhenotype = phenotype.getPrintableRepresentation();

        System.out.println(printableRepresentationPhenotype);
    }

    @Test
    void testPhenotypeMatrixSpiral() {

        GenomeMatrix genome = new GenomeMatrix("UURRRDDDDLLLLLUUUUUURRRRRRRDDDDDDDDLLLLLLLLLUUUUUUUUUU");
        Phenotype phenotype = genome.getPhenotype();

        boolean hasCorrectFormation = phenotype.hasCorrectFormation();
        assert hasCorrectFormation;

        String printableRepresentationPhenotype = phenotype.getPrintableRepresentation();

        System.out.println(printableRepresentationPhenotype);
    }
}
