package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.RegexExercise;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.SerializationExercise;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.UserRegisterInput;

import java.io.File;

@Controller
public class RegexController {

    private RegexExercise regexExercise = new RegexExercise();
    private File file = new File("fileTest.txt");
    private SerializationExercise serializationExercise = new SerializationExercise();

    @GetMapping("/reg") public String regexGet(Model model){
        model.addAttribute("userRegisterInput", new UserRegisterInput());
        return "regex";
    }

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
