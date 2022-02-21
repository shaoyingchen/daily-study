package lock;

/**
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/5/26 17:16
 **/
public class ThreadLocalTest {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("1");
        threadLocal.set("2");
        System.out.println(threadLocal.get());
    }

}
