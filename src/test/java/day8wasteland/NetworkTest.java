package day8wasteland;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NetworkTest {

    @Test
    public void networkTraversesCorrectly() {
        Network network = new Network(Map.of(
                "AAA", new Network.Fork("BBB", "BBB"),
                "BBB", new Network.Fork("AAA", "ZZZ"),
                "ZZZ", new Network.Fork("ZZZ", "ZZZ")
        ));

        int result = network.traverse("LLR");

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void networkTraversesAsGhostCorrectly() {
        Network network = new Network(Map.of(
                "11A", new Network.Fork("11B", "XXX"),
                "11B", new Network.Fork("XXX", "11Z"),
                "11Z", new Network.Fork("11B", "XXX"),
                "22A", new Network.Fork("22B", "XXX"),
                "22B", new Network.Fork("22C", "22C"),
                "22C", new Network.Fork("22Z", "22Z"),
                "22Z", new Network.Fork("22B", "22B"),
                "XXX", new Network.Fork("XXX", "XXX")
        ));

        long result = network.traverseAsGhost("LR");
        assertThat(result).isEqualTo(6);
    }
}