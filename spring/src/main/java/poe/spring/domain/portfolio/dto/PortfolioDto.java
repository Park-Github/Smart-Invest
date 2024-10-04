package poe.spring.domain.portfolio.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

// TODO DTO를 하나로 통일시키기, JPA 양방향 Create Read Update Delete 생각하기
@Getter
@Setter
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PortfolioDto {

    private Long id;

    private String name;

    private List<StockDto> items;

    private List<CashDto> cashes;

}
