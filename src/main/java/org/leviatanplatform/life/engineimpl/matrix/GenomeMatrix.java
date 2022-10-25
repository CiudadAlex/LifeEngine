package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.Genome;
import org.leviatanplatform.life.engine.util.StringGeneticUtils;

public class GenomeMatrix implements Genome<GenomeMatrix, PhenotypeMatrix> {

    private final String sequence;

    private final PhenotypeMatrix phenotype;

    public GenomeMatrix(String sequence) {
        this.sequence = sequence;
        this.phenotype = new PhenotypeMatrix(this);
    }

    @Override
    public PhenotypeMatrix getPhenotype() {
        return phenotype;
    }

    @Override
    public GenomeMatrix mutate() {

        NucleotideMatrix nucleotideRandom = NucleotideMatrix.getRandom();
        String sequenceMutated = StringGeneticUtils.mutate(sequence, nucleotideRandom.getCode());
        return new GenomeMatrix(sequenceMutated);
    }

    @Override
    public GenomeMatrix mix(GenomeMatrix genome) {

        String sequence2 = genome.getSequence();
        String mixedSequence = StringGeneticUtils.mix(sequence, sequence2);
        return new GenomeMatrix(mixedSequence);
    }

    public String getSequence() {
        return sequence;
    }
}
