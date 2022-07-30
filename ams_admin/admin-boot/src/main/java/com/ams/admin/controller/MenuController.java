package com.ams.admin.controller;

import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SaveMenuReq;
import com.ams.admin.pojo.vo.SysMenuSelectVO;
import com.ams.admin.pojo.vo.SysMenuVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.service.ISysMenuService;
import com.ams.admin.service.ISysRoleService;
import com.ams.common.result.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : { UserController }
 * @Author : {whisper}
 * @Date : {Created in 15:03 2022/2/2}
 */
@RestController
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {

    private  final ISysMenuService menuService;


    /**
     * 菜单列表
     */
    @GetMapping("/list")
    public R<List<SysMenuVO>> getMenuList(){
        List<SysMenuVO> sysMenuVOS = menuService.loadMenus();
        return R.ok(sysMenuVOS);

    }
    /**
     * 创建菜单
     */
    @PostMapping
    public R createMenu(@Validated  @RequestBody SaveMenuReq req){
        menuService.createMenu(req);
        return  R.ok();
    }
    /**
     * 菜单树
     */
    @GetMapping("/listTree")
    public R<List<SysMenuVO>> listTree(){
      List<SysMenuVO> menuVOS= menuService.lisTree();
      return R.ok(menuVOS);
    }
    /**
     * 更新菜单
     */
    @PutMapping
    public R updateMenu(@Validated  @RequestBody SaveMenuReq req){
        menuService.updateMenu(req);
        return R.ok();
    }
    /**
     * 删除菜单
     */
    @DeleteMapping("/{ids}")
    public R deletes(@PathVariable List<Long> ids){
        menuService.deletes(ids);
        return R.ok();
    }
    /**
     * 菜单select
     */
    @GetMapping("/select/{status}")
    public R<List<SysMenuSelectVO>> select(@PathVariable  int status) {
       List<SysMenuSelectVO> selectVOS = menuService.select(status);
       return  R.ok(selectVOS);
    }

    /**
     * 菜单详情
     */
    @GetMapping("/{id}")
    public  R<SysMenuVO> getDetail(@PathVariable Long id){
        SysMenuVO sysMenuVO = menuService.getDetail(id);
        return R.ok(sysMenuVO);
    }
    /**
     *  查询角色绑定的菜单
     */
    @GetMapping("/role/{roleId}")
    public R<List<Long>> listRoleMenu(@PathVariable Long roleId){
        List<Long>  menuId =  menuService.listRoleMenu(roleId);
        return R.ok(menuId);
    }

    /**
     * 更新角色绑定的菜单
     */
    @PutMapping("/role/{roleId}")
    public R<List<Long>> updateRoleMenu(@PathVariable Long roleId,@RequestBody CommonReq req){
        menuService.updateRoleMenu(roleId,req);
        return R.ok();
    }
    /**
     * 获取当前用户绑定的菜单
     */

    @GetMapping("/currentUser")
    public R<List<Long>> currentUser(){
        List<Long> menus = menuService.currentUser();
        return R.ok(menus);

    }



}
