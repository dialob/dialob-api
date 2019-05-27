package io.dialob.api.form;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {

  @Test
  public void metadataIsRequired() {
    ConstraintViolationException exception = Assertions.assertThrows(ConstraintViolationException.class, () -> ImmutableForm.builder().build());
    assertEquals(1, exception.getConstraintViolations().size());
    ConstraintViolation constraintViolation = exception.getConstraintViolations().iterator().next();

    assertEquals("may not be null", constraintViolation.getMessage());
    assertEquals("metadata", constraintViolation.getPropertyPath().toString());
  }


  @Test
  public void metadataLabelIsRequired() {
    ConstraintViolationException exception = Assertions.assertThrows(ConstraintViolationException.class, () ->
      ImmutableForm.builder().metadata(ImmutableFormMetadata.builder().build()).build());
    assertEquals(1, exception.getConstraintViolations().size());
    ConstraintViolation constraintViolation = exception.getConstraintViolations().iterator().next();

    assertEquals("may not be null", constraintViolation.getMessage());
    assertEquals("metadata.label", constraintViolation.getPropertyPath().toString());
  }

}
