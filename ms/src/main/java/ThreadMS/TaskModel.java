package ThreadMS;

public class TaskModel implements Comparable<TaskModel> {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(TaskModel task) {
        return this.getId() > task.getId() ? 1 : (this.getId() < task.getId() ? -1 : 0);
    }
}
