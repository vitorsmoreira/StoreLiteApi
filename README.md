# StoreLiteApi
Versão atualizada do trabalho de faculdade para uma criação de API de um aplicativo que conecta o comércio com o consumidor.

## Endpoint

* Produto
    * Cadastrar
    * Atualizar Produto
    * Excluir Produto
    * Mostrar Produtos
* Mercado
    * Cadastrar
    * Atualizar Mercado
    * Excluir Mercado
    * Detalhar Mercado

---

### Cadastrar Produto

`POST` /api/produto

**Campo de Requisição**

campo | tipo | obrigatório | descrição
|---|---|:---:|---|
nome | String | sim | Informa qual o produto comercializado
fabricate | String | sim | Informa qual empresa fabricou o produto
peso | double | sim | Informa o peso do produto
volume | double | não | Informa o volume do produto
categoria_id | int | sim | Informa em qual o grupo do produto
preco | double | sim | Valor a ser pago pelo produto
frete| double | não | Valor a ser pago pela entrega
quantidade | int | sim | Informa quanto do produto será vendido
vencimento | LocalDateTime | sim | Informa quanto a data de vencimento do produto 

**Exemplo de Campo de Requisição**

```js
    "nome": "Ámido de Milho",
    "fabricante": "Maizena",
    "peso": 500.0,
    "volume": null,
    "categoria_id": 1,
    "preco": 10.5,
    "frete": null,
    "quantidade": 1,
    "vencimento": "2023-05-10"
```

**Código de Resposta**

código | descrição
|---|---
200 | Ok
201 | Produto criado com sucesso
400 | Campos enviados são inválidos

---

### Mostrar Produtos

`GET` /api/produto/{id}

```js
    "nome": "Ámido de Milho",
    "fabricante": "Maizena",
    "peso": 500.0,
    "volume": null,
    "categoria":{
        "categoria_id": 1,
        "nome": "alimento"
    }
    "preco": 10.5,
    "frete": null,
    "quantidade": 1,
    "vencimento": "2023-05-10"
```

---

### Cadastrar Mercado

`POST` /api/mercado

**Campo de Requisição**

campo | tipo | obrigatório | descrição
|---|---|:---:|---|
id | long | sim | Identificador único do mercado
nome| String | sim | Informa o nome do estabelecimento
endereco | int | sim | Informa o endereço do estabelecimento 
telefone | String | sim | Informa o telefone do estabelecimento
expediente_inicio | LocalDateTime | sim | Informa o horário em que o estabelimento começa a funcionar
expediente_termino | LocalDateTime | sim | Informa o horário em que o estabelecimento encerra as atividades
cnpj | String | sim | Informa o CNPJ da empresa
preco_minimo | double | não | Informa o preço mínimo para a realização de um produto

---

**Exemplo de Campo de Requisição**

```js
    "id": 1,
    "nome": "Mercadinho Damaceno",
    "endereco_id": 3,
    "telefone": "(11) 98765-4321",
    "expediente_inicio": "09:00",
    "expediente_termino": "19:00",
    "cnpj": "33.254.819/0001-34",
    "preco_minimo": 10.0
```

código | descrição
|---|---
200 | Ok
201 | Estabelecimento criado com sucesso
400 | Campos enviados são inválidos

---

### Detalhar Mercado

`GET` /api/mercado/{id}

```js
    "id": 1,
    "nome": "Mercadinho Damaceno",
    "endereco": {
        "endereco_id": 3,
        "numero": 500,
        "logradouro": "Av. Jonas Matias",
        "bairro": "Pq. Minotauro",
        "cidade": "São Lorentino",
        "estado": "Distrito Federal"
    }
    "telefone": "(11) 98765-4321",
    "expediente_inicio": "09:00",
    "expediente_termino": "19:00",
    "cnpj": "33.254.819/0001-34",
    "preco_minimo": 10.0
```

código | descrição
|---|---
200 | Ok
201 | Estabelecimento criado com sucesso
400 | Campos enviados são inválidos