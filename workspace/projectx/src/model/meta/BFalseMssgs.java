package model.meta;

public interface BFalseMssgs {
    void accept(BFalseMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BFalseDOWNMssgs extends MyBooleanDOWNMssgs, BFalseMssgs{}
interface BFalseUPMssgs extends Mssgs, BFalseMssgs{}
