package services;

import models.Notes;

public interface AtmService {
    public Notes withdraw(Long cash);
}