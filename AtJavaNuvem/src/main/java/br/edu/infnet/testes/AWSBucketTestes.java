package br.edu.infnet.testes;

import com.amazonaws.services.s3.AmazonS3;

import br.edu.infnet.service.AWSService;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class AWSBucketTestes {

	private static final String nome = "java-bucket-at-storage";
	private static final String caminhoArquivo = "imagens/imagem.jpg";
	private static final String caminhoLocalArquivo = "D:\\wasabi\\Downloads\\imagem.jpg";
	private static final File caminhoLocalFile = new File("D:\\wasabi\\Downloads\\imagem.jpg");

	@Autowired
	private static AWSService awsBucketService;

	public static void main(String[] args) {

		AmazonS3 clients3 = awsBucketService.configurar();

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		awsBucketService.isBucketCreated(clients3, nome);
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		awsBucketService.listarBuckets(clients3);
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        awsBucketService.inserirObjeto(s3, nomeBucket, caminhoArquivo, caminhoLocalFile);
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		awsBucketService.listarObjetos(clients3, nome);
//        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        awsBucketService.baixarObjeto(s3,nomeBucket,caminhoArquivo,caminhoLocalArquivo);
//        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        awsBucketService.excluirObjeto(s3,nomeBucket,caminhoArquivo);
//        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        awsBucketService.excluirBucket(s3,nomeBucket);

	}

}
