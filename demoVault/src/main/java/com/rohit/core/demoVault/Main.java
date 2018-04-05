
package com.rohit.core.demoVault;

import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;


public class Main {

	public static final String VAULT_KEY = "secret/my_database_access";

	public static void main(String[] args) {
		if (args.length == 0) {
			throw new IllegalStateException("You Must provide the vault token as CLI argument");
		}
		String vaultToken = args[0];
		VaultTemplate vaultTemplate = createTempalte(vaultToken);

		DbCredentials secrets = new DbCredentials();
		secrets.setDbUserName("Rohit");
		secrets.setDbPassword("Singh");

		vaultTemplate.write(VAULT_KEY, secrets);

		VaultResponseSupport<DbCredentials> response = vaultTemplate.read(VAULT_KEY, DbCredentials.class);
		System.out.println(response.getData());

	}

	private static VaultTemplate createTempalte(String vaultToken) {

		VaultEndpoint vaultEndpoint = new VaultEndpoint();
		vaultEndpoint.setScheme("http");
		vaultEndpoint.setHost("172.16.25.13");
		//RestTemplate vaultClient = VaultClients.createRestTemplate(vaultEndpoint, (new RestTemplate()).getRequestFactory());
		return new VaultTemplate(vaultEndpoint,new TokenAuthentication(vaultToken));

	}
}
