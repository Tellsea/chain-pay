package cn.tellsea.alipay.controller;


import cn.tellsea.alipay.PayApplicationTests;

class AliPayControllerTest extends PayApplicationTests {

    /*public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID, AlipayConfig.MERCHANT_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);

        // 网站支付宝登录
        // 第一步：拼接授权页面url：https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=商户的APPID&scope=auth_user&redirect_uri=ENCODED_URL&state=init
        // 第二步：获取auth_code
        // 第三步：使用auth_code换取access_token及用户userId
        // 第四步：调用接口获取用户信息

        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode("2e4248c2f50b4653bf18ecee3466UC18");
        request.setGrantType("authorization_code");
        AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
        System.out.println(oauthTokenResponse.getAccessToken());

        AlipayUserInfoShareRequest request2 = new AlipayUserInfoShareRequest();
        String auth_token = "composeBcd261a4867d94837a701f92816f18X18";
        AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request2, auth_token);
        System.out.println(userinfoShareResponse.getBody());
    }*/
}
