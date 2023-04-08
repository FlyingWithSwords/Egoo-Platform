package com.emporiumsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emporiumsystem.model.User;
import com.emporiumsystem.service.IUserService;
import com.emporiumsystem.util.JsonObject;
import com.emporiumsystem.util.R;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Api(tags = {""})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;

    @RequestMapping("/queryUserAll")
    public JsonObject queryUserAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    User user){
        JsonObject object=new JsonObject();
        PageInfo<User> pageInfo= userService.findUserAll(page,limit, user);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            userService.delete(Long.parseLong(id));
        }
        return R.ok();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody User user){
        userService.add(user);
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody User user){
        int num= userService.updateData(user);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update1")
    public R update(String oldPwd,String newPwd,Integer id){
        //根据id获取当前的数据记录
        User user=userService.findById(new Long(id));
        if(oldPwd.equals(user.getPassword())){//输入的老密码和原密码一致
            user.setPassword(newPwd);
            userService.updateData(user);
            return R.ok();
        }else{
            return R.fail("旧密码错误");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<User> findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer pageCount){
        return userService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
