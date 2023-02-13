package com.example.candidatecodeanalyser.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CodeAnalyserFacade {
    private  String candidateCode = "";
    private volatile boolean isCandidateCodeSet;
    public void sendCode(String code) {
        this.candidateCode = code;
        this.isCandidateCodeSet=true;
    }

    public String getCandidateCode() throws InterruptedException {
        while(!isCandidateCodeSet)
        {
            Thread.sleep(1000);
        }
        this.isCandidateCodeSet = false;
        System.out.println(this.candidateCode);
        return this.candidateCode;
    }
}
