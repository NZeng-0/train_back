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
import com.ruoyi.train.domain.Seat;
import com.ruoyi.train.service.ISeatService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 座位Controller
 * 
 * @author me
 * @date 2025-03-18
 */
@RestController
@RequestMapping("/train/seat")
public class SeatController extends BaseController
{
    @Autowired
    private ISeatService seatService;

    /**
     * 查询座位列表
     */
//    @PreAuthorize("@ss.hasPermi('train:seat:list')")
    @GetMapping("/list")
    public TableDataInfo list(Seat seat)
    {
        startPage();
        List<Seat> list = seatService.selectSeatList(seat);
        return getDataTable(list);
    }

    /**
     * 导出座位列表
     */
    @PreAuthorize("@ss.hasPermi('train:seat:export')")
    @Log(title = "座位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Seat seat)
    {
        List<Seat> list = seatService.selectSeatList(seat);
        ExcelUtil<Seat> util = new ExcelUtil<Seat>(Seat.class);
        util.exportExcel(response, list, "座位数据");
    }

    /**
     * 获取座位详细信息
     */
    @PreAuthorize("@ss.hasPermi('train:seat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(seatService.selectSeatById(id));
    }

    /**
     * 新增座位
     */
    @PreAuthorize("@ss.hasPermi('train:seat:add')")
    @Log(title = "座位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Seat seat)
    {
        return toAjax(seatService.insertSeat(seat));
    }

    /**
     * 修改座位
     */
    @PreAuthorize("@ss.hasPermi('train:seat:edit')")
    @Log(title = "座位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Seat seat)
    {
        return toAjax(seatService.updateSeat(seat));
    }

    /**
     * 删除座位
     */
    @PreAuthorize("@ss.hasPermi('train:seat:remove')")
    @Log(title = "座位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(seatService.deleteSeatByIds(ids));
    }
}
