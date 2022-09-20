package numerical;

public class EiugenVector extends Vector {

    double eigunvalue;

    EiugenVector(Vector v, double eigunvalue) {
        super(v);
        this.eigunvalue = eigunvalue;
    }

    /**
     * @return the eigunvalue
     */
    public double getEigunvalue() {
        return eigunvalue;
    }

    @Override
    public void print() {
        System.out.println("Corresponding eiugen value: " + eigunvalue);
        System.out.println("EiguenVector: ");
        super.print();
    }

}
