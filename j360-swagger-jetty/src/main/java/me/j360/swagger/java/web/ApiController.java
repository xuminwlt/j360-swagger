package me.j360.swagger.java.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import me.j360.swagger.java.domain.query.FooQuery;
import me.j360.swagger.java.domain.request.FooRequest;
import me.j360.swagger.java.domain.vo.FooVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: min_xu
 * @date: 2018/7/25 下午5:11
 * 说明：
 */

@Slf4j
@RestController
@RequestMapping("/spring/api/foo")
@Api(value = "/spring/api/foo", tags = "foo对接接口")
public class ApiController {

    @ApiOperation(value = "新增接口", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE )
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FooVO fooAdd(@RequestBody @ApiParam(name="新增接口", value="RequestBody风格") FooRequest fooRequest) {

        return null;
    }

    @ApiOperation(value = "列表接口", notes = "分页列表", code = 200, produces = MediaType.APPLICATION_JSON_VALUE )
    @RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FooVO foo(@RequestParam @ApiParam(name="Foo ID", value="Foo id") Long id) {
        return null;
    }

    @ApiOperation(value = "删除接口", notes = "", code = 200, produces = MediaType.APPLICATION_JSON_VALUE )
    @RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public FooVO fooDelete(@RequestBody @ApiParam(name="Foo ID", value="Foo id") FooRequest fooRequest) {

        return null;
    }

    @ApiOperation(value = "列表接口", notes = "分页列表", code = 200, produces = MediaType.APPLICATION_JSON_VALUE )
    @RequestMapping(value = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FooVO> fooList(@ApiParam(name="列表接口", value="Url param风格") FooQuery query) {
        return null;
    }


}
