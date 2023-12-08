package day8wasteland;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NetworkParserTest {

    private static final List<String> testLines = List.of(
            "RL",
            "",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)"
    );


    @Test
    public void parserParsesNetwork() {
        Network result = new NetworkParser().parseNetwork(testLines);

        assertThat(result).isEqualTo(new Network(Map.of(
                "AAA", new Network.Fork("BBB", "CCC"),
                "BBB", new Network.Fork("DDD", "EEE"),
                "CCC", new Network.Fork("ZZZ", "GGG"),
                "DDD", new Network.Fork("DDD", "DDD"),
                "EEE", new Network.Fork("EEE", "EEE"),
                "GGG", new Network.Fork("GGG", "GGG"),
                "ZZZ", new Network.Fork("ZZZ", "ZZZ")
        )));
    }
}