<h1 > Desafio Votação </h1> <br>
<p>
  
</p>

<p>
  Projeto que simula o cadastro de associados, pautas, sessões e votações.
</p>



## Índice

- [Instalar](#instalação)
- [Utilização](#utilização)
- [Endpoints](#exemplos-de-chamadas)

## Instalação

Requisitos: Java 19 e Docker instalados.

No prompt, acesse a pasta do projeto e digite:

1- Executar a base:

```bash
$ docker-compose up -d
```

2- Aplicação:

2.1 Windows:

```bash
$ .\gradlew bootRun
```
2.2 Linux / Macos:

```bash
$ ./gradlew bootRun
```


## Utilização

É possível realizar chamadas REST para as seguintes funcionalidades:
* Cadastrar Pauta.
* Cadastrar Sessão.
* Cadastrar Associado.
* Votar.
* Contabilizar Resultados.

## Exemplos de chamadas

1. Cadastrar Pauta: 
   ```bash
      curl --location 'http://localhost:8080/api/v1/pauta' \
        --header 'Content-Type: application/json' \
        --header 'Cookie: JSESSIONID=20C91576485675672D9703AE86ECD4D4' \
        --data '{
        "nome": "pauta de teste 2",
        "descricao": "descrição de teste"
        }'

      ```
2. Cadastrar Sessão:
           
   ```bash
       curl --location 'http://localhost:8080/api/v1/sessao' \
      --header 'Content-Type: application/json' \
      --header 'Cookie: JSESSIONID=20C91576485675672D9703AE86ECD4D4' \
      --data '{
      "pautaId": 1,
      "prazoDuracao": 5
      }'

      ```
3. Cadastrar Associado:
   
   ```bash
       curl --location 'http://localhost:8080/api/v1/associado' \
       --header 'Content-Type: application/json' \
       --header 'Cookie: JSESSIONID=20C91576485675672D9703AE86ECD4D4' \
       --data '{
       "nome": "associado 1"
       }'
      ```

4. Cadastrar Voto:
   ```bash
       curl --location 'http://localhost:8080/api/v1/voto' \
       --header 'Content-Type: application/json' \
       --header 'Cookie: JSESSIONID=20C91576485675672D9703AE86ECD4D4' \
       --data '{
       "valor": "Nao",
       "sessaoId": 1,
       "pautaId": 1,
       "associadoId": 3
       }'

      ```
