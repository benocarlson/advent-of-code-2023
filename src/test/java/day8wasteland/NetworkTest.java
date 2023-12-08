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

}