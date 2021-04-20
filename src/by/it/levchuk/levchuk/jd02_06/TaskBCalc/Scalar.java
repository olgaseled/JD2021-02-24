package by.it.levchuk.levchuk.jd02_06.TaskBCalc;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value*((Scalar)other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).value;
            if (secondScalar == 0) {
                throw new CalcException("деление на ноль");
            }
            return new Scalar(this.value / secondScalar);
        }
            return super.div(other);
    }

    Scalar(double value) { this.value = value; }

    Scalar(String strValue) { this.value = Double.parseDouble(strValue); }

    @Override
    public String toString() { return Double.toString(value); }
}
