package Adapter.src.is.chimica.elementichimici;

public class CompostoItAdapter implements CompostoItTarget {


    /**
     * @associatesType composition
     * @directed true
     * @link composition
     */

    private CompostoItAdaptee composto;

    public CompostoItAdapter(CompostoItAdaptee composto) {
        this.composto = composto;
    }

    public double dammiPesoMolecolare() {
        return Double.parseDouble(composto.get(CompostoItAdaptee.Type.Weight));
    }

    public double dammiPuntoDiFusione() {
        return Double.parseDouble(composto.get(CompostoItAdaptee.Type.Melting));
    }

    public double dammiPuntoDiEbollizione() {
        return Double.parseDouble(composto.get(CompostoItAdaptee.Type.Boiling));
    }

    public String dammiFormulaChimica() {
        return composto.get(CompostoItAdaptee.Type.Formula);
    }

    public String dammiNomeComposto() {
        return composto.get(CompostoItAdaptee.Type.Name);
    }

}
