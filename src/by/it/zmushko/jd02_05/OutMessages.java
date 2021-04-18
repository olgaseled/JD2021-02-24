package by.it.zmushko.jd02_05;

import java.time.LocalDateTime;

public class OutMessages {
    public void outAllMessages (Language lang){
        System.out.println(lang.get(Messages.HELLO));
        System.out.println(lang.get(Messages.ASK_QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.SECOND_NAME));
        LocalDateTime data = LocalDateTime.now();
    }
}
