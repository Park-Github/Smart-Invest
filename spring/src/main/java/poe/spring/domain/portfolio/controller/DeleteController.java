package poe.spring.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poe.spring.common.Api;
import poe.spring.domain.portfolio.service.PortfolioCrudService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/{userId}/portfolios/{portfolioId}/delete")
public class DeleteController {

    private final PortfolioCrudService crudService;

    @DeleteMapping
    public ResponseEntity<Api<Void>> deletePortfolio(
            @PathVariable Long userId,
            @PathVariable Long portfolioId
    ) {
        crudService.deletePortfolio(userId, portfolioId);

        Api<Void> response = Api.<Void>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }
}
