package view;

import view.objects.*;

import view.visitor.*;

public interface StudyGroupManagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<StudyGroupView> getGroups()throws ModelException;
    public void setGroups(java.util.Vector<StudyGroupView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

