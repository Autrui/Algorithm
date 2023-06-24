package com.dwg.classtest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Company {

    @ApiModelProperty(value = "公司ID")
    private Long id;

    @ApiModelProperty(value = "公司名称")
    private String name;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @ApiModelProperty(value = "公司电话")
    private String phone;

    @ApiModelProperty(value = "公司邮箱")
    private String email;

    @ApiModelProperty(value = "公司网址")
    private String website;
}
