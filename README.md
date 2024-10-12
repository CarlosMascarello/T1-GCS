
# T1-GCS

## Regras:
### Usaremos o fluxo de trabalho do Git (git Flow), a fim de maior organização dos membros do grupo. O Git Flow funciona com duas branches principais (Develop e Master), que estarão sempre lá e três branches suportes (Feature, Release e Hotfix) que duram até realizar o merge com as principais.

## Branch Master/Main:
### Principal branch que terá o código de produção. Todas as futuras funcionalidades estarão associadas na Master e, para isso, deve-se interagir por meio de uma Hotfix ou uma Release.

## Branch Develop:
### É a branch que terá o código do próximo deploy. Serve como linha do tempo com últimos desenvolvimentos, podendo ter funcionalidade que ainda não foram publicadas e, futuramente, serão associadas a branch Master.

## Branch Feature:
### São branches que serão utilizadas para o desenvolvimento de funcionalidades específicas. Deve-se seguir uma convenção de nome que, no nosso caso, será "feature/exemplo-código". Vale ressaltar que essas branches NÃO podem ter relação com a Master, somente com a branch develop.

## Branch Hotfix:
### Criada com o intuito de realizar correções imediatas encontradas no sistema de produção. Quando concluída, ela será descontinuada após dar o merge com as branches Master e Develop. Teremos uma branch de hotfix para cada correção que precisaremos implementar.

## Branch Release:
### Uma vez que a etapa de desenvolvimento esteja concluída, teremos a mescla da Branch Develop com as features e Hotfix. Para mandar as novas funcionalidades para a Branch Master, temos que criar a Branch Release, que servirá como uma ponte para fazer o merge com a Master. Caso seja encontrado algum bug ela também deverá ser sincronizada com a Develop

## Funções dos membros:
### Bernardo Hoff Paiva dos Santos - Busca itens (4)
### Carlos Eduardo Brito Mascarello - Listar dos itens de outros usuários em ordem de preço (3) - Revisão das funcionalidades
### Eduardo da Costa Diaz - Listar as proposta do jogador logado (6)
### Felipe Tavares Dias - Abrir proposta de troca (5)
### Jayme Eduardo Yawata Fortes - Cadastro do usuário (1)
### João Pedro Ayache Quadrado - Raridade do item (10)
### João Vitor Santos de Souza - Estatísticas gerais (8)
### Pedro Francisco Faviero Willmsen - Verificar o valor (9)
### Pedro Henrique Reginato de Carli - HUD básico - O jogador logado poderá selecionar uma proposta de troca para ver seus detalhes e aceitar ou declinar a proposta. (7)
### Rodrigo Macuglia Gagliardi de Lima - Listar os próprios itens em ordem alfabética (2)

## Métodos principais
### 1) O sistema deverá permitir que um novo jogador se cadastre no sistema. O sistema deverá permitir que um jogador entre no sistema com seu email e pin.
### 2) O sistema deverá permitir a um jogador listar os seus próprios itens, em ordem alfabética.
### 3) O sistema deverá permitir a um jogador listar os itens dos demais jogadores, por ordem de preço.
### 4) O sistema deverá permitir a um jogador buscar itens fornecendo parte do nome, descrição, categoria.
### 5) O sistema deverá permitir a um jogador selecionar um item seu e um item de outro usuário para abrir uma proposta de troca. A proposta de troca deverá registrar dia e hora.
### 6) O sistema deverá listar as propostas de troca na tela do jogador logado.
### 7) O jogador logado poderá selecionar uma proposta de troca para ver seus detalhes e aceitar ou declinar a proposta.
### 8) O sistema deverá exibir estatísticas gerais, como:
   ### a) Total de usuários
   ### b) Total de itens (e a soma total de seus preços)
   ### c) Quantidade de Propostas de troca aceitas / declinadas
   ### d) Quantidade total de propostas aguardando resposta.
### 9) Duas funcionalidades a mais, à escolha do grupo.
### 9.1) colocar uma tag no item para verificar o valor (barato, médio ou caro) (9)
### 9.2) colocar raridade de item (comum, raro e épico) (10)