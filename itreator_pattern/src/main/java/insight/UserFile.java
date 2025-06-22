package insight;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserFile implements Iterable<User>{

    private final File file;

    public UserFile(File file) {
        this.file = file;
    }

    @Override
    public Iterator<User> iterator() {
        return new UserFileIterator();
    }

    class UserFileIterator implements Iterator<User>{

        List<User> userList  = LoadUserFromFile(file);
        int cursor = 0;

        private List<User> LoadUserFromFile(File file) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                return lines.stream().map(
                        line-> {
                            String midString = line.substring(1, line.length() - 1);
                            String[] split = midString.split(",");
                            return new User(split[0], Integer.parseInt(split[1]));
                        }
                ).collect(Collectors.toList());

            }catch (IOException e) {
                e.getStackTrace();
                return List.of();
            }

        }

        @Override
        public boolean hasNext() {
            return cursor != userList.size();
        }

        @Override
        public User next() {
            if (cursor >= userList.size()) {
                throw new NoSuchElementException();
            }
            int currentIndex = cursor;
            cursor++;
            return userList.get(currentIndex);
        }
    }
}