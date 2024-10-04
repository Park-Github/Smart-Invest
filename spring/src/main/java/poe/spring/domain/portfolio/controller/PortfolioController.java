package poe.spring.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poe.spring.common.Api;
import poe.spring.common.MapConverter;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.service.PortfolioCrudService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioCrudService crudService;

    @PostMapping
    public ResponseEntity<Api<Map<String, Object>>> create(
            @RequestBody Long userId, String name
    ) {
        PortfolioDto portfolioDto = crudService.createPortfolio(userId, name);
        MapConverter<PortfolioDto> mapConverter = new MapConverter<>();

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertToMap(portfolioDto))
                .statusCode(String.valueOf(HttpStatus.CREATED.value()))
                .resultMessage("Created a new portfolio successfully.")
                .build();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Api<Map<String, Object>>> readPortfolios(
            @RequestBody Long userId
    ) {
        List<PortfolioDto> dtos = crudService.readPortfolios(userId);
        MapConverter<PortfolioDto> mapConverter = new MapConverter<>();

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertListToMap(dtos, "portfolioList"))
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage("Read all portfolios successfully.")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{portfolioId}")
    public ResponseEntity<Api<Void>> deletePortfolio(
            @PathVariable Long portfolioId
    ) {
        crudService.deletePortfolio(portfolioId);

        Api<Void> response = Api.<Void>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

    @PatchMapping("/{portfolioId}")
    public void updatePortfolio(
            @PathVariable Long portfolioId
    ) {

    }

    @GetMapping("/{portfolioId}/stocks")
    public ResponseEntity<Api<Map<String, Object>>> readStocks(
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
