package model.meta;

public interface StudyGroupServiceMssgs {
    void accept(StudyGroupServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyGroupServiceDOWNMssgs extends subAdminServiceDOWNMssgs, StudyGroupServiceMssgs{}
interface StudyGroupServiceUPMssgs extends Mssgs, StudyGroupServiceMssgs{}
