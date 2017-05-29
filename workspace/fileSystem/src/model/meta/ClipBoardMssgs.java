package model.meta;

public interface ClipBoardMssgs {
    void accept(ClipBoardMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ClipBoardDOWNMssgs extends Mssgs, ClipBoardMssgs{}
interface ClipBoardUPMssgs extends Mssgs, ClipBoardMssgs{}
