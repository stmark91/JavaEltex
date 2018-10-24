public class User {
    private String fio;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "fio:' " + fio + '\'' +
                ", phone: '" + phone + '\'' +
                '}';
    }

    User(String a, String b){
        setFio(a);
        setPhone(b);
    }

    String getFio() {
        return fio;
    }

    private void setFio(String fio) {
        this.fio = fio;
    }

    String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}
