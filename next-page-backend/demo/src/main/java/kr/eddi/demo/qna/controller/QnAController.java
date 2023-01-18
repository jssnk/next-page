package kr.eddi.demo.qna.controller;


import kr.eddi.demo.qna.entity.QnA;
import kr.eddi.demo.qna.request.QnARequest;
import kr.eddi.demo.qna.response.QnaResponse;
import kr.eddi.demo.qna.service.QnAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("qna")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class QnAController {



    @Autowired
    private QnAService service;

    @GetMapping("/list")
    public List<QnaResponse> getQnAList () { // QnA 목록
        log.info("getQnAList()");

        return service.getAllQnaList();
    }

    @PostMapping("/register")
    public Boolean QnAWrite (@RequestBody QnARequest qnaRequest) { // QnA 작성
        log.info("QnARegister()");

        return service.write(qnaRequest);
    }

    @GetMapping("/{qnaNo}")
    public QnA QnARead (@PathVariable("qnaNo") Long qnaNo) {  // QnA 읽기
        log.info("qnaRead()");

        return service.read(qnaNo);
    }

    @DeleteMapping("/{qnaNo}")
    public void QnARemove (@PathVariable("qnaNo") Long qnaNo) { // QnA 삭제
        log.info("QnARemove()");

        service.remove(qnaNo);
    }

    @PutMapping("/{qnaNo}")
    public QnA QnAModify (@PathVariable("qnaNo") Long qnaNo, @RequestBody QnA qna) { // QnA 수정
        log.info("boardModify()");

        qna.setQnaNo(qnaNo);
        service.modify(qna);

        return qna;
    }

    @GetMapping("/my-qna-list/{memberId}")
    public List<QnaResponse> getMyQnaList (@PathVariable("memberId")Long memberId) {
        log.info("getMyQnaList()" + memberId);
        return service.getQnaListByMemberId(memberId);
    }








}
