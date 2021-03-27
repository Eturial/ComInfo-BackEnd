package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息
 * @TableName t_user
 */
@ApiModel(value = "UserModel")
@Data
public class User{
    @ApiModelProperty(value = "学号", dataType = "int64", example = "19408020125")
    private Integer id;

    @ApiModelProperty(value = "用户名", dataType = "String", example = "Eturial")
    private String account;

    @ApiModelProperty(value = "密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(value = "姓名", dataType = "String", example = "尹航")
    private String name;

    @ApiModelProperty(value = "性别", dataType = "String", example = "男")
    private String gender;

    @ApiModelProperty(value = "学校", dataType = "String", example = "西安科技大学")
    private String school;

    @ApiModelProperty(value = "权限", dataType = "String", example = "学生")
    private String permission;

}