package by.it.savchenko.jd02_04;

class Scalar extends by.it.savchenko.jd02_04.Var {

    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public by.it.savchenko.jd02_04.Var add(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public by.it.savchenko.jd02_04.Var sub(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.add(this).mul(new Scalar(-1));
    }

    @Override
    public by.it.savchenko.jd02_04.Var mul(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public by.it.savchenko.jd02_04.Var div(by.it.savchenko.jd02_04.Var other) throws CalcException {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).value;
            if (secondScalar==0){
                return null; //TODO div Scalar by zero
            }
            return new Scalar(this.value / secondScalar);
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
