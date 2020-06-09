package ex.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GraphTest {
    @Test
    public void topologicalSort() throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task("C", Arrays.asList("A", "B")),
                new Task("B", Arrays.asList("A")),
                new Task("A", Arrays.asList())
        );

        List<String> expected = Arrays.asList("A", "B", "C");

        Graph charGraph = new Graph(tasks);
        List<String> actual = charGraph.topologicalSort().stream().map(Task::getName).collect(Collectors.toList());

        Assert.assertEquals(expected, actual);
    }

}
