package com.ams.admin.controller;

import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.req.SaveUserReq;
import com.ams.admin.pojo.req.UserListPageReq;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.admin.service.ISysUserService;
import com.ams.common.entity.APage;
import com.ams.common.result.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : { UserController }
 * @Author : {whisper}
 * @Date : {Created in 15:03 2022/2/2}
 */
@RestController
@RequestMapping(value = {"/api/v1/users","/user"})
@Slf4j
@RequiredArgsConstructor
public class UserController {


    private final ISysUserService sysUserService;

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/username/{username}")
    public R<UserAuthDTO> getUserByUsername(@PathVariable String username){
        UserAuthDTO user = sysUserService.getByUsername(username);
        return  R.ok(user);
    }
    /**
     * 创建用户
     */
    @PostMapping
    public R createUser(@RequestBody SaveUserReq req){
        sysUserService.createUser(req);
        return R.ok();
    }

    /**
     * 用户详情
     */
    @GetMapping("/{userId}")
    public R<SysUserVO> userDetail(@PathVariable Long userId){
     SysUserVO sysUserVO= sysUserService.userDetail(userId);
     return R.ok(sysUserVO);
    }

    /**
     * 更新用户
     */
    @PutMapping("/{userId}")
    public R updateUserInfo(@RequestBody SaveUserReq userReq,@PathVariable Long userId){
        sysUserService.updateUserInfo(userReq,userId);
        return R.ok();
    }
    /**
     * 批量删除用户
     */
    @DeleteMapping("/{userIds}")
    public R mulDeleteUsers(@PathVariable List<Long> userIds){
        sysUserService.mulDeleteUsers(userIds);
        return R.ok();
    }

    /**
     * 用户分页列表
     */
    @GetMapping("/listPage")
    public R<List<SysUserVO>> listPage(@RequestBody UserListPageReq req){
        APage<SysUserVO> sysUserVOAPage = sysUserService.listPage(req);
        return  R.page(sysUserVOAPage);
    }

}
