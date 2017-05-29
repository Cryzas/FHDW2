package model.meta;

public interface DirectoryMssgs {
    void accept(DirectoryMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DirectoryDOWNMssgs extends ContaineeDOWNMssgs, DirectoryMssgs{}
interface DirectoryUPMssgs extends Mssgs, DirectoryMssgs{}
