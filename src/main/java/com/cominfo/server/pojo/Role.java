package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 权限信息
 * @TableName t_role
 */
@ApiModel(value = "RoleModel")
@Data
public class Role {
    @ApiModelProperty(value = "权限名", dataType = "String", example = "学生")
    private String roleName;

}