package poe.spring.domain.portfolio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.portfolio.dto.CashDto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code")
    private String currencyCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @OneToMany(mappedBy = "cash", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashTransaction> transactions;

    public static CashDto toDto(Cash entity) {
        return CashDto.builder()
                .id(entity.getId())
                .currencyCode(entity.getCurrencyCode())
                .build();
    }

}
