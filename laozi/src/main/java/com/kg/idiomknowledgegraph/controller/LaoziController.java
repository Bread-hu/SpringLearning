package com.kg.idiomknowledgegraph.controller;

import com.kg.idiomknowledgegraph.bean.Daodejing;
import com.kg.idiomknowledgegraph.service.LaoziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;


@Controller
@RequestMapping("/laozi")
public class LaoziController {

    @Autowired
    private LaoziService laoziService;

    private Daodejing daodejing;

    @GetMapping("/daodejing")
    public String toDaodejing(Model model) {
        return "laozi/daodejing";
    }

    @PostMapping("/daodejing")
    @ResponseBody
    public Daodejing getContentByChapter(int chapter){
        this.daodejing=laoziService.getDaodejing(chapter);
        return this.daodejing;
    }

    @PostMapping("/selectLanguage")
    @ResponseBody
    public String selectLanguage(String language) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.daodejing.getClass().getMethod("get"+language,new Class[]{}).invoke(this.daodejing,new Object[]{});
    }

}
