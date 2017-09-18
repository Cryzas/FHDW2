package model.meta;

public interface StudyGroupManagerMssgsVisitor extends StudyGroupManagerDOWNMssgsVisitor, StudyGroupManagerUPMssgsVisitor {}


interface StudyGroupManagerDOWNMssgsVisitor  {

    public void handleStudyGroupManagerAddStudentToGroupStudyGroupStudentMssg(StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg event) throws persistence.PersistenceException;
    public void handleStudyGroupManagerCreateStudentStudyGroupStringStringDateMssg(StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg event) throws persistence.PersistenceException;
    
}


interface StudyGroupManagerUPMssgsVisitor  {

    public void handleStudyGroupManagerAddStudentToGroupStudyGroupStudentMssg(StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg event) throws persistence.PersistenceException;
    public void handleStudyGroupManagerCreateStudentStudyGroupStringStringDateMssg(StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg event) throws persistence.PersistenceException;
    
}
