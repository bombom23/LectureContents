package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.DragonflyCommentRequest;
import com.example.market3.Entity.JpaDragonfly;
import com.example.market3.Entity.JpaDragonflyComment;
import com.example.market3.Rapository.DragonflyCommentRepository;
import com.example.market3.Rapository.DragonflyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragonflyServiceimpl  implements  DragonflyService{

    @Autowired
    DragonflyRepository dragonflyRepository;
    @Autowired
    DragonflyCommentRepository dragonflyCommentRepository;

    @Override
    public void register(JpaDragonfly jpaDragonfly) throws Exception {
        dragonflyRepository.save(jpaDragonfly);
    }

    @Override
    public List<JpaDragonfly> getDragonList() throws Exception {
        return dragonflyRepository.findAll();
    }

    @Override
    public Optional<JpaDragonfly> read(Long boardNo) throws Exception {
        return dragonflyRepository.findById(boardNo);
    }

    @Override
    public void addcomments(DragonflyCommentRequest dragonflyCommentRequest) throws Exception {

        JpaDragonflyComment jpaDragonflyComment = new JpaDragonflyComment(dragonflyCommentRequest.getBoardNo(), dragonflyCommentRequest.getUi(), dragonflyCommentRequest.getComments());
        dragonflyCommentRepository.save(jpaDragonflyComment);
    }

    @Override
    public List<JpaDragonflyComment> getcomment(Long boardNo) throws Exception {
        return dragonflyCommentRepository.findBycomment(boardNo);
    }

    @Override
    public void addvuecount(Long boardNo) throws Exception {
        dragonflyRepository.addvuecount(boardNo);
    }
}
