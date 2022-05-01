# fila-aws-sqs
Serviço de mensagens em fila usando a Amazon SQS.

Depois de:
-criar uma conta na AWS,
-criar um usuário do IAM,
-instalar Java e Apache Maven,
-e configurar as credenciais (ACCESS_KEY e SECRET_KEY) no SO local,

Criar um projeto Maven com o seguinte comando no terminal:
```
mvn -B archetype:generate \
 -DarchetypeGroupId=org.apache.maven.archetypes \
 -DgroupId=com.example.myapp \
 -DartifactId=myapp
 ```
 
 Depois, colocar a dependência AWS SDK For Java no pom.xml:
 
 ```
<dependency>
    	<groupId>com.amazonaws</groupId>
    	<artifactId>aws-java-sdk</artifactId>
    	<version>1.12.209</version>
</dependency>
```
