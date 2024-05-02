package com.elasticsearch.wayne;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "boards")
public class Board {
    @Id
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "alc_search_keys_board_links",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "board_search_key_id")
    )
    private List<BoardSearchKey> searchKeys = new ArrayList<>();
}
