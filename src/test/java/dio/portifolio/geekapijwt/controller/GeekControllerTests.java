package dio.portifolio.geekapijwt.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import dio.portifolio.geekapijwt.controller.GeekApiController;
import dio.portifolio.geekapijwt.service.GeekService;

@ExtendWith(MockitoExtension.class)
public class GeekControllerTests {

    private static final String GEEK_API_URL_PATH = "/api/v1/geeks";
    private static final long VALID_GEEK_ID = 1;
    private static final long INVALID_GEEK_ID = 0;
    private static final String BEER_API_SUBPATH_INCREMENT_URL = "/increment";
    private static final String BEER_API_SUBPATH_DECREMENT_URL = "/decrement";

    private MockMvc mockMvc;

    @Mock
    private GeekService beerService;

    @InjectMocks
    private GeekApiController geekApiController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(geekApiController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

}
