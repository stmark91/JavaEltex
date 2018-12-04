package my.program;

import java.util.Collections;
import java.util.LinkedList;

final class Conf<T> extends Calls {
    private LinkedList<T> part = new LinkedList<>();

    @Override
    public String toString() {
        return "Conf:" + super.toStringId() +
                "part = " + part +
                super.toStringTime();
    }

    Conf(int id, int time, T... n) {
        super(id,time);
        Collections.addAll(part, n);
    }
}
