package com.example.demo;
/* demo
 * @created 05/29/2022
 * @author Konstantin Staykov
 */

import java.util.Locale;

public class HelloHelper {
    public String getGreeting(Locale locale) {
        String languageTag = locale.toLanguageTag().substring(0, 2);

        String greeting;
        // using enhanced switch statement
        switch (languageTag) {
            case "fr" -> greeting = "Bonjour";
            case "de" -> greeting = "Guten Tag";
            default -> {
                greeting = "hello";
                languageTag = "en";
            }

        }
        return greeting;
    }
}

