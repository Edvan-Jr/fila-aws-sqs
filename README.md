# fila-aws-sqs
Serviço de mensagens em fila usando a Amazon SQS.

Respondendo à solicitação do exercício prático da Semana 2 do iLab com a Gama, sobre a diferença entre o Amazon SQS e o Amazon SNS, basicamente, o SNS é um serviço de notificação/mensagem simples, enquanto o SQS é um serviço de enfileiramento de mensagens.
O grande diferencial do SQS é a capacidade de desacoplamento e escalabilidade, eliminando a complexidade e sobrecarga associadas ao gerenciamento de mensagens. As filas podem ser do tipo Padrão, sem obrigatoriedade de ordenação, ou do tipo FIFO, onde a ordenação é garantida. Há também o recurso de DLQ (Dead-letter queue, ou fila de mensagens mortas), uma fila auxiliar para onde são encaminhadas poison messages e mensagens reincidentes e inertes que só sobracarregariam o sistema. Resumindo, enquanto num modelo request-response comum a requisição dependeria da disponibilidade do servidor, onerando tempo e perdas, o SQS, num modelo producer-consumer, pode gerenciar o envio, recebimento e armazenagem de mensagens, encarregando-se do trâmite e liberando a rede.
O SNS, modelo pub-sub, tanto A2A quanto A2P, fornece tópicos para sistemas de alta taxa de transferência de mensagens entre sistemas distribuídos, microsserviços e aplicações sem servidor orientadas por eventos, agrupando lotes de assinantes, cujos integrantes recebem as mensagens para aquele grupo, as quais podem ser em lotes, filtradas, ordenadas, sem duplicação e seguras. O SNS pode trabalhar em conjunto com o SQS, além do Lambda, por HTTPS, entre outros.

Neste repositório estão três exemplos de aplicações Java SDK nos serviços SQS: Enviar(Send), Ler(Read) e Excluir(Delete). Cada classe é uma main, e deve ser rodada numa IDE, pois, como como ainda veremos o Maven, eu não quis ficar só replicando os exemplos já vistos, mesmo motivo que me levou a preferir uma solução diferente da do professor, além de para experimentar outras possibilidades. A seguir, o desenvolvimento:

Depois de: <br>
- criar uma conta na AWS,<br>
- criar um usuário do IAM,<br>
- instalar Java e Apache Maven,<br>
- e configurar as credenciais (ACCESS_KEY e SECRET_KEY) no SO local,<br>

-> Criar um projeto Maven com o seguinte comando no terminal:
```
mvn -B archetype:generate \
 -DarchetypeGroupId=org.apache.maven.archetypes \
 -DgroupId=com.example.myapp \
 -DartifactId=myapp
 ```
 
-> E colocar a dependência AWS SDK For Java no pom.xml:
 
 ```
<dependency>
    	<groupId>com.amazonaws</groupId>
    	<artifactId>aws-java-sdk</artifactId>
    	<version>1.12.209</version>
</dependency>
```

Por fim, só rodar a classe para a função desejada.
