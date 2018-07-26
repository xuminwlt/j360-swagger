package me.j360.swagger.spring.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: min_xu
 * @date: 2018/7/25 下午5:35
 * 说明：
 */

@ApiModel(value = "Foo新增模型")
@Data
public class FooRequest {

    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
}
