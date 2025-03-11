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
import com.ruoyi.train.domain.station;
import com.ruoyi.train.service.IstationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车站Controller
 * 
 * @author me
 * @date 2025-03-11
 */
@RestController
@RequestMapping("/train/station")
public class stationController extends BaseController
{
    @Autowired
    private IstationService stationService;

    /**
     * 查询车站列表
     */
    @PreAuthorize("@ss.hasPermi('train:station:list')")
    @GetMapping("/list")
    public TableDataInfo list(station station)
    {
        startPage();
        List<station> list = stationService.selectstationList(station);
        return getDataTable(list);
    }

    /**
     * 导出车站列表
     */
    @PreAuthorize("@ss.hasPermi('train:station:export')")
    @Log(title = "车站", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, station station)
    {
        List<station> list = stationService.selectstationList(station);
        ExcelUtil<station> util = new ExcelUtil<station>(station.class);
        util.exportExcel(response, list, "车站数据");
    }

    /**
     * 获取车站详细信息
     */
    @PreAuthorize("@ss.hasPermi('train:station:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stationService.selectstationById(id));
    }

    /**
     * 新增车站
     */
    @PreAuthorize("@ss.hasPermi('train:station:add')")
    @Log(title = "车站", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody station station)
    {
        return toAjax(stationService.insertstation(station));
    }

    /**
     * 修改车站
     */
    @PreAuthorize("@ss.hasPermi('train:station:edit')")
    @Log(title = "车站", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody station station)
    {
        return toAjax(stationService.updatestation(station));
    }

    /**
     * 删除车站
     */
    @PreAuthorize("@ss.hasPermi('train:station:remove')")
    @Log(title = "车站", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stationService.deletestationByIds(ids));
    }
}
