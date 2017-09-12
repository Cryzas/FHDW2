package model.meta;

public interface DozentenServiceMssgs {
    void accept(DozentenServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DozentenServiceDOWNMssgs extends ServiceDOWNMssgs, DozentenServiceMssgs{}
interface DozentenServiceUPMssgs extends Mssgs, DozentenServiceMssgs{}
