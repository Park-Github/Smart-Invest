package poe.spring.domain.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import poe.spring.domain.member.model.entity.Member;
import poe.spring.domain.member.model.repository.MemberRepo;
import poe.spring.domain.portfolio.dto.PortfolioDto;
import poe.spring.domain.portfolio.model.entity.Portfolio;
import poe.spring.domain.portfolio.model.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioCrudService {

    private final MemberRepo memberRepo;
    private final PortfolioRepo portfolioRepo;

    public PortfolioDto createPortfolio(Long memberId, String name) {
        Member memberEntity = memberRepo.findById(memberId)
                .orElseThrow(() -> new NullPointerException("Member does not exist."));
        portfolioRepo.findByName(name)
                .ifPresent(portfolio -> {
                    throw new IllegalArgumentException("Portfolio '%s' already exists.".formatted(name));
                });
        Portfolio portfolioEntity =
                Portfolio.builder()
                        .name(name)
                        .member(memberEntity)
                        .build();

        return Portfolio.toDto(portfolioRepo.save(portfolioEntity));
    }

    public List<PortfolioDto> readPortfolios(Long memberId) {
        Member member = readMember(memberId);
        List<Portfolio> portfolios = member.getPortfolios();
        List<PortfolioDto> portfolioDtos =
                portfolios.stream().map(Portfolio::toSimpleDto).toList();
        return portfolioDtos;
    }

    public PortfolioDto update(Long portfolioId, String name) {
        Portfolio existingPortfolio = readPortfolio(portfolioId);
        Portfolio updatedPortfolio = portfolioRepo.updateById(existingPortfolio.getId());
        return Portfolio.toSimpleDto(updatedPortfolio);
    }

    public void deletePortfolio(Long portfolioId) {
        Portfolio portfolio = readPortfolio(portfolioId);
        portfolioRepo.deleteById(portfolio.getId());
    }

    private Member readMember(Long id) {
        Optional<Member> memberEntity = memberRepo.findById(id);
        if (memberEntity.isEmpty())
            throw new NullPointerException("Member does not exist.");
        else
            return memberEntity.get();
    }

    private Portfolio readPortfolio(Long id) {
        Optional<Portfolio> portfolioEntity = portfolioRepo.findById(id);
        if (portfolioEntity.isEmpty())
            throw new NullPointerException("Portfolio does not exist.");
        else
            return portfolioEntity.get();
    }

}
