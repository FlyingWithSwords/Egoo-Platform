package com.emporiumsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emporiumsystem.model.Commodity;
import com.emporiumsystem.service.ICommodityService;
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
@RequestMapping("/commodity")
public class CommodityController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICommodityService commodityService;


    @RequestMapping("/queryCommodityAll")
    public JsonObject queryCommodityAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                       Commodity commodity){
        JsonObject object=new JsonObject();
        PageInfo<Commodity> pageInfo= commodityService.findCommodityAll(page,limit,commodity);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryCommodity")
    public JsonObject queryCommodity(Commodity commodity){
        JsonObject object=new JsonObject();
        List<Commodity> list= commodityService.findAll(commodity);
        return new JsonObject(0,"ok", (long) list.size(),list);
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Commodity commodity){
        int num= commodityService.add(commodity);
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
            commodityService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Commodity commodity){
        int num= commodityService.updateData(commodity);
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
    public IPage<Commodity> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return commodityService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Commodity findById(@PathVariable Long id){
        return commodityService.findById(id);
    }

}
