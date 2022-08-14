package dio.portifolio.geekapijwt.dto.request;

import dio.portifolio.geekapijwt.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GameDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private GameType gameStyle;

    private BigDecimal price;
}
