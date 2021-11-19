package com.example.springtimeattack1119.domain;

import com.example.springtimeattack1119.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseBody
    ResponseEntity<MemberDTO> post(@RequestBody MemberDTO memberDTO) {
        Member memebr = modelMapper.map(memberDTO, Member.class);

        memberRepository.save(memebr);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberDTO);
    }

    @GetMapping
    @ResponseBody
    ResponseEntity<List<MemberDTO>> get() {
        List<Member> member = memberRepository.findAll();
        List<MemberDTO> memberDTOList = member.stream()
                .map(m -> modelMapper.map(m, MemberDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(memberDTOList);
    }

    @PutMapping("/{id}")
    @ResponseBody
    ResponseEntity<MemberDTO> put(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {

        Optional<Member> memberOp = memberRepository.findById(id);
        Member member = memberOp.orElseThrow();

        modelMapper.map(memberDTO, member);

        memberRepository.save(member);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
    //test-001
    //test-002
    //test-003
}
