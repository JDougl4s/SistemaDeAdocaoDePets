package system.service;

import java.text.Normalizer;

public class StringUtils {

    public static String removeAccents(String input){
        // normalize(...,NFD) Retorna a string separando as acentuações,
        // replaceAll pega os acentos separados e substitui por nada "", assim retornando a palavra sem acento
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}","");
    }
}
