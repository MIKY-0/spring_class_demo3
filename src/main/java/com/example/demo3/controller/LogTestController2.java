package com.example.demo3.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 대신 만들어줌
@RestController // IoC대상 + 싱글톤 패턴으로 관리 됨.
public class LogTestController2 {

    // GET - http://localhost:8080/log-test2 (yaml의 active : dev --> 8080포트)
    @GetMapping("/log-test2")
    public String logTest() {
        log.trace("TRACE 레벨 - 가장 자세한 추적");
        log.debug("DEBUG 레벨 - 개발 중 확인용");
        log.info("INFO 레벨 - 일반 실행 정보");
        log.warn("WARN 레벨 - 주의 필요");
        log.error("ERROR 레벨 - 오류 발생. 필수 수정");

        return "서버 컴퓨터의 콘솔을 확인하세요";
    }
}
