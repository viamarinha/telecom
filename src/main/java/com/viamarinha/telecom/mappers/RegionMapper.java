package com.viamarinha.telecom.mappers;

import com.viamarinha.telecom.models.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

//    @Mapping(source = "doctor.patientList", target = "patientDtoList")
//    @Mapping(source = "doctor.specialty", target = "specialization")
//    RegionDto toRegion(Region region);
}
