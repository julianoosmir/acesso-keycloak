1 - criar realm e setar na propriedade de acesso = quarkus.keycloak.admin-client.realm=acesso

2 - criar cliente e setar na propridade = quarkus.keycloak.admin-client.client-id=tentativa

3- pegar o cliente secret = quarkus.keycloak.admin-client.client-secret=EHg6HAJ2P4v769WHfMby6wehXkY7rTiJ

4 - setar as roles no client na aba Service accounts roles = manage-users , view-realm, view-users ,query-users , uma_protection ,uma_authorization

5 - criar as roles que ira usar no sistema ex: admin,user, company, etc