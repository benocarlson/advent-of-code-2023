package day8wasteland.part2;

import day8wasteland.Network;
import day8wasteland.NetworkParser;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NetworkTableTest {

    @Test
    public void networkTraversesAsGhostCorrectly() {
        NetworkTable network = new NetworkTable(Map.of(
                "11A", new Network.Fork("11B", "XXX"),
                "11B", new Network.Fork("XXX", "11Z"),
                "11Z", new Network.Fork("11B", "XXX"),
                "22A", new Network.Fork("22B", "XXX"),
                "22B", new Network.Fork("22C", "22C"),
                "22C", new Network.Fork("22Z", "22Z"),
                "22Z", new Network.Fork("22B", "22B"),
                "XXX", new Network.Fork("XXX", "XXX")),
                "LR");

        long result = network.stepsToTarget();
        assertThat(result).isEqualTo(6);
    }

    private static final List<String> testy = List.of(
            "LLLR",
            "",
            "11A = (11B, 11Z)",
            "11B = (11A, 11Z)",
            "11Z = (11A, 11B)",
            "22A = (22Z, 22Z)",
            "22B = (22A, 22Z)",
            "22Z = (22A, 22B)"
    );

    @Test
    public void testy() {
        NetworkTable networkTable = new NetworkParser().parseNetworkTable(testy);
        System.out.println(networkTable.stepsToTarget());
    }

}