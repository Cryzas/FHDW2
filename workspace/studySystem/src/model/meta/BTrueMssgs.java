package model.meta;

public interface BTrueMssgs {
    void accept(BTrueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BTrueDOWNMssgs extends MyBooleanDOWNMssgs, BTrueMssgs{}
interface BTrueUPMssgs extends Mssgs, BTrueMssgs{}
