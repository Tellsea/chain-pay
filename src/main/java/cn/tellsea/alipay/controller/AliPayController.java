package cn.tellsea.alipay.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import cn.tellsea.alipay.config.AliPayConfig;
import cn.tellsea.alipay.service.AliPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝支付接口支付宝支付接口
 * <p>
 * 同步回调和异步回调的区别：https://blog.csdn.net/ruziwang/article/details/82499959
 *
 * @author Tellsea
 * @date 2020-9-14
 */
@Api(tags = "支付宝支付接口")
@Slf4j
@RestController
@RequestMapping("/aliPay")
public class AliPayController {

    @Autowired
    private AliPayService alipayService;

    @ApiOperation("电脑网站支付")
    @PostMapping("webPagePay")
    public String webPagePay(String outTradeNo, Double totalAmount, String subject, String body) throws AlipayApiException {
        return alipayService.webPagePay(outTradeNo, totalAmount, subject, body);
    }

    @ApiOperation("交易查询")
    @PostMapping("query")
    public String query(String outTradeNo, String tradeNo) throws AlipayApiException {
        return alipayService.query(outTradeNo, tradeNo);
    }

    @ApiOperation("退款")
    @PostMapping("refund")
    public String refund(String outTradeNo, String tradeNo, String refundReason, Double refundAmount, String outRequestNo) throws AlipayApiException {
        return alipayService.refund(outTradeNo, tradeNo, refundReason, refundAmount, outRequestNo);
    }

    @ApiOperation("退款查询")
    @PostMapping("refundQuery")
    public String refundQuery(String outTradeNo, String tradeNo, String outRequestNo) throws AlipayApiException {
        return alipayService.refundQuery(outTradeNo, tradeNo, outRequestNo);
    }

    @ApiOperation("交易关闭")
    @PostMapping("close")
    public String close(String outTradeNo, String tradeNo) throws AlipayApiException {
        return alipayService.close(outTradeNo, tradeNo);
    }

    @ApiOperation(value = "对账单下载地址", notes = "返回对账单下载地址")
    @PostMapping("billDownloadUrl")
    public String billDownloadUrl(String billType, String billDate) throws AlipayApiException {
        return alipayService.billDownloadUrl(billType, billDate);
    }

    @ApiOperation("web端-同步回调")
    @GetMapping("returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request) throws AlipayApiException {
        log.info("web端-同步回调：");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = getReturnParam(request);
        // 调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.CHARSET, AliPayConfig.SIGN_TYPE);
        if (signVerified) {
            // 商户订单号
            String out_trade_no = params.get("out_trade_no");
            // 支付宝交易号
            String trade_no = params.get("trade_no");
            //付款金额
            String total_amount = params.get("total_amount");
        } else {
            log.error("web端-同步回调：验签失败");
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("alipay/return_url");
        return view;
    }

    @ApiOperation("web端-异步回调")
    @PostMapping("notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws AlipayApiException {
        // 获取支付宝POST过来反馈信息
        log.info("web端-异步回调：");
        Map<String, String> params = getReturnParam(request);
        // 调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.CHARSET, AliPayConfig.SIGN_TYPE);
        //——请在这里编写您的程序（以下代码仅作参考）——
        /* 实际验证过程建议商户务必添加以下校验：
        1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
        4、验证app_id是否为该商户本身。
        */
        // 验证成功
        if (signVerified) {
            // 商户订单号
            String out_trade_no = params.get("out_trade_no");
            // 支付宝交易号
            String trade_no = params.get("trade_no");
            // 交易状态
            String trade_status = params.get("trade_status");
            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
            System.out.println("success");
        } else {
            log.error("web端-异步回调：验签失败");
            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }

    /**
     * 获得请求中的参数
     *
     * @param request
     * @return
     */
    private static Map<String, String> getReturnParam(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>(16);
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            /*try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
            params.put(name, valueStr);
        }
        log.info("request获取返回参数：{}", JSON.toJSONString(params));
        return params;
    }
}
