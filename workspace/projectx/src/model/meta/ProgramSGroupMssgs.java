package model.meta;

public interface ProgramSGroupMssgs {
    void accept(ProgramSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProgramSGroupDOWNMssgs extends Mssgs, ProgramSGroupMssgs{}
interface ProgramSGroupUPMssgs extends Mssgs, ProgramSGroupMssgs{}
