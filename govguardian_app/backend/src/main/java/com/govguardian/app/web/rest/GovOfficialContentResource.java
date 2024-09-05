package com.govguardian.app.web.rest;

import com.govguardian.app.domain.criteria.GovOfficialContentCriteria;
import com.govguardian.app.repository.GovOfficialContentRepository;
import com.govguardian.app.service.GovOfficialContentService;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
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
 * REST controller for managing {@link com.govguardian.app.domain.GovOfficialContent}.
 */
@RestController
@RequestMapping("/api/gov-official-contents")
public class GovOfficialContentResource {

    private final Logger log = LoggerFactory.getLogger(GovOfficialContentResource.class);

    private static final String ENTITY_NAME = "govOfficialContent";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GovOfficialContentService govOfficialContentService;

    private final GovOfficialContentRepository govOfficialContentRepository;

    public GovOfficialContentResource(
        GovOfficialContentService govOfficialContentService,
        GovOfficialContentRepository govOfficialContentRepository
    ) {
        this.govOfficialContentService = govOfficialContentService;
        this.govOfficialContentRepository = govOfficialContentRepository;
    }

    /**
     * {@code POST  /gov-official-contents} : Create a new govOfficialContent.
     *
     * @param govOfficialContentDTO the govOfficialContentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new govOfficialContentDTO, or with status {@code 400 (Bad Request)} if the govOfficialContent has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public Mono<ResponseEntity<GovOfficialContentDTO>> createGovOfficialContent(@RequestBody GovOfficialContentDTO govOfficialContentDTO)
        throws URISyntaxException {
        log.debug("REST request to save GovOfficialContent : {}", govOfficialContentDTO);
        if (govOfficialContentDTO.getId() != null) {
            throw new BadRequestAlertException("A new govOfficialContent cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return govOfficialContentService
            .save(govOfficialContentDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/gov-official-contents/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /gov-official-contents/:id} : Updates an existing govOfficialContent.
     *
     * @param id the id of the govOfficialContentDTO to save.
     * @param govOfficialContentDTO the govOfficialContentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated govOfficialContentDTO,
     * or with status {@code 400 (Bad Request)} if the govOfficialContentDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the govOfficialContentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<GovOfficialContentDTO>> updateGovOfficialContent(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody GovOfficialContentDTO govOfficialContentDTO
    ) throws URISyntaxException {
        log.debug("REST request to update GovOfficialContent : {}, {}", id, govOfficialContentDTO);
        if (govOfficialContentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, govOfficialContentDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return govOfficialContentRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return govOfficialContentService
                    .update(govOfficialContentDTO)
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
     * {@code PATCH  /gov-official-contents/:id} : Partial updates given fields of an existing govOfficialContent, field will ignore if it is null
     *
     * @param id the id of the govOfficialContentDTO to save.
     * @param govOfficialContentDTO the govOfficialContentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated govOfficialContentDTO,
     * or with status {@code 400 (Bad Request)} if the govOfficialContentDTO is not valid,
     * or with status {@code 404 (Not Found)} if the govOfficialContentDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the govOfficialContentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<GovOfficialContentDTO>> partialUpdateGovOfficialContent(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody GovOfficialContentDTO govOfficialContentDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update GovOfficialContent partially : {}, {}", id, govOfficialContentDTO);
        if (govOfficialContentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, govOfficialContentDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return govOfficialContentRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<GovOfficialContentDTO> result = govOfficialContentService.partialUpdate(govOfficialContentDTO);

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
     * {@code GET  /gov-official-contents} : get all the govOfficialContents.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of govOfficialContents in body.
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<GovOfficialContentDTO>>> getAllGovOfficialContents(
        GovOfficialContentCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get GovOfficialContents by criteria: {}", criteria);
        return govOfficialContentService
            .countByCriteria(criteria)
            .zipWith(govOfficialContentService.findByCriteria(criteria, pageable).collectList())
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
     * {@code GET  /gov-official-contents/count} : count all the govOfficialContents.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public Mono<ResponseEntity<Long>> countGovOfficialContents(GovOfficialContentCriteria criteria) {
        log.debug("REST request to count GovOfficialContents by criteria: {}", criteria);
        return govOfficialContentService.countByCriteria(criteria).map(count -> ResponseEntity.status(HttpStatus.OK).body(count));
    }

    /**
     * {@code GET  /gov-official-contents/:id} : get the "id" govOfficialContent.
     *
     * @param id the id of the govOfficialContentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the govOfficialContentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<GovOfficialContentDTO>> getGovOfficialContent(@PathVariable("id") Long id) {
        log.debug("REST request to get GovOfficialContent : {}", id);
        Mono<GovOfficialContentDTO> govOfficialContentDTO = govOfficialContentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(govOfficialContentDTO);
    }

    /**
     * {@code DELETE  /gov-official-contents/:id} : delete the "id" govOfficialContent.
     *
     * @param id the id of the govOfficialContentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteGovOfficialContent(@PathVariable("id") Long id) {
        log.debug("REST request to delete GovOfficialContent : {}", id);
        return govOfficialContentService
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
