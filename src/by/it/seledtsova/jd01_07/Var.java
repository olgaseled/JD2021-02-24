package by.it.seledtsova.jd01_07;

// нажать alt insert

abstract class Var { // cлово abstract (модификатор)  означет , что наш класс абстрактный. Также мы убрали слова public
                    //так как этот класс не используется нигде больше
    @Override
    public String toString() {    //здесь мы не можешь снять модификатор public,
        return "abstract Var{}";  // тк этот класс String  наследуется от Object
    }                                  //а в object  сказано,  метод  toString возвращает String и он public,
                                    //
}


