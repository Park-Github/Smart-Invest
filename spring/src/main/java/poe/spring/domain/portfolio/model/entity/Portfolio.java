package poe.spring.domain.portfolio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.member.model.entity.Member;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.dto.CashDto;
import poe.spring.domain.portfolio.dto.StockDto;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> stocks;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cash> cashes;

    public static PortfolioDto toDto(Portfolio portfolio) {
        List<CashDto> cashDtos =
                portfolio.getCashes().stream().map(Cash::toDto).toList();
        List<StockDto> stockDtos =
                portfolio.getStocks().stream().map(Stock::toDto).toList();
        return PortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .cashes(cashDtos)
                .items(stockDtos)
                .build();
    }

    public static PortfolioDto toSimpleDto(Portfolio portfolio) {
        return PortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .build();
    }

}
