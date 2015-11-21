package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import modelo.Aluguel;
import modelo.Apartamento;
import modelo.Avaliacao;
import modelo.Categoria;
import modelo.Comentario;
import modelo.Condomino;
import modelo.EstadoCivil;
import modelo.ImagemProduto;
import modelo.Produto;
import modelo.SolicitacaoAluguel;
import modelo.TipoUsuario;
import util.JPAUtil;

public class PopulaBanco {
    
    public PopulaBanco() {
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
        
        Condomino adm1 = new Condomino();
        adm1.setNome("ADA");
        adm1.setLogin("laada");
        adm1.setSenha("saada");
        adm1.setTipoUsuario(TipoUsuario.ADMIN);
        adm1.setDataNascimento(Calendar.getInstance());
        adm1.getDataNascimento().set(1997, 11, 26);
        adm1.setCpf("111.111.111-11");
        adm1.setApartamento(a1);
        adm1.setEstadoCivil(etc1);
        
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
        cat1.setDescricao("Educação, Esporte e Lazer");

        Categoria cat2 = new Categoria();
        cat2.setDescricao("Brinquedos e Jogos");
        
        Categoria cat3 = new Categoria();
        cat3.setDescricao("Brinquedos Educativos");
        
        Categoria cat4 = new Categoria();
        cat4.setDescricao("Brinquedos Eletrônicos ou Motorizados");
        
        Categoria cat5 = new Categoria();
        cat5.setDescricao("Brinquedos Infláveis");
        
        Categoria cat6 = new Categoria();
        cat6.setDescricao("Brinquedos para Playgrounds");
        
        Categoria cat7 = new Categoria();
        cat7.setDescricao("Ping-pong, bilhar, pebolim e jogos de mesa");
        
        Categoria cat8 = new Categoria();
        cat8.setDescricao("Esporte e Lazer");
        
        Categoria cat9 = new Categoria();
        cat9.setDescricao("Equipamentos para Esporte Aquáticos");
        
        Categoria cat10 = new Categoria();
        cat10.setDescricao("Equipamentos para Esporte Coletivos");
        
        Categoria cat11 = new Categoria();
        cat11.setDescricao("Equipamentos para Esporte de Combate");
        
        Categoria cat12 = new Categoria();
        cat12.setDescricao("Música");
        
        Categoria cat13 = new Categoria();
        cat13.setDescricao("Acessórios para Instrumentos Musicais");
        
        Categoria cat14 = new Categoria();
        cat14.setDescricao("Instrumentos Musicais");
        
        Categoria cat15 = new Categoria();
        cat15.setDescricao("Eletrodomésticos e Eletroportáteis");
        
        Categoria cat16 = new Categoria();
        cat16.setDescricao("Aparelhos de DVD e Blu-Ray");
        
        Categoria cat17 = new Categoria();
        cat17.setDescricao("Aparelhos de Som");
        
        Categoria cat18 = new Categoria();
        cat18.setDescricao("Aparelhos de Televisão");
        
        Categoria cat19 = new Categoria();
        cat19.setDescricao("Beleza e Saúde");
        
        Categoria cat20 = new Categoria();
        cat20.setDescricao("Aparelhos para Cortar, Secar e Modelar Cabelos");
        
        Categoria cat21 = new Categoria();
        cat21.setDescricao("Aparelhos para Tratamento Estético");
        
        Categoria cat22 = new Categoria();
        cat22.setDescricao("Peças para Equip. Beleza e Saúde");
        
        Categoria cat23 = new Categoria();
        cat23.setDescricao("Climatização");
        
        Categoria cat24 = new Categoria();
        cat24.setDescricao("Cozinha");
        
        Categoria cat25 = new Categoria();
        cat25.setDescricao("Batedeiras e Liquidificadores");
        
        Categoria cat26 = new Categoria();
        cat26.setDescricao("Fornos");
        
        Categoria cat27 = new Categoria();
        cat27.setDescricao("Torradeiras e Sanduicheiras");
        
        Categoria cat28 = new Categoria();
        cat28.setDescricao("Lavanderia e Jardinagem");
        
        Categoria cat29 = new Categoria();
        cat29.setDescricao("Máquinas de lavar, passar e secar roupas");
        
        Categoria cat30 = new Categoria();
        cat30.setDescricao("Informática");
        
        Categoria cat31 = new Categoria();
        cat31.setDescricao("Computadores");
        
        Categoria cat32 = new Categoria();
        cat32.setDescricao("Notebooks");
        
        Categoria cat33 = new Categoria();
        cat33.setDescricao("Teclado");
        
        Categoria cat34 = new Categoria();
        cat34.setDescricao("Mouse");
        
        Categoria cat35 = new Categoria();
        cat35.setDescricao("Impressora");
        
        Categoria cat36 = new Categoria();
        cat36.setDescricao("Monitor");
        
        Categoria cat37 = new Categoria();
        cat37.setDescricao("Máquinas e Equipamentos");
        
        Categoria cat38 = new Categoria();
        cat38.setDescricao("Batedeiras, Masseiras e Massadeiras");
        
        Categoria cat39 = new Categoria();
        cat39.setDescricao("Fritadeiras");
        
        Categoria cat40 = new Categoria();
        cat40.setDescricao("Máquinas de café e chá");
        
        Categoria cat41 = new Categoria();
        cat41.setDescricao("Moedores, Amaciadores e Picadores de Carne");
        
        Categoria cat42 = new Categoria();
        cat42.setDescricao("Utilidades");
        
        Categoria cat43 = new Categoria();
        cat43.setDescricao("Artigos para Serviços de Mesa");
        
        Categoria cat44 = new Categoria();
        cat44.setDescricao("Foras e Assadeiras");
        
        Categoria cat45 = new Categoria();
        cat45.setDescricao("Panelas");
        
        Categoria cat46 = new Categoria();
        cat46.setDescricao("Talheres e Utensílios de Cozinha");
        
        Categoria cat47 = new Categoria();
        cat47.setDescricao("Utensídios em Cerâmica");
        
        Categoria cat48 = new Categoria();
        cat48.setDescricao("Veículo e transporte");
        
        Categoria cat49 = new Categoria();
        cat49.setDescricao("Bicicletas");
        
        Categoria cat50 = new Categoria();
        cat50.setDescricao("Patinete");
        
        Condomino cd1 = new Condomino();
        cd1.setNome("ADA");
        cd1.setLogin("lcada");
        cd1.setSenha("scada");
        cd1.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd1.setDataNascimento(Calendar.getInstance());
        cd1.getDataNascimento().set(1997, 11, 26);
        cd1.setCpf("555.555.555-55");
        cd1.setApartamento(a1);
        cd1.setEstadoCivil(etc1);
        
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
        
        Produto p1 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(1);
        p1.setNome("MOUSE");
        p1.setStatus(true);
        p1.getCategorias().add(cat30);
        p1.getCategorias().add(cat34);

        Produto p2 = new Produto();
        p2.setDiaria(6);
        p2.setTaxa(1);
        p2.setNome("TECLADO");
        p2.setStatus(true);
        p2.getCategorias().add(cat30);
        p2.getCategorias().add(cat33);

        Produto p3 = new Produto();
        p3.setDiaria(15);
        p3.setTaxa(3);
        p3.setNome("MONITOR");
        p3.setStatus(true);
        p3.getCategorias().add(cat30);
        p3.getCategorias().add(cat36);
        
        Produto p4 = new Produto();
        p4.setDiaria(3);
        p4.setTaxa(1);
        p4.setNome("CADERNO");
        p4.setStatus(true);
        p4.getCategorias().add(cat1);

        Produto p5 = new Produto();
        p5.setDiaria(35);
        p5.setTaxa(5);
        p5.setNome("NOTEBOOK");
        p5.setStatus(true);
        p5.getCategorias().add(cat30);
        p5.getCategorias().add(cat32);

        Produto p6 = new Produto();
        p6.setDiaria(3);
        p6.setTaxa(0.5);
        p6.setNome("CANETA");
        p6.setStatus(true);
        p6.getCategorias().add(cat1);

        Produto p7 = new Produto();
        p7.setDiaria(25);
        p7.setTaxa(4);
        p7.setNome("CELULAR");
        p7.setStatus(true);
        p7.getCategorias().add(cat30);

        Produto p8 = new Produto();
        p1.setDiaria(10);
        p1.setTaxa(3);
        p8.setNome("FONE");
        p8.setStatus(true);
        p8.getCategorias().add(cat30);

        Produto p9 = new Produto();
        p1.setDiaria(2);
        p1.setTaxa(0.25);
        p9.setNome("CABO USB");
        p9.setStatus(true);
        p9.getCategorias().add(cat30);

        Produto p10 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(2);
        p10.setNome("CHAVE");
        p10.getCategorias().add(cat24);

        Produto p11 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(2);
        p11.setNome("CHAVEIRO");
        p11.getCategorias().add(cat27);

        Produto p12 = new Produto();
        p1.setDiaria(10);
        p1.setTaxa(5);
        p12.setNome("GARRAFA");
        p12.getCategorias().add(cat47);
      
        cd1.getTelefones().add("1111111111");
        cd2.getTelefones().add("2222222222");
        cd3.getTelefones().add("3333333333");
        cd4.getTelefones().add("4444444444");
                
        cd1.getProdutos().add(p1);
        cd1.getProdutos().add(p2);
        cd1.getProdutos().add(p3);
        
        cd2.getProdutos().add(p4);
        cd2.getProdutos().add(p5);
        cd2.getProdutos().add(p6);

        cd3.getProdutos().add(p7);
        cd3.getProdutos().add(p8);
        cd3.getProdutos().add(p9);
        
        cd4.getProdutos().add(p10);
        cd4.getProdutos().add(p11);
        cd4.getProdutos().add(p12);
        
        p1.setCondomino(cd1);
        p2.setCondomino(cd1);
        p3.setCondomino(cd1);

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
        com3.setComentarista(cd1);
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
        com7.setComentarista(cd1);
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
        
        a1.getCondominos().add(adm1);
        a1.getCondominos().add(cd1);
        a2.getCondominos().add(adm2);
        a2.getCondominos().add(cd2);
        a3.getCondominos().add(adm3);
        a3.getCondominos().add(cd3);
        a4.getCondominos().add(adm4);
        a4.getCondominos().add(cd4);

        ImagemProduto img1;
        ImagemProduto img2;
        ImagemProduto img3;
        ImagemProduto img4;
        ImagemProduto img5;
        ImagemProduto img6;
        ImagemProduto img7;
        ImagemProduto img8;
        ImagemProduto img9;
        ImagemProduto img10;
        ImagemProduto img11;
        
        img1 = carregarBufferedImage(p1, "src/icon/mouse.jpg");
        img2 = carregarBufferedImage(p2, "src/icon/teclado.jpg");
        img3 = carregarBufferedImage(p3, "src/icon/monitor.jpg");
        img4 = carregarBufferedImage(p4, "src/icon/caderno.jpg");
        img5 = carregarBufferedImage(p5, "src/icon/notebook.jpg");
        img6 = carregarBufferedImage(p6, "src/icon/caneta.jpg");
        img7 = carregarBufferedImage(p7, "src/icon/celular.jpg");
        img8 = carregarBufferedImage(p8, "src/icon/fone.jpg");
        img9 = carregarBufferedImage(p9, "src/icon/cabo.jpg");
        img10 = carregarBufferedImage(p10, "src/icon/chaveiro.jpg");
        img11 = carregarBufferedImage(p11, "src/icon/bicicleta2.jpg");
        
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
        img11.setProduto(p11);
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);
        produtos.add(p6);
        produtos.add(p7);
        produtos.add(p8);
        produtos.add(p9);
        produtos.add(p10);
        produtos.add(p11);
        produtos.add(p12);
        
        List<Condomino> condominos = new ArrayList<>();
        condominos.add(cd1);
        condominos.add(cd2);
        condominos.add(cd3);
        condominos.add(cd4);
        
        //Começa a inserir dados no banco.
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
        
        //Persistindo Categorias
        manager.persist ( cat1 );
        manager.persist ( cat2 );
        manager.persist ( cat3 );
        manager.persist ( cat4 );
        manager.persist ( cat5 );
        manager.persist ( cat6 );
        manager.persist ( cat7 );
        manager.persist ( cat8 );
        manager.persist ( cat9 );
        manager.persist ( cat10 );
        manager.persist ( cat11 );
        manager.persist ( cat12 );
        manager.persist ( cat13 );
        manager.persist ( cat14 );
        manager.persist ( cat15 );
        manager.persist ( cat16 );
        manager.persist ( cat17 );
        manager.persist ( cat18 );
        manager.persist ( cat19 );
        manager.persist ( cat20 );
        manager.persist ( cat21 );
        manager.persist ( cat22 );
        manager.persist ( cat23 );
        manager.persist ( cat24 );
        manager.persist ( cat25 );
        manager.persist ( cat26 );
        manager.persist ( cat27 );
        manager.persist ( cat28 );
        manager.persist ( cat29 );
        manager.persist ( cat30 );
        manager.persist ( cat31 );
        manager.persist ( cat32 );
        manager.persist ( cat33 );
        manager.persist ( cat34 );
        manager.persist ( cat35 );
        manager.persist ( cat36 );
        manager.persist ( cat37 );
        manager.persist ( cat38 );
        manager.persist ( cat39 );
        manager.persist ( cat40 );
        manager.persist ( cat41 );
        manager.persist ( cat42 );
        manager.persist ( cat43 );
        manager.persist ( cat44 );
        manager.persist ( cat45 );
        manager.persist ( cat46 );
        manager.persist ( cat47 );
        manager.persist ( cat48 );
        manager.persist ( cat49 );
        manager.persist ( cat50 );

        manager.persist ( adm1 ); 
        manager.persist ( adm2 ); 
        manager.persist ( adm3 );
        manager.persist ( adm4 );
        
        manager.persist ( cd1 ); 
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
        
        List<SolicitacaoAluguel> solicitacoes = new ArrayList<>();
        for (int i = 5; i < 1605; i++) {
            int diaSolicitacao, diaInicioAluguel, quantidadeDias, sorteioProduto, sorteioCondomino;
            Calendar dataSolicitacao = Calendar.getInstance(), dataInicioAluguel = Calendar.getInstance();
            diaSolicitacao = i/5;
            diaInicioAluguel = (int) (diaSolicitacao + (5 + Math.random() * 20));
            quantidadeDias = (int) (3 + Math.random() * 12);
            dataSolicitacao.set(Calendar.DAY_OF_YEAR, diaSolicitacao);
            dataInicioAluguel.set(Calendar.DAY_OF_YEAR, diaInicioAluguel);
            sorteioProduto = (int) (Math.random() * 12);
            sorteioCondomino = (int) (Math.random() * 4);
            while (sorteioProduto == 12) {
                sorteioProduto = (int) (Math.random() * 12);
            }
            while (condominos.get(sorteioCondomino) == produtos.get(sorteioProduto).getCondomino()) {
                sorteioCondomino = (int) (Math.random() * 4);
            }
            SolicitacaoAluguel sa = new SolicitacaoAluguel(quantidadeDias, 1, produtos.get(sorteioProduto), condominos.get(sorteioCondomino), dataSolicitacao, dataInicioAluguel);
            solicitacoes.add(sa);
            manager.persist ( sa );
        }
        
        List<Aluguel> alugueis = new ArrayList<>();
        for (int i = 0; i<50; i++) {
            int sorteioSolicitacao, sorteioDataDevolucao;
            Calendar dataDevolucao = Calendar.getInstance();
            sorteioSolicitacao = (int) (Math.random() * 1600);
            SolicitacaoAluguel solicitacao = solicitacoes.get(sorteioSolicitacao);
            sorteioDataDevolucao = (int) (solicitacao.getDataInicioAluguel().get(Calendar.DAY_OF_YEAR) + (solicitacao.getDiasPretendidos() - 7 + Math.random() * 10));
            dataDevolucao.set(Calendar.DAY_OF_YEAR, sorteioDataDevolucao);
            
            solicitacao = sorteiaAluguelSemRepeticao(alugueis, solicitacoes, dataDevolucao);
            Aluguel aluguel = new Aluguel(solicitacao, dataDevolucao);
            alugueis.add(aluguel);
            manager.persist(aluguel);
        }
        
        manager.getTransaction().commit();
        manager.close();
        
        System.exit(0);
    }
    
    private ImagemProduto carregarBufferedImage(Produto produto, String path){
        BufferedImage imagem;
        ByteArrayOutputStream bytesImg;
        ImagemProduto img = null;
        try {
            bytesImg = new ByteArrayOutputStream();
            imagem = ImageIO.read(new File(path));
            ImageIO.write(imagem, "jpg", bytesImg);
            bytesImg.flush();
            img = new ImagemProduto();
            img.setImagem(bytesImg.toByteArray());
            produto.getImagensProduto().add(img);
            bytesImg.close();
        } catch (IOException ex) {
            System.out.println("Erro imagem: " + ex.getMessage() + "\nPath: " + path);
        }
        return img;
    }
    
    private SolicitacaoAluguel sorteiaAluguelSemRepeticao(List<Aluguel> alugueis, List<SolicitacaoAluguel> solicitacoes, Calendar dataDevolucao){
        SolicitacaoAluguel solicitacao = solicitacoes.get((int) (Math.random() * 1600));
        
        for (Aluguel aluguel: alugueis) {
            boolean dataFimSolicitacaoIsBeforeAluguel = dataDevolucao.getTime().before(aluguel.getSolicitacaoAluguel().getDataInicioAluguel().getTime());
            boolean dataInicioSolicitacaoIsAfterAluguelDevolucao = solicitacao.getDataInicioAluguel().getTime().after(aluguel.getDataDevolucao().getTime());
            
            while (aluguel.getSolicitacaoAluguel().equals(solicitacao) || !(dataFimSolicitacaoIsBeforeAluguel || dataInicioSolicitacaoIsAfterAluguelDevolucao)) {
                dataFimSolicitacaoIsBeforeAluguel = dataDevolucao.getTime().before(aluguel.getSolicitacaoAluguel().getDataInicioAluguel().getTime());
                dataInicioSolicitacaoIsAfterAluguelDevolucao = solicitacao.getDataInicioAluguel().getTime().after(aluguel.getDataDevolucao().getTime());
                
                int sorteioSolicitacao = (int) (Math.random() * 1600);
                int sorteioDataDevolucao = (int) (solicitacao.getDataInicioAluguel().get(Calendar.DAY_OF_YEAR) + (solicitacao.getDiasPretendidos() - 7 + Math.random() * 10));
                dataDevolucao = Calendar.getInstance();
                dataDevolucao.set(Calendar.DAY_OF_YEAR, sorteioDataDevolucao);
                solicitacao = solicitacoes.get(sorteioSolicitacao);
            }
        }
        return solicitacao;
    }
    
    public static void main(String args[]){
        PopulaBanco populaBanco = new PopulaBanco();
    }
}