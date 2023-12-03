package day3gearratios.part2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class GearCalculatorTest {

    @Mock
    GearParser mockGearParser;

    @InjectMocks
    GearCalculator calculator;

    List<CandidatePart> testList = List.of(
            new CandidatePart(467, new CandidatePart.GearCoordinate(1, 3)),
            new CandidatePart(35, new CandidatePart.GearCoordinate(1, 3)),
            new CandidatePart(617, new CandidatePart.GearCoordinate(4, 3)),
            new CandidatePart(755, new CandidatePart.GearCoordinate(8, 5)),
            new CandidatePart(598, new CandidatePart.GearCoordinate(8, 5))
    );

    @Test
    public void gearCalculatorSumsGearsCorrectly() {
        doReturn(testList).when(mockGearParser).parseCandidateParts(any());

        int result = calculator.calculateSumOfGearRatios(new ArrayList<>());

        assertThat(result).isEqualTo(467835);
    }

}