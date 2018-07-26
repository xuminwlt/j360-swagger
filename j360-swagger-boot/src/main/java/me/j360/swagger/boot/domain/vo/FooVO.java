package me.j360.swagger.boot.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author: min_xu
 * @date: 2018/7/25 下午5:29
 * 说明：
 */

@ApiModel(value = "Foo显示模型")
@Data
@Builder
public class FooVO {

    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;

}
