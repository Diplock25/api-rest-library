package com.diplock.library.mapper;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;
import com.diplock.library.entities.loan.Loan;
import java.util.List;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface LoanMapper {
  Loan asEntity(LoanDh loanDh);
  LoanDTO asDTO(Loan loan);
  List<Loan> asEntityList(List<LoanDh> loanDhList);
  List<LoanDTO> asDTOList(List<Loan> loanList);

}
