package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import modelo.Apartamento;
import modelo.Avaliacao;
import modelo.Categoria;
import modelo.Comentario;
import modelo.Condomino;
import modelo.EstadoCivil;
import modelo.ImagemProduto;
import modelo.Produto;
import modelo.TipoUsuario;
import util.JPAUtil;

public class PopulaBanco {
    
    public static void main (String[] args) {
        EstadoCivil etc1 = new EstadoCivil("Solteiro");
        EstadoCivil etc2 = new EstadoCivil("Casado");
        EstadoCivil etc3 = new EstadoCivil("Divorciado");
        EstadoCivil etc4 = new EstadoCivil("Viúvo");

        Apartamento a1 = new Apartamento();
        a1.setBloco('A');
        a1.setAndar(1);
        a1.setNumApartamento("101");

        Apartamento a2 = new Apartamento();
        a2.setBloco('A');
        a2.setAndar(2);
        a2.setNumApartamento("201");
        
        Apartamento a3 = new Apartamento();
        a3.setBloco('A');
        a3.setAndar(3);
        a3.setNumApartamento("301");
        
        Apartamento a4 = new Apartamento();
        a4.setBloco('A');
        a4.setAndar(4);
        a4.setNumApartamento("401");
        
        Condomino adm = new Condomino();
        adm.setNome("ADA");
        adm.setLogin("laada");
        adm.setSenha("saada");
        adm.setTipoUsuario(TipoUsuario.ADMIN);
        adm.setDataNascimento(Calendar.getInstance());
        adm.getDataNascimento().set(1997, 11, 26);
        adm.setCpf("111.111.111-11");
        adm.setApartamento(a1);
        adm.setEstadoCivil(etc1);
        
        Condomino adm2 = new Condomino();
        adm2.setNome("BRUNA");
        adm2.setLogin("labruna");
        adm2.setSenha("sabruna");
        adm2.setTipoUsuario(TipoUsuario.ADMIN);
        adm2.setDataNascimento(Calendar.getInstance());
        adm2.getDataNascimento().set(1994, 00, 21);
        adm2.setCpf("222.222.222-22");
        adm2.setApartamento(a2);
        adm2.setEstadoCivil(etc2);
        
        Condomino adm3 = new Condomino();
        adm3.setNome("EVERTON");
        adm3.setLogin("laeverton");
        adm3.setSenha("saeverton");
        adm3.setTipoUsuario(TipoUsuario.ADMIN);
        adm3.setDataNascimento(Calendar.getInstance());
        adm3.getDataNascimento().set(1990, 07, 20);
        adm3.setCpf("333.333.333-33");
        adm3.setApartamento(a3);
        adm3.setEstadoCivil(etc3);
        
        Condomino adm4 = new Condomino();
        adm4.setNome("WILSON");
        adm4.setLogin("lawilson");
        adm4.setSenha("sawilson");
        adm4.setTipoUsuario(TipoUsuario.ADMIN);
        adm4.setDataNascimento(Calendar.getInstance());
        adm4.getDataNascimento().set(1988, 05, 03);
        adm4.setCpf("444.444.444-44");
        adm4.setApartamento(a4);
        adm4.setEstadoCivil(etc4);
        
        Categoria cat1 = new Categoria();
        cat1.setDescricao("INFORMATICA");

        Categoria cat2 = new Categoria();
        cat2.setDescricao("ELETRÔNICO");
        
        Categoria cat3 = new Categoria();
        cat3.setDescricao("DIVERSOS");
        
        Condomino cd = new Condomino();
        cd.setNome("ADA");
        cd.setLogin("lcada");
        cd.setSenha("scada");
        cd.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd.setDataNascimento(Calendar.getInstance());
        cd.getDataNascimento().set(1997, 11, 26);
        cd.setCpf("555.555.555-55");
        cd.setApartamento(a1);
        cd.setEstadoCivil(etc1);
        
        Condomino cd2 = new Condomino();
        cd2.setNome("BRUNA");
        cd2.setLogin("lcbruna");
        cd2.setSenha("scbruna");
        cd2.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd2.setDataNascimento(Calendar.getInstance());
        cd2.getDataNascimento().set(1994, 00, 21);
        cd2.setCpf("666.666.666-66");
        cd2.setApartamento(a2);
        cd2.setEstadoCivil(etc2);
        
        Condomino cd3 = new Condomino();
        cd3.setNome("WILSON");
        cd3.setLogin("lcwilson");
        cd3.setSenha("scwilson");
        cd3.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd3.setDataNascimento(Calendar.getInstance());
        cd3.getDataNascimento().set(1988, 05, 03);
        cd3.setCpf("777.777.777-77");
        cd3.setApartamento(a3);
        cd3.setEstadoCivil(etc3);
        
        Condomino cd4 = new Condomino();
        cd4.setNome("EVERTON");
        cd4.setLogin("lceverton");
        cd4.setSenha("sceverton");
        cd4.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd4.setDataNascimento(Calendar.getInstance());
        cd4.getDataNascimento().set(1990, 07, 20);
        cd4.setCpf("888.888.888-88");
        cd4.setApartamento(a4);
        cd4.setEstadoCivil(etc4);
        
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
        p7.setStatus(true);
        p7.getCategorias().add(cat2);
        p7.setQuantidade(10);

        Produto p8= new Produto();
        p8.setNome("FONE");
        p8.setStatus(true);

        p8.getCategorias().add(cat2);
        p8.setQuantidade(10);

        Produto p9= new Produto();
        p9.setNome("CABO USB");
         p9.setStatus(true);

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
      
        cd.getTelefones().add("1111111111");
        cd2.getTelefones().add("2222222222");
        cd3.getTelefones().add("3333333333");
        cd4.getTelefones().add("4444444444");
                
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
        com1.setData(Calendar.getInstance());
        
        Comentario com2= new Comentario();
        com2.setComentario("Muito linda a locadora");
        com2.setProduto(p1);
        com2.setComentarista(cd2);
        com2.setAvaliacao(av1);
        com2.setData(Calendar.getInstance());

        
        Comentario com3= new Comentario();
        com3.setComentario("Muito bom esse produto");
        com3.setProduto(p2);
        com3.setComentarista(cd);
        com3.setAvaliacao(av1);
        com3.setData(Calendar.getInstance());
        
        Comentario com4= new Comentario();
        com4.setComentario("Não gostei");
        com4.setProduto(p2);
        com4.setComentarista(cd3);
        com4.setAvaliacao(av3);
        com4.setData(Calendar.getInstance());

        
        Comentario com5= new Comentario();
        com5.setComentario("Muito show");
        com5.setProduto(p2);
        com5.setComentarista(cd4);
        com5.setAvaliacao(av1);
        com5.setData(Calendar.getInstance());

        
        Comentario com6= new Comentario();
        com6.setComentario("Não gostei");
        com6.setProduto(p3);
        com6.setComentarista(cd3);
        com6.setAvaliacao(av3);
        com6.setData(Calendar.getInstance());
      
        
        Comentario com7= new Comentario();
        com7.setComentario("Sem defeitos");
        com7.setProduto(p3);
        com7.setComentarista(cd);
        com7.setAvaliacao(av2);
        com7.setData(Calendar.getInstance());

        Comentario com8= new Comentario();
        com8.setComentario("Legalzão, gostei mesmo");
        com8.setProduto(p4);
        com8.setComentarista(cd3);
        com8.setAvaliacao(av1);
        com8.setData(Calendar.getInstance());

        
        Comentario com9= new Comentario();
        com9.setComentario("Muito show");
        com9.setProduto(p4);
        com9.setComentarista(cd2);
        com9.setAvaliacao(av1);
        com9.setData(Calendar.getInstance());
       
        Comentario com10= new Comentario();
        com10.setComentario("Não gostei");
        com10.setProduto(p4);
        com10.setComentarista(cd4);
        com10.setAvaliacao(av3);
        com10.setData(Calendar.getInstance());

        Comentario com11= new Comentario();
        com11.setComentario("Sem defeitos");
        com11.setProduto(p5);
        com11.setComentarista(cd4);
        com11.setAvaliacao(av2);
        com11.setData(Calendar.getInstance());

        Comentario com12= new Comentario();
        com12.setComentario("Legalzão, gostei mesmo");
        com12.setProduto(p5);
        com12.setComentarista(cd3);
        com12.setAvaliacao(av1);
        com12.setData(Calendar.getInstance());

        
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
        
        
        a1.getCondominos().add(adm);
        a1.getCondominos().add(cd);
        a2.getCondominos().add(adm2);
        a2.getCondominos().add(cd2);
        a3.getCondominos().add(adm3);
        a3.getCondominos().add(cd3);
        a4.getCondominos().add(adm4);
        a4.getCondominos().add(cd4);
        
        
        
        BufferedImage imagem;
        ByteArrayOutputStream bytesImg;// = new ByteArrayOutputStream();
        //byte[] byteArray = null;
        ImagemProduto img1= new ImagemProduto();
        
        ImagemProduto img2= new ImagemProduto();
        
        ImagemProduto img3= new ImagemProduto();
        
        ImagemProduto img4= new ImagemProduto();
       
        ImagemProduto img5= new ImagemProduto();

        ImagemProduto img6= new ImagemProduto();

        ImagemProduto img7= new ImagemProduto();
        
        ImagemProduto img8= new ImagemProduto();
        
        ImagemProduto img9= new ImagemProduto();       
        
        ImagemProduto img10= new ImagemProduto();       
        

        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/mouse.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img1 = new ImagemProduto();
            img1.setImagem(bytesImg.toByteArray());
            p1.getImagensProduto().add(img1);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem 1: " + ex.getMessage());
        }
  
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/teclado.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img2= new ImagemProduto();
            img2.setImagem(bytesImg.toByteArray());
            p2.getImagensProduto().add(img2);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem 2: " + ex.getMessage());
        }

        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/monitor.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img3 = new ImagemProduto();
            img3.setImagem(bytesImg.toByteArray());
            p3.getImagensProduto().add(img3);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/caderno.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img4 = new ImagemProduto();
            img4.setImagem(bytesImg.toByteArray());
            p4.getImagensProduto().add(img4);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/notebook.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img5 = new ImagemProduto();
            img5.setImagem(bytesImg.toByteArray());
            p5.getImagensProduto().add(img5);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/caneta.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img6 = new ImagemProduto();
            img6.setImagem(bytesImg.toByteArray());
            p6.getImagensProduto().add(img6);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/celular.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img7 = new ImagemProduto();
            img7.setImagem(bytesImg.toByteArray());
            p7.getImagensProduto().add(img7);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/fone.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img8 = new ImagemProduto();
            img8.setImagem(bytesImg.toByteArray());
            p8.getImagensProduto().add(img8);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/cabo.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img9 = new ImagemProduto();
            img9.setImagem(bytesImg.toByteArray());
            p9.getImagensProduto().add(img9);
            bytesImg.close();
        } catch (IOException ex) {
            //Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File("src/icon/chaveiro.jpg"));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img10 = new ImagemProduto();
            img10.setImagem(bytesImg.toByteArray());
            p10.getImagensProduto().add(img10);
            bytesImg.close();
        } catch (IOException ex) {
            
            System.out.println("Erro imagem: " + ex.getMessage());
        }
        
        img1.setProduto(p1);
        img2.setProduto(p2);
        img3.setProduto(p3);
        img4.setProduto(p4);
        img5.setProduto(p5);
        img6.setProduto(p6);
        img7.setProduto(p7);
        img8.setProduto(p8);
        img9.setProduto(p9);
        img10.setProduto(p10);
        
        
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        
        manager.persist ( etc1 );
        manager.persist ( etc2 );
        manager.persist ( etc3 );
        manager.persist ( etc4 );
        
        
        manager.persist ( a1 ); 
        manager.persist ( a2 ); 
        manager.persist ( a3 );
        manager.persist ( a4 );

        manager.persist ( cat1 ); 
        manager.persist ( cat2 ); 
        manager.persist ( cat3 );

        manager.persist ( adm ); 
        manager.persist ( adm2 ); 
        manager.persist ( adm3 );
        manager.persist ( adm4 );
        
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
        
        manager.persist ( img1 ); 
        manager.persist ( img2 ); 
        manager.persist ( img3 );
        manager.persist ( img4 );
        manager.persist ( img5 ); 
        manager.persist ( img6 ); 
        manager.persist ( img7 );
        manager.persist ( img8 );        
        manager.persist ( img9 ); 
        manager.persist ( img10);
        
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
        
        manager.getTransaction().commit();
        manager.close();
        
        System.exit(0);
    }
}