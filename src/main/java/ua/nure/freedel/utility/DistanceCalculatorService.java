package ua.nure.freedel.utility;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorService {

    private final GeoApiContext geoApiContext;

    private final static String apiKey = "AIzaSyDUcgXkEdhMGjFNT-0LWJ4tbsYNjXE7FkQ";

    public DistanceCalculatorService() {
        geoApiContext = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public long calculateDistance(String originAddress, String destinationAddress) {
        try {
            DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(geoApiContext)
                    .origins(originAddress)
                    .destinations(destinationAddress)
                    .await();

            if (distanceMatrix.rows.length > 0 &&
                    distanceMatrix.rows[0].elements.length > 0 &&
                    distanceMatrix.rows[0].elements[0].distance != null) {
                return distanceMatrix.rows[0].elements[0].distance.inMeters;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


}
