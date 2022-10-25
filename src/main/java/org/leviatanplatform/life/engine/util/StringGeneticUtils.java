package org.leviatanplatform.life.engine.util;

public class StringGeneticUtils {

    public static String mutate(String sequence, char nucleotide) {

        int typeOfMutation = RandomUtils.getInt(3);

        if (typeOfMutation == 0) {
            return mutateDeletion(sequence);
        } else if (typeOfMutation == 1) {
            return mutateAddition(sequence, nucleotide);
        } else {
            return mutateChange(sequence, nucleotide);
        }
    }

    public static String mutateDeletion(String sequence) {

        int indexToDeleteMutation = RandomUtils.getInt(sequence.length());
        String initialSequence = sequence.substring(0, indexToDeleteMutation);
        String finalSequence = indexToDeleteMutation >= sequence.length() - 1 ?
                "" : sequence.substring(indexToDeleteMutation + 1);

        String sequenceMutated = initialSequence + finalSequence;

        return sequenceMutated;
    }

    public static String mutateAddition(String sequence, char nucleotide) {

        int indexToInsertMutation = RandomUtils.getInt(sequence.length() + 1);

        String sequenceMutated;

        if (indexToInsertMutation == 0) {
            sequenceMutated = nucleotide + sequence;

        } else if (indexToInsertMutation == sequence.length())  {
            sequenceMutated = sequence + nucleotide;

        } else {
            String initialSequence = sequence.substring(0, indexToInsertMutation);
            String finalSequence = sequence.substring(indexToInsertMutation);

            sequenceMutated = initialSequence + nucleotide + finalSequence;
        }

        return sequenceMutated;
    }

    public static String mutateChange(String sequence, char nucleotide) {

        char[] sequenceMutated = sequence.toCharArray();

        int indexToMutate = RandomUtils.getInt(sequenceMutated.length);

        sequenceMutated[indexToMutate] = nucleotide;

        return new String(sequenceMutated);
    }

    public static String mix(String sequence1, String sequence2) {

        int indexToCut1 = RandomUtils.getInt(sequence1.length());
        int indexToCut2 = RandomUtils.getInt(sequence2.length());

        String mixedSequence = sequence1.substring(0, indexToCut1) + sequence2.substring(indexToCut2);

        return mixedSequence;
    }
}
