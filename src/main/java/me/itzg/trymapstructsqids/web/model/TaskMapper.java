package me.itzg.trymapstructsqids.web.model;

import me.itzg.trymapstructsqids.data.TaskEntity;
import me.itzg.trymapstructsqids.web.SqidMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SqidMapper.class})
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "completed", ignore = true)
    TaskEntity fromCreate(TaskCreate request);

    @Mapping(target = "id", qualifiedBy = SqidMapper.ToSqid.class)
    TaskDto toDto(TaskEntity task);

    List<TaskDto> toDtoList(Iterable<TaskEntity> tasks);
}
