package Adapter.src.is.chimica.elementichimici;

public interface CompostoEngInterfaceTarget {

    String getInfo(Type t);

    enum Type {Melting, Boiling, Weight, Formula, Name}

}
