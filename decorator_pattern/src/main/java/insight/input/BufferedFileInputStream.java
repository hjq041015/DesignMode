package insight.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedFileInputStream extends InputStream {

    // 缓冲区，用于存储从文件中读取的数据
    private final byte[] buffer = new byte[8192];

    // 当前缓冲区读取位置
    private int position = 0;

    // 当前缓冲区的有效数据大小
    private int capacity = 0;

    // 文件输入流，用于从文件中读取数据
    private final FileInputStream fileInputStream;

    // 构造方法，初始化文件输入流
    public BufferedFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @Override
    public int read() throws IOException {
        // 如果缓冲区可以读取，则从缓冲区读取数据
        if (bufferCanRead()) {
            return readFromBuffer();
        }
        // 刷新缓冲区，从文件中读取新的数据
        refreshBuffer();
        // 如果缓冲区仍然无法读取，则返回 -1 表示文件结束
        if (!bufferCanRead()) {
            return -1;
        }
        // 从缓冲区读取数据
        return readFromBuffer();
    }

    // 刷新缓冲区，从文件输入流中读取数据到缓冲区
    private void refreshBuffer() throws IOException {
        position = 0;
        capacity = this.fileInputStream.read(buffer);
    }

    // 从缓冲区读取一个字节数据
    private int readFromBuffer() {
        return buffer[position++] & 0xFF; // 将 byte 转换为无符号整数
    }

    // 检查缓冲区是否可以读取数据
    private boolean bufferCanRead() {
        if (capacity == -1) { // 文件结束
            return false;
        }
        if (position == capacity) { // 缓冲区数据已读完
            return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        // 关闭流，释放资源
       fileInputStream.close();
    }
}