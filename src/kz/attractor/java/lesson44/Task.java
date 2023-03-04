package kz.attractor.java.lesson44;

public class Task {
    private int type;
    private String name;
    private String desc;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "type=" + type +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Task(int type, String name, String desc) {
        this.type = type;
        this.name = name;
        this.desc = desc;
    }
}
