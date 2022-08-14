package dio.portifolio.geekapijwt.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FilmDTO {

    private Long id;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;
}
