package model.meta;

public interface QuantifiedComponentMssgs {
    void accept(QuantifiedComponentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface QuantifiedComponentDOWNMssgs extends Mssgs, QuantifiedComponentMssgs{}
interface QuantifiedComponentUPMssgs extends Mssgs, QuantifiedComponentMssgs{}
