package com.nowcoder.community.controller;

import com.nowcoder.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 统计页面
    @RequestMapping(path = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDatePage() {
        return "/site/admin/data";
    }

    // 统计网站UV
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long uv = dataService.calculateUV(start, end);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);
//        两种方法都行，上面一直是返回一个模板给dispatcherServlet，再继续处理；下面的forward是处理一半交由/data方法执行
//        return "/site/admin/data";
        return "forward:/data";
    }

    // 统计活跃用户
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long dau = dataService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);
        return "forward:/data";
    }

}
