package model.meta;

public interface ContaineeMssgs {
    void accept(ContaineeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ContaineeDOWNMssgs extends Mssgs, ContaineeMssgs{}
interface ContaineeUPMssgs extends FileUPMssgs, DirectoryUPMssgs, ContaineeMssgs{}
