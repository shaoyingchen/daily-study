package proxy.jdk;

/**
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/7/6 15:14
 **/
public class JdkTest {

    public static void main(String[] args) {
        Calculate calculate = CalculateProxy.getProxy(new MyCalculate());
        System.out.println(calculate.add(1,1));
    }

}
