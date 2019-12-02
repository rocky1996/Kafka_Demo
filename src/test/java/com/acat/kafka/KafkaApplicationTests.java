package com.acat.kafka;

import com.acat.kafka.consumer.UserLogConsumer;
import com.acat.kafka.product.UserLogProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class KafkaApplicationTests {

	@Autowired
	private UserLogProducer userLogProducer;

	@Autowired
	private UserLogConsumer userLogConsumer;

	@Test
	public void contextLoads() {
		for(int i=0;i<3;i++){
			userLogProducer.send();

			try{
				Thread.sleep(3000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
