package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 小组信息
 * @TableName t_member
 */
@ApiModel(value = "MemberModel")
@Data
public class Member {
    @ApiModelProperty(value = "小组编号", dataType = "int64", example = "1")
    private Integer id;

    @ApiModelProperty(value = "比赛编号", dataType = "int64", example = "1")
    private Integer race;

    @ApiModelProperty(value = "项目名称", dataType = "String", example = "赛小咖")
    private String projectName;

    @ApiModelProperty(value = "成员1（队长）学号", dataType = "int64", example = "19408020125")
    private Integer member1;

    @ApiModelProperty(value = "成员2（队员）学号", dataType = "int64", example = "19408020126")
    private Integer member2;

    @ApiModelProperty(value = "成员3（队员）学号", dataType = "int64", example = "19408020127")
    private Integer member3;

    @ApiModelProperty(value = "成员4（队员）学号", dataType = "int64", example = "19408020128")
    private Integer member4;

    @ApiModelProperty(value = "成员5（队员）学号", dataType = "int64", example = "19408020129")
    private Integer member5;
}