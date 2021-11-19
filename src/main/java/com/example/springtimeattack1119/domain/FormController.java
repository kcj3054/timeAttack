package com.example.springtimeattack1119.domain;

import com.example.springtimeattack1119.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FormController {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String getForm() {
        log.info("log");
        return "index";
    }

    @PostMapping
    @ResponseBody
    public String post(@RequestBody Member member, Model model) {

        memberRepository.save(member);

        List<Member> allMember = memberRepository.findAll();
        model.addAttribute("allMember", allMember);
        return "ok";

    }



//    @GetMapping
//    @ResponseBody
//    ResponseEntity<List<MemberDTO>> get() {
//        List<Member> member = memberRepository.findAll();
//        List<MemberDTO> memberDTOList = member.stream()
//                .map(m -> anyMapTo(m, MemberDTO.class))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberDTOList);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseBody
//    ResponseEntity<MemberDTO> put(@PathVariable Long id, @RequestBody final MemberDTO memberDTO) {
//
//        Optional<Member> memberOp = memberRepository.findById(id);
//        Member member = memberOp.orElseThrow();
//
//        modelMapper.map(memberDTO, member);
//
//        memberRepository.save(member);
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
//    }
//
//    private Member mapTo(final MemberDTO memberDTO) {
//        return modelMapper.map(memberDTO, Member.class);
//    }
//
//    private <T> T anyMapTo(Object data, Class<T> type) {
//        return modelMapper.map(data, type);
//    }
    //test-001
    //test-002
    //test-003
    //test-004
}
