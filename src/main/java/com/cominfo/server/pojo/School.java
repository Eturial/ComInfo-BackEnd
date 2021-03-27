package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 学校信息
 * @TableName t_school
 */
@ApiModel(value = "SchoolModel")
@Data
public class School {
    @ApiModelProperty(value = "编号", dataType = "int64", example = "1")
    private Integer id;

    @ApiModelProperty(value = "学校名称", dataType = "String", example = "西安科技大学")
    private String school;

}