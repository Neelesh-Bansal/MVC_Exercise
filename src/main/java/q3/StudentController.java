package q3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class StudentController{

    @RequestMapping("/hello")
    public ModelAndView request1() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public  String request2(){
        return "This is from response body";
    }



    @RequestMapping("/hello3")
    public ModelAndView request3() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name","Hello World");
        return modelAndView;
    }


//    @RequestMapping("/{id}/{name}")
//    public ModelAndView request4(@PathVariable("id") int id,@PathVariable("name") String name){
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("sid",id);
//        modelAndView.addObject("name1",name);
//        return modelAndView;
//    }

//    @RequestMapping("/{id}/{name}")
//    public ModelAndView get3(@PathVariable Map<String,String> var){
//        ModelAndView modelAndView=new ModelAndView("index");
//        String id=var.get("id");
//        String name=var.get("name");
//        modelAndView.addObject("sid",id);
//        modelAndView.addObject("name",name);
//        return modelAndView;
//    }

    @RequestMapping("/type")
    public ModelAndView request6(@RequestParam("id") int id, @RequestParam("name") String name){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("sid",id);
        modelAndView.addObject("name",name);
        return modelAndView;
    }


    @RequestMapping("/bind")
    public ModelAndView request7(@RequestParam("firstName") String firstName1, @RequestParam("lastName") String lastName1){

        StudentCo studentCo = new StudentCo();
        studentCo.setFirstName(firstName1);
        studentCo.setLastName(lastName1);
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("sid",studentCo.getFirstName());
        modelAndView.addObject("name",studentCo.getLastName());
        return modelAndView;
    }

    @ModelAttribute
    void addHeader(Model model){
        model.addAttribute("Head","Welcome User");
    }

}
