package persistence;



import model.visitor.*;

public class AdminServiceServicesProxi extends PersistentProxi implements PersistentAdminServiceServices{
    
    public AdminServiceServicesProxi(long objectId) {
        super(objectId);
    }
    public AdminServiceServicesProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 298;
    }
    
    public AdminService4Public getObserver() throws PersistenceException {
        return ((PersistentAdminServiceServices)this.getTheObject()).getObserver();
    }
    public void setObserver(AdminService4Public newValue) throws PersistenceException {
        ((PersistentAdminServiceServices)this.getTheObject()).setObserver(newValue);
    }
    public AdminServiceServices_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAdminServiceServices)this.getTheObject()).getObservee();
    }
    public PersistentAdminServiceServices getThis() throws PersistenceException {
        return ((PersistentAdminServiceServices)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdminServiceServices(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServiceServices(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServiceServices(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServiceServices(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdminServiceServices(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServiceServices(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServiceServices(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServiceServices(this);
    }
    
    
    public void add(final subAdminService4Public observee) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<subAdminService4Public,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<subAdminService4Public,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<subAdminService4Public,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<subAdminService4Public> procdure) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<subAdminService4Public> findAllException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<subAdminService4Public> findAll(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).findAll(predcate);
    }
    public <E extends model.UserException> subAdminService4Public findFirstException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).findFirstException(predcate);
    }
    public subAdminService4Public findFirst(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).findFirst(predcate);
    }
    public long getLength() 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).getLength();
    }
    public subAdminServiceSearchList getList() 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).getList();
    }
    public java.util.Iterator<subAdminService4Public> iterator() 
				throws PersistenceException{
        return ((PersistentAdminServiceServices)this.getTheObject()).iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAdminServiceServices)this.getTheObject()).update(event);
    }

    
}
