package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.service.TextService;
import camt.se331.shoppingcart.service.textserviceimpl.DoNothingTextServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dto on 2/7/2015.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("textBuffer")
public class TextController {
    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

    @ModelAttribute("textBuffer")
    private String getTemp(){
        return "";
    }


    TextService textService = new DoNothingTextServiceImpl();
    @RequestMapping(value = "/temp", method = RequestMethod.POST)
    public @ResponseBody String getTemp(@RequestBody String input, @ModelAttribute("textBuffer") String buffer,BindingResult result,ModelMap model){
        String newText = buffer + "<br/>" + textService.formatText(input);
        model.addAttribute("textBuffer",newText);
        return newText;
    }
}
