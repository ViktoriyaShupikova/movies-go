package com.wsiz.moviego.dto;

import lombok.Data;

import java.util.List;

/**
 * @param <T>
 */
@Data
public class ApiListResponse<T> {

    private List<T> results;
}
