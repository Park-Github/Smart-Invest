package poe.spring.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poe.spring.common.Api;
import poe.spring.common.MapConverter;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.dto.SimplePortfolioDto;
import poe.spring.domain.portfolio.service.PortfolioCrudService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/{userId}/portfolios")
public class ReadController {

    private final PortfolioCrudService crudService;

    @GetMapping
    public ResponseEntity<Api<Map<String, Object>>> readAll(
            @PathVariable Long userId
    ) {
        List<SimplePortfolioDto> dtos = crudService.readPortfolios(userId);
        MapConverter<SimplePortfolioDto> mapConverter = new MapConverter<>();

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertListToMap(dtos, "portfolioList"))
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage("Read all portfolios successfully.")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<Api<Map<String, Object>>> readPortfolio(
            @PathVariable Long userId,
            @PathVariable Long portfolioId
    ) {
        PortfolioDto dto = crudService.readOnePortfolio(portfolioId);
        MapConverter<PortfolioDto> mapConverter = new MapConverter<>();

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertToMap(dto))
                .statusCode(String.valueOf(HttpStatus.OK))
                .resultMessage("Read a portfolio successfully.")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
