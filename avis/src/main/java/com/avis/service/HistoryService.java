package com.avis.service;

import com.avis.domain.AppResponse;
import com.avis.domain.HistoryDtoOut;
import com.avis.model.Car;
import com.avis.model.History;
import com.avis.repo.HistoryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    private final HistoryRepo historyRepo;

    public HistoryService(HistoryRepo historyRepo) {
        this.historyRepo = historyRepo;
    }

    void addHistory(Car car) {
        History history = new History();
        history.setSellDate(LocalDate.now());
        history.setCar(car);
        historyRepo.save(history);
    }

    public AppResponse getHistory() {
        List<History> history = historyRepo.findAll();
        List<HistoryDtoOut> collect = history.stream()
                .map(HistoryDtoOut::new)
                .collect(Collectors.toList());
        AppResponse appResponse = new AppResponse();
        appResponse.put("history", collect);
        return appResponse;
    }

}
