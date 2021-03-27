package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 比赛信息
 * @TableName t_race
 */
@ApiModel(value = "RaceModel")
@Data
public class Race {
    @ApiModelProperty(value = "比赛编号", dataType = "int64", example = "1")
    private Integer id;

    @ApiModelProperty(value = "比赛名称", dataType = "String", example = "全国大学生网络技术挑战赛")
    private String name;

    @ApiModelProperty(value = "比赛开始时间", dataType = "Date", example = "2021.3.21")
    private Date startTime;

    @ApiModelProperty(value = "比赛截止时间", dataType = "Date", example = "2021.4.27")
    private Date endTime;

    @ApiModelProperty(value = "比赛状态", dataType = "String", example = "进行中")
    private String status;

}