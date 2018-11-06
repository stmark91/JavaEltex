package my.program;

final class Entity extends User {
    private int inn;

    Entity(String a, String b, int c) {
        super(a, b);
        setInn(c);
    }

    @Override
    public String toString() {
        return "Entity - " + super.toString() +
                ", inn :: " + inn;
    }

    public String toStringInFile() {
        return super.toStringInFile() + "," + inn;
    }

    public int getInn() {
        return inn;
    }

    private void setInn(int inn) {
        this.inn = inn;
    }
}
