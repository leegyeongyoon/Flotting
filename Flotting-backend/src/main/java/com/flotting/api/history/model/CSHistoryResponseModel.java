package com.flotting.api.history.model;

import com.flotting.api.history.entity.CSHistory;
import com.flotting.api.user.enums.CSEnum;
import com.flotting.api.user.enums.ProcessStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CSHistoryResponseModel {

    private Long id;

    private LocalDate requestDate;

    private Long managerId;

    private Long requestId;

    private ProcessStatus status;

    private String content;
    private CSEnum csType;

    public CSHistoryResponseModel(CSHistory csHistory) {
        this.id = csHistory.getId();
        this.requestDate = csHistory.getRequestDate();
        this.managerId = csHistory.getManager().getSeq();
        this.requestId = csHistory.getRequester().getUserNo();
        this.status = csHistory.getStatus();
        this.content = csHistory.getContent();
        this.csType = csHistory.getCsType();
    }
}
