package com.example.candidatecodeanalyser.controllers;

import com.example.candidatecodeanalyser.domain.CodeAnalyserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/codeAnalyser")
@RequiredArgsConstructor
public class CodeAnalyserController {
    private final CodeAnalyserFacade codeAnalyserFacade;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    String getCodeResult() throws InterruptedException {
        return this.codeAnalyserFacade.getCandidateCode();
    }
    @PostMapping
    void postCandidateCode(@RequestBody String candidateCode)
    {
        this.codeAnalyserFacade.sendCode(candidateCode);
    }
}
