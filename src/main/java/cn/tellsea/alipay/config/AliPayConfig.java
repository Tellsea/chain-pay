package cn.tellsea.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tellsea
 * @date 2020/09/16
 */
public class AliPayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String APP_ID = "2016092100564408";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String MERCHANT_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKgZ8jP8O9YIsH5XnKWNmmQaKBVye1MivSdXY5k7bApscUSBJo3mXXb1krFMv4cjPihU4UJkY3ll6yIuXenCxtsF9yo41RTrF9Xxp7x+OEngpkr8c8nDCCLk9kEcJqD5hm8V2p3wRSSsUUsAns+1lnfD3yvPOmR/f85G5JTYDhXmwSlihSMZ6N51zY/3gHoI1rc0NOeu9b804BkpZj2tIZr+MI7LsylEpORdcR3vjMd03LJ+fyqWCXgjd/e4xHTSUTr4nr1C0GpbLrlIw284B6lA4tnnF79w0k9y1aPh9mnNhlT3hby7Ehs1Fqmxok0jEWXsNK0c38DQQ4kugWg8GPAgMBAAECggEASR2MCGuMxNfGDPESjcLBgoZ7ZpO/nmNRxtPDCTn061YfGZHCRiHA2S0qgReFZS3EPfvo77IUtxtl+dt6RT1kJrNIb5fu7dEA2RHvRRCMBmH3UpeIMXKyGMahmk3Vt29sIEuiCh50hYx65STY2IUG+R4ZBZ7BcDHls1ZS8dc8BbuuDrutRQH1baa+PbRzstEHY7ZxzuXnuLMK4emEv9qD/pyX2DDk6HmokyGEXAq3Izl6ger8GxVx96c7D3sLL8vS4tMavAIBKKEZLXSakv2a93XoDmd12WFZp1xPgsz9k6cMkUDj8R/TCOnELKt3RIqVwX3mOQjJD7nx2xLvVTI2oQKBgQDWXFRhEuVuXuzRbDk9l2LggIGxQLxGD2iaKPz71Yr7BnLbMuAuFAK0f3uo9D09T4ZXXDaG+OI8GShYKw4BrV7ObFIPfMq/EtYLLMQXscHLLDbAfE5nNSay/YhoOcAYAgw1GEo1KlIZqvwpLYe8AVNGYXVqysIf7PzmDLkjNWfolQKBgQClaTpg601LgY7dcJosxOruNQuixF8Y1mwSJAdcoARz/+fyC600lEsxBJ1P5/JG2rw7/rkJjh2XxdLDbXuFm5D2yxN/08kh3S5UFIx/AFLnUfgURMcGgufFnzvtegZjQ0L/pZlWHyAdAg+H+QBG507FrZLUnarZ1OifEQc+nkNkkwKBgQCRLQzUhbiuzEk0+Ee4B+wmQcIUKtSX2l2scnALmq86nT5yZ/1eF51RYzl7zpYfDNneFoyzUqHds+gX9mjRB/q6cLAO3yRszbP684GGzpOCJ1qZeFadHWktNfoJJHuNhu1/lAjGAviBe8S1mqlf0cH1W5HrFpDskFMi9qD4UHYkFQKBgHkXPLaA63fwI482hJdrnPS/foIssdVz+2+YUo9bUYc9+yX1qFnKifUbhLJfgbyfGpftFLbLBBz8pBuPBZM83HXfGqpEd4TD78t7s5KxwP84wZzM8MpygIvq0ys5Xn3CWsTeDQ+//3lc7dPD1JETelY6iDgAKHgJZjY0eBI+N+XjAoGAGQEkfZpiXpHdFiJytdtAwPe03W0UDf4BAIu1EEdE6z311UAVsxJtRnCIfPIdDkJ3+2JAYLBAFET2DzIliKSxWSIJjPJIzJ7KdGBy6fWTolqAV8rn0gtiUG9SQTsitIqLF4Tkdp2m0isd+Nw2FbLsfyEx4mNMh6vkeSHV4DmOM2M=";

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

