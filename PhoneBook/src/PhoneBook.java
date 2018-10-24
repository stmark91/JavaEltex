import java.util.LinkedList;

class PhoneBook {
    private LinkedList<User> book = new LinkedList<>();
    private String t;

    void viewAll(){
        for (User i: book){
            t = i.toString();
            System.out.println(t);
        }
    }

    void add(String f, String p){
        User tmp = new User(f,p);
        book.add(tmp);
    }

    void remove(String f){
        for (User i:book) {
            t = i.getFio();
            if(f.equals(t)){
                book.remove(i);
                break;
            }
        }
    }

    String search(String f){
        for (User i:book) {
            t = i.getFio();
            if(f.equals(t)){
                return i.getPhone();
            }
        }
        return null;
    }
}
