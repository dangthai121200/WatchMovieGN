package watch.movie.gn.rsa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RsaKey {
	public static void generateRSAKey() throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048);
		KeyPair pair = generator.generateKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();

		System.out.println("Write private key!:");
		try (FileOutputStream fos = new FileOutputStream("src/main/resources/JwtPrivateKey.key")) {
			fos.write(privateKey.getEncoded());
			System.out.println(privateKey.getEncoded());

		}
		System.out.println("Write private key: done");
		
		System.out.println("Write public key!:");
		try (FileOutputStream fos = new FileOutputStream("src/main/resources/JwtPublicKey.pub")) {
			fos.write(publicKey.getEncoded());
		}
		System.out.println("Write public key: done");
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		generateRSAKey();
	}
}
