package Adapter.src.is.chimica.elementichimici;

public class CompostoEngAdapter implements CompostoEngInterfaceTarget {


    /**
     * @associatesType composition
     * @directed true
     * @link composition
     */

    private final String nome;

    public CompostoEngAdapter(String composto) throws Exception {
        if (!BancaCompostiChimiciEngAdaptee.compostoNoto(composto))
            throw new Exception("Composto non noto");
        this.nome = composto;
    }


    public String getInfo(Type t) {
        switch (t) {
            case Melting:
                return Double.toString(BancaCompostiChimiciEngAdaptee.dammiTemperaturaDiFusione(nome));
            case Formula:
                return BancaCompostiChimiciEngAdaptee.dammiFormulaChimica(nome);
            case Name:
                return nome;
            case Weight:
                return Double.toString(BancaCompostiChimiciEngAdaptee.dammiPesoMolecolare(nome));
            default:
                return Double.toString(BancaCompostiChimiciEngAdaptee.dammiTemperaturaDiEbollizione(nome));
        }
    }

}
