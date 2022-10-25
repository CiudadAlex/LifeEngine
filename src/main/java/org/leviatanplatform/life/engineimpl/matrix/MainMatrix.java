package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.LifeCycle;

import java.util.List;

public class MainMatrix {

    public static void main(String[] args) {

        LifeCycle<GenomeMatrix, PhenotypeMatrix> lifeCycle = new LifeCycle<>();

        LifeCycleGraphicRepresentationMatrix lifeCycleGraphicRepresentationMatrix =
                new LifeCycleGraphicRepresentationMatrix();

        GenomeGeneratorMatrix genomeGenerator = new GenomeGeneratorMatrix();
        int numberOfGenomes = 50;
        NaturalSelectionMatrix naturalSelection = new NaturalSelectionMatrix();
        int numberOfLifeCycles = 100;
        int millisToWaitBetweenCycles = 200;
        List<GenomeMatrix> listOfGenome = lifeCycle.executeLifeSimulation(genomeGenerator, numberOfGenomes,
                naturalSelection, numberOfLifeCycles, lifeCycleGraphicRepresentationMatrix, millisToWaitBetweenCycles);

        GenomeMatrix genome = listOfGenome.get(0);
        System.out.println("###################################");
        System.out.println(genome.getSequence());
        System.out.println("###################################");
        String representation = genome.getPhenotype().getPrintableRepresentation();
        System.out.println(representation);
        System.out.println("###################################");
    }


}
