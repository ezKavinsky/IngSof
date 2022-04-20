package Adapter.src.is.chimica.elementichimici;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BancaCompostiChimiciEngAdaptee {

    private static Set<String> composti = new HashSet<String>();
    private static Map<String, Double> temperaturaDiFusione = new HashMap<String, Double>();
    private static Map<String, Double> temperaturaDiEbollizione = new HashMap<String, Double>();
    private static Map<String, Double> pesoMolecolare = new HashMap<String, Double>();
    private static Map<String, String> formulaChimica = new HashMap<String, String>();


    static {

        composti.add("ACQUA");
        composti.add("BENZENE");
        composti.add("ETANOLO");

        temperaturaDiFusione.put("ACQUA", 0.0);
        temperaturaDiFusione.put("BENZENE", 5.5);
        temperaturaDiFusione.put("ETANOLO", -114.1);

        temperaturaDiEbollizione.put("ACQUA", 100.0);
        temperaturaDiEbollizione.put("BENZENE", 80.1);
        temperaturaDiEbollizione.put("ETANOLO", 78.3);

        pesoMolecolare.put("ACQUA", 18.015);
        pesoMolecolare.put("BENZENE", 78.1134);
        pesoMolecolare.put("ETANOLO", 46.0688);

        formulaChimica.put("ACQUA", "H20");
        formulaChimica.put("BENZENE", "C6H6");
        formulaChimica.put("ETANOLO", "C2H5OH");
    }

    public static boolean compostoNoto(String composto) {
        return composti.contains(composto.toUpperCase());
    }

    public static String dammiFormulaChimica(String composto) throws ElementoSconosciutoException {
        if (!formulaChimica.containsKey(composto.toUpperCase()))
            throw new ElementoSconosciutoException();
        return formulaChimica.get(composto.toUpperCase());
    }

    public static double dammiPesoMolecolare(String composto) throws ElementoSconosciutoException {
        if (!pesoMolecolare.containsKey(composto.toUpperCase()))
            throw new ElementoSconosciutoException();
        return pesoMolecolare.get(composto.toUpperCase());
    }

    public static double dammiTemperaturaDiEbollizione(String composto) throws ElementoSconosciutoException {
        if (!temperaturaDiEbollizione.containsKey(composto.toUpperCase()))
            throw new ElementoSconosciutoException();
        return temperaturaDiEbollizione.get(composto.toUpperCase());
    }

    public static double dammiTemperaturaDiFusione(String composto) throws ElementoSconosciutoException {
        if (!temperaturaDiFusione.containsKey(composto.toUpperCase()))
            throw new ElementoSconosciutoException();
        return temperaturaDiFusione.get(composto.toUpperCase());
    }
}
