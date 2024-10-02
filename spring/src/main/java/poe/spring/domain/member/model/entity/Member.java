package poe.spring.domain.member.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.alert.model.entity.Alert;
import poe.spring.domain.member.dto.ResponseDto;
import poe.spring.domain.portfolio.model.entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private SnsMember snsMember;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alert> alerts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios = new ArrayList<>();

    public static ResponseDto toDto(Member entity) {
        return ResponseDto.builder()
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

}
