package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO;
import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.JourneyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, JourneyId> {
    @Query("select new cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO(j.id.originName,j.id.destinationName) FROM Journey j")
    List<JourneyDTO> findAllDTO();

    Optional<Journey> findByOriginNameAndDestinationName(String origin, String destination);
}
