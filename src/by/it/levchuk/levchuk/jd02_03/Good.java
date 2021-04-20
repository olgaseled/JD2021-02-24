package by.it.levchuk.levchuk.jd02_03;
/*crash-noobik
Liauchuk Aliaksandr*/

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
