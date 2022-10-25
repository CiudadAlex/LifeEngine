package org.leviatanplatform.life.engine.util;

import org.junit.jupiter.api.Test;

public class StringGeneticUtilsTest {

    @Test
    void testMutationDeletion() {
        String sequence = "UUDDLLRR";
        String sequenceMutated = StringGeneticUtils.mutateDeletion(sequence);

        System.out.println(sequence);
        System.out.println(sequenceMutated);

        assert sequence.length() == sequenceMutated.length() + 1;
    }

    @Test
    void testMutationAddition() {
        String sequence = "UUDDLLRR";
        String sequenceMutated = StringGeneticUtils.mutateAddition(sequence, 'A');

        System.out.println(sequence);
        System.out.println(sequenceMutated);

        assert sequence.length() + 1 == sequenceMutated.length();
    }

    @Test
    void testMutationChange() {
        String sequence = "UUDDLLRR";
        String sequenceMutated = StringGeneticUtils.mutateChange(sequence, 'A');

        System.out.println(sequence);
        System.out.println(sequenceMutated);

        assert sequence.length() == sequenceMutated.length();
    }
}
