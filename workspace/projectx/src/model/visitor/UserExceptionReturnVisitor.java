
package model.visitor;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleStudyProgramException(model.StudyProgramException studyProgramException) throws PersistenceException;
    
}
