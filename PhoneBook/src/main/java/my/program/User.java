package my.program;
abstract class User implements Interface {
    private String fio;
    private String phone;
    CallLog journal;

    User(String a, String b){
        setFio(a);
        setPhone(b);
    }

    @Override
    public String toString() {
        return "fio :: " + fio +
                ", phone :: " + phone;
    }

    public String toStringInFile() {
        return fio + "," + phone;
    }

    String getFio() {
        return fio;
    }
    String getPhone() {
        return phone;
    }
    private void setFio(String fio) {
        this.fio = fio;
    }
    private void setPhone(String phone) {
        this.phone = phone;
    }
}
