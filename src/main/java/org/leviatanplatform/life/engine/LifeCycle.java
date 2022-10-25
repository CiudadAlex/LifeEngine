package org.leviatanplatform.life.engine;

import org.leviatanplatform.life.engine.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LifeCycle<G extends Genome<G, P>, P extends Phenotype> {

    public List<G> executeLifeSimulation(GenomeGenerator<G> genomeGenerator, int numberOfGenomes,
                                         NaturalSelection<G> naturalSelection, int numberOfLifeCycles,
                                         LifeCycleGraphicRepresentation<G, P> lifeCycleGraphicRepresentation,
                                         int millisToWaitBetweenCycles) {

        List<G> listOfGenome = new ArrayList<>();

        for (int i=0; i<numberOfGenomes; i++) {
            listOfGenome.add(genomeGenerator.generate());
        }

        for (int i=0; i<numberOfLifeCycles; i++) {

            listOfGenome = executeLifeCycle(listOfGenome, naturalSelection);

            lifeCycleGraphicRepresentation.show(listOfGenome);

            if (millisToWaitBetweenCycles > 0) {

                try {
                    Thread.sleep(millisToWaitBetweenCycles);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return listOfGenome;
    }

    private List<G> executeLifeCycle(List<G> listOfGenome, NaturalSelection<G> naturalSelection) {

        int numberOfGenomes = listOfGenome.size();
        List<G> listOfGenomeWellFormed = listOfGenome.stream().filter(g -> g.getPhenotype().hasCorrectFormation()).toList();
        List<G> newGeneration = naturalSelection.selectBestFitted(listOfGenomeWellFormed);
        int numberToRecreate = numberOfGenomes - newGeneration.size();

        for (int i=0; i<numberToRecreate; i++) {
            newGeneration.add(getNewCreation(newGeneration));
        }

        return newGeneration;
    }

    private G getNewCreation(List<G> listOfGenome) {

        int typeOfCreation = RandomUtils.getInt(2);

        if (typeOfCreation == 1) {
            return getRandomAndMutate(listOfGenome);
        } else {
            return getRandomAndMix(listOfGenome);
        }
    }

    private G getRandomAndMutate(List<G> listOfGenome) {

        int indexToMutate = RandomUtils.getInt(listOfGenome.size());
        return listOfGenome.get(indexToMutate).mutate();
    }

    private G getRandomAndMix(List<G> listOfGenome) {

        int indexToMix1 = RandomUtils.getInt(listOfGenome.size());
        int indexToMix2 = RandomUtils.getInt(listOfGenome.size());

        G genome1 = listOfGenome.get(indexToMix1);
        G genome2 = listOfGenome.get(indexToMix2);
        return genome1.mix(genome2);
    }
}
