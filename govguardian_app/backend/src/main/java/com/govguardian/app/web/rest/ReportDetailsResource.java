package com.govguardian.app.web.rest;

import com.govguardian.app.domain.criteria.ReportDetailsCriteria;
import com.govguardian.app.repository.ReportDetailsRepository;
import com.govguardian.app.service.ReportDetailsService;
import com.govguardian.app.service.dto.ReportDetailsDTO;
import com.govguardian.app.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.ForwardedHeaderUtils;
import reactor.core.publisher.Mono;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link com.govguardian.app.domain.ReportDetails}.
 */
@RestController
@RequestMapping("/api/report-details")
public class ReportDetailsResource {

    private final Logger log = LoggerFactory.getLogger(ReportDetailsResource.class);

    private static final String ENTITY_NAME = "reportDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReportDetailsService reportDetailsService;

    private final ReportDetailsRepository reportDetailsRepository;

    public ReportDetailsResource(ReportDetailsService reportDetailsService, ReportDetailsRepository reportDetailsRepository) {
        this.reportDetailsService = reportDetailsService;
        this.reportDetailsRepository = reportDetailsRepository;
    }

    /**
     * {@code POST  /report-details} : Create a new reportDetails.
     *
     * @param reportDetailsDTO the reportDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reportDetailsDTO, or with status {@code 400 (Bad Request)} if the reportDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public Mono<ResponseEntity<ReportDetailsDTO>> createReportDetails(@RequestBody ReportDetailsDTO reportDetailsDTO)
        throws URISyntaxException {
        log.debug("REST request to save ReportDetails : {}", reportDetailsDTO);
        if (reportDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new reportDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return reportDetailsService
            .save(reportDetailsDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/report-details/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /report-details/:id} : Updates an existing reportDetails.
     *
     * @param id the id of the reportDetailsDTO to save.
     * @param reportDetailsDTO the reportDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reportDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the reportDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reportDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<ReportDetailsDTO>> updateReportDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReportDetailsDTO reportDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ReportDetails : {}, {}", id, reportDetailsDTO);
        if (reportDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reportDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return reportDetailsRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return reportDetailsService
                    .update(reportDetailsDTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /report-details/:id} : Partial updates given fields of an existing reportDetails, field will ignore if it is null
     *
     * @param id the id of the reportDetailsDTO to save.
     * @param reportDetailsDTO the reportDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reportDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the reportDetailsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the reportDetailsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the reportDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<ReportDetailsDTO>> partialUpdateReportDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReportDetailsDTO reportDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReportDetails partially : {}, {}", id, reportDetailsDTO);
        if (reportDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reportDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return reportDetailsRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<ReportDetailsDTO> result = reportDetailsService.partialUpdate(reportDetailsDTO);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, res.getId().toString()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /report-details} : get all the reportDetails.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reportDetails in body.
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<ReportDetailsDTO>>> getAllReportDetails(
        ReportDetailsCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get ReportDetails by criteria: {}", criteria);
        return reportDetailsService
            .countByCriteria(criteria)
            .zipWith(reportDetailsService.findByCriteria(criteria, pageable).collectList())
            .map(countWithEntities ->
                ResponseEntity
                    .ok()
                    .headers(
                        PaginationUtil.generatePaginationHttpHeaders(
                            ForwardedHeaderUtils.adaptFromForwardedHeaders(request.getURI(), request.getHeaders()),
                            new PageImpl<>(countWithEntities.getT2(), pageable, countWithEntities.getT1())
                        )
                    )
                    .body(countWithEntities.getT2())
            );
    }

    /**
     * {@code GET  /report-details/count} : count all the reportDetails.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public Mono<ResponseEntity<Long>> countReportDetails(ReportDetailsCriteria criteria) {
        log.debug("REST request to count ReportDetails by criteria: {}", criteria);
        return reportDetailsService.countByCriteria(criteria).map(count -> ResponseEntity.status(HttpStatus.OK).body(count));
    }

    /**
     * {@code GET  /report-details/:id} : get the "id" reportDetails.
     *
     * @param id the id of the reportDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reportDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ReportDetailsDTO>> getReportDetails(@PathVariable("id") Long id) {
        log.debug("REST request to get ReportDetails : {}", id);
        Mono<ReportDetailsDTO> reportDetailsDTO = reportDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reportDetailsDTO);
    }

    /**
     * {@code DELETE  /report-details/:id} : delete the "id" reportDetails.
     *
     * @param id the id of the reportDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteReportDetails(@PathVariable("id") Long id) {
        log.debug("REST request to delete ReportDetails : {}", id);
        return reportDetailsService
            .delete(id)
            .then(
                Mono.just(
                    ResponseEntity
                        .noContent()
                        .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                        .build()
                )
            );
    }
}
