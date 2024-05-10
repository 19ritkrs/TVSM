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
    
    
    public Location createLocation(Location location) throws IllegalArgumentException {
        // Validate location data (optional)
        if (location.getName() == null || location.getLatitude() < -90 || location.getLatitude() > 90 
                || location.getLongitude() < -180 || location.getLongitude() > 180) {
            throw new IllegalArgumentException("Invalid location data");
        }
        
        return locationRepository.save(location);
    }
    
    

    // Add methods for creating, updating, and deleting locations (omitted for brevity)
}