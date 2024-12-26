package me.itzg.trymapstructsqids.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("task")
public record TaskEntity(
    @Id
    Long id,
    String name,
    Instant dueDate,
    boolean completed
) {
}
