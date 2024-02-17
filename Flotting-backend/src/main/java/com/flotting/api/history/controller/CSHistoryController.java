package com.flotting.api.history.controller;

import com.flotting.api.history.model.CSHistoryResponseModel;
import com.flotting.api.history.service.CSHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CSHistoryController {

    private final CSHistoryService csHistoryService;

    @GetMapping("/cs-history/all")
    public List<CSHistoryResponseModel> getAllHistories() {
        return csHistoryService.getAllCSHistory();
    }

    @GetMapping("/cs-history/{historyId}")
    public CSHistoryResponseModel getHistory(@PathVariable(name = "historyId") Long historyId) {
        return csHistoryService.getCSHistory(historyId);
    }
}
