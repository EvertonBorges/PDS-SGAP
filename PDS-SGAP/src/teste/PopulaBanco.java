/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Apartamento;
import modelo.Avaliacao;
import modelo.Categoria;
import modelo.Comentario;
import modelo.Condomino;
import modelo.Produto;

/**
 *
 * @author LAB-05
 */
public class PopulaBanco {
    
    public static void main ( String [] args ) {
    
        EntityManagerFactory factory = Persistence.createEntityManagerFactory ("PDS-SGAPPU");
        EntityManager manager = factory . createEntityManager () ;

        manager.getTransaction().begin();

/*      Apartamento a1= new Apartamento();
        a1.setNumApartamento("apto1");

        Apartamento a2= new Apartamento();
        a2.setNumApartamento("apto2");
        
        Apartamento a3= new Apartamento();
        a3.setNumApartamento("apto3");  */      
   
        
        Categoria cat1= new Categoria();
        cat1.setDescricao("INFORMATICA");

        Categoria cat2= new Categoria();
        cat2.setDescricao("ELETRÔNICO");
        
        Categoria cat3= new Categoria();
        cat3.setDescricao("DIVERSOS");
        
        Condomino cd = new Condomino();
        cd.setNome("ADA");

        Condomino cd2 = new Condomino();
        cd2.setNome("BRUNA");
        
        Condomino cd3 = new Condomino();
        cd3.setNome("WILSON");
        
        Condomino cd4 = new Condomino();
        cd4.setNome("EVERTON");
        
        Produto p1= new Produto();
        p1.setNome("MOUSE");
        p1.setStatus(true);
        p1.getCategorias().add(cat1);
        p1.setQuantidade(10);

        Produto p2= new Produto();
        p2.setNome("TECLADO");
        p2.setStatus(true);
        p2.getCategorias().add(cat1);
        p2.setQuantidade(10);

        Produto p3= new Produto();
        p3.setNome("MONITOR");
        p3.setStatus(true);
        p3.getCategorias().add(cat1);
        p3.setQuantidade(10);
        
        Produto p4= new Produto();
        p4.setNome("CADERNO");
        p4.setStatus(true);
        p4.getCategorias().add(cat3);
        p4.setQuantidade(10);

        Produto p5= new Produto();
        p5.setNome("NOTEBOOK");
        p5.setStatus(true);
        p5.getCategorias().add(cat1);
        p5.setQuantidade(10);

        Produto p6= new Produto();
        p6.setNome("CANETA");
        p6.setStatus(true);
        p6.getCategorias().add(cat3);
        p6.setQuantidade(10);
        

        Produto p7= new Produto();
        p7.setNome("CELULAR");
        p7.getCategorias().add(cat2);
        p7.setQuantidade(10);

        Produto p8= new Produto();
        p8.setNome("FONE");
        p8.getCategorias().add(cat2);
        p8.setQuantidade(10);

        Produto p9= new Produto();
        p9.setNome("CABO USB");
        p9.getCategorias().add(cat2);
        p9.setQuantidade(10);

        Produto p10= new Produto();
        p10.setNome("CHAVE");
        p10.getCategorias().add(cat3);
        p10.setQuantidade(10);

        Produto p11= new Produto();
        p11.setNome("CHAVEIRO");
        p11.getCategorias().add(cat3);
        p11.setQuantidade(10);

        Produto p12= new Produto();
        p12.setNome("GARRAFA");
        p12.getCategorias().add(cat2);
        p12.setQuantidade(10);
      
        
                
        cd.getProdutos().add(p1);
        cd.getProdutos().add(p2);
        cd.getProdutos().add(p3);
        
        cd2.getProdutos().add(p4);
        cd2.getProdutos().add(p5);
        cd2.getProdutos().add(p6);

        cd3.getProdutos().add(p7);
        cd3.getProdutos().add(p8);
        cd3.getProdutos().add(p9);
        
        cd4.getProdutos().add(p10);
        cd4.getProdutos().add(p11);
        cd4.getProdutos().add(p12);
        
        /*
        cat1.getProdutos().add(p1);
        cat1.getProdutos().add(p2);
        cat1.getProdutos().add(p3);
        cat1.getProdutos().add(p5);
        
        cat2.getProdutos().add(p7);
        cat2.getProdutos().add(p8);
        cat2.getProdutos().add(p9);
        cat2.getProdutos().add(p12);
        
        cat3.getProdutos().add(p4);
        cat3.getProdutos().add(p6);
        cat3.getProdutos().add(p10);
        cat3.getProdutos().add(p11);
        */
        
        p1.setCondomino(cd);
        p2.setCondomino(cd);
        p3.setCondomino(cd);

        p4.setCondomino(cd2);
        p5.setCondomino(cd2);
        p6.setCondomino(cd2);
        
        p7.setCondomino(cd3);
        p8.setCondomino(cd3);
        p9.setCondomino(cd3);

        p10.setCondomino(cd4);
        p11.setCondomino(cd4);
        p12.setCondomino(cd4);
        
        p1.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p2.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p3.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p4.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p5.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p6.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p7.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p8.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p9.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p10.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p11.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");
        p12.setDescricao("Produto de boa qualidade e resistente. Ano:2015. ");

    /*    a1.getCondominos().add(cd);
       
        cd.setApartamentos(a1);

        a2.getCondominos().add(cd2);
        a2.getCondominos().add(cd3);
        
        cd2.setApartamentos(a2);
        cd3.setApartamentos(a2);

        a3.getCondominos().add(cd3);
        cd4.setApartamentos(a3);*/
        

        Avaliacao av1= new Avaliacao();
        av1.setAvaliacao("Positiva");
        
        Avaliacao av2= new Avaliacao();
        av2.setAvaliacao("Razoável");
       
        Avaliacao av3= new Avaliacao();
        av3.setAvaliacao("Negativa");
        
        
        Comentario com1= new Comentario();
        com1.setComentario("Uma porcaria!!!");
        com1.setProduto(p1);
        com1.setComentarista(cd4);
        com1.setAvaliacao(av3);
        
        Comentario com2= new Comentario();
        com2.setComentario("Muito linda a locadora");
        com2.setProduto(p1);
        com2.setComentarista(cd2);
        com2.setAvaliacao(av1);
       
        
        Comentario com3= new Comentario();
        com3.setComentario("Muito bom esse produto");
        com3.setProduto(p2);
        com3.setComentarista(cd);
        com3.setAvaliacao(av1);
        
        Comentario com4= new Comentario();
        com4.setComentario("Não gostei");
        com4.setProduto(p2);
        com4.setComentarista(cd3);
        com4.setAvaliacao(av3);

        
        Comentario com5= new Comentario();
        com5.setComentario("Muito show");
        com5.setProduto(p2);
        com5.setComentarista(cd4);
        com5.setAvaliacao(av1);

        
        Comentario com6= new Comentario();
        com6.setComentario("Não gostei");
        com6.setProduto(p3);
        com6.setComentarista(cd3);
        com6.setAvaliacao(av3);
       
        
        Comentario com7= new Comentario();
        com7.setComentario("Sem defeitos");
        com7.setProduto(p3);
        com7.setComentarista(cd);
        com7.setAvaliacao(av2);

        Comentario com8= new Comentario();
        com8.setComentario("Legalzão, gostei mesmo");
        com8.setProduto(p4);
        com8.setComentarista(cd3);
        com8.setAvaliacao(av1);

        
        Comentario com9= new Comentario();
        com9.setComentario("Muito show");
        com9.setProduto(p4);
        com9.setComentarista(cd2);
        com9.setAvaliacao(av1);
       
        Comentario com10= new Comentario();
        com10.setComentario("Não gostei");
        com10.setProduto(p4);
        com10.setComentarista(cd4);
        com10.setAvaliacao(av3);
 
        Comentario com11= new Comentario();
        com11.setComentario("Sem defeitos");
        com11.setProduto(p5);
        com11.setComentarista(cd4);
        com11.setAvaliacao(av2);

        Comentario com12= new Comentario();
        com12.setComentario("Legalzão, gostei mesmo");
        com12.setProduto(p5);
        com12.setComentarista(cd3);
        com12.setAvaliacao(av1);
 
        
        p1.getComentarios().add(com1);
        p1.getComentarios().add(com2);

        p2.getComentarios().add(com3);
        p2.getComentarios().add(com4);
        p2.getComentarios().add(com5);
        
        
        p3.getComentarios().add(com6);
        p3.getComentarios().add(com7);
        
        p4.getComentarios().add(com8);
        p4.getComentarios().add(com9);
        p4.getComentarios().add(com10);

        p5.getComentarios().add(com11);
        p5.getComentarios().add(com12);
        
        BufferedImage imagem;
        ByteArrayOutputStream bytesImg;// = new ByteArrayOutputStream();
        //byte[] byteArray = null;
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\mouse.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p1.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
  
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\teclado.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p2.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }

        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\bicicleta.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p3.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\caderno.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p4.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\notebook.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p5.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\caneta.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p6.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\celular.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p7.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\fone.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p8.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\cabo.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p9.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("C:\\Users\\Ada\\Documents\\TADS\\3° periodo\\PIG\\NetBeansProjects\\SGAP\\src\\icon\\chaveiro.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            p10.getImagensProduto().get(0).setImagem(bytesImg.toByteArray());
            bytesImg.close();
        } catch (IOException ex) {
            
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
     /* manager.persist ( a1 ); 
        manager.persist ( a2 ); 
        manager.persist ( a3 );*/

        manager.persist ( cat1 ); 
        manager.persist ( cat2 ); 
        manager.persist ( cat3 );

        manager.persist ( cd ); 
        manager.persist ( cd2 ); 
        manager.persist ( cd3 );
        manager.persist ( cd4 );

        manager.persist ( p1 ); 
        manager.persist ( p2 ); 
        manager.persist ( p3 );
        manager.persist ( p4 );
        manager.persist ( p5 ); 
        manager.persist ( p6 ); 
        manager.persist ( p7 );
        manager.persist ( p8 );        
        manager.persist ( p9 ); 
        manager.persist ( p10); 
        manager.persist ( p11);
        manager.persist ( p12);
        
        manager.persist ( av1 ); 
        manager.persist ( av2 ); 
        manager.persist ( av3 );
        
        manager.persist ( com1 ); 
        manager.persist ( com2 ); 
        manager.persist ( com3 );
        manager.persist ( com4 );
        manager.persist ( com5 ); 
        manager.persist ( com6 ); 
        manager.persist ( com7 );
        manager.persist ( com8 );        
        manager.persist ( com9 ); 
        manager.persist ( com10); 
        manager.persist ( com11);
        manager.persist ( com12); 
        
        
        manager . getTransaction () . commit () ;
        manager . close () ;
        factory . close () ;
        
        
        System.exit(0);
    }
}

