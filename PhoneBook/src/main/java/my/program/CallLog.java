package my.program;

import java.util.LinkedList;

class CallLog {
    LinkedList<Calls> log = new LinkedList<>();

    void addCall(int id, User cqph, User cdph, int time){
        System.out.println("LOX");
        Calls tmp = new Call<User>(id,cqph,cdph,time);
        log.add(tmp);
    }

    void addConf(int id, int time, User... ent){
        Calls tmp = new Conf<User>(id,time,ent);
        log.add(tmp);
    }

    void viewAll(){
        String t;
        for (Calls i: log) {
            t = i.toString();
            System.out.println(t);
        }
    }
}
