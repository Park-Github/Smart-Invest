package poe.spring.exception.others;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import poe.spring.common.Api;
import poe.spring.domain.alert.service.AlertCrudService;
import poe.spring.domain.member.service.MemberCrudService;
import poe.spring.domain.portfolio.service.PortfolioCrudService;

@Slf4j
@RestControllerAdvice(basePackageClasses = { MemberCrudService.class , PortfolioCrudService.class, AlertCrudService.class })
public class CrudExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Api<Void>> IllegalExceptionHandle(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Api.<Void>builder()
                        .statusCode(String.valueOf(HttpStatus.CONFLICT.value()))
                        .resultMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Api<Void>> NullExceptionHandle(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Api.<Void>builder()
                        .statusCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                        .resultMessage(e.getMessage())
                        .build());
    }

}
