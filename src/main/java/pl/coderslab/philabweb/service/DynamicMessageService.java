package pl.coderslab.philabweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.philabweb.entities.DynamicMessage;
import pl.coderslab.philabweb.repositories.DynamicMessageRepository;

@Service
public class DynamicMessageService {
    @Autowired
    DynamicMessageRepository dynamicMessageRepository;
    public DynamicMessage findOneByName(String name){
        return dynamicMessageRepository.findOneByName(name);
    };

}
