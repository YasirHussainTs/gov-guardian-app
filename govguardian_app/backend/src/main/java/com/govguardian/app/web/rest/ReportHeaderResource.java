package com.govguardian.app.web.rest;

import com.govguardian.app.domain.criteria.ReportHeaderCriteria;
import com.govguardian.app.repository.ReportHeaderRepository;
import com.govguardian.app.service.ReportHeaderService;
import com.govguardian.app.service.dto.ReportHeaderDTO;
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
import java.util.UUID;

/**
 * REST controller for managing {@link com.govguardian.app.domain.ReportHeader}.
 */
@RestController
@RequestMapping("/api/report-headers")
public class ReportHeaderResource {

    private final Logger log = LoggerFactory.getLogger(ReportHeaderResource.class);

    private static final String ENTITY_NAME = "reportHeader";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReportHeaderService reportHeaderService;

    private final ReportHeaderRepository reportHeaderRepository;

    public ReportHeaderResource(ReportHeaderService reportHeaderService, ReportHeaderRepository reportHeaderRepository) {
        this.reportHeaderService = reportHeaderService;
        this.reportHeaderRepository = reportHeaderRepository;
    }

    /**
     * {@code POST  /report-headers} : Create a new reportHeader.
     *
     * @param reportHeaderDTO the reportHeaderDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reportHeaderDTO, or with status {@code 400 (Bad Request)} if the reportHeader has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public Mono<ResponseEntity<ReportHeaderDTO>> createReportHeader(@RequestBody ReportHeaderDTO reportHeaderDTO)
        throws URISyntaxException {
        log.debug("REST request to save ReportHeader : {}", reportHeaderDTO);
        if (reportHeaderDTO.getId() != null) {
            throw new BadRequestAlertException("A new reportHeader cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reportHeaderDTO.setId(UUID.randomUUID().toString());
        return reportHeaderService
            .save(reportHeaderDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/report-headers/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /report-headers/:id} : Updates an existing reportHeader.
     *
     * @param id the id of the reportHeaderDTO to save.
     * @param reportHeaderDTO the reportHeaderDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reportHeaderDTO,
     * or with status {@code 400 (Bad Request)} if the reportHeaderDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reportHeaderDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<ReportHeaderDTO>> updateReportHeader(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody ReportHeaderDTO reportHeaderDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ReportHeader : {}, {}", id, reportHeaderDTO);
        if (reportHeaderDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reportHeaderDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return reportHeaderRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return reportHeaderService
                    .update(reportHeaderDTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId()))
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /report-headers/:id} : Partial updates given fields of an existing reportHeader, field will ignore if it is null
     *
     * @param id the id of the reportHeaderDTO to save.
     * @param reportHeaderDTO the reportHeaderDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reportHeaderDTO,
     * or with status {@code 400 (Bad Request)} if the reportHeaderDTO is not valid,
     * or with status {@code 404 (Not Found)} if the reportHeaderDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the reportHeaderDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<ReportHeaderDTO>> partialUpdateReportHeader(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody ReportHeaderDTO reportHeaderDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReportHeader partially : {}, {}", id, reportHeaderDTO);
        if (reportHeaderDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reportHeaderDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return reportHeaderRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<ReportHeaderDTO> result = reportHeaderService.partialUpdate(reportHeaderDTO);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, res.getId()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /report-headers} : get all the reportHeaders.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reportHeaders in body.
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<ReportHeaderDTO>>> getAllReportHeaders(
        ReportHeaderCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get ReportHeaders by criteria: {}", criteria);
        return reportHeaderService
            .countByCriteria(criteria)
            .zipWith(reportHeaderService.findByCriteria(criteria, pageable).collectList())
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
     * {@code GET  /report-headers/count} : count all the reportHeaders.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public Mono<ResponseEntity<Long>> countReportHeaders(ReportHeaderCriteria criteria) {
        log.debug("REST request to count ReportHeaders by criteria: {}", criteria);
        return reportHeaderService.countByCriteria(criteria).map(count -> ResponseEntity.status(HttpStatus.OK).body(count));
    }

    /**
     * {@code GET  /report-headers/:id} : get the "id" reportHeader.
     *
     * @param id the id of the reportHeaderDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reportHeaderDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ReportHeaderDTO>> getReportHeader(@PathVariable("id") String id) {
        log.debug("REST request to get ReportHeader : {}", id);
        Mono<ReportHeaderDTO> reportHeaderDTO = reportHeaderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reportHeaderDTO);
    }

    /**
     * {@code DELETE  /report-headers/:id} : delete the "id" reportHeader.
     *
     * @param id the id of the reportHeaderDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteReportHeader(@PathVariable("id") String id) {
        log.debug("REST request to delete ReportHeader : {}", id);
        return reportHeaderService
            .delete(id)
            .then(
                Mono.just(
                    ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build()
                )
            );
    }
}
