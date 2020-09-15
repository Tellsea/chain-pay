package cn.tellsea.alipay.service.impl;

import cn.tellsea.alipay.config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import cn.tellsea.alipay.service.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 支付宝支付接口 实现类
 *
 * @author Tellsea
 * @date 2020/09/15
 */
@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {

    /**
     * web端支付
     */
    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID, AlipayConfig.MERCHANT_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);

    @Override
    public String webPagePay(String outTradeNo, Double totalAmount, String subject, String body) throws AlipayApiException {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
        return alipayClient.pageExecute(alipayRequest).getBody().replace('\"','\'').replace('\n',' ');
    }

    @Override
    public String appPagePay(String outTradeNo, Integer totalAmount, String subject, String body) throws Exception {
        return null;
    }

    @Override
    public String query(String outTradeNo, String tradeNo) throws AlipayApiException {
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"trade_no\":\"" + tradeNo + "\"}");
        return alipayClient.execute(alipayRequest).getBody();
    }

    @Override
    public String refund(String outTradeNo, String tradeNo, String refundReason, Double refundAmount, String outRequestNo) throws AlipayApiException {
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"trade_no\":\"" + tradeNo + "\","
                + "\"refund_amount\":\"" + refundAmount + "\","
                + "\"refund_reason\":\"" + refundReason + "\","
                + "\"out_request_no\":\"" + outRequestNo + "\"}");
        return alipayClient.execute(alipayRequest).getBody();
    }

    @Override
    public String refundQuery(String outTradeNo, String tradeNo, String outRequestNo) throws AlipayApiException {
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"trade_no\":\"" + tradeNo + "\","
                + "\"out_request_no\":\"" + outRequestNo + "\"}");
        return alipayClient.execute(alipayRequest).getBody();
    }

    @Override
    public String close(String outTradeNo, String tradeNo) throws AlipayApiException {
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"trade_no\":\"" + tradeNo + "\"}");
        return alipayClient.execute(alipayRequest).getBody();
    }

    @Override
    public String billDownloadUrl(String billType, String billDate) throws AlipayApiException {
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "\"bill_type\":\"" + billType + "\"," +
                "\"bill_date\":\"" + billDate + "\"" +
                "  }");
        return alipayClient.execute(request).getBody().replace('\"','\'').replace('\n',' ');
    }
}
