package cn.tellsea.alipay.service;

import com.alipay.api.AlipayApiException;

/**
 * 支付宝支付接口
 *
 * @author Tellsea
 * @date 2020-9-15
 */
public interface AliPayService {

    /**
     * 电脑网站支付
     *
     * @param outTradeNo  订单编号（唯一），必填
     * @param totalAmount 订单价格，必填
     * @param subject     商品名称，必填
     * @param body        商品描述，可空
     */
    String webPagePay(String outTradeNo, Double totalAmount, String subject, String body) throws AlipayApiException;

    /**
     * app端订单支付
     *
     * @param outTradeNo  订单编号
     * @param totalAmount 订单价格
     * @param subject     商品名称
     * @param body        商品描述
     */
    String appPagePay(String outTradeNo, Integer totalAmount, String subject, String body) throws Exception;

    /**
     * 交易查询
     * 商户订单号outTradeNo，支付宝交易号tradeNo 二选一
     *
     * @param outTradeNo 订单编号（唯一）
     * @param tradeNo
     * @return
     * @throws AlipayApiException
     */
    String query(String outTradeNo, String tradeNo) throws AlipayApiException;

    /**
     * 退款
     *
     * @param outTradeNo   订单编号
     * @param tradeNo      支付宝交易号
     * @param refundReason 退款原因
     * @param refundAmount 退款金额
     * @param outRequestNo 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     * @return
     * @throws AlipayApiException
     */
    String refund(String outTradeNo, String tradeNo, String refundReason, Double refundAmount, String outRequestNo) throws AlipayApiException;

    /**
     * 退款查询
     * 商户订单号outTradeNo，支付宝交易号tradeNo 二选一，这里我使用商户订单号
     *
     * @param outTradeNo   订单编号（唯一）
     * @param tradeNo      支付宝交易号
     * @param outRequestNo 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
     * @return
     * @throws AlipayApiException
     */
    String refundQuery(String outTradeNo, String tradeNo, String outRequestNo) throws AlipayApiException;

    /**
     * 交易关闭
     *
     * @param outTradeNo 订单编号（唯一）
     * @param tradeNo    支付宝交易号
     * @return
     * @throws AlipayApiException
     */
    String close(String outTradeNo, String tradeNo) throws AlipayApiException;

    /**
     * 对账单下载地址
     * https://openhome.alipay.com/platform/demoManage.htm#/alipay.data.dataservice.bill.downloadurl.query
     *
     * @param billType 账单类型：trade（商户基于支付宝交易收单的业务账单）、signcustomer（基于商户支付宝余额收入及支出等资金变动的帐务账单）
     * @param billDate 账单时间：日账单格式为yyyy-MM-dd，最早可下载2016年1月1日开始的日账单；月账单格式为yyyy-MM，最早可下载2016年1月开始的月账单
     * @return 返回对账单下载地址
     * @throws AlipayApiException
     */
    String billDownloadUrl(String billType, String billDate) throws AlipayApiException;
}
