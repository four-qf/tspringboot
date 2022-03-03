package com.qiux.tspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//send message synchronously
//		rocketMQTemplate.convertAndSend("laoliutest", "Hello, World!");
//		//send spring message
//		rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
////		//send messgae asynchronously
//		rocketMQTemplate.asyncSend("test-topic-2", new OrderPaidEvent("OEDER_001", new BigDecimal("98.00")), new SendCallback() {
//			@Override
//			public void onSuccess(SendResult var1) {
//				System.out.printf("async onSucess SendResult=%s %n", var1);
//			}
//
//			@Override
//			public void onException(Throwable var1) {
//				System.out.printf("async onException Throwable=%s %n", var1);
//			}
//
//		});
//		//Send messages orderly
//		rocketMQTemplate.syncSendOrderly("orderly_topic",MessageBuilder.withPayload("Hello, World").build(),"hashkey");

		//rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
//	}

//	@Data
//	@AllArgsConstructor
//	public class OrderPaidEvent implements Serializable {
//		private String orderId;
//
//		private BigDecimal paidMoney;
//	}
}
