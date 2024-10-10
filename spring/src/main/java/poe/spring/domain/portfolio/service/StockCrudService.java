package poe.spring.domain.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import poe.spring.domain.portfolio.dto.StockDto;
import poe.spring.domain.portfolio.model.entity.Portfolio;
import poe.spring.domain.portfolio.model.entity.Stock;
import poe.spring.domain.portfolio.model.repository.PortfolioRepo;
import poe.spring.domain.portfolio.model.repository.StockRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockCrudService {

    private final StockRepo stockRepo;
    private final PortfolioRepo portfolioRepo;

    public StockDto createStock(Long portfolioId, StockDto requestDto) {

        Portfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new NullPointerException("Portfolio does not exist."));
    }

    public List<StockDto> readStocks(Long portfolioId) {
        List<Stock> stockList = stockRepo.findByPortfolioId(portfolioId);
        return stockList.stream()
                .map(Stock::toDto)
                .toList();
    }

    public void updateStock() {

    }

    public void deleteStock() {

    }

}
