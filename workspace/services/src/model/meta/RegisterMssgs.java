package model.meta;

public interface RegisterMssgs {
    void accept(RegisterMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface RegisterDOWNMssgs extends ServiceDOWNMssgs, RegisterMssgs{}
interface RegisterUPMssgs extends Mssgs, RegisterMssgs{}
