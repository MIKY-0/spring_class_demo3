package com.example.demo3.controller;

import com.example.demo3.models.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MustacheTestController {
    // GET http://localhost:8080/mustache-test
    @GetMapping("/mustache-test")
    public String mustacheTest(Model model) {
        log.warn("여기확인1111111111111");
        // Model : 화면에 넘길 값을 담는 상자. 이름으로 넣고 템플릿에서 같은 이름으로 꺼낼 수 있음.
        // 1. 값 출력.
        model.addAttribute("stringValue" , "안녕하세요");
        model.addAttribute("intValue" , 1234);

        // 2. 조건 (섹션 , 반전 섹션)
        model.addAttribute("isLogin" , false);
        model.addAttribute("notice" , "공지사항이 있습니다.");
        model.addAttribute("emptyList" , List.of());

        // 3. 반복
//         List list = new ArrayList();
//         list.add("사과");
//         list.add("포도");
//         list.add("배");
//         model.addAttribute("fruits" , list);

        model.addAttribute("fruits", List.of("사과", "배", "포도"));

        model.addAttribute("users", List.of(
                new UserDto("김민수", 25),
                    new UserDto("박지훈", 31),
                    new UserDto("이서연", 28)
        ));

        // 4. 점(.)으로 안쪽 값 꺼내기.
        model.addAttribute("info", Map.of("job", "개발자", "city", "부산"));

        // 5. 이스케이프 비교.
        model.addAttribute("htmlContent", "<b>굵은 글씨</b>");

        // templates/mustache-test.mustache로 찾아감.
        return "mustache-test";
    }

    // http://localhost:8080/layout-test
    @GetMapping("/layout-test")
    public String layoutTest() {
        return "layout-test";
    }
}
