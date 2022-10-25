package org.leviatanplatform.life.engine;

public interface GenomeGenerator<G extends Genome> {

    G generate();
}
