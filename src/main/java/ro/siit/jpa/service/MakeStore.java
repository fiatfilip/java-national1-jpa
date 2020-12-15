package ro.siit.jpa.service;

import ro.siit.jpa.entity.Make;

import java.util.List;
import java.util.UUID;

public interface MakeStore {
    Make getMake(UUID makeId);
    void addMake(Make make);
    void updateMake(UUID makeId, Make updatedMake);
    void deleteMake(UUID makeId);
    List<Make> getMakes();
}
