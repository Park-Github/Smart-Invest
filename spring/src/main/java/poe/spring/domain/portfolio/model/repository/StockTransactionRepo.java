package poe.spring.domain.portfolio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poe.spring.domain.portfolio.model.entity.StockTransaction;

import java.util.List;

public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findByStockId(Long portfolioId);
}
