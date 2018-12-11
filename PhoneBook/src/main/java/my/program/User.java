package my.program;

import java.util.LinkedList;

abstract class User implements Interface {
    private String fio;
    private String phone;
    LinkedList<Calls> log = new LinkedList<>();

    void addCall(int id, User cqpn, User cdpn, int time){
        Calls tmp = new Call<User>(id,cqpn,cdpn,time);
        log.add(tmp);
    }

    void addConf(int id, int time, User... ent){
        Calls tmp = new Conf<User>(id,time,ent);
        log.add(tmp);
    }

    void viewCalls(){
        String t;
        for (Calls i: log) {
            t = i.toString();
            System.out.println(t);
        }
    }

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
