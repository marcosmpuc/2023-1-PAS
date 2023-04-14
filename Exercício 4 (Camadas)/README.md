Segue o enunciado do exercício 3 e o do 4

# Exercício
## Modelando um sistema de logística
Dinâmica: organizar a turma em grupos. Cada grupo deve usar um quadro móvel para desenhar o diagrama de classes com a sua modelagem para cada uma das situações propostas. Ao final do tempo todos os quadros devem ser alinhados lado a lado para que se possa identificar as diferentes visões. Cada grupo deve defender sua modelagem.  
1) Analise a especificação que segue. Considere que está sendo planejado o módulo “backend”. Modele inicialmente a camada de domínio. Na sequência apresente os elementos que irão compor a camada de aplicação e, finalmente, as camadas de interface e acesso a dados. Justifique suas escolhas.  
Especificação: uma empresa de logística necessita desenvolver o sistema que calcula o custo do transporte de encomendas simples (pacotes). Encomendas simples caracterizam-se por ter um endereço de origem, um endereço de destino e um peso em gramas (inteiro). O cálculo do custo é feito a partir destas informações. Na verdade, para efeito de cálculo de custo não se consideram os endereços inteiros, apenas a cidade de origem e a cidade de destino (a empresa atende uma lista de cidades). A identificação das cidades de origem e destino é feita a partir dos CEP dos endereços. O cálculo do custo leva em conta um custo básico, um adicional pelo peso e diferentes promoções que podem ser aplicáveis ou não. Cada cidade atendida tem um centro de distribuição pequeno, mas o centro de distribuição principal fica em São Paulo. Existe uma tabela com o custo básico de transporte entre São Paulo (SAO) e de cada uma das cidades atendidas. Se uma encomenda vai de Porto Alegre (POA) para Curitiba (CUR), então ela vai primeiro a São Paulo e depois para Curitiba. Neste caso o custo básico é a soma do custo de entrega POAàSAO mais o custo de entrega SAOàCUR. Se tanto o endereço de entrega como o de destino forem na mesma cidade, então usa-se o custo da cidade para São Paulo como custo básico. Inicialmente esta é a lista de cidades atendidas:

| Cidade | Custo básico até são Paulo |
| ------ | -------------------------- |
| Porto Alegre | R$ 25,00 |
| Florianópolis | R$ 20,00 |
| Curitiba | R$ 15,00 |
| São Paulo | R$ 10,00 |

Para calcular o custo final da entrega deve-se somar o custo básico com o adicional por peso. O peso é informado em gramas, mas deve ser convertido para Kg. No caso de valores quebrados arredonda-se para cima (ex: 2400 gramas devem ser arredondadas para 3Kg). Para calcular o adicional por peso usa-se a regra que segue (os valores podem variar, mas a estrutura não). Encomendas até 2Kg são isentas de custo adicional. A partir de 3Kg cobram-se R$ 10,00 por Kg e a partir de 12Kg cobra-se R$ 15,00 por Kg. Exemplo: uma encomenda de 15Kg irá pagar: R$ 0,00 pelos primeiros dois Kg + R$ 100,00 pelos próximos 10Kg e R$ 45,00 pelos últimos 3Kg totalizando R$ 145,00 de adicional por peso. Além do custo básico e do adicional por peso é necessário acrescentar um percentual de impostos para se chegar ao custo final do transporte. O percentual de imposto é aplicado sobre o custo de cada trecho considerando-se o imposto da cidade de origem. Quando não especificado o imposto é de 5% do custo básico. Note que promoções podem ser aplicadas tanto no custo básico como no adicional dependendo da cidade e do peso conforme a promoção do momento. O mesmo pode ocorrer com os impostos que podem variar de uma cidade para outra conforme as políticas locais.  
O sistema deve ser capaz não apenas de fornecer os custos como de registrar os “orçamentos” fornecidos. Cada orçamento deve conter um identificador, a data e hora em que foi fornecido, a cidade de origem, a cidade de destino, o peso da encomenda, o custo básico, o custo adicional, o valor dos impostos, o desconto aplicado e o valor final. Isso é importante porque as promoções e custos variam ao longo do tempo, então é importante saber a origem de um valor apresentado para um cliente.  
As funcionalidades básicas previstas para o sistema são:
- Retornar a lista das cidades atendidas
- Verificar se a cidade de um determinado CEP é atendida
- Retornar a promoção vigente
- Calcular o orçamento para uma determinada encomenda (deve armazenar o orçamento fornecido)
- Recuperar os orçamentos de uma determinada data

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
