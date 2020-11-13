package mock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountServiceTest {

	@Test
	void testTransferOk() {
		MockAccountManager mockAccountManager = new MockAccountManager();
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);
		mockAccountManager.addAccount("1", senderAccount);
		mockAccountManager.addAccount("2", beneficiaryAccount);
		AccountService accountService = new AccountService();
		accountService.setAccountManager(mockAccountManager);
		accountService.transfer("1", "2", 50);

		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());

	}

}
