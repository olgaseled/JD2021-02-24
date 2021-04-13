package by.it.korotkevich.jd02_01;

public class Good {
    final String nameOfGood;

    Good(String nameOfGood) {
        this.nameOfGood = nameOfGood;
    }

    static Good toLowerCase(Good uneditedGood) {
        String goodToLowerCase = uneditedGood.toString().toLowerCase();
        return new Good(goodToLowerCase);
    }


    @Override
    public String toString() {
        return nameOfGood;
    }
}
