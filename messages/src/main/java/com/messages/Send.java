package com.messages;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;


public class Send {
    public static void main( String[] args ) {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
        
        String queueUrl = "https://sqs.us-east-1.amazonaws.com/129395643683/OrdersEdvan";
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        messageAttributes.put("Name", new MessageAttributeValue()
        	.withStringValue("Edvan")
        	.withDataType("String"));
        
        SendMessageRequest send_msg_request = new SendMessageRequest()
        	.withQueueUrl(queueUrl)
        	.withMessageBody("hello world 10")
        	.withMessageAttributes(messageAttributes)
//        	withDelaySeconds(5)
        	;
        SendMessageResult result = sqs.sendMessage(send_msg_request);
        System.out.println(result.getMessageId());
    }
}
