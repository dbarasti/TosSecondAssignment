package it.unipd.tos.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTest {
    @Test
    public void testEnumToStringValues() {
        assertEquals("PRIMO", Type.valueOf(Type.PRIMO.toString()).name());

        assertEquals("PIZZA", Type.valueOf(Type.PIZZA.toString()).name());

    }

}