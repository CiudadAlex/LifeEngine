package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.LifeCycleGraphicRepresentation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LifeCycleGraphicRepresentationMatrix implements LifeCycleGraphicRepresentation<GenomeMatrix, PhenotypeMatrix> {

    private JFrame frame;
    private JPanel canvas;
    private List<GenomeMatrix> listOfGenome;

    @Override
    public void show(List<GenomeMatrix> listOfGenome) {

        this.listOfGenome = listOfGenome;

        if (frame == null) {
            frame = new JFrame("LIFE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1600, 900);
            frame.setVisible(true);
            frame.setResizable(false);

            canvas = createCanvas();
            frame.add(canvas);
        }

        SwingUtilities.invokeLater(() -> {
            canvas.invalidate();
            canvas.validate();
            canvas.repaint();
        });

    }

    public JPanel createCanvas() {

        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                LifeCycleGraphicRepresentationMatrixUtils.paintCurrentListOfGenome(g, width, listOfGenome);
            }
        };
    }

}
