package day3gearratios;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartNumberParserTest {
    private final List<String> testList = List.of(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
    );

    @ParameterizedTest
    @CsvSource({
            "0, 0, 3, true",
            "0, 5, 8, false",
            "2, 2, 4, true",
            "5, 7, 9, false",
            "9, 1, 4, true",
            "8, 6, 10, true"
    })
    public void gearParserFindsAdjacentSymbolsCorrectly(int row, int startColumn, int endColumn, boolean expectedResult) {
        boolean result = new PartNumberParser().rangeHasAdjacentSymbol(row, startColumn, endColumn, testList);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void gearParserRetrievesListOfPartNumbers() {
        List<Integer> result = new PartNumberParser().parsePartNumbers(testList);

        assertThat(result).containsExactly(467, 35, 633, 617, 592, 755, 664, 598);
    }
}