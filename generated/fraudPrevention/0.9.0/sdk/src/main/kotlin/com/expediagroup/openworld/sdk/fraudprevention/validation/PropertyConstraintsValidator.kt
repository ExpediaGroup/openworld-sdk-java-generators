package com.expediagroup.openworld.sdk.fraudprevention.validation

import com.expediagroup.openworld.sdk.fraudprevention.models.exception.PropertyConstraintViolation
import com.expediagroup.openworld.sdk.fraudprevention.models.exception.PropertyConstraintViolationException
import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import java.util.stream.Collectors

internal object PropertyConstraintsValidator {
    fun validateConstraints(obj: Any) {
        Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(ParameterMessageInterpolator())
            .buildValidatorFactory().use { factory ->
                val violations = factory.validator.validate(obj)
                if (violations.isNotEmpty()) {
                    throw PropertyConstraintViolationException(
                        "Some field constraints have been violated",
                        violations.stream().map { toConstraintViolation(it) }.collect(Collectors.toList())
                    )
                }
            }
    }

    private fun toConstraintViolation(violation: ConstraintViolation<*>): PropertyConstraintViolation {
        return PropertyConstraintViolation(
            violation.propertyPath.iterator().next().name,
            violation.propertyPath.toString(),
            violation.message
        )
    }
}