package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.Phenotype;

public class PhenotypeMatrix implements Phenotype {

    public static final int MATRIX_SIZE = 20;

    private final boolean[][] matrix = new boolean[MATRIX_SIZE][MATRIX_SIZE];

     private boolean correctFormation = true;

    public PhenotypeMatrix(GenomeMatrix genome) {

        final String sequence = genome.getSequence();

        int i = MATRIX_SIZE / 2;
        int j = MATRIX_SIZE / 2;

        matrix[i][j] = true;

        for (char ch : sequence.toCharArray()) {

            if (NucleotideMatrix.UP.getCode() == ch) {
                j++;
            } else if (NucleotideMatrix.DOWN.getCode() == ch) {
                j--;
            } else if (NucleotideMatrix.LEFT.getCode() == ch) {
                i--;
            } else if (NucleotideMatrix.RIGHT.getCode() == ch) {
                i++;
            } else {
                // If genome has characters different from UP, DOWN, LEFT, RIGHT the phenotype dies
                correctFormation = false;
                return;
            }

            if (i<0 || j<0 || i>=MATRIX_SIZE || j>=MATRIX_SIZE) {
                // If phenotype exits the matrix dies for too much size to survive
                correctFormation = false;
                return;
            }

            if (matrix[i][j]) {
                // If phenotype has that position already true the phenotype dies by intersecting itself
                correctFormation = false;
                return;
            }

            matrix[i][j] = true;
        }
    }

    @Override
    public boolean hasCorrectFormation() {
        return correctFormation;
    }

    @Override
    public String getPrintableRepresentation() {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<MATRIX_SIZE; i++) {

            for (int j=0; j<MATRIX_SIZE; j++) {
                String printable = matrix[i][j] ? "X" : " ";
                sb.append(printable);
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean getMatrixEntry(int i, int j) {

        if (i<0 || j<0 || i>=MATRIX_SIZE || j>=MATRIX_SIZE) {
            return false;
        }

        return matrix[i][j];
    }
}
