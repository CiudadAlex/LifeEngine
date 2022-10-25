package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.GenomeGenerator;
import org.leviatanplatform.life.engine.util.RandomUtils;

public class GenomeGeneratorMatrix implements GenomeGenerator<GenomeMatrix> {
    @Override
    public GenomeMatrix generate() {

        int numberOfNucleotides = RandomUtils.getInt(5) + 3;
        StringBuilder sequenceBuilder = new StringBuilder();

        for (int i=0; i<numberOfNucleotides; i++) {
            sequenceBuilder.append(NucleotideMatrix.getRandom().getCode());
        }

        return new GenomeMatrix(sequenceBuilder.toString());
    }
}
