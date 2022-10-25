package org.leviatanplatform.life.engine;

public class GenomeSurvival<G extends Genome> {

    private final G genome;
    private final Double survivalCoefficient;

    public GenomeSurvival(G genome, double survivalCoefficient) {
        this.genome = genome;
        this.survivalCoefficient = survivalCoefficient;
    }

    public G getGenome() {
        return genome;
    }

    public Double getSurvivalCoefficient() {
        return survivalCoefficient;
    }

}
