package poe.spring.domain.portfolio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poe.spring.domain.portfolio.model.entity.Stock;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Long> {
    List<Stock> findByPortfolioId(Long portfolioId);
}
