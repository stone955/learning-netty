package org.stone.learning.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Transfer {

    public static void main(String[] args) throws Exception {
        // 构建文件输入、输出流
        FileInputStream in = new FileInputStream("C:\\Users\\stone\\Project\\java\\stone\\learning-netty\\src\\main\\java\\org\\stone\\learning\\nio\\a.jpg");
        FileOutputStream out = new FileOutputStream("C:\\Users\\stone\\Project\\java\\stone\\learning-netty\\src\\main\\java\\org\\stone\\learning\\nio\\b.jpg");

        // 构建输入、输出流对应的 Channel
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();

        try {
            // 使用 transferFrom 完成拷贝
//            outChannel.transferFrom(inChannel, 0, inChannel.size());
            // 使用 transferTo 完成拷贝
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            inChannel.close();
            outChannel.close();
            in.close();
            out.close();
        }
    }
}
