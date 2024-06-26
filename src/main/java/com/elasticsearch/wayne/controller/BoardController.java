package com.elasticsearch.wayne.controller;

import com.elasticsearch.wayne.document.BoardDocument;
import com.elasticsearch.wayne.dto.BoardReq;
import com.elasticsearch.wayne.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /*
    게시글 생성
     */
    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody BoardReq.PostBoardReq postBoardReq) {
        String response = boardService.createBoard(postBoardReq);
        return ResponseEntity.ok(response);
    }

    /*
    게시글 수정
     */
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id, @RequestBody BoardReq.PatchBoardReq patchBoardReq) {
        String response = boardService.updateBoard(id, patchBoardReq);
        return ResponseEntity.ok(response);
    }

    /*
    게시글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        String response = boardService.deleteBoard(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BoardDocument>> searchBoards(@RequestParam String query) {
        List<BoardDocument> searchResult = boardService.searchBoards(query);
        return ResponseEntity.ok(searchResult);
    }
}
