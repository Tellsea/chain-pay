<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>支付宝电脑网站支付</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        ul, ol {
            list-style: none;
        }

        body {
            font-family: "Helvetica Neue", Helvetica, Arial, "Lucida Grande",
            sans-serif;
        }

        .tab-head {
            margin-left: 120px;
            margin-bottom: 10px;
        }

        .tab-content {
            clear: left;
            display: none;
        }

        h2 {
            border-bottom: solid #02aaf1 2px;
            width: 200px;
            height: 25px;
            margin: 0;
            float: left;
            text-align: center;
            font-size: 16px;
        }

        .selected {
            color: #FFFFFF;
            background-color: #02aaf1;
        }

        .show {
            clear: left;
            display: block;
        }

        .hidden {
            display: none;
        }

        .new-btn-login-sp {
            padding: 1px;
            display: inline-block;
            width: 75%;
        }

        .new-btn-login {
            background-color: #02aaf1;
            color: #FFFFFF;
            font-weight: bold;
            border: none;
            width: 100%;
            height: 30px;
            border-radius: 5px;
            font-size: 16px;
        }

        #main {
            width: 100%;
            margin: 0 auto;
            font-size: 14px;
        }

        .red-star {
            color: #f00;
            width: 10px;
            display: inline-block;
        }

        .null-star {
            color: #fff;
        }

        .content {
            margin-top: 5px;
        }

        .content dt {
            width: 100px;
            display: inline-block;
            float: left;
            margin-left: 20px;
            color: #666;
            font-size: 13px;
            margin-top: 8px;
        }

        .content dd {
            margin-left: 120px;
            margin-bottom: 5px;
        }

        .content dd input {
            width: 85%;
            height: 28px;
            border: 0;
            -webkit-border-radius: 0;
            -webkit-appearance: none;
        }

        #foot {
            margin-top: 10px;
            position: absolute;
            bottom: 15px;
            width: 100%;
        }

        .foot-ul {
            width: 100%;
        }

        .foot-ul li {
            width: 100%;
            text-align: center;
            color: #666;
        }

        .note-help {
            color: #999999;
            font-size: 12px;
            line-height: 130%;
            margin-top: 5px;
            width: 100%;
            display: block;
        }

        #btn-dd {
            margin: 20px;
            text-align: center;
        }

        .foot-ul {
            width: 100%;
        }

        .one_line {
            display: block;
            height: 1px;
            border: 0;
            border-top: 1px solid #eeeeee;
            width: 100%;
            margin-left: 20px;
        }

        .am-header {
            display: -webkit-box;
            display: -ms-flexbox;
            display: box;
            width: 100%;
            position: relative;
            padding: 7px 0;
            -webkit-box-sizing: border-box;
            -ms-box-sizing: border-box;
            box-sizing: border-box;
            background: #1D222D;
            height: 50px;
            text-align: center;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            box-pack: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            box-align: center;
        }

        .am-header h1 {
            -webkit-box-flex: 1;
            -ms-flex: 1;
            box-flex: 1;
            line-height: 18px;
            text-align: center;
            font-size: 18px;
            font-weight: 300;
            color: #fff;
        }
    </style>
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>
<header class="am-header">
    <h1>支付宝电脑网站支付体验入口页</h1>
</header>
<div id="main">
    <div id="tabhead" class="tab-head">
        <h2 id="tab1" class="selected" name="tab">付 款</h2>
        <h2 id="tab2" name="tab">交 易 查 询</h2>
        <h2 id="tab3" name="tab">退 款</h2>
        <h2 id="tab4" name="tab">退 款 查 询</h2>
        <h2 id="tab5" name="tab">交 易 关 闭</h2>
        <h2 id="tab6" name="tab">下载对账单</h2>
    </div>
    <form name=alipayment action=/aliPay/webPagePay method=post
          target="_blank">
        <div id="body1" class="show" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="WIDout_trade_no" name="outTradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>订单名称 ：</dt>
                <dd>
                    <input id="WIDsubject" name="subject"/>
                </dd>
                <hr class="one_line">
                <dt>付款金额 ：</dt>
                <dd>
                    <input id="WIDtotal_amount" name="totalAmount"/>
                </dd>
                <hr class="one_line">
                <dt>商品描述：</dt>
                <dd>
                    <input id="WIDbody" name="body"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">付 款</button>
						</span> <span class="note-help">如果您点击“付款”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <form name=tradequery action=/aliPay/query method=post
          target="_blank">
        <div id="body2" class="tab-content" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="WIDTQout_trade_no" name="outTradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>支付宝交易号 ：</dt>
                <dd>
                    <input id="WIDTQtrade_no" name="tradeNo"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">交 易 查 询</button>
						</span> <span class="note-help">商户订单号与支付宝交易号二选一，如果您点击“交易查询”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <form name=traderefund action=/aliPay/refund method=post
          target="_blank">
        <div id="body3" class="tab-content" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="WIDTRout_trade_no" name="outTradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>支付宝交易号 ：</dt>
                <dd>
                    <input id="WIDTRtrade_no" name="tradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>退款金额 ：</dt>
                <dd>
                    <input id="WIDTRrefund_amount" name="refundAmount"/>
                </dd>
                <hr class="one_line">
                <dt>退款原因 ：</dt>
                <dd>
                    <input id="WIDTRrefund_reason" name="refundReason"/>
                </dd>
                <hr class="one_line">
                <dt>退款请求号 ：</dt>
                <dd>
                    <input id="WIDTRout_request_no" name="outRequestNo"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">退 款</button>
						</span> <span class="note-help">商户订单号与支付宝交易号二选一，如果您点击“退款”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <form name=traderefundquery
          action=/aliPay/refundQuery method=post
          target="_blank">
        <div id="body4" class="tab-content" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="WIDRQout_trade_no" name="outTradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>支付宝交易号 ：</dt>
                <dd>
                    <input id="WIDRQtrade_no" name="tradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>退款请求号 ：</dt>
                <dd>
                    <input id="WIDRQout_request_no" name="outRequestNo"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">退 款 查 询</button>
						</span> <span class="note-help">商户订单号与支付宝交易号二选一，如果您点击“退款查询”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <form name=tradeclose action=/aliPay/close method=post
          target="_blank">
        <div id="body5" class="tab-content" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="WIDTCout_trade_no" name="outTradeNo"/>
                </dd>
                <hr class="one_line">
                <dt>支付宝交易号 ：</dt>
                <dd>
                    <input id="WIDTCtrade_no" name="tradeNo"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">交 易 关 闭</button>
						</span> <span class="note-help">商户订单号与支付宝交易号二选一，如果您点击“交易关闭”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <form name=billdownloadurl action=/aliPay/billDownloadUrl method=post
          target="_blank">
        <div id="body6" class="tab-content" name="divcontent">
            <dl class="content">
                <dt>商户订单号 ：</dt>
                <dd>
                    <input id="billdwnurl_type" name="billType"/>
                </dd>
                <hr class="one_line">
                <dt>支付宝交易号 ：</dt>
                <dd>
                    <input id="billdwnurl_date" name="billDate"/>
                </dd>
                <hr class="one_line">
                <dt></dt>
                <dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
                                    style="text-align: center;">对账单下载地址</button>
						</span> <span class="note-help">商户订单号与支付宝交易号二选一，如果您点击“交易关闭”按钮，即表示您同意该次的执行操作。</span>
                </dd>
            </dl>
        </div>
    </form>
    <div id="foot">
        <ul class="foot-ul">
            <li>支付宝版权所有 2015-2018 ALIPAY.COM</li>
        </ul>
    </div>
</div>
</body>
<script language="javascript">
    var tabs = document.getElementsByName('tab');
    var contents = document.getElementsByName('divcontent');

    (function changeTab(tab) {
        for (var i = 0, len = tabs.length; i < len; i++) {
            tabs[i].onmouseover = showTab;
        }
    })();

    function showTab() {
        for (var i = 0, len = tabs.length; i < len; i++) {
            if (tabs[i] === this) {
                tabs[i].className = 'selected';
                contents[i].className = 'show';
            } else {
                tabs[i].className = '';
                contents[i].className = 'tab-content';
            }
        }
    }

    function GetDateNow() {
        var vNow = new Date();
        var sNow = "";
        sNow += String(vNow.getFullYear());
        sNow += String(vNow.getMonth() + 1);
        sNow += String(vNow.getDate());
        sNow += String(vNow.getHours());
        sNow += String(vNow.getMinutes());
        sNow += String(vNow.getSeconds());
        sNow += String(vNow.getMilliseconds());

        // 付款
        document.getElementById("WIDout_trade_no").value = sNow;
        document.getElementById("WIDsubject").value = "耐克 男子 NIKE AIR FORCE 1 '07 AF1 运动鞋 315122 315122-111 42";
        document.getElementById("WIDtotal_amount").value = "700.00";
        document.getElementById("WIDbody").value = "商品名称：耐克 男子 NIKE AIR FORCE 1 '07 AF1 运动鞋 315122 315122-111 42商品编号：30230780037店铺： TOPSPORTS官方旗舰店商品毛重：1.0kg货号：315122适用人群：男士鞋底材质：防滑橡胶上市时间：2020年春季闭合方式：系带鞋帮高度：低帮";

        // 交易查询
        // 商户订单号outTradeNo，支付宝交易号tradeNo 二选一
        document.getElementById("WIDTQout_trade_no").value = "202091513469957";
        document.getElementById("WIDTQtrade_no").value = "2020091522001454760504843118";

        // 退款
        document.getElementById("WIDTRout_trade_no").value = "202091511214133";
        document.getElementById("WIDTRtrade_no").value = "2020091522001454760504841160";
        document.getElementById("WIDTRrefund_amount").value = "783.04";
        document.getElementById("WIDTRrefund_reason").value = "这个不是摆明了莆田货么，搞笑！！！";
        document.getElementById("WIDTRout_request_no").value = "";

        // 退款查询
        // 商户订单号outTradeNo，支付宝交易号tradeNo 二选一
        document.getElementById("WIDRQout_trade_no").value = "202091511214133";
        document.getElementById("WIDRQtrade_no").value = "2020091522001454760504841160";
        document.getElementById("WIDRQout_request_no").value = "1";

        // 交易关闭
        document.getElementById("WIDTCout_trade_no").value = "202091511214133";
        document.getElementById("WIDTCtrade_no").value = "2020091522001454760504841160";

        // 对账单下载地址
        document.getElementById("billdwnurl_type").value = "trade";
        document.getElementById("billdwnurl_date").value = "2020-09-14";
    }

    GetDateNow();
</script>
</html>
