package com.elasticsearch.wayne.repository;

import com.elasticsearch.wayne.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
