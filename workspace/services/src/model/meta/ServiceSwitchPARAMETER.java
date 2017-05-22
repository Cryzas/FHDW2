package model.meta;

public interface ServiceSwitchPARAMETER{
    persistence.Administrator4Public handleAdministrator() throws persistence.PersistenceException;
    persistence.Customer4Public handleCustomer() throws persistence.PersistenceException;
    persistence.Register4Public handleRegister() throws persistence.PersistenceException;
    persistence.UserManager4Public handleUserManager() throws persistence.PersistenceException;
}
