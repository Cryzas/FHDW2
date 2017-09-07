package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProgramStudentProxi extends ViewProxi implements ProgramStudentView{
    
    public ProgramStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ProgramStudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> modules_string = (java.util.Vector<String>)resultTable.get("modules");
        java.util.Vector<ModuleAbstractStudentView> modules = ViewProxi.getProxiVector(modules_string, connectionKey);
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi programCopy = null;
        String programCopy$String = (String)resultTable.get("programCopy");
        if (programCopy$String != null) {
            common.ProxiInformation programCopy$Info = common.RPCConstantsAndServices.createProxiInformation(programCopy$String);
            programCopy = view.objects.ViewProxi.createProxi(programCopy$Info,connectionKey);
            programCopy.setToString(programCopy$Info.getToString());
        }
        ViewProxi grade = null;
        String grade$String = (String)resultTable.get("grade");
        if (grade$String != null) {
            common.ProxiInformation grade$Info = common.RPCConstantsAndServices.createProxiInformation(grade$String);
            grade = view.objects.ViewProxi.createProxi(grade$Info,connectionKey);
            grade.setToString(grade$Info.getToString());
        }
        ProgramStudentView result$$ = new ProgramStudent(modules,(String)name,(common.Fraction)creditPoints,(ProgramSGroupView)programCopy,(GradeView)grade, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesProgramStudentWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
        index = index - this.getModules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModules().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModulesIterator = this.getModules().iterator();
        while(getModulesIterator.hasNext()){
            if(getModulesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleAbstractStudentView> getModules()throws ModelException{
        return ((ProgramStudent)this.getTheObject()).getModules();
    }
    public void setModules(java.util.Vector<ModuleAbstractStudentView> newValue) throws ModelException {
        ((ProgramStudent)this.getTheObject()).setModules(newValue);
    }
    public String getName()throws ModelException{
        return ((ProgramStudent)this.getTheObject()).getName();
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((ProgramStudent)this.getTheObject()).getCreditPoints();
    }
    public ProgramSGroupView getProgramCopy()throws ModelException{
        return ((ProgramStudent)this.getTheObject()).getProgramCopy();
    }
    public void setProgramCopy(ProgramSGroupView newValue) throws ModelException {
        ((ProgramStudent)this.getTheObject()).setProgramCopy(newValue);
    }
    public GradeView getGrade()throws ModelException{
        return ((ProgramStudent)this.getTheObject()).getGrade();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramStudent(this);
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
