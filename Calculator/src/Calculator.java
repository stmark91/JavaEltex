import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String s = in.next();
        int b = in.nextInt();
        Functions f = new Functions(a,b);
        switch (s){
            case "+" :f.add();break;
            case "-" :f.sub();break;
            case "*" :f.mul();break;
            case "/" :f.div();break;
        }
        int ans = f.getAns();
        System.out.println(ans);
    }
}
