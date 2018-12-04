package my.program;

abstract class Calls {
    private int id;
    private int time;

    Calls(int id, int time) {
        this.id = id;
        this.time = time;
    }

    String toStringId() {
        return "id = " + id;
    }

    String toStringTime() {
        return " time = " + time;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }
}
