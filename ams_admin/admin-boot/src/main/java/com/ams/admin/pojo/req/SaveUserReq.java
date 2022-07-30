package com.ams.admin.pojo.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@Data
public class SaveUserReq {

    private Long id;
    @NotBlank(message = "username 不能为空")
    private String username;

    @NotBlank(message = "nickname 不能为空")
    private String nickname;

    @NotBlank(message = "mobile 不能为空")
    private String mobile;

    @NotNull(message = "gender 不能为空")
    private Integer gender;

    @NotBlank(message = "email 不能为空")
    private String email;

    @NotNull(message = "status 不能为空")
    private Integer status;

    @Size(min =1,message = "roleIds 不能为空")
    private List<Long> roleIds;




}
