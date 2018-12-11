package my.program;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        connectDB();
        Scanner in = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();
        boolean flag = true;
        String csv = "Users.csv";
        while(flag){
            System.out.println("1) Add Individual");
            System.out.println("2) Add Entity");
            System.out.println("3) Remove");
            System.out.println("4) Search");
            System.out.println("5) View all users");
            System.out.println("6) Read from CSV");
            System.out.println("7) Write in CSV");
            System.out.println("8) Add call for user:");
            System.out.println("9) View journal for user:");
            System.out.println("0) Exit");
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
                    User userq, userd;
                    System.out.println("Write FIO or Name:");
                    String f = in.next();
                    userq = pb.search2(f);
                    int id1 = userq.log.size();
                    System.out.println("Enter call time:");
                    int time = in.nextInt();
                    System.out.println("Enter the number of convives:");
                    int n = in.nextInt();
                    if(n == 0) break;
                    if(n == 1){
                        System.out.println("Enter name your convive:");
                        String a = in.next();
                        userd = pb.search2(a);
                        int id2 = userd.log.size();
                        try {
                            userq.addCall(id1,userq,userd,time);
                            userd.addCall(id2,userd,userq,time);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else{
                        User[] array = new User[n];
                        User tmp;
                        User u = userq;
                        for(int i=0;i<n;i++){
                            System.out.print("Enter name your convive №");
                            System.out.println(i+1);
                            String a = in.next();
                            array[i] = pb.search2(a);

                        }
                        int id = u.log.size();
                        u.addConf(id,time,array);
                        for(int i=0;i<n;i++){
                            tmp = array[i];
                            array[i] = u;
                            u = tmp;
                            id = u.log.size();
                            u.addConf(id,time,array);
                        }

                    }
                    break;
                }
                case "9":{
                    System.out.println("Write FIO or Name:");
                    String f = in.next();
                    User u1 = pb.search2(f);
                    try {
                        u1.viewCalls();
                    }catch (Exception e){
                        e.getMessage();
                        System.out.println(e);
                    }
                    break;
                }
                case "0":{
                    flag = false;
                    break;
                }
            }
        }
    }
    private static void connectDB (){
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        String URL = "jdbc:mysql://localhost:3306/eltex?serverTimezone=UTC&useSSL=false";
        String UserName = "root";
        String Password = "mark91";
        try(Connection connection = DriverManager.getConnection(URL,UserName,Password)) {
            System.out.println("Connected");
            Statement st = connection.createStatement();
            while (flag) {
                System.out.println("1)View all");
                System.out.println("2)Add user");
                System.out.println("3)Remove user");
                String n = in.next();
                switch (n) {
                    case "1": {
                        ResultSet resultSet = st.executeQuery("select * from user");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String fio = resultSet.getString(2);
                            String phone = resultSet.getString(3);
                            String sex = resultSet.getString(4);
                            String inn = resultSet.getString(5);
                            System.out.print(id + " ");
                            System.out.print(fio + " ");
                            System.out.print(phone + " ");
                            System.out.print(sex + " ");
                            System.out.println(inn);
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("1) Add Individual");
                        System.out.println("2) Add Entity");
                        System.out.println("0) Exit");
                        String s = in.next();
                        switch (s) {
                            case "1": {
                                System.out.println("Write FIO, phone and sex:");
                                String f = in.next();
                                String p = in.next();
                                String c = in.next();
                                String q = "insert user (fio, phone, sex)" +
                                        "value (\"" + f + "\", " +
                                        "\"" + p +"\", " +
                                        "\"" + c + "\");";
                                st.executeQuery(q);
                                break;
                            }
                            case "2": {
                                System.out.println("Write Name, phone and INN:");
                                String f = in.next();
                                String p = in.next();
                                String c = in.next();
                                String q = "insert user (fio, phone, inn)" +
                                        "value (\"" + f + "\", " +
                                        "\"" + p +"\", " +
                                        "\"" + c + "\");";
                                st.executeQuery(q);
                                break;
                            }
                            case "0":{
                                break;
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Enter the user ID of the user you want to delete:");
                        String f = in.next();
                        String q = "DELETE FROM user WHERE id = " + f + ";";
                        st.executeQuery(q);
                        break;
                    }
                    case "0": {
                        flag = false;
                        break;
                    }

                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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
