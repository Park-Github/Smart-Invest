package poe.spring.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poe.spring.common.Api;
import poe.spring.common.MapConverter;
import poe.spring.domain.portfolio.dto.StockDto;
import poe.spring.domain.portfolio.service.StockCrudService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolios/{portfolioId}/stocks")
public class StockController {

    private final StockCrudService crudService;
    private final MapConverter<StockDto> mapConverter;

    @GetMapping
    public ResponseEntity<Api<Map<String, Object>>> readStocks(
            @PathVariable Long portfolioId
    ) {
        List<StockDto> dto = crudService.readStocks(portfolioId);

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(mapConverter.convertListToMap(dto, "stocks"))
                .statusCode(String.valueOf(HttpStatus.OK))
                .resultMessage("Read stocks successfully.")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<Api<Map<String, Object>>> createStock(
            @PathVariable Long portfolioId,
            @RequestBody StockDto requestDto
    ){
        StockDto dto = crudService.createStock(portfolioId, requestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
