package ua.nure.freedel.utility;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class DistanceCalculatorServiceIntegrationTest {

    private final DistanceCalculatorService distanceCalculatorService;



    @Test
    public void testCalculateDistance() {
        // given
        String originAddress = "94 Shepherds Bush Rd, London W6 7PD";
        String destinationAddress = "204 Kensington High St, London W8 7RG";

        // when
        long distance = distanceCalculatorService.calculateDistance(originAddress, destinationAddress);

        // then
        assertEquals(1000, distance);
    }
}
