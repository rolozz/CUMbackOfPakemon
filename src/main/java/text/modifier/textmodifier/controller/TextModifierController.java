package text.modifier.textmodifier.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import text.modifier.textmodifier.model.Text;
import text.modifier.textmodifier.service.TextService;

@Controller
public class TextModifierController {

    TextService textService;


    @Autowired
    public TextModifierController(TextService textService) {

        this.textService = textService;

    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/result")
    public String result(@RequestParam("inputString") String inputString, Model model){

        if (inputString.isEmpty()){
            return "redirect:/";
        }
        Text text = new Text(inputString);
        String result = textService.textModifier(text);
        model.addAttribute("result", result);
        return "result";

    }


}
