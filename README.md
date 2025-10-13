# APS 4 Semestre

O tema dessa APS (atividades práticas supervisionadas) é: “Desenvolvimento de um Sistema para Análise de Performance de Algoritmos de Ordenação de Dados”

## Proposta do Trabalho

A análise de performance de algoritmos aplicada ao geoprocessamento de dados
envolvendo focos de incêndios detectados por satélites em todo o país configura-se
como um campo de pesquisa rico e promissor, apresentando um significativo potencial
de impacto. Incêndios em regiões críticas não apenas comprometem a biodiversidade
global, mas também alteram o clima do planeta de forma alarmante. O monitoramento
contínuo da floresta, do cerrado e demais biomas por meio de imagens de satélite é
essencial para a fiscalização e combate a atividades ilegais.

Nesse cenário, o desenvolvimento de algoritmos eficientes para a análise de
grandes volumes de dados geográficos é fundamental, possibilitando a tomada de
decisões rápidas e precisas.

O objetivo deste trabalho é incentivar a pesquisa e o desenvolvimento de soluções
inovadoras para enfrentar um dos maiores desafios ambientais contemporâneos,
através da utilização de algoritmos de ordenação como etapa inicial do
processamento dos dados, preparando-os para a aplicação de técnicas de
aprendizado de máquina ou deep learning.

## Funcionalidades

- Busca dinâmica de dados em diferentes documentos num mesmo endpoint;
- Ordenação de diversos tipos de dados, como: latitude, longitude, bioma, data, município e etc;
- Uso de paginação para tornar a API mais flexível e facilitar sua integração com o front-end;
- Capacidade de fornecer o número de trocas e comparações feitos pelo algoritmo de ordenação.

## Ferramentas utilizadas

- Java;
- Spring Boot;
- Thymeleaf;
- MongoDB;
- Docker.

## Boas práticas

Nossa API foi criada por desenvolvedores, para desenvolvedores. Tendo isso em mente, decidimos utilizar diversas boas práticas - com o objetivo de tornar colaborações algo mais prático, um código simples de ser compreendido e escalável.
Não só isso, nosso sistema também conta com uma alta performance; o que proporciona mais flexibilidade e agilidade na renderização ao exibir seu conteúdo para os usuários.
Algumas práticas que foram levadas em consideração: SOLID, Clean Code, uso de Big O para estimar performance e DDD (Domain Driven Design).

## Padrões de projeto

Para construção da nossa API, utilizamos dois padrões de projetos. O primeiro é o Repository Pattern, um ótimo padrão de projeto para centralizar o código em um só ponto, facilitar na hora de troca do banco de dados, 
diminui o acoplamento entre classes e facilita na hora de fazer os testes unitários. E o outro padrão é o Singleton, o Singleton garante que a classe terá apenas uma instância, o ganho de acesso global a essa mesma instância e a
capacidade de inicializar o objeto quando for pedido pela primeira vez.

## Arquitetura

Levando em conta o uso de boas práticas, optamos por fazer uso da arquitetura de três camadas; algo muito utilizado em projetos de grandes empresas.
Através dessa arquitetura, fazemos separação total das diferentes camadas (serviço, banco de dados e visualização) - garantindo escalabilidade e facilidade na hora de realizar manutenções.
Enquanto o front-end deve ser exibido localmente para o usuário, a lógica/regra de negócio está em um container via Docker e o banco de dados em nuvem por meio do MongoDB ATLAS.

## Licença

The MIT License (MIT)

Copyright (c) 2025 Samuel Nóbrega

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

