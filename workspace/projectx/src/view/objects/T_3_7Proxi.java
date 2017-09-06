package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class T_3_7Proxi extends GradesInThirdProxi implements T_3_7View{
    
    public T_3_7Proxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public T_3_7View getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        T_3_7View result$$ = new T_3_7( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(GradesInThirdVisitor visitor) throws ModelException {
        visitor.handleT_3_7(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleT_3_7(this);
    }
    public <E extends view.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleT_3_7(this);
    }
    public <R, E extends view.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleT_3_7(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException {
        visitor.handleT_3_7(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleT_3_7(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleT_3_7(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleT_3_7(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleT_3_7(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleT_3_7(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleT_3_7(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleT_3_7(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
