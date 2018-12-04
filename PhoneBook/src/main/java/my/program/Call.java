package my.program;

final class Call<T> extends Calls {
    private T cqpn;
    private T cdpn;

    Call(int id, T cqpn, T cdpn, int time) {
        super(id,time);
        this.cqpn = cqpn;
        this.cdpn = cdpn;
    }

    @Override
    public String toString() {
        return "Call: " + super.toStringId() +
                "cqpn = " + cqpn +
                " cdpn = " + cdpn +
                super.toStringTime();
    }

    public T getcqpn() {
        return cqpn;
    }

    public T getcdpn() {
        return cdpn;
    }

}
