# Projeto teste - GAM

- Projetos
  - api	
    - utiliza spring-boot com mybatis
    - projeto está configurado para rodar na porta 6699
    - script de criação do banco no postgres em **\src\main\resources\script-banco.sql**
    - rotas
      - json com as requisições disponíveis no arquivo **teste-api.json**
  - webapp
    - interface web em jsf
    - em BaseService.java fica o endereço base de comunicação com a api acima http://localhost:6699/contato
    - permite a busca listagem/cadastro de clientes e edição de clientee e cadastro/listagem de telefones do cliente
- Imagens com prints das telas estão na raiz no projeto
- Ao iniciar  os dois projetos acessar http://localhost:<porta>/webapp/

