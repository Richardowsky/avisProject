package com.avis.cotroller;

import com.avis.domain.AppResponse;
import com.avis.service.HistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RequestMapping(value = "/history", method = GET)
    public AppResponse getAllHistory() {
        return historyService.getHistory();
    }
}
