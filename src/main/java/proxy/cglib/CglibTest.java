package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/7/6 15:21
 **/
public class CglibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MyCglib());
        enhancer.setSuperclass(MyCalucate.class);
        MyCalucate calucate = (MyCalucate) enhancer.create();
        System.out.println(calucate.add(1,4));
        System.out.println(calucate.getClass());
    }

}
