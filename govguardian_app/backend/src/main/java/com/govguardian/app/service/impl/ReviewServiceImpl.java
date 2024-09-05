package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.ReviewCriteria;
import com.govguardian.app.repository.ReviewRepository;
import com.govguardian.app.service.ReviewService;
import com.govguardian.app.service.dto.ReviewDTO;
import com.govguardian.app.service.mapper.ReviewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.Review}.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public Mono<ReviewDTO> save(ReviewDTO reviewDTO) {
        log.debug("Request to save Review : {}", reviewDTO);
        return reviewRepository.save(reviewMapper.toEntity(reviewDTO)).map(reviewMapper::toDto);
    }

    @Override
    public Mono<ReviewDTO> update(ReviewDTO reviewDTO) {
        log.debug("Request to update Review : {}", reviewDTO);
        return reviewRepository.save(reviewMapper.toEntity(reviewDTO)).map(reviewMapper::toDto);
    }

    @Override
    public Mono<ReviewDTO> partialUpdate(ReviewDTO reviewDTO) {
        log.debug("Request to partially update Review : {}", reviewDTO);

        return reviewRepository
            .findById(reviewDTO.getId())
            .map(existingReview -> {
                reviewMapper.partialUpdate(existingReview, reviewDTO);

                return existingReview;
            })
            .flatMap(reviewRepository::save)
            .map(reviewMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReviewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Reviews");
        return reviewRepository.findAllBy(pageable).map(reviewMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReviewDTO> findByCriteria(ReviewCriteria criteria, Pageable pageable) {
        log.debug("Request to get all Reviews by Criteria");
        return reviewRepository.findByCriteria(criteria, pageable).map(reviewMapper::toDto);
    }

    /**
     * Find the count of reviews by criteria.
     * @param criteria filtering criteria
     * @return the count of reviews
     */
    public Mono<Long> countByCriteria(ReviewCriteria criteria) {
        log.debug("Request to get the count of all Reviews by Criteria");
        return reviewRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return reviewRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<ReviewDTO> findOne(Long id) {
        log.debug("Request to get Review : {}", id);
        return reviewRepository.findById(id).map(reviewMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Review : {}", id);
        return reviewRepository.deleteById(id);
    }
}
