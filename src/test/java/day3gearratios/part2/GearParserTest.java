package day3gearratios.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GearParserTest {

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

    @Test
    public void gearParserFindsCandidateParts() {
        List<CandidatePart> result = new GearParser().parseCandidateParts(testList);

        assertThat(result).containsExactly(
                new CandidatePart(467, new CandidatePart.GearCoordinate(1, 3)),
                new CandidatePart(35, new CandidatePart.GearCoordinate(1, 3)),
                new CandidatePart(617, new CandidatePart.GearCoordinate(4, 3)),
                new CandidatePart(755, new CandidatePart.GearCoordinate(8, 5)),
                new CandidatePart(598, new CandidatePart.GearCoordinate(8, 5))
        );
    }
}