package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.LifeCycleGraphicRepresentation;

import javax.swing.*;
import java.util.List;

public class LifeCycleGraphicRepresentationMatrix implements LifeCycleGraphicRepresentation<GenomeMatrix, PhenotypeMatrix> {

    private JFrame frame;

    @Override
    public void show(List<GenomeMatrix> listOfGenome) {

        if (frame != null) {
            frame.dispose();
        }

        frame = new JFrame("LIFE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(LifeCycleGraphicRepresentationMatrixUtils.createCanvas(listOfGenome));
        frame.setSize(1600, 900);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
