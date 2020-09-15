package cn.tellsea.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tellsea
 * @date 2020-9-15
 */
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String APP_ID = "2016092100564408";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String MERCHANT_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDfdvaJ90KjiJuNZ1qRmyQxfr7DHT5jm7IZX5fLVuD/8IEhxPma0OCEFbycdc95YJ00J+QIdJIVjoV0AAd6jkM5skBMBCYP8xv1bT0E6LDI0L2F+okhGzVVlc0M8s86T9age1UpnIoWe+JX8FCjeBwt35yxmCAc/SO5qG+BYJoZf853toHZAbMED4SKmkTxWwkN2qWlFA+uQXh0ddmqmYUYHVBKjGsUHICjfE8QM1tQ/HLa2yKqpJTDKQWVurlS1+fngfkFI6pYTlB/GTtJEPQJrhmF/E8pmoViu//BplAlJTfJMloJXuhpFAuiuVQcL/8RHPujSzXOyceUYytj7e/tAgMBAAECggEAJQ3B1aC1YQ5+1JSltO0ntDlTAmFv/e5MOt7Z+bKfPnEvyFy0EtK918kO7Fawn2zAxGw06J4DtyVZxaFXnB/Iz+FZvgEWGqDyKuEBNDYtUi8irfucD2xGjLl5NcNxTzb73MJ2nZ7CWvYR0wkbJe/9pDGm9t/Fu2jSKq/eRXKyOrXiOvrjEpwlc/CIoTH1wthCFM5J9rZo3iJP7UCQMckRZvLp/riJ3JdV5RGQv9YCGyEjmxXvcLJwPo7M2mm6DSM1Rf27aeEY0KVesOsMTXGIPjks4ifPzNtLodoNLgHZWJEkEMglhtrI5l0u8UUDlj6ARSVMfW1w0ZfP/WcO0qccIQKBgQD1U4KYQfS7wf16AbluWvDFuyamhRq/uhFYXYevVxdrKIAyLjnaTTfkPt5kSRsUBlsbOAm/KSldX82b8Ao9ifrfd7tLl/YxDTbacbKFxixHO6rqtg9MRPqxy+EFx6oG75fZQt5x86W/PqM9QQ0+XbsBYgrDAGpnmLzxQZHix/3j+QKBgQDpL/SKmCEPGKgW4p5iJasMSoUZUiSG2o2Zri6PqaDi+c6E5p9NZjVIuwnoxA/Gi9TwivcFcvkD3ild4xEVB51Y4YkQnOqyAJ8xHbuU62wLTMQLzEIOHUEjHbrX3SB2Sd71LViKR1QCq1J08kUAHK9mzlebWU880CYZyYvmu/pAlQKBgQDS3Iaha/946pJ+LcE+UzgkHGpqMnn9VWbXNv0K/qaIWnVlrEnZkwl5S3hHZna5zYS9bnsiLbT6JwBJChcjMdfJ/9WicekP3DXLqHIzfVRNncGYoAeiHKAF9iFhoG5KK+GuwkUEWNGcAbC5U5KYimPUGnr5hP/wL14nV56W+CMHsQKBgQCQ2a8oIJP4krJndOI5yXhVLD09m18BPeXT3vUhXJeKJu74c2HlbGYRBc6D/rZl+RqPSWNkySSSGIDNx20nCRHe0kqYPUE0zVoV4ohRW2REKK1nPryRk+6QZ7lWug+eKwkKd96WFvTCq7WO26etCCSU0fxtja7A8fOY9S+oZoBveQKBgG2LpaDDfazK0mqICyFEsWdayshlPJeMYUPgeOKgpPoY5k5SM3d2w6qm7DiCabHs64VeIt5wFpahYVIPtbzFG4Ci62r2iWcJ6uDOXB70c6Gp51im5izvb6kkbkndwpI3kOklwvX3zlfkEva+N9ZXDea7Q6+cOmTiW0YO9ovgN68q";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4CvpSIrWbPA4UlW6l5X+bi7Ee1+lrsh/6JoaPH+aqz21fMq2L+q6qjgznWfFUAsj9xJ5u6HIvu+57UXytm5LyYg2zha4aC3McwCvpVvnY8UjRBk+nciFpWxZxegNj9/YZv3B8xdq0G/7uB3aBySK2mEesNxI5FpkG0lQjEvrF8l3rxTlbNlvFNCsG2GnXg7QYD7Hi0YttLxXNws2QsP83GRHGgFNblH0H11WR547W4zvo4zqpY3/btg15fCVrjOwBr1pashHEkNU0LlQCkMZMf641lWwd9neVOwjhLfRr3e7pHkUH3g3IfV+mkPc3EF3455548r1WwyxZzok0J+W6QIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String NOTIFY_URL = "http://tellsea.4kb.cn/aliPay/notifyUrl";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String RETURN_URL = "http://tellsea.4kb.cn/aliPay/returnUrl";

    /**
     * 签名方式
     */
    public static String SIGN_TYPE = "RSA2";

    /**
     * 字符编码格式
     */
    public static String CHARSET = "utf-8";

    /**
     * 支付宝网关
     */
    public static String GATEWAYURL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝网关
     */
    public static String LOG_PATH = "C:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

