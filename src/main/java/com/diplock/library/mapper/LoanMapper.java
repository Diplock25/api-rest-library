package com.diplock.library.mapper;

import com.diplock.library.dtos.LoanDTO;
import com.diplock.library.entities.Loan;
import java.util.List;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface LoanMapper {
  LoanDTO toDTO(Loan loan);
  List<LoanDTO> toDTOList(List<Loan> loanList);
  Loan toEntity(LoanDTO loanDTO);

}
