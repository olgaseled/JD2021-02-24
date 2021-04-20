package by.it.dudko.calc;

public class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(value - ((Scalar) other).value);
        }
        return other.add(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).value;
            if (secondScalar == 0) {
                throw new CalcException(Language.INSTANCE.get(Messages.DIV_BY_ZERO));
            }
            return new Scalar(value / secondScalar);
        }
        return super.div(other);
    }

}
