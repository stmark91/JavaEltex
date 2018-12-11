package my.program;
import java.io.FileWriter;
import java.io.IOException;
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

    void addEntity(String f, String p, int c){
        User tmp = new Entity(f,p,c);
        book.add(tmp);
    }

    void addIndividual(String f, String p, String c){
        User tmp = new Individual(f,p,c);
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

    User search2(String f){
        for (User i:book) {
            t = i.getFio();
            if(f.equals(t)){
                return i;
            }
        }
        return null;
    }

    void writeToCSV(String csv){
        try(FileWriter writer = new FileWriter(csv,false)){
            //String lineSeparator = new System.getProperty("line.separator");
            for (User i:book) {
                String out = i.toStringInFile();
                writer.write(out + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
