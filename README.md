# fila-aws-sqs
Serviço de mensagens em fila usando a Amazon SQS.

Depois de: <br>
- criar uma conta na AWS,<br>
- criar um usuário do IAM,<br>
- instalar Java e Apache Maven,<br>
- e configurar as credenciais (ACCESS_KEY e SECRET_KEY) no SO local,<br>

Criar um projeto Maven com o seguinte comando no terminal:
```
mvn -B archetype:generate \
 -DarchetypeGroupId=org.apache.maven.archetypes \
 -DgroupId=com.example.myapp \
 -DartifactId=myapp
 ```
 
 E colocar a dependência AWS SDK For Java no pom.xml:
 
 ```
<dependency>
    	<groupId>com.amazonaws</groupId>
    	<artifactId>aws-java-sdk</artifactId>
    	<version>1.12.209</version>
</dependency>
```
