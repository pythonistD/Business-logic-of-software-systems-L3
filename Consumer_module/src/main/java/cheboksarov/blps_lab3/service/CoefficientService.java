package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.model.Coefficient;

public interface CoefficientService {
    Coefficient findById(Long coeff_id);
    Coefficient saveCoefficient(Coefficient coefficient);

    Coefficient createDefaultCoefficient();

    Coefficient updateCoefficient(Coefficient coefficient);

    void deleteCoefficient(Long coeffId);
}
