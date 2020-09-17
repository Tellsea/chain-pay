package cn.tellsea.alipay.controller;

import cn.tellsea.alipay.config.AliPayConfig;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author Tellsea
 * @date 2020/09/16
 */
@Controller
@RequestMapping("/aliLogin")
public class AliLoginController {

    @ApiOperation("网页授权登录")
    @GetMapping("auth")
    public String auth(HttpSession session) {
        // 用于第三方应用防止CSRF攻击
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        session.setAttribute("state", uuid);
        // Step1：获取Authorization Code
        String url = "https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?scope=auth_user" +
                "&app_id=" + AliPayConfig.APP_ID +
                "&redirect_uri=" + URLEncoder.encode(AliPayConfig.RETURN_URL) +
                "&state=" + uuid;
        return "redirect:" + url;
    }
}
