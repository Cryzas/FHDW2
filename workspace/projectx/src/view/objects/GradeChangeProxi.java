package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class GradeChangeProxi extends ViewProxi implements GradeChangeView{
    
    public GradeChangeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public GradeChangeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi fromGrade = null;
        String fromGrade$String = (String)resultTable.get("fromGrade");
        if (fromGrade$String != null) {
            common.ProxiInformation fromGrade$Info = common.RPCConstantsAndServices.createProxiInformation(fromGrade$String);
            fromGrade = view.objects.ViewProxi.createProxi(fromGrade$Info,connectionKey);
            fromGrade.setToString(fromGrade$Info.getToString());
        }
        ViewProxi toGrade = null;
        String toGrade$String = (String)resultTable.get("toGrade");
        if (toGrade$String != null) {
            common.ProxiInformation toGrade$Info = common.RPCConstantsAndServices.createProxiInformation(toGrade$String);
            toGrade = view.objects.ViewProxi.createProxi(toGrade$Info,connectionKey);
            toGrade.setToString(toGrade$Info.getToString());
        }
        java.util.Date dateOfChange = (java.util.Date)resultTable.get("dateOfChange");
        String comment = (String)resultTable.get("comment");
        GradeChangeView result$$ = new GradeChange((GradeView)fromGrade,(GradeView)toGrade,(java.util.Date)dateOfChange,(String)comment, this.getId(), this.getClassId());
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
    
    public GradeView getFromGrade()throws ModelException{
        return ((GradeChange)this.getTheObject()).getFromGrade();
    }
    public void setFromGrade(GradeView newValue) throws ModelException {
        ((GradeChange)this.getTheObject()).setFromGrade(newValue);
    }
    public GradeView getToGrade()throws ModelException{
        return ((GradeChange)this.getTheObject()).getToGrade();
    }
    public void setToGrade(GradeView newValue) throws ModelException {
        ((GradeChange)this.getTheObject()).setToGrade(newValue);
    }
    public java.util.Date getDateOfChange()throws ModelException{
        return ((GradeChange)this.getTheObject()).getDateOfChange();
    }
    public void setDateOfChange(java.util.Date newValue) throws ModelException {
        ((GradeChange)this.getTheObject()).setDateOfChange(newValue);
    }
    public String getComment()throws ModelException{
        return ((GradeChange)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws ModelException {
        ((GradeChange)this.getTheObject()).setComment(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleGradeChange(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleGradeChange(this);
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
