package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.crudapi.dao.LocationRepository;
import in.bushansirgur.springboot.crudapi.exception.LocationNotFoundException;
import in.bushansirgur.springboot.crudapi.model.Location;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) throws LocationNotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    // Add methods for creating, updating, and deleting locations (omitted for brevity)
}
