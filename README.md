# 🛠️ automacao-opencart-selenium

## 📂 Acessando o Projeto

-Realize a instalação do **Git** na máquina para que seja possível clonar o projeto criado.  
-Necessário a instalação do **Java** (versão utilizada: `11.0.26`).
-Utilize o **Vscode** para abrir o projeto e ter acesso as automações realizadas.

---

## ⚙️ Instalação e Configuração XAMPP e OpenCart

OBS: Foi realizado o teste em hambitente local devido a aplicação "https://demo.opencart.com/" tem um Cloundflare bot protection e não e possível automatizar quando existe esse bloqueio.

 

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



