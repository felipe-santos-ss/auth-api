# Auth API
Este projeto é uma API de autenticação construída com Spring Boot, utilizando Spring Security e JWT (JSON Web Token) para controle de acesso. Trata-se de uma base sólida para aplicações que exigem autenticação e autorização baseadas em papéis, como usuário comum (user), que possui funcionalidades limitadas, e administrador (admin), que possui acesso completo às funcionalidades da aplicação.

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven
- Lombok

## 🚀 Funcionalidades

- Registro de usuários com papéis (USER ou ADMIN)
- Login com geração de token JWT
- Autorização com base em papéis
- Endpoints protegidos com verificação de token
- Tokens armazenados e validados para garantir segurança

## 🔒 Controle de Acesso
- USER: Acesso limitado a funcionalidades básicas.
- ADMIN: Acesso completo à aplicação.
