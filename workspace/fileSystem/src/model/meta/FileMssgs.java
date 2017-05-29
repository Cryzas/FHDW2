package model.meta;

public interface FileMssgs {
    void accept(FileMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FileDOWNMssgs extends ContaineeDOWNMssgs, FileMssgs{}
interface FileUPMssgs extends Mssgs, FileMssgs{}
