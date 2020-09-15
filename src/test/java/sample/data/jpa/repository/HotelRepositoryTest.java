package sample.data.jpa.repository;


import java.nio.file.Path;
import java.util.List;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import sample.data.jpa.domain.Hotel;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findsFirstPageOfCities() {

        Page<Hotel> hotelProjectionPage = repository.findAllHotels(PageRequest.of(0, 10));
        assertNotNull(hotelProjectionPage);


        log.info("-- executing query --");

//        Query query = entityManager.createQuery("SELECT DISTINCT h FROM Hotel h LEFT JOIN FETCH h.reviews r");
//        List<Hotel> resultList = query.getResultList();
//        for (Hotel hotel : resultList) {
//            log.info(hotel.getName() + " - " + hotel.getReviews());
//        }
//        entityManager.close();


//        EntityGraph<Hotel> entityGraph = entityManager.createEntityGraph(Hotel.class);
//        entityGraph.addAttributeNodes("id");
//        entityGraph.addAttributeNodes("name");
//        entityGraph.addSubgraph("city")
//                .addAttributeNodes("id");
//
////        List<Hotel> resultList = query.getResultList();
//        for (Hotel hotel : resultList) {
//            log.info(hotel.getName() + " - " + hotel.getReviews());
//        }
//        entityManager.close();

//        EntityGraph entityGraph = entityManager.getEntityGraph(HOTEL_NAME_GRAPH);
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("javax.persistence.fetchgraph", entityGraph);
//        Hotel post = entityManager.find(Hotel.class, id, properties);


    }
}
