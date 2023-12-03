package day3gearratios.part2;

public record CandidatePart(int partNumber, GearCoordinate coordinate) {
    public record GearCoordinate(int row, int column){}
}
