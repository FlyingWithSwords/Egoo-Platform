package com.emporiumsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emporiumsystem.model.Commodity;
import com.emporiumsystem.model.Evaluate;
import com.emporiumsystem.service.IEvaluateService;
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
@RequestMapping("/evaluate")
public class EvaluateController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IEvaluateService evaluateService;


    @RequestMapping("/queryEvaluateAll")
    public JsonObject queryEvaluateAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                       Evaluate evaluate, String evaluatename){
        JsonObject object=new JsonObject();
        if(evaluatename!=null&&!evaluatename.equals("")) {
            Commodity commodity = new Commodity();
            commodity.setName(evaluatename);
            evaluate.setCommodity(commodity);
        }
        PageInfo<Evaluate> pageInfo= evaluateService.findEvaluateAll(page,limit,evaluate);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryEvaluate")
    public JsonObject queryEvaluate(Evaluate evaluate){
        JsonObject object=new JsonObject();
        List<Evaluate> list= evaluateService.findAll(evaluate);
        return new JsonObject(0,"ok", (long) list.size(),list);
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Evaluate evaluate){
        int num= evaluateService.add(evaluate);
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
            evaluateService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Evaluate evaluate){
        int num= evaluateService.updateData(evaluate);
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
    public IPage<Evaluate> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return evaluateService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Evaluate findById(@PathVariable Long id){
        return evaluateService.findById(id);
    }

}
