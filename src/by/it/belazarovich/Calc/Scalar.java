package by.it.belazarovich.Calc;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalkExeption {
        if (other instanceof Scalar) {

            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.add(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            double div = this.value / (((Scalar) other).value);
            return new Scalar(div);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) throws CalkExeption {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0)
                throw new CalkExeption("Деление на ноль");
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);

    /*        if (secondScalar==0){
                return null; //TODO div by zero
            }
            return new Scalar(this.value / secondScalar);
   */
        }
        return super.div(other);
    }


    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


}
