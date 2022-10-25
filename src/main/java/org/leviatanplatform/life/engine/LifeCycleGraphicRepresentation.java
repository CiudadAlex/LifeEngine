package org.leviatanplatform.life.engine;

import java.util.List;

public interface LifeCycleGraphicRepresentation<G extends Genome<G, P>, P extends Phenotype> {

    void show(List<G> listOfGenome);
}
