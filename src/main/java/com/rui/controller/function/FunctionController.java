package com.rui.controller.function;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/5.
 */
@Controller
@RequestMapping("function")
public class FunctionController {
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        model.addAttribute("tieFormBean",new TieFormBean());
        return "function/addNewTie";
    }

    @RequestMapping("add")
    public String add(){

        return null;
    }
}
