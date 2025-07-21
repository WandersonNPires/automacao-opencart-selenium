# 🛠️ automacao-opencart-selenium

## 📂 Acessando o Projeto

- Realize a instalação do Git na máquina para que seja possível clonar o projeto criado.  
- Necessário a instalação do Java (versão utilizada: 11.0.26).  
- Utilize o Vscode para abrir o projeto e ter acesso às automações realizadas.



---

## ⚙️ Instalação e Configuração XAMPP e OpenCart

##📌 Observação Importante

Foi realizado o teste em ambiente local, pois a aplicação oficial (https://demo.opencart.com/) possui proteção contra bots via Cloudflare, o que impede a automação.

---

##🔧 Requisitos
XAMPP com Apache e MySQL

OpenCart (versão 4.x)

Navegador moderno (Chrome, Firefox etc.)

Git, Java 11 e Maven instalados

VSCode (ou outro editor de código)

##🪛 Passo a Passo para Instalar o OpenCart Localmente
1. Instalar o XAMPP
Baixe e instale o XAMPP:
👉 https://www.apachefriends.org

Inicie os serviços:

✅ Apache

✅ MySQL

---

2. Baixar o OpenCart
Acesse:
👉 https://www.opencart.com/index.php?route=cms/download

Baixe a versão mais recente (ex: opencart-4.1.0.3.zip)


---


3. Configurar Diretório Local
Extraia o conteúdo da pasta upload/ do .zip para:

C:\xampp\htdocs\meu-opencart

Renomeie os seguintes arquivos:

config-dist.php         → config.php
admin/config-dist.php   → admin/config.php

---


4. Criar o Banco de Dados no phpMyAdmin
Acesse:
👉 http://localhost/phpmyadmin

Crie um banco de dados com o nome:


opencart_db
Defina a collation como:


utf8mb4_general_ci

---


5. Ativar Extensões Obrigatórias no PHP
No XAMPP, clique em Config → PHP (php.ini)

Localize e descomente (remova o ;) das linhas:

extension=gd
extension=zip

---


6. Instalar o OpenCart via Navegador
Acesse:
👉 http://localhost/meu-opencart

Siga o assistente de instalação:

✅ Etapa 1: Aceite os termos de uso

✅ Etapa 2: Verificação do sistema (todos os itens devem ficar verdes)

✅ Etapa 3: Preencha os dados do banco de dados e crie o usuário administrador

✅ Etapa 4: Conclusão da instalação

---


7. Remover a Pasta de Instalação
Após a instalação, exclua a pasta de instalação para garantir a segurança:

C:\xampp\htdocs\meu-opencart\install


---

✅ Acessos
🛒 Loja (frontend):
👉 http://localhost/meu-opencart

---


## 💻 Ferramentas Utilizadas
 
- 🐙 Git  
- 🖥️ VSCode  
- 🛠️ XAMPP  

---

## 📦 Dependências  e Liguagens utilizadas

- 📜 JavaScript
- 🐘 PHP
- ☕ Java 
- ✅ TestNG  
- 🚀 Maven  
- 🌐 Selenium WebDriver  
- ☕ Java - 11.0.26  

---

## 🗂️ Pasta Documentos

Foi criada uma pasta **documentos**, onde as evidências dos testes serão alocadas após sua execução.

---

## ✅ Cenários de Teste

### 🏠 Página Inicial
- Validar o carregamento da home (título, banners, carrossel)
- Verificar se a navegação pelo menu superior funciona
- Validar que as categorias principais exibem seus produtos
- Validar funcionamento do carrossel principal

---

### 🔍 Busca de Produtos
- Buscar produto existente e validar resultado
- Buscar produto inexistente e validar mensagem
- Validar filtro por categorias e ordem

---

### 📦 Detalhes do Produto
- Acessar página do produto e validar informações
- Adicionar produto ao carrinho
- Verificar funcionamento da galeria de imagens
- Tentar adicionar quantidade inválida

---

### 🛒 Carrinho de Compras
- Adicionar item ao carrinho e validar listagem
- Remover item do carrinho
- Atualizar quantidade e validar total
- Finalizar compra com carrinho vazio
- Validar cálculo de subtotal e total
- Visualizar Carrinho

---

### 🛍️ Checkout
- Finalizar compra como usuário logado
- Verificar erros ao omitir dados obrigatórios
- Validar seleção de pagamento e envio

---

### 👤 Cadastro/Login
- Criar nova conta com dados válidos
- Criar conta com e-mail já cadastrado
- Login com dados válidos
- Login com senha incorreta
- Recuperação de senha
- Logout com sucesso

---

### 🗃️ Minha Conta
- Editar informações pessoais
- Alterar senha
- Verificar histórico de pedidos
- Acessar e gerenciar lista de desejos

---

### ⭐ Avaliação de Produtos
- Adicionar avaliação como logado
- Tentar avaliar como visitante
- Validar erros ao enviar sem preencher campos

---

### ✉️ Contato
- Enviar mensagem com dados válidos
- Enviar com campos obrigatórios em branco
- Validar mensagem de sucesso/erro

---

### 🔧 Outros
- Adicionar e comparar produtos
- Cadastrar na newsletter e validar
- Trocar idioma/moeda e validar
- Validar responsividade do site

---



