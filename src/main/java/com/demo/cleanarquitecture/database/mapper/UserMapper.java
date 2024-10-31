package com.demo.cleanarquitecture.database.mapper;

import com.demo.cleanarquitecture.core.model.User;
import com.demo.cleanarquitecture.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toDomain(UserEntity entity);

    List<User> toDomain(List<UserEntity> userEntities);

}
