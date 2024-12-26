package me.itzg.trymapstructsqids.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record TaskCreate(
    @NotBlank
    String name,
    @NotNull
    Instant dueDate
) {
}
