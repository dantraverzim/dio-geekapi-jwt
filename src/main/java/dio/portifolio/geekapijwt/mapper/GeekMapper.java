package dio.portifolio.geekapijwt.mapper;

import org.mapstruct.factory.Mappers;
import dio.portifolio.geekapijwt.dto.request.GeekDTO;
import dio.portifolio.geekapijwt.entity.Geek;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface GeekMapper {

    GeekMapper INSTANCE = Mappers.getMapper(GeekMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Geek toModel(GeekDTO geekDTO);

    GeekDTO toDTO(Geek geek);
}