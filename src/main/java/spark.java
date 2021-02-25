
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class spark {
    public static void main(String[] args) throws IOException {
        long pre = System.currentTimeMillis();
        long now = System.currentTimeMillis();

        File f = new File("/home/ubuntu/logs/physicplan.txt");
        FileWriter fw = new FileWriter(f, true); // true,进行追加写。

        PrintWriter pw = new PrintWriter(fw);
        pw.println(now - pre);
        pw.println(54655465);
        pw.println("asdasdasd");
        pw.flush();
        //pw.close();
        System.out.println(now - pre);
    }
}
