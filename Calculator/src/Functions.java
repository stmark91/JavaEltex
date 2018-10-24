class Functions {
    private int a;
    private int b;
    private int ans;

    @Override
    public String toString() {
        return "Functions{" +
                "a=" + a +
                ", b=" + b +
                ", ans=" + ans +
                '}';
    }

    Functions(int x, int y) {
        setA(x);
        setB(y);
    }
    private void setA(int a) {
        this.a = a;
    }
    private void setB(int b) {
        this.b = b;
    }

    int getAns() {
        return ans;
    }

    void add(){
        ans = a + b;
    }
    void sub(){
        ans = a - b;
    }
    void mul(){
        ans = a * b;
    }
    void div(){
        ans = a / b;
    }

}
