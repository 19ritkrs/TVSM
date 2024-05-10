package in.bushansirgur.springboot.crudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bushansirgur.springboot.crudapi.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
