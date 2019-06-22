package com.wsiz.moviego.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiListResponse<T> {

    private List<T> results;
}
