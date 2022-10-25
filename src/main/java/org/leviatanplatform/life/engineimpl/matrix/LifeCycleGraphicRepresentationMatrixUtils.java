package org.leviatanplatform.life.engineimpl.matrix;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LifeCycleGraphicRepresentationMatrixUtils {

    public static JPanel createCanvas(List<GenomeMatrix> listOfGenome) {

        JPanel canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                LifeCycleGraphicRepresentationMatrixUtils.paintCurrentListOfGenome(g, width, listOfGenome);
            }
        };

        return canvas;
    }

    public static void paintCurrentListOfGenome(Graphics g, int width, List<GenomeMatrix> listOfGenome) {

        g.setColor(Color.black);

        int pixelSize = 5;
        int reservedSpace = (PhenotypeMatrix.MATRIX_SIZE + 10) * pixelSize;
        int marginX = 10;

        int offsetX = marginX;
        int offsetY = - reservedSpace;

        int numberPerRow = width / reservedSpace;
        int count = 0;

        for (GenomeMatrix genome : listOfGenome) {

            PhenotypeMatrix phenotype = genome.getPhenotype();

            if (count % numberPerRow == 0) {
                offsetY = offsetY + reservedSpace;
                offsetX = marginX;

            } else {
                offsetX = offsetX + reservedSpace;
            }

            paintPhenotype(g, phenotype, offsetX, offsetY, pixelSize);

            count++;
        }
    }

    private static void paintPhenotype(Graphics g, PhenotypeMatrix phenotype, int offsetX, int offsetY, int pixelSize) {

        for (int i=0; i<PhenotypeMatrix.MATRIX_SIZE; i++) {

            for (int j=0; j<PhenotypeMatrix.MATRIX_SIZE; j++) {
                if (phenotype.getMatrixEntry(i, j)) {
                    g.drawRect(offsetX + i * pixelSize, offsetY + j * pixelSize, pixelSize, pixelSize);
                }
            }
        }
    }
}
