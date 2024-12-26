package me.itzg.trymapstructsqids.web;

import org.mapstruct.Qualifier;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Service
public class SqidMapper {

    private final Sqids sqids;

    public SqidMapper(Sqids sqids) {
        this.sqids = sqids;
    }

    @ToSqid
    public String toSqid(Long id) {
        return sqids.encode(List.of(id));
    }

    @FromSqid
    public Long fromSqid(String sqid) {
        return sqids.decode(sqid).getFirst();
    }

    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.CLASS)
    public @interface ToSqid {
    }

    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.CLASS)
    public @interface FromSqid {
    }
}
