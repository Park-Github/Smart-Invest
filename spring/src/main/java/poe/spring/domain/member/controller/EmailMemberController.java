package poe.spring.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poe.spring.common.Api;
import poe.spring.common.MapConverter;
import poe.spring.domain.member.dto.ResponseDto;
import poe.spring.domain.member.service.MemberCrudService;
import poe.spring.domain.member.dto.RequestDto;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmailMemberController {

    private final MemberCrudService crudService;
    private final MapConverter<ResponseDto> mapConverter;

    @PostMapping("/email-user")
    public ResponseEntity<Api<Map<String, Long>>> createEmailUser(@RequestBody RequestDto requestDto) {

        Long id = crudService.createUser(requestDto);

        Map<String, Long> data = new HashMap<>();
        data.put("member_id", id);

        Api<Map<String, Long>> response = Api.<Map<String, Long>>builder()
                .data(data)
                .statusCode(String.valueOf(HttpStatus.CREATED.value()))
                .resultMessage("Created a new member successfully.").build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/email-user/{id}")
    public ResponseEntity<Api<Void>> deleteEmailUser(@PathVariable Long id) {

        // 사용자 삭제 로직
        crudService.deleteUser(id);

        Api<Void> response = Api.<Void>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage("Member deleted successfully.").build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/email-user/{id}")
    public ResponseEntity<Api<Map<String, Object>>> readEmailUser(@PathVariable Long id) {

        // 사용자 정보 조회 로직
        ResponseDto responseDto = crudService.readUser(id);

        MapConverter<ResponseDto> mapConverter = new MapConverter<>();
        Map<String, Object> data = mapConverter.convertToMap(responseDto);

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .statusCode(HttpStatus.OK.getReasonPhrase())
                .resultMessage("Successfully read member information")
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/email-user/{id}/email")
    public ResponseEntity<Api<Map<String, Object>>> updateUserEmail(
            @PathVariable Long id,
            @RequestBody RequestDto requestDto) {

        // 사용자 수정 로직
        ResponseDto dto = crudService.updateUser(id, requestDto);
        dto.setPhoneNumber(null);

        Map<String, Object> data = mapConverter.convertToMap(dto);

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(data)
                .statusCode(String.valueOf(HttpStatus.OK))
                .resultMessage("Member email updated successfully.").build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/email-user/{id}/password")
    public ResponseEntity<Api<Void>> updateUserPassword(
            @PathVariable Long id,
            @RequestBody RequestDto requestDto) {

        // 사용자 수정 로직
        crudService.updateUser(id, requestDto);

        Api<Void> response = Api.<Void>builder()
                .statusCode(String.valueOf(HttpStatus.OK))
                .resultMessage("Member password updated successfully.").build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/email-user/{id}/phone")
    public ResponseEntity<Api<Map<String, Object>>> updateUserPhone(
            @PathVariable Long id,
            @RequestBody RequestDto requestDto) {

        // 사용자 수정 로직
        ResponseDto dto = crudService.updateUser(id, requestDto);
        dto.setEmail(null);

        Map<String, Object> data = mapConverter.convertToMap(dto);

        Api<Map<String, Object>> response = Api.<Map<String, Object>>builder()
                .data(data)
                .statusCode(String.valueOf(HttpStatus.OK))
                .resultMessage("Member phoneNumber updated successfully.").build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
