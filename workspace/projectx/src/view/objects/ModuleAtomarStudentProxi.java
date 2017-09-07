package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleAtomarStudentProxi extends ModuleAbstractStudentProxi implements ModuleAtomarStudentView{
    
    public ModuleAtomarStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
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
        ViewProxi ownGrade = null;
        String ownGrade$String = (String)resultTable.get("ownGrade");
        if (ownGrade$String != null) {
            common.ProxiInformation ownGrade$Info = common.RPCConstantsAndServices.createProxiInformation(ownGrade$String);
            ownGrade = view.objects.ViewProxi.createProxi(ownGrade$Info,connectionKey);
            ownGrade.setToString(ownGrade$Info.getToString());
        }
        ModuleAtomarStudentView result$$ = new ModuleAtomarStudent((ModuleAbstractSGroupView)moduleCopy,(String)name,(common.Fraction)creditPoints,(GradeView)grade,(common.Fraction)CPmulGrade,(common.Fraction)CPwithGrade,(GradesInSimpleOrThirdView)ownGrade, this.getId(), this.getClassId());
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
    
    public GradesInSimpleOrThirdView getOwnGrade()throws ModelException{
        return ((ModuleAtomarStudent)this.getTheObject()).getOwnGrade();
    }
    public void setOwnGrade(GradesInSimpleOrThirdView newValue) throws ModelException {
        ((ModuleAtomarStudent)this.getTheObject()).setOwnGrade(newValue);
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
