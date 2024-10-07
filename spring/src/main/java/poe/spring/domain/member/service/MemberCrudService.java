package poe.spring.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import poe.spring.domain.member.dto.ResponseDto;
import poe.spring.domain.member.dto.RequestDto;
import poe.spring.domain.member.model.entity.Member;
import poe.spring.domain.member.model.repository.MemberRepo;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberCrudService {

    private final MemberRepo memberRepo;

    public Long createUser(RequestDto requestDto) {
        // 사용자 생성 로직
        return memberRepo.save(RequestDto.toEntity(requestDto)).getId();
    }

    public ResponseDto readUser(Long id) {
        // 사용자 조회 로직
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("Member does not exist."));
        ResponseDto responseDto = Member.toDto(member);
        return responseDto;
    }

    public ResponseDto updateUser(Long id, RequestDto requestDto) {
        // 사용자 수정 로직
        Member existingMember = memberRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("Member does not exist."));
        // 이메일
        existingMember.setEmail(Objects.isNull(requestDto.getEmail()) ?
                existingMember.getEmail() : requestDto.getEmail());
        // 휴대폰 번호
        existingMember.setPhoneNumber(Objects.isNull(requestDto.getPhoneNumber()) ?
                existingMember.getPhoneNumber() : requestDto.getPhoneNumber());
        // 비밀번호
        existingMember.setPassword(Objects.isNull(requestDto.getPassword()) ?
                existingMember.getPassword() : requestDto.getPassword());

        return Member.toDto(memberRepo.updateById(existingMember.getId()));
    }

    public void deleteUser(Long id) {
        // 사용자 삭제 로직
        Member member = memberRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("Member does not exist."));
        memberRepo.deleteById(member.getId());
    }
}
