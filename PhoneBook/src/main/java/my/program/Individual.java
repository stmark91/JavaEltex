package my.program;

final class Individual extends User {
    private String sex;

    Individual(String a, String b, String c) {
        super(a, b);
        setSex(c);
    }

    @Override
    public String toString() {
        return "Individual - " + super.toString() +
                ", sex :: " + sex;
    }

    public String toStringInFile() {
        return super.toStringInFile() + "," + sex;
    }

    public String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }

}
