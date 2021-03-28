package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "user注册界面请求数据")
@Data
public class ReqUserRegister {
    @ApiModelProperty(value = "学号", dataType = "int64", example = "19408020125")
    private long id;
    @ApiModelProperty(value = "密码", dataType = "String", example = "123456")
    private String password;

}
