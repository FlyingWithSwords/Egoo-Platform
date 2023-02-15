package com.emporiumsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emporiumsystem.service.IAddressService;
import com.github.pagehelper.PageInfo;
import com.emporiumsystem.model.Address;
import com.emporiumsystem.util.JsonObject;
import com.emporiumsystem.util.R;
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
@RequestMapping("/address")
public class AddressController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAddressService addressService;


    @RequestMapping("/queryAddressAll")
    public JsonObject queryAddressAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                       Address address){
        JsonObject object=new JsonObject();
        PageInfo<Address> pageInfo= addressService.findAddressAll(page,limit,address);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryAddress")
    public JsonObject queryAddress(Address address){
        JsonObject object=new JsonObject();
        List<Address> list= addressService.findAll(address);
        return new JsonObject(0,"ok", (long) list.size(),list);
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Address address){
        int num= addressService.add(address);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }

    }

    @ApiOperation(value = "删除")
    @RequestMapping("/delete")
    public R delete(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            addressService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Address address){
        int num= addressService.updateData(address);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Address> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return addressService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }

}
