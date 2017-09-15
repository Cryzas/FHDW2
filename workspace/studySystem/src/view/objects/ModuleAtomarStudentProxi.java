package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleAtomarStudentProxi extends ModuleAbstractStudentProxi implements ModuleAtomarStudentView{
    
    public ModuleAtomarStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleAtomarStudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi moduleCopy = null;
        String moduleCopy$String = (String)resultTable.get("moduleCopy");
        if (moduleCopy$String != null) {
            common.ProxiInformation moduleCopy$Info = common.RPCConstantsAndServices.createProxiInformation(moduleCopy$String);
            moduleCopy = view.objects.ViewProxi.createProxi(moduleCopy$Info,connectionKey);
            moduleCopy.setToString(moduleCopy$Info.getToString());
        }
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
        common.Fraction passedCP = common.Fraction.parse((String)resultTable.get("passedCP"));
        ViewProxi finished = null;
        String finished$String = (String)resultTable.get("finished");
        if (finished$String != null) {
            common.ProxiInformation finished$Info = common.RPCConstantsAndServices.createProxiInformation(finished$String);
            finished = view.objects.ViewProxi.createProxi(finished$Info,connectionKey);
            finished.setToString(finished$Info.getToString());
        }
        ViewProxi ownGrade = null;
        String ownGrade$String = (String)resultTable.get("ownGrade");
        if (ownGrade$String != null) {
            common.ProxiInformation ownGrade$Info = common.RPCConstantsAndServices.createProxiInformation(ownGrade$String);
            ownGrade = view.objects.ViewProxi.createProxi(ownGrade$Info,connectionKey);
            ownGrade.setToString(ownGrade$Info.getToString());
        }
        java.util.Vector<String> changes_string = (java.util.Vector<String>)resultTable.get("changes");
        java.util.Vector<GradeChangeView> changes = ViewProxi.getProxiVector(changes_string, connectionKey);
        ModuleAtomarStudentView result$$ = new ModuleAtomarStudent((ModuleAbstractSGroupView)moduleCopy,(String)name,(common.Fraction)creditPoints,(GradeView)grade,(common.Fraction)CPmulGrade,(common.Fraction)CPwithGrade,(common.Fraction)passedCP,(MyBooleanView)finished,(GradesInSimpleOrThirdView)ownGrade,changes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getChanges().size()) return new ChangesModuleAtomarStudentWrapper(this, originalIndex, (ViewRoot)this.getChanges().get(index));
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
    
    public GradesInSimpleOrThirdView getOwnGrade()throws ModelException{
        return ((ModuleAtomarStudent)this.getTheObject()).getOwnGrade();
    }
    public void setOwnGrade(GradesInSimpleOrThirdView newValue) throws ModelException {
        ((ModuleAtomarStudent)this.getTheObject()).setOwnGrade(newValue);
    }
    public java.util.Vector<GradeChangeView> getChanges()throws ModelException{
        return ((ModuleAtomarStudent)this.getTheObject()).getChanges();
    }
    public void setChanges(java.util.Vector<GradeChangeView> newValue) throws ModelException {
        ((ModuleAtomarStudent)this.getTheObject()).setChanges(newValue);
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
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
