package com.messages;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Delete {

	public static void main(String[] args) {
//		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
//			.withRegion(Regions.US_EAST_1)
//			.build();
		
//		String queueUrl = "https://sqs.us-east-1.amazonaws.com/129395643683/OrdersEdvan";
//		List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
//		for (Message m : messages) {
//			sqs.deleteMessage(queueUrl, m.getReceiptHandle());
//		}
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				.build();
		
		String queueUrl = "https://sqs.us-east-1.amazonaws.com/129395643683/OrdersEdvan";
		ReceiveMessageRequest receive_request = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl).withVisibilityTimeout(20)
				.withMaxNumberOfMessages(10);
		
		List<Message> messages = sqs.receiveMessage(receive_request).getMessages();
		
		for (Message m : messages) {
			DeleteMessageResult result = sqs.deleteMessage(queueUrl, m.getReceiptHandle());
			System.out.println(result.getSdkResponseMetadata());
		}
		
		
	}

}
