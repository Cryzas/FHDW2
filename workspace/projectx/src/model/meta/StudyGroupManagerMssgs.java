package model.meta;

public interface StudyGroupManagerMssgs {
    void accept(StudyGroupManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyGroupManagerDOWNMssgs extends Mssgs, StudyGroupManagerMssgs{}
interface StudyGroupManagerUPMssgs extends Mssgs, StudyGroupManagerMssgs{}
