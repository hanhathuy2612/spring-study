package com.huy.spring_study.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class PaginationResponse<T> extends BaseResponse<List<T>> {
    private int pageSize;
    private int currentPage;
    private int total;
}
