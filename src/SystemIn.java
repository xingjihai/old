import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入：");
        BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入：");
        char c;
        do {
            c=(char) br.read();
            System.out.println(c);
        } while (c!='q');
        char d;
        do {
            d=(char) br2.read();
            System.out.println(c);
        } while (d!='q');
    }
}
