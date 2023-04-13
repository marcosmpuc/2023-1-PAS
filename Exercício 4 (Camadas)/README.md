Segue o enunciado do exercício

# Exercício: aplicando o padrão camadas
Considerando a modelagem resultante do exercício anterior, implemente o sistema de cálculo de fretes usando uma arquitetura em camadas e os “Building blocks” da abordagem DDD.

Vamos trabalhar com as 4 camadas propostas no DDD:
- Interface
- Aplicação
- Domínio
- Persistência

Nessa primeira versão a camada de interface terá apenas o(s) “controler(s)”.  
Na camada de aplicação teremos basicamente a(s) classe(s) que implementa(m) os casos de uso e os eventuais DTOs que se façam necessários. Discuta com o grupo quais as vantagens ou desvantagens de implementar os casos de uso em classes separadas.  
Na camada de domínio iremos localizar as classes que modelam as entidades e os serviços.  
Finalmente a camada de persistência vai conter os repositórios.  
Questão para discussão: o acesso aos dados relativos ao CEP será modelado como um serviço ou como um repositório?

Simplificações para esta versão:
- O cálculo do orçamento será simplificado. Será calculado apenas o custo básico e o imposto. Para facilitar e padronizar as soluções, as classes que implementam os serviços de orçamento e serviço de CEP serão fornecidas pelo professor. Note que a classe "ServicoCEP” depende de outras classes para acessar o serviço remoto de CEP e estas dependências não estão explícitas. Estas classes estão à disposição no pacote “util” também disponíveis no Moodle.
- Não trabalharemos com promoções. O caso de uso que solicita a lista de promoções vigentes deverá retornar uma lista com uma única string: “nenhuma”.
