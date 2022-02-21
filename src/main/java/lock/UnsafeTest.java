package lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author chensy6
 * @CreateDate 2021/11/1 17:16
 **/
public class UnsafeTest {

    private static Unsafe UNSAFE;

    private static long COUNTER_OFFSET;

    private static int count = 1;

    private static int a = 1;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            Class<UnsafeTest> unsafeTest = UnsafeTest.class;
            COUNTER_OFFSET = UNSAFE.staticFieldOffset(unsafeTest.getDeclaredField("count"));
        } catch (Exception e) {

        }
    }

    public static void lock() {
        for (; ; ) {
            if (UNSAFE.compareAndSwapInt(UnsafeTest.class, COUNTER_OFFSET, 1, 0)) {
                break;
            }
            Thread.yield();
        }
    }

    public static void unlock() {
        count = 1;
    }

    public static void add() {
        lock();
        a++;
        unlock();
    }
}
