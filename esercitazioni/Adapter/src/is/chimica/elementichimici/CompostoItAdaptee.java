package Adapter.src.is.chimica.elementichimici;

public class CompostoItAdaptee {

    private String name;
    private String formula;
    private double melting;
    private double weight;
    private double bolinig;
    public CompostoItAdaptee(String name, String formula, double melting,
                             double weight, double bolinig) {
        this.name = name;
        this.formula = formula;
        this.melting = melting;
        this.weight = weight;
        this.bolinig = bolinig;
    }

    public String get(Type t) {
        switch (t) {
            case Melting:
                return Double.toString(melting);
            case Formula:
                return formula;
            case Name:
                return name;
            case Weight:
                return Double.toString(weight);
            default:
                return Double.toString(bolinig);
        }
    }

    public enum Type {
        Melting, Boiling, Weight, Formula, Name
    }

}
