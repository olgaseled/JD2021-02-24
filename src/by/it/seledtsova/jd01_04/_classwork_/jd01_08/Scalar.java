package by.it.seledtsova.jd01_04._classwork_.jd01_08;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.add(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double secondScalar = ((Scalar) other).value;
            if (secondScalar==0){
                return null; //TODO div by zero
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
