package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.services.RegexExercise;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.UserRegisterInput;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.services.SerializationExercise;

import java.io.File;

/**
 * Control regex page with exercise
 */
@Controller
public class RegexController {

    /**
     * Services and variables declaration
     */
    @Autowired private RegexExercise regexExercise;
    @Autowired private SerializationExercise serializationExercise;
    private File file = new File("fileTest.txt");

    /**
     * Method responsible for loading requested regex template also with inputs to fulfill by user and store with
     * given model variable
     * @param model stored user inputs
     * @return ready regex template
     */
    @GetMapping("/reg") public String regexGet(Model model){
        model.addAttribute("userRegisterInput", new UserRegisterInput());
        return "regex";
    }

    /**
     * Method responsible to manage regex service logic
     * @param userRegisterInput stored user variable
     * @param model holding calculations
     * @return regex template with results
     */
    @PostMapping("/reg") public String regexPost(@ModelAttribute("userRegisterInput") UserRegisterInput userRegisterInput, Model model){
        if (!regexExercise.isProperName(userRegisterInput.getName())){
            model.addAttribute("infoName", "Name have to start from Capital letter without any special characters");
        } else if (!regexExercise.isProperSurname(userRegisterInput.getSurName())){
            model.addAttribute("infoSurname", "Surname have to start from Capital letter without any special " +
                    "characters, allowed second surname separated '-' ");
        }
        else if (!regexExercise.isEmailAddress(userRegisterInput.getEmail())){
            model.addAttribute("infoEmail", "Proper email address have to contain one '@' and allowed ending");
        }
        else if (!regexExercise.isStreetCorrected(userRegisterInput.getStreet())){
            model.addAttribute("infoEmail", "Proper street name have started from capital letter, without any " +
                    "'st.', 'ul.' and ',' before or after street number");
        } else if (!regexExercise.isPasswordSecure(userRegisterInput.getPassword())){
            model.addAttribute("infoPassword", "Password have to contain 8 characters, at least one Capital letter, " +
                    "special sign and digit");
        } else {
            serializationExercise.saveObject(file, userRegisterInput);
            model.addAttribute("message", "REGISTRATION SUCCESSFUL! LAST USER:");
            model.addAttribute("loadedLastObject", serializationExercise.loadObject(file).toString());
            return "serial";
        }
        return "regex";
    }
}