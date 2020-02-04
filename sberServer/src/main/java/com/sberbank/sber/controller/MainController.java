package com.sberbank.sber.controller;

import com.sberbank.sber.model.Dict;
import com.sberbank.sber.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    private DictionaryRepo dictionaryRepo;

    public MainController(@Autowired DictionaryRepo dictionaryRepo) {
        this.dictionaryRepo = dictionaryRepo;
    }

    @GetMapping(value = "/dictionary/{title}")
    public Dict getDictByName(HttpServletRequest request, @PathVariable String title) throws Exception {
        return dictionaryRepo.findByName(title);
    }
}
