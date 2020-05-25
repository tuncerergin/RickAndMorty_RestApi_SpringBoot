package com.tuncerergin.rickandmorty.controller;

import com.tuncerergin.rickandmorty.entity.report.Endpoint;
import com.tuncerergin.rickandmorty.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("report")
    public String getReport(Model theModel) {
        Endpoint endpoint = reportService.getEndpoint("");

        List<Endpoint> endpointList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();

        for (String endpointUrl : endpoint.getAvailableTags().get(2).getValues()) {
            if (!endpointUrl.contains("actuator")) {
                Endpoint e = reportService.getEndpoint("?tag=uri:" + endpointUrl);
                endpointList.add(e);
                urlList.add(endpointUrl);
            }
        }

        theModel.addAttribute("endpoint", endpointList);
        theModel.addAttribute("endpointUrl", urlList);
        return "report";
    }
}
