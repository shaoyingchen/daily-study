package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chensy6@asiainfo.com
 * @Company 亚信科技
 * @Copyright asiainfo
 * @CreateDate 2021/7/6 15:07
 **/
public class CalculateProxy {

    public static Calculate getProxy(final Calculate calculate) {
        ClassLoader classLoader = calculate.getClass().getClassLoader();
        Class<?>[] interfaces = calculate.getClass().getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> method.invoke(calculate,args);

        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (Calculate) o;
    }

}
