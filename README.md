# APS 4 Semestre

O tema dessa APS (atividades práticas supervisionadas) é: “Desenvolvimento de um Sistema para Análise de Performance de Algoritmos de Ordenação de Dados”

<img width="1383" height="395" alt="Screenshot 2025-10-15 at 15 41 58" src="https://github.com/user-attachments/assets/db7da764-4bc0-407b-a2aa-270c26b881bc" />

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

## Deploy

Para trabalhar com a arquitura de três camadas - era necessário fazer o deploy do nosso backend; tendo isso em mente decidimos utilizar a plataforma Render.
Fizemos o push da nossa imagem no Docker, inserimos as variáveis do .env e hospedamos nossa aplicação em um servidor. Isso não só torna nossa aplicação mais desacoplada, mas também coloca ela nos padrões de mercado exigidos para APIs modernas.

<img width="1079" height="563" alt="Screenshot 2025-10-17 at 14 50 30" src="https://github.com/user-attachments/assets/59eb4634-3275-45ab-ba59-16e6e7b59218" />

## Como rodar o projeto

### Acesso através do domínio

O projeto pode ser acessado através dessa <a href="https://spring-aps.onrender.com/state">URL</a>

### Clonando e instalando dependências

Ou, se preferir, você pode fazer o acesso de outra maneira. Primeiro, dê um git clone usando o seguinte comando: 

```
git clone https://github.com/Invokedzz/aps_4semestre
```

Depois disso é necessário fazer a instalação das dependências. Portanto, use esse comando:

```
./mvnw install
```

### Criando um arquivo .env

Para acessar ao MongoDB, é necessário criar um arquivo .env na raíz do projeto com as seguintes variáveis (note que você deve ter uma database e uma connection string já definidas):

```
MONGODB_CONNECTION_STRING=
MONGODB_DATABASE_NAME=
```

Dessa maneira, poderemos iniciar a aplicação tranquilamente. Seja de maneira local ou através de um container.

### Iniciando a aplicação

Para iniciar a aplicação, execute o seguinte comando em seu terminal:

```
./mvnw spring-boot:run
```

Se tudo deu certo, o projeto vai estar funcionando devidamente. Você tem tanto a opção de visualizar o JSON quanto a página web que foi criada com o Thymeleaf. Para acessar o JSON, use ```locahost:8080``` e para acessar a página web, será através do seguinte domínio: ```http://localhost:8080/state```.


## Manipulando a Query String

> Não é necessário se preocupar com lançamento de exceções caso o tipo passado no query param for diferente do original. Os valores das variáveis definidas como query params são alteradas apenas com os valores/tipos corretos. 

A manipulação da query string pode ser feita de diversas formas. Seja para trabalhar com paginação, ordenação de dados ou até mesmo trocar uma database. Para lidar com paginação, pode fazer uso do ``size`` ou do ``pageNumber``. Um exemplo de manipulação que pode fazer utilizando esses componentes seria: ```http://localhost:8080?size=10&pageNumber=1```.

O projeto analisa dados de 2023/2024 do estado do Amazonas; para tornar tudo mais dinâmico e prático, optamos por tornar possível a mudança de databases através da query. Veja como pode ser feito: ```http://localhost:8080?year=2023```.

Para fazer a ordenação, deve-se usar o query param ``orderBy`` levando em consideração os campos disponíveis para ordenar (latitude, longitude, estado, municipio, data e bioma).
Veja o seguinte exemplo: ``http://localhost:8080?orderBy=municipio``. Não só isso, você também pode juntar a cláusula ``orderBy`` com outras cláusulas que foram apresentadas até aqui, como apresentado a seguir: ``http://localhost:8080?size=10&year=2023&orderBy=municipio``.

## Licença

The MIT License (MIT)

Copyright (c) 2025 Samuel Nóbrega

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

