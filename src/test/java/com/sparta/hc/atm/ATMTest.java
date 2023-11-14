package com.sparta.hc.atm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ATMTest {

    @Test
    public void testCalculateTotalBalance() {
        // Arrange
        int note1 = 1;
        int note2 = 2;
        int note5 = 3;
        int note10 = 4;
        int note20 = 5;
        int note50 = 6;


        int result = ATM.calculateTotalBalance();


        int expected = calculateExpectedTotalBalance(note1, note2, note5, note10, note20, note50);
        Assertions.assertEquals(expected, result);
    }

    private int calculateExpectedTotalBalance(int note1, int note2, int note5, int note10, int note20, int note50) {
        return note1 + (note2 * 2) + (note5 * 5) + (note10 * 10) + (note20 * 20) + (note50 * 50);
    }
}

