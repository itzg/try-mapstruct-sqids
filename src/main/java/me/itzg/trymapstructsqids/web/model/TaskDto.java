package me.itzg.trymapstructsqids.web.model;

import java.time.Instant;

public record TaskDto(
    String id,
    String name,
    Instant dueDate,
    boolean completed
) {
}
