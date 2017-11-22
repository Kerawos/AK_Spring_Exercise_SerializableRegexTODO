package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegex.models.SerializationExercise;

import java.io.File;


@Controller
public class SerialController {

    private File file = new File("fileTest.txt");
    private SerializationExercise serializationExercise = new SerializationExercise();

    @GetMapping("/ser") public String serialGet(Model model){
        if (file.exists() && serializationExercise.loadObject(file).getName()!=null){
            model.addAttribute("message", "Last Registered Object:");
            model.addAttribute("loadedLastObject", serializationExercise.loadObject(file).toString());
        } else {
            model.addAttribute("message", "No user has been registered.. Go to '/reg' and register user..");
        }
        return "serial";
    }

}
