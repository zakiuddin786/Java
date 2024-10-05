package com.thealgorithms.conversions;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

public class UnitsConverterTest {

    @Test
    void testConvertThrowsForSameUnits() {
        final UnitsConverter someConverter = new UnitsConverter(Map.ofEntries(entry(Pair.of("A", "B"), new AffineConverter(10.0, -20.0))));
        assertThrows(IllegalArgumentException.class, () -> someConverter.convert("A", "A", 20.0));
        assertThrows(IllegalArgumentException.class, () -> someConverter.convert("B", "B", 20.0));
    }

    @Test
    void testConvertThrowsForUnknownUnits() {
        final UnitsConverter someConverter = new UnitsConverter(Map.ofEntries(entry(Pair.of("A", "B"), new AffineConverter(10.0, -20.0))));
        assertThrows(NoSuchElementException.class, () -> someConverter.convert("A", "X", 20.0));
        assertThrows(NoSuchElementException.class, () -> someConverter.convert("X", "A", 20.0));
        assertThrows(NoSuchElementException.class, () -> someConverter.convert("X", "Y", 20.0));
    }
}
