package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.GenomeSurvival;
import org.leviatanplatform.life.engine.NaturalSelection;

import java.util.List;
import java.util.stream.Collectors;

public class NaturalSelectionMatrix implements NaturalSelection<GenomeMatrix> {

    private static final float RATIO_SURVIVAL = 0.8f;

    @Override
    public List<GenomeMatrix> selectBestFitted(List<GenomeMatrix> listGenome) {

        List<GenomeSurvival<GenomeMatrix>> listGenomeSurvival = listGenome.stream().map(g -> {
            double survivalCoefficient = calculateSurvivalCoefficient(g, listGenome);
            return new GenomeSurvival<>(g, survivalCoefficient);
        }).sorted((gs1, gs2) -> -gs1.getSurvivalCoefficient().compareTo(gs2.getSurvivalCoefficient())).toList();

        int numberSurvivors = Math.round(listGenome.size() * RATIO_SURVIVAL);
        return listGenomeSurvival.subList(0, numberSurvivors).stream().map(gs -> gs.getGenome()).collect(Collectors.toList());
    }

    private double calculateSurvivalCoefficient(GenomeMatrix genome, List<GenomeMatrix> listGenome) {
        return calculateLengthSurvivalCoefficient(genome) + calculateMaxCoupleSurvivalCoefficient(genome, listGenome);
    }

    private double calculateLengthSurvivalCoefficient(GenomeMatrix genome) {
        return genome.getSequence().length() / 2.0;
    }

    private double calculateMaxCoupleSurvivalCoefficient(GenomeMatrix genome, List<GenomeMatrix> listGenome) {

        double maxCoupleSurvivalCoefficient = Double.NEGATIVE_INFINITY;

        for (GenomeMatrix genomeItem : listGenome) {
            double coupleSurvivalCoefficient = calculateCoupleSurvivalCoefficient(genome, genomeItem);

            if (coupleSurvivalCoefficient > maxCoupleSurvivalCoefficient) {
                maxCoupleSurvivalCoefficient = coupleSurvivalCoefficient;
            }
        }

        return maxCoupleSurvivalCoefficient;
    }

    private double calculateCoupleSurvivalCoefficient(GenomeMatrix genome1, GenomeMatrix genome2) {

        PhenotypeMatrix phenotype1 = genome1.getPhenotype();
        PhenotypeMatrix phenotype2 = genome2.getPhenotype();

        int coupleSurvivalCoefficient = 0;

        for (int i=0; i<PhenotypeMatrix.MATRIX_SIZE; i++) {

            for (int j=0; j<PhenotypeMatrix.MATRIX_SIZE; j++) {

                if (phenotype1.getMatrixEntry(i, j)) {
                    int summand = calculateSurroundingSummand(i, j, phenotype2);
                    coupleSurvivalCoefficient = coupleSurvivalCoefficient + summand;
                }

            }
        }

        return coupleSurvivalCoefficient;
    }

    private int calculateSurroundingSummand(int i, int j, PhenotypeMatrix phenotype) {

        int summand = 0;

        if (phenotype.getMatrixEntry(i, j)) {
            summand = summand - 4;
        }

        if (phenotype.getMatrixEntry(i + 1, j)) {
            summand = summand + 1;
        }

        if (phenotype.getMatrixEntry(i - 1, j)) {
            summand = summand + 1;
        }

        if (phenotype.getMatrixEntry(i, j + 1)) {
            summand = summand + 1;
        }

        if (phenotype.getMatrixEntry(i, j - 1)) {
            summand = summand + 1;
        }

        return summand;
    }
}
