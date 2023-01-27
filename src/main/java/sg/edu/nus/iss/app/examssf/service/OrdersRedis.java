package sg.edu.nus.iss.app.examssf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.examssf.model.Order;

@Qualifier("orderRedis")
@Service
public class OrdersRedis {
    private static final String ORDER_ENTITY = "orderlist";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // public void save(final Order ord){
    //     redisTemplate.opsForList()
    //         .leftPush(ORDER_ENTITY, ord.getId());
    //     redisTemplate.opsForHash()
    //         .put( ORDER_ENTITY+ "_Map", ord.getId(), ord);
    // }

    // public Order findById(final String orderId){
    //     Order result= (Order)redisTemplate.opsForHash()
    //             .get(ORDER_ENTITY+ "_Map", 
    //             orderId);
    //     return result;
    // }

    // public List<Order> findAll(int startIndex){
    //     List<Object> fromContactList = redisTemplate.opsForList()
    //         .range(ORDER_ENTITY, startIndex, 10);
    //     List<Order> ords = redisTemplate.opsForHash()
    //         .multiGet(ORDER_ENTITY+ "_Map", fromContactList)
    //         .stream()
    //         .filter(Contact.class::isInstance)
    //         .map(Contact.class::cast)
    //         .toList();
        
    //     return ords;
    // }
    
}