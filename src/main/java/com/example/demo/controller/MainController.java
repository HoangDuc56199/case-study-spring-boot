package com.example.demo.controller;


import com.example.demo.service.IQuestionContentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class MainController {
    private final IQuestionContentService questionContentService;

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "") String name,
                                 @PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
    ) {
        ModelAndView modelAndView = new ModelAndView("table");
        modelAndView.addObject("questions", questionContentService.findAll());

        return modelAndView;
    }


}
