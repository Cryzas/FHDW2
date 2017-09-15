package model.meta;

public interface MyBooleanMssgs {
    void accept(MyBooleanMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MyBooleanDOWNMssgs extends Mssgs, MyBooleanMssgs{}
interface MyBooleanUPMssgs extends BFalseUPMssgs, BTrueUPMssgs, MyBooleanMssgs{}
