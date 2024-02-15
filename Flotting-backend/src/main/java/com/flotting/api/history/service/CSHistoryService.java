package com.flotting.api.history.service;

import com.flotting.api.history.entity.CSHistory;
import com.flotting.api.history.model.CSHistoryResponseModel;
import com.flotting.api.history.repository.CSHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CSHistoryService {

    private final CSHistoryRepository csHistoryRepository;

    @Transactional(readOnly = true)
    public CSHistoryResponseModel getCSHistory(Long id) {
        CSHistory result = csHistoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        CSHistoryResponseModel csHistoryResponseModel = new CSHistoryResponseModel(result);

        return csHistoryResponseModel;
    }

    @Transactional(readOnly = true)
    public List<CSHistoryResponseModel> getAllCSHistory() {
        ArrayList<CSHistoryResponseModel> result = new ArrayList<>();
        List<CSHistory> datas = csHistoryRepository.findAll();
        datas.forEach(data -> {
            result.add(new CSHistoryResponseModel(data));
        });

        return result;
    }

}
