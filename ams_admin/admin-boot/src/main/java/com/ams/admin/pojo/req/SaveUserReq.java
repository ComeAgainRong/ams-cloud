package com.ams.admin.pojo.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： AI码师 关注公众号"AI码师"获取完整源码
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@ApiModel(value = "SaveUserReq",description = "用户接收类")
@Data
public class SaveUserReq {

    @ApiModelProperty(value = "主键",name = "id")
    private Long id;

    @ApiModelProperty(value = "用户名",name = "username")
    @NotBlank(message = "username 不能为空")
    private String username;

    @ApiModelProperty(value = "名字",name = "nickname")
    @NotBlank(message = "nickname 不能为空")
    private String nickname;

    @ApiModelProperty(value = "手机号",name = "mobile")
    @NotBlank(message = "mobile 不能为空")
    private String mobile;

    @ApiModelProperty(value = "性别",name = "gender")
    @NotNull(message = "gender 不能为空")
    private Integer gender;

    @ApiModelProperty(value = "邮箱",name = "email")
    @NotBlank(message = "email 不能为空")
    private String email;

    @ApiModelProperty(value = "状态",name = "status")
    @NotNull(message = "status 不能为空")
    private Integer status;

    @ApiModelProperty(value = "角色",name = "roleIds")
    @Size(min =1,message = "roleIds 不能为空")
    private List<Long> roleIds;




}
