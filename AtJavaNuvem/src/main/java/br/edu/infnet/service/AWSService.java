package br.edu.infnet.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AWSService {

	public static AmazonS3 configurar() {
		
		AWSCredentials credentials = new BasicAWSCredentials("AKIAYOCU34EHYSLRCSHJ",
				"g3IHh9D4UedLt/iQ1EHpY2RYVnU9azQ+Kh3xavgi");

		AmazonS3 clients3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1).build();
		return clients3;
	}

	public static void excluirObjeto(AmazonS3 clients3, String nome, String caminho) {
		clients3.deleteObject(nome, caminho);
	}

	public static void excluirBucket(AmazonS3 clients3, String nome) {
		try {
			clients3.deleteBucket(nome);
		} catch (AmazonS3Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void baixarObjeto(AmazonS3 clients3, String nome, String caminho, String caminho_Imagem) {
		S3Object s3Object = clients3.getObject(nome, caminho);
		S3ObjectInputStream inputStream = s3Object.getObjectContent();
		try {
			FileUtils.copyInputStreamToFile(inputStream, new File(caminho_Imagem));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			;
		}
	}

	public static void listarObjetos(AmazonS3 clients3, String nome) {
		System.out.println("Objetos do bucket " + nome);
		ObjectListing objectListing = clients3.listObjects(nome);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
		}
	}

	public static void inserirObjeto(AmazonS3 clients3, String nome, String caminho, File file) {
		clients3.putObject(nome, caminho, file);
	}

	public static void listarBuckets(AmazonS3 clients3) {
		List<Bucket> buckets = clients3.listBuckets();
		System.out.println("Lista de buckets");
		for (Bucket bucket : buckets) {
			System.out.println(bucket.getName());
		}
	}

	public static boolean isBucketCreated(AmazonS3 clients3, String nome) {
		if (clients3.doesBucketExistV2(nome)) {
			return true;
		} else {
			clients3.createBucket(nome);
			return false;
		}
	}

}
