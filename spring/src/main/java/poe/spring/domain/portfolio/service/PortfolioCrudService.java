package poe.spring.domain.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import poe.spring.domain.member.model.entity.Member;
import poe.spring.domain.member.model.repository.MemberRepo;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.dto.SimplePortfolioDto;
import poe.spring.domain.portfolio.model.entity.Portfolio;
import poe.spring.domain.portfolio.model.repository.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioCrudService {

    private final MemberRepo memberRepo;
    private final PortfolioRepo portfolioRepo;
    private final ItemRepo itemRepo;
    private final CashRepository cashRepository;
    private final CashTransactionRepo cashTransactionRepo;
    private final StockTransactionRepo stockTransactionRepo;

    public SimplePortfolioDto createPortfolio(Long memberId, String name) {
        Member memberEntity = memberRepo.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist."));
        portfolioRepo.findByName(name)
                .ifPresent(portfolio -> {
                    throw new IllegalArgumentException("Portfolio '%s' already exists.".formatted(name));
                });
        Portfolio portfolioEntity =
                Portfolio.builder()
                        .name(name)
                        .member(memberEntity)
                        .build();

        return Portfolio.toSimpleDto(portfolioRepo.save(portfolioEntity));
    }

    public List<SimplePortfolioDto> readPortfolios(Long memberId) {
        Member member = readMember(memberId);
        List<Portfolio> portfolios = member.getPortfolios();
        List<SimplePortfolioDto> simplePortfolioDtos =
                portfolios.stream().map(Portfolio::toSimpleDto).toList();
        return simplePortfolioDtos;
    }

    public PortfolioDto readOnePortfolio(Long portfolioId) {
        Portfolio portfolio = readPortfolio(portfolioId);
        return Portfolio.toDto(portfolio);
    }

    public void update(Long memberId, SimplePortfolioDto simplePortfolioDto) {

    }

    public void deletePortfolio(Long memberId, Long portfolioId) {
        deleteException(memberId, portfolioId);
        portfolioRepo.deleteById(portfolioId);
    }

    private Member readMember(Long id) {
        Optional<Member> memberEntity = memberRepo.findById(id);
        if (memberEntity.isEmpty())
            throw new IllegalArgumentException("Member does not exist.");
        else
            return memberEntity.get();
    }

    private Portfolio readPortfolio(Long id) {
        Optional<Portfolio> portfolioEntity = portfolioRepo.findById(id);
        if (portfolioEntity.isEmpty())
            throw new IllegalArgumentException("Portfolio does not exist.");
        else
            return portfolioEntity.get();
    }

    private void deleteException(Long memberId, Long portfolioId) {
        Member member = readMember(memberId);
        Portfolio portfolio = readPortfolio(portfolioId);
        if (!Objects.equals(member.getId(), portfolio.getMember().getId()))
            throw new IllegalArgumentException("It's not a member's portfolio.");
    }


}
