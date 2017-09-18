package model;

import model.visitor.TransferStateReturnVisitor;
import persistence.Account4Public;
import persistence.AccountWrppr4Public;
import persistence.AccountWrpprAccount4Public;
import persistence.Anything;
import persistence.Booked4Public;
import persistence.NotBooked4Public;
import persistence.PersistenceException;
import persistence.Transfer4Public;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        result = transfer.getState().accept(new TransferStateReturnVisitor<Integer>() {
			@Override
			public Integer handleBooked(Booked4Public booked) throws PersistenceException {
				return common.IconConstants.BookedStateIconNumber;
			}
			@Override
			public Integer handleNotBooked(NotBooked4Public notBooked) throws PersistenceException {
				return common.IconConstants.NotBookedStateIconNumber;
			}
		});
    }
    public void handleAccount(Account4Public account) throws PersistenceException{
        result = common.IconConstants.AccountIconNumber;
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrpprAccount) throws PersistenceException{
        result = common.IconConstants.AccountWrapperIconNumber;
    }

}
