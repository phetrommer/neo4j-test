package com.example.demo.repository;

import com.example.demo.model.GenusEntity;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface GenusRepository extends ReactiveNeo4jRepository<GenusEntity, String> {
    Mono<GenusEntity> findOneByName(String name);
}
