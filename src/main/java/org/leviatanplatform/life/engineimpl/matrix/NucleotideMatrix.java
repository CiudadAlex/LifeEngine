package org.leviatanplatform.life.engineimpl.matrix;

import org.leviatanplatform.life.engine.util.RandomUtils;

public enum NucleotideMatrix {

    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

    private char code;

    NucleotideMatrix(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static NucleotideMatrix getRandom() {

        NucleotideMatrix[] arrayNucleotideMatrix = values();
        int indexValueMutation = RandomUtils.getInt(arrayNucleotideMatrix.length);

        return arrayNucleotideMatrix[indexValueMutation];
    }
}
