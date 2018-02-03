package services;

import models.Notes;
import utils.CustomException;

public interface AtmService {
    public Notes withdraw(Long cash) throws CustomException;
}