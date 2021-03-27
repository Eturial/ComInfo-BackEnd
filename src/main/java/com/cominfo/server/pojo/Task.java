package com.cominfo.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 任务信息
 * @TableName t_task
 */
@ApiModel(value = "TaskModel")
@Data
public class Task {
    @ApiModelProperty(value = "项目编号", dataType = "int64", example = "1")
    private Integer projectId;

    @ApiModelProperty(value = "用户编号", dataType = "int64", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "任务名", dataType = "String", example = "数据库设计")
    private String taskName;

    @ApiModelProperty(value = "任务开始时间", dataType = "Date", example = "2021.3.21")
    private Date startTime;

    @ApiModelProperty(value = "任务完成时间", dataType = "Date", example = "2021.4.27")
    private Date endTime;

}