package poe.spring.domain.portfolio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.member.model.entity.Member;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.dto.SimpleCashDto;
import poe.spring.domain.portfolio.dto.SimpleItemDto;
import poe.spring.domain.portfolio.dto.SimplePortfolioDto;

import java.util.ArrayList;
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
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cash> cashes = new ArrayList<>();

    public static PortfolioDto toDto(Portfolio portfolio) {
        List<SimpleCashDto> cashDtos =
                portfolio.getCashes().stream().map(Cash::toDto).toList();
        List<SimpleItemDto> itemDtos =
                portfolio.getItems().stream().map(Item::toDto).toList();
        return PortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .cashes(cashDtos)
                .items(itemDtos)
                .build();
    }

    public static SimplePortfolioDto toSimpleDto(Portfolio portfolio) {
        return SimplePortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .build();
    }

}
