package persistence;

import model.visitor.*;

/* Additional import section end */

public interface LectureWithGrade extends AbstractPersistentProxi {
    
    
    public void changeGrade(final Grade4Public grade) 
				throws model.InvalidGradeForSystemException, PersistenceException;

    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException;
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

