# PROJETO FINAL

## PAN Academy | Squad 5 - Turma 2
O PAN Academy é um programa de capacitação em desenvolvimento back-end em Java com  conceitos em AWS e Cloud.

### Projeto BlueBank
O projeto BlueBank foi desenvolvido com base no treinamento, onde foram implementadas as seguintes funções.
- Uma aplicação Web Service com Front-End e Back-End;
- Funções específicas por perfil;
- Transações em API/REST;
- Cadastrar/Editar/Bloquear usuários;
- Realizar transação entre contas;
- Listar movimentações;
- Listar Usuário.

### Integrantes
- Gabriel Costa Dias
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=LINK_GIT)](https://github.com/gabrieldias1990)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=LINK_LINKEDIN)](https://www.linkedin.com/in/gabriel-dias-55906b147/)
- Henrique Douglas Barbosa
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=LINK_GIT)](https://github.com/barbosa-henrique)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=LINK_LINKEDIN)](https://www.linkedin.com/in/henrique-douglas-barbosa-849b45116/)
- Pedro Lucas Roseno Pacheco
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=LINK_GIT)](https://github.com/Ordep97)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=LINK_LINKEDIN)](https://www.linkedin.com/in/pedro-pacheco-162035141/)
- Phillip Marques
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=LINK_GIT)](https://github.com/pHMqZ)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=LINK_LINKEDIN)](https://www.linkedin.com/in/phillip-marques-201832161/)
- Vinicius Trindade
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=LINK_GIT)](https://github.com/viniciustrr)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=LINK_LINKEDIN)](https://www.linkedin.com/in/vinicius-trindade-148a431b6/)

## Funcionalidades

<ul>
  <li>
    <div>
      <img align="left" src="/img/front-end.jpeg">
    </div>
  </li>
  <br />
  <li>
    <div>
      <img align="left" src="/img/aws.jpeg">
    </div>
  </li>
  <br />
</ul>


## Endpoints
### <a href="http://bluebanks5t2prod-env-1.eba-mymcbaht.us-east-1.elasticbeanstalk.com/" target="_blank">Aplicação</a>
### <a href="http://sq5t2teste-env.eba-vwdhhprt.us-east-1.elasticbeanstalk.com/swagger-ui/" target="_blank">Swagger</a>
#### admin-controller
```json
POST /usuario/admin/bloquearUsuario/{id}
{
  "admin": true,
  "conta": {
    "age": {
      "conta": [
        {
          "data_abertura": "2021-12-12T17:20:28.145Z",
          "data_fechamento": "2021-12-12T17:20:28.145Z",
          "debito": true,
          "id": 0,
          "movimento": [
            {
              "data_movimento": "2021-12-12T17:20:28.145Z",
              "id": 0,
              "nome_conta": "string",
              "numero_doc": 0,
              "tipo_movimento": "string",
              "valor": 0
            }
          ],
          "nome": "string",
          "saldo": 0
        }
      ],
      "id": 0,
      "nome": "string",
      "status": true
    },
    "data_abertura": "2021-12-12T17:20:28.146Z",
    "data_fechamento": "2021-12-12T17:20:28.146Z",
    "debito": true,
    "id": 0,
    "nome": "string",
    "saldo": 0
  },
  "dado_usuario": {
    "bairro": "string",
    "cidade": "string",
    "complemento": "string",
    "cpf": "string",
    "email": "string",
    "estado": "string",
    "id": 0,
    "numero": 0,
    "rua": "string",
    "telefone": "string"
  },
  "id": 0,
  "nome": "string",
  "num_conta": 0,
  "status": true
}
```

```json
POST /usuario/admin/desbloquearUsuario/{id}
{
  "admin": true,
  "conta": {
    "age": {
      "conta": [
        {
          "data_abertura": "2021-12-12T17:25:24.531Z",
          "data_fechamento": "2021-12-12T17:25:24.531Z",
          "debito": true,
          "id": 0,
          "movimento": [
            {
              "data_movimento": "2021-12-12T17:25:24.532Z",
              "id": 0,
              "nome_conta": "string",
              "numero_doc": 0,
              "tipo_movimento": "string",
              "valor": 0
            }
          ],
          "nome": "string",
          "saldo": 0
        }
      ],
      "id": 0,
      "nome": "string",
      "status": true
    },
    "data_abertura": "2021-12-12T17:25:24.532Z",
    "data_fechamento": "2021-12-12T17:25:24.532Z",
    "debito": true,
    "id": 0,
    "nome": "string",
    "saldo": 0
  },
  "dado_usuario": {
    "bairro": "string",
    "cidade": "string",
    "complemento": "string",
    "cpf": "string",
    "email": "string",
    "estado": "string",
    "id": 0,
    "numero": 0,
    "rua": "string",
    "telefone": "string"
  },
  "id": 0,
  "nome": "string",
  "num_conta": 0,
  "status": true
}
```

```json
PUT /usuario/admin/editarUser/{id}
{
  "additionalProp1": {},
  "additionalProp2": {},
  "additionalProp3": {}
}
```

```json
GET /usuario/admin/historico/{id}
[
  {
    "data_movimento": "2021-12-12T18:32:48.846Z",
    "id": 0,
    "nome_conta": "string",
    "tipo_movimento": "string",
    "valor": 0
  }
]
```

```json
GET /usuario/admin/historicoGeral
[
  {
    "data_movimento": "2021-12-12T18:33:07.036Z",
    "id": 0,
    "nome_conta": "string",
    "tipo_movimento": "string",
    "valor": 0
  }
]
```

```json
GET /usuario/admin/listarUsuarioId/{id}
{
  "admin": true,
  "conta": {
    "age": {
      "conta": [
        {
          "data_abertura": "2021-12-12T18:33:19.629Z",
          "data_fechamento": "2021-12-12T18:33:19.629Z",
          "debito": true,
          "id": 0,
          "movimento": [
            {
              "data_movimento": "2021-12-12T18:33:19.629Z",
              "id": 0,
              "nome_conta": "string",
              "numero_doc": 0,
              "tipo_movimento": "string",
              "valor": 0
            }
          ],
          "nome": "string",
          "saldo": 0
        }
      ],
      "id": 0,
      "nome": "string",
      "status": true
    },
    "data_abertura": "2021-12-12T18:33:19.629Z",
    "data_fechamento": "2021-12-12T18:33:19.629Z",
    "debito": true,
    "id": 0,
    "nome": "string",
    "saldo": 0
  },
  "dado_usuario": {
    "bairro": "string",
    "cidade": "string",
    "complemento": "string",
    "cpf": "string",
    "email": "string",
    "estado": "string",
    "id": 0,
    "numero": 0,
    "rua": "string",
    "telefone": "string"
  },
  "id": 0,
  "nome": "string",
  "num_conta": 0,
  "status": true
}
```

```json
GET /usuario/admin/listarUsuario
[
  {
    "admin": true,
    "conta": {
      "age": {
        "conta": [
          {
            "data_abertura": "2021-12-12T18:33:48.701Z",
            "data_fechamento": "2021-12-12T18:33:48.701Z",
            "debito": true,
            "id": 0,
            "movimento": [
              {
                "data_movimento": "2021-12-12T18:33:48.702Z",
                "id": 0,
                "nome_conta": "string",
                "numero_doc": 0,
                "tipo_movimento": "string",
                "valor": 0
              }
            ],
            "nome": "string",
            "saldo": 0
          }
        ],
        "id": 0,
        "nome": "string",
        "status": true
      },
      "data_abertura": "2021-12-12T18:33:48.702Z",
      "data_fechamento": "2021-12-12T18:33:48.702Z",
      "debito": true,
      "id": 0,
      "nome": "string",
      "saldo": 0
    },
    "dado_usuario": {
      "bairro": "string",
      "cidade": "string",
      "complemento": "string",
      "cpf": "string",
      "email": "string",
      "estado": "string",
      "id": 0,
      "numero": 0,
      "rua": "string",
      "telefone": "string"
    },
    "id": 0,
    "nome": "string",
    "num_conta": 0,
    "status": true
  }
]
```

#### aws-sns-controller

```json
GET /addInscricao/{email}

string
```

```json
GET /enviaNotificacao

string
```

#### usuario-controller

```json
GET /usuario/cliente/conta/{id}
{
  "age": {
    "conta": [
      {
        "data_abertura": "2021-12-12T18:43:47.644Z",
        "data_fechamento": "2021-12-12T18:43:47.644Z",
        "debito": true,
        "id": 0,
        "movimento": [
          {
            "data_movimento": "2021-12-12T18:43:47.644Z",
            "id": 0,
            "nome_conta": "string",
            "numero_doc": 0,
            "tipo_movimento": "string",
            "valor": 0
          }
        ],
        "nome": "string",
        "saldo": 0
      }
    ],
    "id": 0,
    "nome": "string",
    "status": true
  },
  "data_abertura": "2021-12-12T18:43:47.644Z",
  "data_fechamento": "2021-12-12T18:43:47.644Z",
  "debito": true,
  "id": 0,
  "nome": "string",
  "saldo": 0
}
```

```json
PUT /usuario/cliente/editar/{id}
{
  "additionalProp1": {},
  "additionalProp2": {},
  "additionalProp3": {}
}
```

```json
GET /usuario/cliente/historico/{id}
[
  {
    "data_movimento": "2021-12-12T18:44:34.416Z",
    "id": 0,
    "nome_conta": "string",
    "tipo_movimento": "string",
    "valor": 0
  }
]
```

```json
GET /usuario/cliente/pegarIds
0
```

```json
GET /usuario/cliente/pegarSenha/{id}
string
```

```json
POST /usuario/cliente/salvar
{
  "bairro": "string",
  "cidade": "string",
  "complemento": "string",
  "cpf": "string",
  "email": "string",
  "estado": "string",
  "nome": "string",
  "numero": 0,
  "rua": "string",
  "senha": "string",
  "telefone": "string"
}
```

```json
POST /usuario/cliente/transferir/{id_origem}/{id_destino}/{valor}
0
```


## Entidade Relacionamento
<p align="center">
  <img align="left" width="400" height="400" src="/img/DER.PNG">
</p>



