package dio.portifolio.geekapijwt.service;

import dio.portifolio.geekapijwt.builder.GeekDTOBuilder;
import dio.portifolio.geekapijwt.dto.request.GeekDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import dio.portifolio.geekapijwt.entity.Geek;
import dio.portifolio.geekapijwt.exception.GeekAlreadyRegisteredException;
import dio.portifolio.geekapijwt.mapper.GeekMapper;
import dio.portifolio.geekapijwt.repository.GeekRepository;


import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeekServiceTest {

    @Mock
    private GeekRepository geekRepository;

    private final GeekMapper geekMapper = GeekMapper.INSTANCE;

    @InjectMocks
    private dio.portifolio.geekapijwt.service.GeekService geekService;

    @Test
    void whenGeekInformedThenItShouldBeCreated() throws GeekAlreadyRegisteredException {
        // given
        GeekDTO expectedGeekDTO = GeekDTOBuilder.builder().build().toGeekDTO();
        Geek expectedSavedGeek = geekMapper.toModel(expectedGeekDTO);

        // when
        when(geekRepository.findByGeekName(expectedGeekDTO.getGeekName())).thenReturn(Optional.empty());
        when(geekRepository.save(expectedSavedGeek)).thenReturn(expectedSavedGeek);

        //then
        GeekDTO createdGeekDTO = geekService.createGeekByName(expectedGeekDTO);

        assertThat(createdGeekDTO.getId(),  is(equalTo(expectedGeekDTO.getId())));
        assertThat(createdGeekDTO.getGeekName(), is(equalTo(expectedGeekDTO.getGeekName())));
        assertThat(createdGeekDTO.getRealName(), is(equalTo(expectedGeekDTO.getRealName())));
    }

}