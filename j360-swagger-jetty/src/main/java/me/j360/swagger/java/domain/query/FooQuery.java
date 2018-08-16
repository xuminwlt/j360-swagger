package me.j360.swagger.java.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: min_xu
 * @date: 2018/7/25 下午5:34
 * 说明：
 */

@ApiModel(value = "Foo显示模型")
@Data
public class FooQuery {

    @ApiModelProperty(value = "页码")
    private Integer page;

    @ApiModelProperty(value = "页数")
    private Integer size;

}
