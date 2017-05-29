package model.meta;

public interface FileSystemMssgs {
    void accept(FileSystemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FileSystemDOWNMssgs extends Mssgs, FileSystemMssgs{}
interface FileSystemUPMssgs extends Mssgs, FileSystemMssgs{}
