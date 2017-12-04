package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.controllers;

/**
 * Imports section
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.services.SerializationExercise;

import java.io.File;

/**
 * Control serialization page with exercise
 */
@Controller
public class SerialController {

    /**
     * Services and variables declaration
     */
    @Autowired
    private SerializationExercise serializationExercise;
    private File file = new File("fileTest.txt");

    /**
     * Method responsible for loading requested serialization template also with logic of given model variable
     *
     * @param model stored user inputs
     * @return ready serialization template
     */
    @GetMapping("/ser")
    public String serialGet(Model model) {
        if (file.exists() && serializationExercise.loadObject(file).getName() != null) {
            model.addAttribute("message", "Last Registered Object:");
            model.addAttribute("loadedLastObject", serializationExercise.loadObject(file).toString());
        } else {
            model.addAttribute("message", "No user has been registered.. Go to '/reg' and register user..");
        }
        return "serial";
    }
}