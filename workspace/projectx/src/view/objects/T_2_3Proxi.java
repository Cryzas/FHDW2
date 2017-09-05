package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class T_2_3Proxi extends GradesInThirdProxi implements T_2_3View{
    
    public T_2_3Proxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public T_2_3View getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        T_2_3View result$$ = new T_2_3( this.getId(), this.getClassId());
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
        visitor.handleT_2_3(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleT_2_3(this);
    }
    public <E extends view.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleT_2_3(this);
    }
    public <R, E extends view.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleT_2_3(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleT_2_3(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleT_2_3(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleT_2_3(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleT_2_3(this);
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
