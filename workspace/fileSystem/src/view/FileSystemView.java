package view;

import view.objects.*;

import view.visitor.*;

public interface FileSystemView extends Anything, AbstractViewRoot {
    
    public DirectoryView getSystemRoot()throws ModelException;
    public void setSystemRoot(DirectoryView newValue) throws ModelException ;
    public ClipBoardView getClipBoard()throws ModelException;
    public void setClipBoard(ClipBoardView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

