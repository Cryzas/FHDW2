package model.meta;

public interface FolderMssgs {
    void accept(FolderMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FolderDOWNMssgs extends Mssgs, FolderMssgs{}
interface FolderUPMssgs extends Mssgs, FolderMssgs{}
