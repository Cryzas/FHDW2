package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitStudentProxi extends ViewProxi implements UnitStudentView{
    
    public UnitStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public UnitStudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi grade = null;
        String grade$String = (String)resultTable.get("grade");
        if (grade$String != null) {
            common.ProxiInformation grade$Info = common.RPCConstantsAndServices.createProxiInformation(grade$String);
            grade = view.objects.ViewProxi.createProxi(grade$Info,connectionKey);
            grade.setToString(grade$Info.getToString());
        }
        common.Fraction CPmulGrade = common.Fraction.parse((String)resultTable.get("CPmulGrade"));
        common.Fraction CPwithGrade = common.Fraction.parse((String)resultTable.get("CPwithGrade"));
        java.util.Vector<String> changes_string = (java.util.Vector<String>)resultTable.get("changes");
        java.util.Vector<GradeChangeView> changes = ViewProxi.getProxiVector(changes_string, connectionKey);
        UnitStudentView result$$ = new UnitStudent((String)name,(common.Fraction)creditPoints,(GradesInThirdView)grade,(common.Fraction)CPmulGrade,(common.Fraction)CPwithGrade,changes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getChanges().size()) return new ChangesUnitStudentWrapper(this, originalIndex, (ViewRoot)this.getChanges().get(index));
        index = index - this.getChanges().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getChanges().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getChanges().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getChangesIterator = this.getChanges().iterator();
        while(getChangesIterator.hasNext()){
            if(getChangesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getName();
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getCreditPoints();
    }
    public GradesInThirdView getGrade()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getGrade();
    }
    public void setGrade(GradesInThirdView newValue) throws ModelException {
        ((UnitStudent)this.getTheObject()).setGrade(newValue);
    }
    public common.Fraction getCPmulGrade()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getCPmulGrade();
    }
    public common.Fraction getCPwithGrade()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getCPwithGrade();
    }
    public java.util.Vector<GradeChangeView> getChanges()throws ModelException{
        return ((UnitStudent)this.getTheObject()).getChanges();
    }
    public void setChanges(java.util.Vector<GradeChangeView> newValue) throws ModelException {
        ((UnitStudent)this.getTheObject()).setChanges(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws ModelException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitStudent(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
