import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();
        boolean flag = true;
        while(flag){
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Search");
            System.out.println("4) View all users");
            System.out.println("5) Exit");
            String s = in.next();
            switch (s){
                case "1":{
                    System.out.println("Write FIO and Phone:");
                    String f = in.next();
                    String p = in.next();
                    pb.add(f,p);
                    break;
                }
                case "2":{
                    System.out.println("Write FIO:");
                    String f = in.next();
                    pb.remove(f);
                    break;
                }
                case "3":{
                    System.out.println("Write FIO:");
                    String f = in.next();
                    s = pb.search(f);
                    System.out.println(s);
                    break;
                }
                case "4":{
                    pb.viewAll();
                    break;
                }
                case "5":{
                    flag = false;
                    break;
                }
            }
        }
    }
}
