package com.rohit.demoVault_Lts;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
@VaultPropertySource("secret/certs")
public class VaultConfig extends AbstractVaultConfiguration {


	@Override
	public VaultEndpoint vaultEndpoint() {
		String uri = getEnvironment().getProperty("vault.uri");
		if (uri != null) {
			return VaultEndpoint.from(URI.create(uri));
		}
		throw new IllegalStateException();
	}

	@Override
	public ClientAuthentication clientAuthentication() {
		String token = getEnvironment().getProperty("vault.token");
		if (token != null) {
			return new TokenAuthentication(token);
		}
		throw new IllegalStateException();
	}

}
