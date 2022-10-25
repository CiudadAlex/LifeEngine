package org.leviatanplatform.life.engine;

public interface Genome<G extends Genome, P extends Phenotype> {

    P getPhenotype();

    G mutate();

    G mix(G genome);

    String getSequence();
}
