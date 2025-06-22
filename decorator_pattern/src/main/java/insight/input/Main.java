package insight.input;

import java.io.File;
import java.io.FileInputStream;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/1.pdf");
        long time = Instant.now().toEpochMilli();
        // 装饰器模式实现的缓冲文件输入流
        try (BufferedFileInputStream bufferedFileInputStream = new BufferedFileInputStream(new FileInputStream(file))) {
           while (true) {
               int read = bufferedFileInputStream.read();
               if (read == -1) {
                   break;
               }
           }
            System.out.println("读取文件耗时: " + (Instant.now().toEpochMilli() - time) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}