package com.bank.app.api.staging.services;

import java.util.List;

import com.bank.app.api.staging.dto.StgAccountDTO;
import com.bank.app.domain.staging.entities.StgAccount;
import com.bank.app.domain.common.error.exceptions.DataIngestionError;
import com.bank.app.domain.common.error.exceptions.DataNotFoundException;

public interface StgAccountService {
	public List<StgAccountDTO> getAccounts();
	public StgAccountDTO getAccountById(Long id) throws DataNotFoundException;
	public StgAccountDTO createAccount(StgAccount stgAccount) throws DataIngestionError;
	public List<StgAccountDTO> createAccounts(List<StgAccount> stgAccounts) throws DataIngestionError;
	
}
