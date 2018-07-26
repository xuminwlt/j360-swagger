package me.j360.swagger.boot.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: min_xu
 * @date: 2018/7/25 下午5:11
 * 说明：
 */

@Slf4j
@RestController
@RequestMapping("/xcx/api/weixin")
@Api(value = "/xcx/api/weixin", tags = "微信第三方对接接口")
public class WsController {
}
