package cn.tellsea.alipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tellsea
 * @date 2020-9-14
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "index"})
    public String index() {
        return "alipay/index";
    }
}
