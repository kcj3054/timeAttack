package com.example.easyjava22.controller;


import com.example.easyjava22.domain.Story;
import com.example.easyjava22.repository.StoryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;


//@RequestMapping("")
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final StoryRepository storyRepository;

    @GetMapping("/writes")
    public String lists(Model model) {
        List<Story> story = storyRepository.findAll();
        model.addAttribute("storys", story);
        return "index";
    }


    @GetMapping("/write")
    public String writeStory(Model model) {
        model.addAttribute("story", new Story());
        return "story";
    }

    @PostMapping("/board/write")
    public String createStory(@ModelAttribute Story story, Model model) {
        storyRepository.save(story);
        model.addAttribute("content", story.getContent());
        return "index";
    }

}
