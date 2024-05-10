package in.bushansirgur.springboot.crudapi.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long id) {
        super("Location with ID " + id + " not found");
    }
}
