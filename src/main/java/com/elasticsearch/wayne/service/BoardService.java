package com.elasticsearch.wayne.service;

import com.elasticsearch.wayne.document.BoardDocument;
import com.elasticsearch.wayne.dto.BoardReq;
import com.elasticsearch.wayne.entity.Board;
import com.elasticsearch.wayne.repository.BoardElasticsearchRepository;
import com.elasticsearch.wayne.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardElasticsearchRepository boardElasticsearchRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, BoardElasticsearchRepository boardElasticsearchRepository) {
        this.boardRepository = boardRepository;
        this.boardElasticsearchRepository = boardElasticsearchRepository;
    }

    /*
    게시글 생성
    */
    @Transactional
    public String createBoard(BoardReq.PostBoardReq postBoardReq){
        Board board = Board.builder()
                .title(postBoardReq.getTitle())
                .content(postBoardReq.getContent())
                .build();

        boardRepository.save(board);

        return "boardId:" + board.getId() + " 인 게시글 생성"; // getId() 호출
    }

    /*
    게시글 수정
     */
    @Transactional
    public String updateBoard(Long id, BoardReq.PatchBoardReq patchBoardReq){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        board.updateBoard(patchBoardReq.getTitle(), patchBoardReq.getContent());
        boardRepository.save(board); // 수정 후 저장

        return "boardId:" + board.getId() + " 인 게시글 수정"; // getId() 호출
    }

    /*
    게시글 삭제
     */
    @Transactional
    public String deleteBoard(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        });

        boardRepository.delete(board);
        return "boardId:" + boardId + " 인 게시글 삭제";
    }

    public List<BoardDocument> searchBoards(String query) {
        return boardElasticsearchRepository.findByTitleContains(query);
    }
}
