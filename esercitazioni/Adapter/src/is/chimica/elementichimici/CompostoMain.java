package Adapter.src.is.chimica.elementichimici;

public class CompostoMain {

    public static void main(String[] args) {

        CompostoItAdaptee cia = new CompostoItAdaptee("Acqua", "H2O", 0, 18.015, 100);

        CompostoItTarget composto = new CompostoItAdapter(cia);

        System.out.println(composto.dammiFormulaChimica());
        System.out.println(composto.dammiNomeComposto());
        System.out.println(composto.dammiPesoMolecolare());
        System.out.println(composto.dammiPuntoDiEbollizione());
        System.out.println(composto.dammiPuntoDiFusione());

    }

}
