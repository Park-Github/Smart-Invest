package poe.spring.domain.portfolio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.portfolio.dto.StockDto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;

    @Column(name = "asset_class")
    private String assetClass;

    private Float ratio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockTransaction> transactions;

    public static StockDto toDto(Stock entity) {
        return StockDto.builder()
                .id(entity.getId())
                .ticker(entity.getTicker())
                .assetClass(entity.getAssetClass())
                .ratio(entity.getRatio())
                .build();
    }

}
