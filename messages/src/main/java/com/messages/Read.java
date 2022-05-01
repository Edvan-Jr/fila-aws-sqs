package com.messages;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Read {

	public static void main(String[] args) {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		
		String queueUrl = "https://sqs.us-east-1.amazonaws.com/129395643683/OrdersEdvan";
		ReceiveMessageRequest receive_request = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl)
				.withWaitTimeSeconds(20)
				.withVisibilityTimeout(20)
				.withMaxNumberOfMessages(10);
		
		List<Message> messages = sqs.receiveMessage(receive_request).getMessages();
		
		for (Message m : messages) {
			System.out.println(m.toString());
			sqs.deleteMessage(queueUrl, m.getReceiptHandle());
		}
	}

}
