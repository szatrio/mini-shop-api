package com.example.minishopapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo {

    private Integer currentPage;

    private Integer totalPage;

    private Integer limit;

    private Integer totalData;
}
