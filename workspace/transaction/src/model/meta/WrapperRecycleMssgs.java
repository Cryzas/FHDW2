package model.meta;

public interface WrapperRecycleMssgs {
    void accept(WrapperRecycleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface WrapperRecycleDOWNMssgs extends Mssgs, WrapperRecycleMssgs{}
interface WrapperRecycleUPMssgs extends Mssgs, WrapperRecycleMssgs{}
