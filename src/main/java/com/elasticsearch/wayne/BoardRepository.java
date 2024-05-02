package com.elasticsearch.wayne;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT a FROM Board a " +
            "LEFT JOIN FETCH a.searchKeys")
    List<Board> findAllWithSearchKeys();

    @Query("SELECT a FROM Board a " +
            "LEFT JOIN FETCH a.searchKeys " +
            "WHERE a.id = :id")
    Optional<Board> findByIdWithSearchKeys(Long id);
}
