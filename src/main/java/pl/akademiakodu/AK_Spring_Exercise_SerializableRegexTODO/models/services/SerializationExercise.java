package pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.services;

import pl.akademiakodu.AK_Spring_Exercise_SerializableRegexTODO.models.UserRegisterInput;

import java.io.*;

public class SerializationExercise {

        public void saveObject(File file, UserRegisterInput object){
            //todo create file
            //todo write object into file
        }

        public UserRegisterInput loadObject(File file){
            //todo load object from file
            return new UserRegisterInput();
        }


}
