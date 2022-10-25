package org.leviatanplatform.life.engine;

import java.util.List;

public interface NaturalSelection<G extends Genome> {

    List<G> selectBestFitted(List<G> listGenome);
}
