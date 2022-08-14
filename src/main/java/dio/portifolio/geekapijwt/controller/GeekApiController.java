package dio.portifolio.geekapijwt.controller;

import dio.portifolio.geekapijwt.dto.request.GeekDTO;
import dio.portifolio.geekapijwt.dto.response.MessageResponseDTO;
import dio.portifolio.geekapijwt.exception.GeekNotFoundException;
import dio.portifolio.geekapijwt.service.GeekService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/geek")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GeekApiController implements GeekApiControllerDocs {

    private GeekService geekService;

    @GetMapping("/listAll")
    public List<GeekDTO> listAll() {
        return geekService.listAll();
    }

    @GetMapping("/{id}")
    public GeekDTO findById(@PathVariable Long id) throws GeekNotFoundException {
        return geekService.findById(id);
    }

    @GetMapping("/{name}")
    public GeekDTO findByName(@PathVariable String geekName) throws GeekNotFoundException {
        return geekService.findByName(geekName);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createGeek(@Valid @RequestBody GeekDTO geekDTO) {
        return geekService.createGeek(geekDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @Valid @RequestBody GeekDTO geekDTO) throws GeekNotFoundException {
        return geekService.updateById(id, geekDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws GeekNotFoundException {
        geekService.delete(id);
    }

}
