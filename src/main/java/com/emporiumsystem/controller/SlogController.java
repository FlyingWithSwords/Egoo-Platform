package com.emporiumsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emporiumsystem.model.Commodity;
import com.emporiumsystem.model.Slog;
import com.emporiumsystem.model.Stat;
import com.emporiumsystem.service.ISlogService;
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
@RequestMapping("/slog")
public class SlogController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISlogService slogService;


    @RequestMapping("/querySlogAll")
    public JsonObject querySlogAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                       Slog slog, String commodityname){
        JsonObject object=new JsonObject();
        if(commodityname!=null&&!commodityname.equals("")) {
            Commodity commodity = new Commodity();
            commodity.setName(commodityname);
            slog.setCommodity(commodity);
        }
        PageInfo<Slog> pageInfo= slogService.findSlogAll(page,limit,slog);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/querySlog")
    public JsonObject querySlog(Slog slog){
        JsonObject object=new JsonObject();
        List<Slog> list= slogService.findAll(slog);
        return new JsonObject(0,"ok", (long) list.size(),list);
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Slog slog){
        int num= slogService.add(slog);
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
            slogService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Slog slog){
        int num= slogService.updateData(slog);
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
    public IPage<Slog> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return slogService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Slog findById(@PathVariable Long id){
        return slogService.findById(id);
    }

    /**
     * 统计分析
     */
    @RequestMapping(value = "/stat", method = RequestMethod.POST)
    public List<Stat> queryStat(@RequestParam String type, @RequestParam String where){
        return slogService.queryStat(type, where);
    }

}
