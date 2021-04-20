package by.it.dudko.calc;

public enum Languages {
    EN, RU, BE;

    public static String getLongName(String langName) {
        Languages current = Languages.valueOf(langName.toUpperCase());
        switch (current) {
            case EN:
                return "english";
            case RU:
                return "русский";
            case BE:
                return "беларускi";
            default:
                return "system language";
        }
    }
}
