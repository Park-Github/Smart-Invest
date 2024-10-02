package poe.spring.domain.portfolio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import poe.spring.domain.portfolio.dto.SimpleItemDto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

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

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockTransaction> transactions = new ArrayList<>();

    public static SimpleItemDto toDto(Item entity) {
        return SimpleItemDto.builder()
                .id(entity.getId())
                .ticker(entity.getTicker())
                .assetClass(entity.getAssetClass())
                .ratio(entity.getRatio())
                .build();
    }

}
