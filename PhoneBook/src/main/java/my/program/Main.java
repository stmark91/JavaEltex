package my.program;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();
        boolean flag = true;
        String csv = "data.csv";
        while(flag){
            System.out.println("1) Add Individual");
            System.out.println("2) Add Entity");
            System.out.println("3) Remove");
            System.out.println("4) Search");
            System.out.println("5) View all users");
            System.out.println("6) Read from CSV");
            System.out.println("7) Write in CSV");
            System.out.println("8) Exit");
            String s = in.next();
            switch (s){
                case "1":{
                    System.out.println("Write FIO, phone and sex:");
                    String f = in.next();
                    String p = in.next();
                    String c = in.next();
                    pb.addIndividual(f,p,c);
                    break;
                }
                case "2":{
                    System.out.println("Write Name, phone and INN:");
                    String f = in.next();
                    String p = in.next();
                    int c = in.nextInt();
                    pb.addEntity(f,p,c);
                    break;
                }
                case "3":{
                    System.out.println("Write FIO or Name:");
                    String f = in.next();
                    pb.remove(f);
                    break;
                }
                case "4":{
                    System.out.println("Write FIO or Name:");
                    String f = in.next();
                    s = pb.search(f);
                    System.out.println(s);
                    break;
                }
                case "5":{
                    pb.viewAll();
                    break;
                }
                case "6":{
                    try(FileReader reader1 = new FileReader(csv)) {
                        BufferedReader reader = new BufferedReader(new FileReader(csv));
                        String tmp2 = "", tmp1 = "", tmp3 = "";
                        String line;
                        Scanner scanner;
                        int index = 0;
                        while ((line = reader.readLine()) != null) {
                            scanner = new Scanner(line);
                            scanner.useDelimiter(",");
                            while (scanner.hasNext()) {
                                String data = scanner.next();
                                if (index == 0)
                                    tmp1 = data;
                                else if (index == 1)
                                    tmp2 = data;
                                else if (index == 2)
                                    tmp3 = data;
                                else
                                    System.out.println("Некорректные данные::" + data);
                                index++;
                            }
                            index = 0;
                            if(isDigit(tmp3)) {
                                int tmp = Integer.parseInt(tmp3);
                                pb.addEntity(tmp1, tmp2, tmp);
                            }
                            else {
                                pb.addIndividual(tmp1, tmp2, tmp3);
                            }
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "7":{
                    pb.writeToCSV(csv);
                    break;
                }
                case "8":{
                    flag = false;
                    break;
                }
            }
        }
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
