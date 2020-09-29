package org.csu.coderlee.jvm;

/**
 * 配置VM options一下参数，运行main方法
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 *
 * 返回内容
 * Heap
 *  PSYoungGen      total 9216K, used 2283K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 27% used [0x00000007bf600000,0x00000007bf83afa8,0x00000007bfe00000)
 *   from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *  ParOldGen       total 10240K, used 0K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 10240K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf600000)
 *  Metaspace       used 3096K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 339K, capacity 388K, committed 512K, reserved 1048576K
 *
 */
public class Test {
    public static void main(String[] args) {

    }
}
