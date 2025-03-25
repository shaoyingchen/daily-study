package lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chensy6
 * @CreateDate 2021/4/13 16:09
 **/
public class CasTest {

    private static Unsafe UNSAFE;
    private static long COUNTER_OFFSET;

    static int a = 0;
    static int counter = 1;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            Class<CasTest> casTestClass = CasTest.class;
            COUNTER_OFFSET = UNSAFE.staticFieldOffset(casTestClass.getDeclaredField("counter"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lock() {
        for (; ; ) {
            if (UNSAFE.compareAndSwapInt(CasTest.class, COUNTER_OFFSET, 1, 0)) {
                break;
            }
            Thread.yield();
        }
    }

    public static void unlock() {
        counter = 1;
    }

    public static void incr() {
        lock();
        a++;
        unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> incr());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(a);
    }

}
