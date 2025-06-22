package insight;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("demo.user");
        UserFile userFile = new UserFile(file);
        for (User user : userFile) {
            System.out.println(user);
        }
    }
}