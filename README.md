# Catálogo de Carros - API RESTful 🚗

Esta API RESTful permite gerenciar um catálogo de carros, incluindo marcas, motores e categorias como esportivo, SUV, hatch, entre outros. Desenvolvida com foco em escalabilidade, performance e organização semântica, ela fornece uma interface simples e padronizada para desenvolvedores e sistemas externos.

## 📦 Tecnologias Utilizadas

- **Java 17** + **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker** e **Docker Compose**
- **JUnit** e **Mockito** para testes
- **Postman** para documentação e testes de API

## 🚀 Executando a Aplicação com Docker Compose

### Pré-requisitos

- Docker
- Docker Compose

### Passos para Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/catalogo-carros.git
   cd catalogo-carros
   ```

2. Crie o arquivo `.env` com as variáveis de ambiente:

   ```env
      SPRING_PROFILES_ACTIVE: hml
      DB_HOST: mysql
      DB_PORT: 3306
      DB_NAME: carros_db
      DB_USERNAME: <seu_user/>
      DB_PASSWORD: <sua_senha/>
   ```
2.1 Sugestão de arquivo `docker-compose.yml`:
```env
services:
  mysql:
    image: mysql:8.0
    container_name: mysql_hml
    environment:
      MYSQL_DATABASE: carros_db
      MYSQL_ROOT_PASSWORD: ####
      MYSQL_USER: <seu_user/>
      MYSQL_PASSWORD: <sua_senha/>
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - catalogo-network
    healthcheck:
      test: ["CMD", "mysqladmin", "ping", "-h", "localhost", "-u", "root", "-proot"]
      interval: 10s
      timeout: 5s
      retries: 5

  catalogo-api:
    build: .
    container_name: catalogo_hml
    environment:
      SPRING_PROFILES_ACTIVE: hml
      DB_HOST: mysql
      DB_PORT: 3306
      DB_NAME: carros_db
      DB_USERNAME: <seu_user/>
      DB_PASSWORD: <sua_senha/>
    ports:
      - "8080:8080"
    depends_on:
      mysql:
        condition: service_healthy
    networks:
      - catalogo-network

volumes:
  mysql_data:

networks:
  catalogo-network:
```

3. Execute o Docker Compose:

   ```bash
   docker-compose up --build
   ```

   Isso iniciará os containers da aplicação e do banco de dados PostgreSQL.

4. Acesse a aplicação:

   - A API estará disponível em: `http://localhost:8080`

## 📄 Documentação da API

A documentação completa da API está disponível no Postman:\
👉 Documentação da API no Postman

## 📚 Endpoints Principais

### 🔹 Marcas

#### 📥 Criar Marca

`POST /api/marcas`\
Cria uma nova marca de carro.

**Requisição**

```json
{
  "nome": "Ferrari"
}
```

**Resposta (201 Created)**

```json
{
  "id": 1,
  "nome": "Ferrari"
}
```

**Erros Possíveis**

| Código | Descrição |
| --- | --- |
| 400 | Dados inválidos ou campo `nome` ausente |

#### 📤 Listar Todas as Marcas

`GET /api/marcas`

**Resposta (200 OK)**

```json
[
  {
    "id": 1,
    "nome": "Ferrari"
  },
  {
    "id": 2,
    "nome": "Lamborghini"
  }
]
```

#### 🔍 Buscar Marca por ID

`GET /api/marcas/{id}`

**Resposta (200 OK)**

```json
{
  "id": 1,
  "nome": "Ferrari"
}
```

**Erros Possíveis**

| Código | Descrição |
| --- | --- |
| 404 | Marca com o ID não encontrada |

#### ✏️ Atualizar Marca

`PUT /api/marcas/{id}`

**Requisição**

```json
{
  "nome": "Ferrari Atualizada"
}
```

**Resposta (200 OK)**

```json
{
  "id": 1,
  "nome": "Ferrari Atualizada"
}
```

**Erros Possíveis**

| Código | Descrição |
| --- | --- |
| 400 | Dados inválidos |
| 404 | Marca não encontrada |

#### ❌ Deletar Marca

`DELETE /api/marcas/{id}`

**Resposta (204 No Content)**\
Sem corpo na resposta.

**Erros Possíveis**

| Código | Descrição |
| --- | --- |
| 404 | Marca não encontrada |

### 🚗 Carros

#### 📥 Criar Carro

`POST /api/carros`\
Cria um novo carro associado a uma marca e a um motor.

**Requisição**

```json
{
  "nome": "Mustang GT",
  "ano": "2023",
  "descricao": "Ícone esportivo com motor V8.",
  "combustivel": "Gasolina",
  "cambio": "Automático",
  "tracao": "Traseira",
  "marchas": 10,
  "velocidadeMaxima": 250,
  "direcao": "Elétrica",
  "freios": "Disco carbono-cerâmico (4 rodas)",
  "categoria": "ESPORTIVO",
  "foto": "mustang.jpg",
  "marcaId": 1,
  "motorId": "a2e5c1e2-bd3f-4567-9c1e-987654321000"
}
```

**Resposta (201 Created)**

```json
{
  "id": 1,
  "nome": "Mustang GT",
  "ano": "2023",
  "descricao": "Ícone esportivo com motor V8.",
  "combustivel": "Gasolina",
  "cambio": "Automático",
  "tracao": "Traseira",
  "marchas": 10,
  "velocidadeMaxima": 250,
  "direcao": "Elétrica",
  "freios": "Disco carbono-cerâmico (4 rodas)",
  "categoria": "ESPORTIVO",
  "foto": "mustang.jpg",
  "marca": {
    "id": 1,
    "nome": "Ford"
  },
  "motor": {
    "id": "a2e5c1e2-bd3f-4567-9c1e-987654321000",
    "nome": "4.0 V8 Twin-Turbo",
    "descricao": "Motor V8 de alta performance",
    "potencia": 760
  }
}
```

#### 📤 Listar Todos os Carros

`GET /api/carros`

**Resposta (200 OK)**

```json
[
  {
    "id": 1,
    "nome": "Mustang GT",
    "categoria": "ESPORTIVO"
  },
  {
    "id": 2,
    "nome": "Gol",
    "categoria": "HATCH"
  }
]
```

#### 🔍 Buscar Carro por ID

`GET /api/carros/{id}`

**Resposta (200 OK)**

```json
{
  "id": 1,
  "nome": "Mustang GT",
  "descricao": "Ícone esportivo com motor V8.",
  "categoria": "ESPORTIVO"
}
```

**Erros Possíveis**

| Código | Descrição |
| --- | --- |
| 404 | Carro com o ID não encontrado |

#### ✏️ Atualizar Carro

`PUT /api/carros/{id}`

**Requisição**

```json
{
  "nome": "Mustang GT 2024",
  "ano": "2024",
  "descricao": "Atualização do modelo esportivo.",
  "categoria": "ESPORTIVO"
}
```

**Resposta (200 OK)**

```json
{
  "id": 1,
  "nome": "Mustang GT 2024",
  "ano": "2024",
  "descricao": "Atualização do modelo esportivo.",
  "categoria": "ESPORTIVO"
}
```

#### ❌ Deletar Carro

`DELETE /api/carros/{id}`

**Resposta (204 No Content)**\
Sem corpo na resposta.

### 🔹 Motores

| Método | Endpoint | Descrição |
| --- | --- | --- |
| **GET** | `/api/motores` | Lista todos os motores |
| **GET** | `/api/motores/{id}` | Obtém um motor pelo ID |
| **POST** | `/api/motores` | Cria um novo motor |
| **PUT** | `/api/motores/{id}` | Atualiza um motor existente |
| **DELETE** | `/api/motores/{id}` | Remove um motor |

## 🧪 Testes

Os testes unitários foram implementados utilizando **JUnit** e **Mockito**. Para executá-los:

```bash
./mvnw test
```

## 📌 Observações

- Certifique-se de que as portas **8080** e **5432** estejam livres em sua máquina.
- Utilize o perfil `hml` para o ambiente de homologação, configurando o `application-hml.properties` adequadamente.
- Para ambientes de produção, ajustes adicionais de segurança e performance são recomendados.
