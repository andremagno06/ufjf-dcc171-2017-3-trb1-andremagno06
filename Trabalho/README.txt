Trabalho 

Aluno: André Magno Ribeiro
Matrícula: 20136060
Curso: Sistema de Informação


Cenário 

Esse sistema tem o intuito de gerenciar os pedidos feitos em uma lanchonete. Neste sistema pode incluir e excluir Mesa e Item. Pode ser gerado um relatório de todos os pedidos feito por uma Mesa(Cliente).

Modelo de dados

Item 
    String nome
    double preco

Mesa 
    String codigo
    List<Pedido> pedido 
    String aberto
    String fechado
    int estado

Pedido
    Item item
    int quantidade
    double preco


Construção das Janelas

Tabela dela de Pedidos
Combobox para selecionar item
Caixa de texto para inserir a quantidade
Botão de Inserir Pedido
Botão de Excluir Pedido
Botão para abrir o Pedido
Botão para fechar o Pedido





Tabela de Itens
Botão para Inserir item 
Botão para Excluir Item 
Campo texto para nome do Item 
Campo Texto para o preço do Item 

Tabela de Mesas
Botão para inserir Item 
Botão para excluir Item 





Funcionamento do programa

Os passos para que o programa funcione:

Inserir Pedidos:

1º Passo:  Selecione uma mesa na tabela de Mesas

2º Passo: Logo depois você selecione o botão “Abrir Pedido”

3º Passo: Selecione o Item a ser inserido no combo-box

4º Passo: Digite a quantidade que você quer inserir deste produto.

5º Passo:Clique no Botão “Inserir Item no Pedido” e visualize que o Item carregou na Tabela de Pedidos


Excluir Pedido:

1ºPasso: Selecione o pedido na “Tabela Pedidos” e clique no botão “Excluir Pedido”

Excluir Item:
1ºPasso: Selecione o pedido na “Tabela Item” e clique no botão “Excluir Item”

Excluir Mesa:

1º Passo: Selecione o pedido na “Tabela Mesa” e clique no botão “Excluir Mesa”

Inserir uma Mesa:

1º Passo: Clique no botão inserir Mesa, digite no campo o nome da Mesa que você quer inserir e clique em ok.

Inserir uma Item:

1º Passo: Clique no botão inserir Item, digite o nome do seu produto e o Preço e clique em Criar Pedido.

Gerar Relatório:

1º Passo: Para gerar relatório você tem que ter fechado uma mesa, após fechar uma mesa você pode perceber que ele gera o relatório automaticamente, e caso você queira gera-lo de novo apenas clique em no botão “Gerar Relatório”.

Limpar Pedidos da Mesa:

1º Passo: Selecione uma Mesa e clique em “Limpar Pedido da Mesa”



Dificuldade

Tive dificuldade na parte de ajustar layout, pois existem muitos parâmetros a se definir tive dificuldade também para entender o JTable, acabei optando usar a JList.

Melhorias

Pode ser usado JTable ao invés de JList para que as informações seja melhor visualizadas, colocar o cadastro de Mesas e Item em outra janela e reajustar a tabela de pedidos para que fique mais usual.
