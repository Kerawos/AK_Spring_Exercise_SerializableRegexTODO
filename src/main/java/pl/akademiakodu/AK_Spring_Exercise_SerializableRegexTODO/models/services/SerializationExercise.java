package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.services;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.UserRegisterInput;

import java.io.*;

/**
 * Service responsible for all serialization logic using in this exercise.
 */
@Service
public class SerializationExercise {

    /**
     * Method try to save given object in listed file
     * @param file
     * @param object
     */
    public void saveObject(File file, UserRegisterInput object){
        //todo create file
        //todo write object into file
    }

    /**
     * Method load object from given file
     * @param file
     * @return object from file
     */
    public UserRegisterInput loadObject(File file){
        //todo load object from file
        return new UserRegisterInput();
    }

}
