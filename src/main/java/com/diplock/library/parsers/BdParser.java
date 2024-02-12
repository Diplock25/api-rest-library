package com.diplock.library.parsers;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dataholders.RoleDh;
import com.diplock.library.dataholders.UserDh;
import com.diplock.library.exceptions.BdNotSaveException;
import java.util.Objects;

public class BdParser {

  public void Evaluator(CategoryDh categoryDh, String action) {
    if (Objects.equals(categoryDh.getName(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is null");
    } else if (categoryDh.getName().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is blank");
    }
  }

  public void Evaluator(LoanDh loanDh, String action) {
    if (Objects.equals(loanDh.getLoanDate(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field LoanDate - name is null");
    } else if (loanDh.getLoanDate().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field LoanDate - name is blank");
    }

    if (Objects.equals(loanDh.getReturnDate(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field ReturnDate - name is null");
    } else if (loanDh.getReturnDate().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field ReturnDate - name is blank");
    }
  }

  public void Evaluator(AuthorDh authorDh, String action) {
    if (Objects.equals(authorDh.getFirstName(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field firstName - firstName is null");
    } else if (authorDh.getFirstName().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field firstName - firstName is blank");
    }

    if (Objects.equals(authorDh.getLastName(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field lastName - lastName is null");
    } else if (authorDh.getLastName().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field lastName - lastName is blank");
    }
  }

  public void Evaluator(BookDh bookDh, String action) {
    if (Objects.equals(bookDh.getTitle(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field title - title is null");
    } else if (bookDh.getTitle().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field title - title is blank");
    }

    if (Objects.equals(bookDh.getIsbn(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field isbn - isbn is null");
    } else if (bookDh.getIsbn().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field isbn - isbn is blank");
    }
  }

  public void Evaluator(PublisherDh publisherDh, String action) {
    if (Objects.equals(publisherDh.getName(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is null");
    } else if (publisherDh.getName().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is blank");
    }
  }

  public void Evaluator(RoleDh roleDh, String action) {
    if (Objects.equals(roleDh.getName(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is null");
    } else if (roleDh.getName().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field name - name is blank");
    }
  }

  public void Evaluator(UserDh userDh, String action) {

    if (Objects.equals(userDh.getEmail(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field email - email is null");
    } else if (userDh.getEmail().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field email - email is blank");
    }

    if (Objects.equals(userDh.getUsername(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field username - username is null");
    } else if (userDh.getUsername().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field username - username is blank");
    }

    if (Objects.equals(userDh.getPassword(), null)) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field password - password is null");
    } else if (userDh.getPassword().isBlank()) {
      throw new BdNotSaveException(action + " - Parameters are incorrect for field password - password is blank");
    }
  }

}
