package com.ruoyi.train.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.train.domain.Train;
import com.ruoyi.train.service.ITrainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 列车Controller
 * 
 * @author me
 * @date 2025-03-17
 */
@RestController
@RequestMapping("/train/train")
public class TrainController extends BaseController
{
    @Autowired
    private ITrainService trainService;

    /**
     * 查询列车列表
     */
    @PreAuthorize("@ss.hasPermi('train:train:list')")
    @GetMapping("/list")
    public TableDataInfo list(Train train)
    {
        startPage();
        List<Train> list = trainService.selectTrainList(train);
        return getDataTable(list);
    }

    /**
     * 导出列车列表
     */
    @PreAuthorize("@ss.hasPermi('train:train:export')")
    @Log(title = "列车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Train train)
    {
        List<Train> list = trainService.selectTrainList(train);
        ExcelUtil<Train> util = new ExcelUtil<Train>(Train.class);
        util.exportExcel(response, list, "列车数据");
    }

    /**
     * 获取列车详细信息
     */
    @PreAuthorize("@ss.hasPermi('train:train:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(trainService.selectTrainById(id));
    }

    /**
     * 新增列车
     */
    @PreAuthorize("@ss.hasPermi('train:train:add')")
    @Log(title = "列车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Train train)
    {
        return toAjax(trainService.insertTrain(train));
    }

    /**
     * 修改列车
     */
    @PreAuthorize("@ss.hasPermi('train:train:edit')")
    @Log(title = "列车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Train train)
    {
        return toAjax(trainService.updateTrain(train));
    }

    /**
     * 删除列车
     */
    @PreAuthorize("@ss.hasPermi('train:train:remove')")
    @Log(title = "列车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(trainService.deleteTrainByIds(ids));
    }
}
