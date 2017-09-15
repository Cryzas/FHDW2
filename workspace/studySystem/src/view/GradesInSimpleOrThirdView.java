package view;

import view.visitor.*;

public interface GradesInSimpleOrThirdView extends GradeView {
    
    
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException;
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

