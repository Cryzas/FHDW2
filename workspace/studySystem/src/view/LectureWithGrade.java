package view;

import view.objects.*;

import view.visitor.*;

public interface LectureWithGrade extends AbstractViewRoot {
    
    
    public void accept(LectureWithGradeVisitor visitor) throws ModelException;
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
}

