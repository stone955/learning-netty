package org.stone.learning.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        // 创建一个buffer
        IntBuffer buf = IntBuffer.allocate(10);
        // 向buffer存放数据
        for (int i = 0; i < buf.capacity(); i++) {
            buf.put(i * 2);
        }
        // 读写切换
        buf.flip();

        // 读buffer
        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }
    }

}
