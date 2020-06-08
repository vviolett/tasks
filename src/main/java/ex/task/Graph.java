package ex.task;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<String, Task> nodes;
    private List nodeVisited = new ArrayList<Task>();

    public Graph(List<Task> vertices) {
        nodes = vertices.stream()
                .collect(Collectors.toMap(Task::getName, task -> task));
    }

    public List<Task> topologicalSort() {
        List tasks = new LinkedList<String>();
        for (Task task: nodes.values()) {
            if (!nodeVisited.contains(task)) {
                sort(task, tasks);
            }
        }
        return tasks;
    }

    public void sort(Task task, List tasks) {
        nodeVisited.add(task);
        List<String> predecessors = task.getPredecessors();

        if (!predecessors.isEmpty()) {
            Iterator iter = predecessors.iterator();
            Task neighborNode;
            while (iter.hasNext()) {
                neighborNode = nodes.get(iter.next());

                if (!nodeVisited.contains(neighborNode)) {
                    sort(neighborNode, tasks);
                }
            }
        }
        tasks.add(task);
    }
}