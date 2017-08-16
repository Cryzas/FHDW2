package persistence;

import model.visitor.*;

/* Additional import section end */

public interface StudyGroupManagerCommand extends  Command {
    
    

    public void accept(StudyGroupManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(StudyGroupManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(StudyGroupManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(StudyGroupManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

