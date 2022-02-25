package leetCode;

/**
 * 537. 复数乘法
 * <p>
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 * @author chensy6
 * @CreateDate 2022/2/25 09:12
 **/
public class LeetCode537 {

    /**
     * 输入：num1 = "1+1i", num2 = "1+1i"
     * 输出："0+2i"
     * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String complexNumberMultiply(String num1, String num2) {
        String[] split = num1.split("\\+");
        String[] split1 = num2.split("\\+");

        int shi = Integer.valueOf(split[0]) * Integer.valueOf(split1[0]);
        int xu =
                Integer.valueOf(split[0]) * Integer.valueOf(split1[1].substring(0, split1[1].length() - 1)) + Integer.valueOf(split1[0]) * Integer.valueOf(split[1].substring(0, split[1].length() - 1));
        int end = Integer.valueOf(split[1].substring(0, split[1].length() - 1)) * Integer.valueOf(split1[1].substring(0, split1[1].length() - 1)) * -1;
        return (shi + end) + "+" + xu + "i";
    }


}
