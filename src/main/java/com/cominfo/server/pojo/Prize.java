package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 获奖信息
 * @TableName t_Prize
 */
@ApiModel(value = "PrizeModel")
@Data
public class Prize {
    @ApiModelProperty(value = "用户id（学号或工号）", dataType = "int64", example = "19408020125")
    private Integer userId;

    @ApiModelProperty(value = "比赛编号", dataType = "int64", example = "1")
    private Integer raceId;

    @ApiModelProperty(value = "获奖信息", dataType = "String", example = "数学建模陕西省一等奖")
    private String prize;

}