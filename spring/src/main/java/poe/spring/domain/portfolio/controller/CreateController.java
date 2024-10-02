package poe.spring.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poe.spring.common.Api;
import poe.spring.common.MapConverter;
import poe.spring.domain.portfolio.dto.SimplePortfolioDto;
import poe.spring.domain.portfolio.service.PortfolioCrudService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/{id}/portfolios/create")
public class CreateController {

    private final PortfolioCrudService crudService;

    @PostMapping
    public ResponseEntity<Api<Map<String, Object>>> create(
            @PathVariable Long id,
            @RequestBody String name
    ) {
        SimplePortfolioDto portfolioDto = crudService.createPortfolio(id, name);
        MapConverter<SimplePortfolioDto> mapConverter = new MapConverter<>();

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertToMap(portfolioDto))
                .statusCode(String.valueOf(HttpStatus.CREATED.value()))
                .resultMessage("Created a new portfolio successfully.")
                .build();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
