package day3gearratios.part2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GearCalculator {

    private final GearParser gearParser;

    public GearCalculator(GearParser gearParser) {
        this.gearParser = gearParser;
    }

    public int calculateSumOfGearRatios(List<String> inputLines) {
        List<CandidatePart> candidateParts = gearParser.parseCandidateParts(inputLines);

        return getUniqueCoordinates(candidateParts).stream()
                .map(coordinate -> partNumbersForGear(coordinate, candidateParts))
                .filter(partNumbers -> partNumbers.size() == 2)
                .mapToInt(partNumbers -> partNumbers.get(0) * partNumbers.get(1))
                .sum();
    }

    private List<Integer> partNumbersForGear(CandidatePart.GearCoordinate coordinate, List<CandidatePart> partList) {
        return partList.stream()
                .filter(candidatePart -> coordinate.equals(candidatePart.coordinate()))
                .map(CandidatePart::partNumber)
                .toList();
    }

    private Set<CandidatePart.GearCoordinate> getUniqueCoordinates(List<CandidatePart> partList) {
        return partList.stream()
                .map(CandidatePart::coordinate)
                .collect(Collectors.toSet());
    }
}
