package com.diplock.library.mapper;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDto;
import com.diplock.library.entities.Loan;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface LoanMapper {

  Loan asEntity(LoanDh loanDh);

  LoanDto asDTO(Loan loan);

  List<Loan> asEntityList(List<LoanDh> loanDhList);

  List<LoanDto> asDTOList(List<Loan> loanList);

}
