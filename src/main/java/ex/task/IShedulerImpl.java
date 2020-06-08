package ex.task;

import java.util.List;

public class IShedulerImpl implements IScheduler {
    @Override
    public List schedule(List<Task> tasks) {
        Graph charGraph = new Graph(tasks);
        return charGraph.topologicalSort();
    }
}
