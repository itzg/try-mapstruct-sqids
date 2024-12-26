package me.itzg.trymapstructsqids.web.model;

import java.util.List;

public record ListResponse<T>(
    List<T> values
) {
    public static <T> ListResponse<T> of(List<T> values) {
        return new ListResponse<T>(values);
    }
}
