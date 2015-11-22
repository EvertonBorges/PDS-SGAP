package teste;

import dao.AluguelDAO;
import dao.ApartamentoDAO;
import dao.CategoriaDAO;
import dao.ComentarioDAO;
import dao.CondominoDAO;
import dao.EstadoCivilDAO;
import dao.ProdutoDAO;
import dao.SolicitacaoAluguelDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
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

public class PopulaBanco {
    private List<Aluguel> alugueis = new ArrayList<>();
    private List<SolicitacaoAluguel> solicitacoes;
    private List<Apartamento> apartamentos;
    private List<EstadoCivil> estadosCivis;
    private List<Categoria> categorias;
    private List<Condomino> condominos;
    private List<Produto> produtos;
    
    public PopulaBanco() {
        
    }
    
    public void populaEstadosCivis(){
        EstadoCivil etc1 = new EstadoCivil("Solteiro");
        EstadoCivil etc2 = new EstadoCivil("Casado");
        EstadoCivil etc3 = new EstadoCivil("Divorciado");
        EstadoCivil etc4 = new EstadoCivil("Viúvo");
        
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        estadoCivilDAO.add(etc1);
        estadoCivilDAO.add(etc2);
        estadoCivilDAO.add(etc3);
        estadoCivilDAO.add(etc4);
    }
    
    public void populaApartamentos(){
        Apartamento a1 = new Apartamento('A', 1, "101");
        Apartamento a2 = new Apartamento('A', 2, "201");
        Apartamento a3 = new Apartamento('A', 3, "301");
        Apartamento a4 = new Apartamento('A', 4, "401");
        
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        apartamentoDAO.inserir(a1);
        apartamentoDAO.inserir(a2);
        apartamentoDAO.inserir(a3);
        apartamentoDAO.inserir(a4);
    }
    
    public void populaCondominos(){
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        this.apartamentos = apartamentoDAO.findApartamentos();
        this.estadosCivis = estadoCivilDAO.findEstadoCivil(new EstadoCivil(""));
        
        Condomino adm1 = new Condomino();
        adm1.setNome("ADA");
        adm1.setLogin("laada");
        adm1.setSenha("saada");
        adm1.setTipoUsuario(TipoUsuario.ADMIN);
        adm1.setDataNascimento(Calendar.getInstance());
        adm1.getDataNascimento().set(1997, 11, 26);
        adm1.setCpf("111.111.111-11");
        adm1.setApartamento(apartamentos.get(0));
        adm1.setEstadoCivil(estadosCivis.get(0));
        
        Condomino adm2 = new Condomino();
        adm2.setNome("BRUNA");
        adm2.setLogin("labruna");
        adm2.setSenha("sabruna");
        adm2.setTipoUsuario(TipoUsuario.ADMIN);
        adm2.setDataNascimento(Calendar.getInstance());
        adm2.getDataNascimento().set(1994, 00, 21);
        adm2.setCpf("222.222.222-22");
        adm2.setApartamento(apartamentos.get(1));
        adm2.setEstadoCivil(estadosCivis.get(1));
        
        Condomino adm3 = new Condomino();
        adm3.setNome("EVERTON");
        adm3.setLogin("laeverton");
        adm3.setSenha("saeverton");
        adm3.setTipoUsuario(TipoUsuario.ADMIN);
        adm3.setDataNascimento(Calendar.getInstance());
        adm3.getDataNascimento().set(1990, 07, 20);
        adm3.setCpf("333.333.333-33");
        adm3.setApartamento(apartamentos.get(2));
        adm3.setEstadoCivil(estadosCivis.get(2));
        
        Condomino adm4 = new Condomino();
        adm4.setNome("WILSON");
        adm4.setLogin("lawilson");
        adm4.setSenha("sawilson");
        adm4.setTipoUsuario(TipoUsuario.ADMIN);
        adm4.setDataNascimento(Calendar.getInstance());
        adm4.getDataNascimento().set(1988, 05, 03);
        adm4.setCpf("444.444.444-44");
        adm4.setApartamento(apartamentos.get(3));
        adm4.setEstadoCivil(estadosCivis.get(3));
        
        Condomino cd1 = new Condomino();
        cd1.setNome("ADA");
        cd1.setLogin("lcada");
        cd1.setSenha("scada");
        cd1.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd1.setDataNascimento(Calendar.getInstance());
        cd1.getDataNascimento().set(1997, 11, 26);
        cd1.setCpf("555.555.555-55");
        cd1.setApartamento(apartamentos.get(0));
        cd1.setEstadoCivil(estadosCivis.get(0));
        
        Condomino cd2 = new Condomino();
        cd2.setNome("BRUNA");
        cd2.setLogin("lcbruna");
        cd2.setSenha("scbruna");
        cd2.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd2.setDataNascimento(Calendar.getInstance());
        cd2.getDataNascimento().set(1994, 00, 21);
        cd2.setCpf("666.666.666-66");
        cd2.setApartamento(apartamentos.get(1));
        cd2.setEstadoCivil(estadosCivis.get(1));
        
        Condomino cd3 = new Condomino();
        cd3.setNome("WILSON");
        cd3.setLogin("lcwilson");
        cd3.setSenha("scwilson");
        cd3.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd3.setDataNascimento(Calendar.getInstance());
        cd3.getDataNascimento().set(1988, 05, 03);
        cd3.setCpf("777.777.777-77");
        cd3.setApartamento(apartamentos.get(2));
        cd3.setEstadoCivil(estadosCivis.get(2));
        
        Condomino cd4 = new Condomino();
        cd4.setNome("EVERTON");
        cd4.setLogin("lceverton");
        cd4.setSenha("sceverton");
        cd4.setTipoUsuario(TipoUsuario.CONDOMINO);
        cd4.setDataNascimento(Calendar.getInstance());
        cd4.getDataNascimento().set(1990, 07, 20);
        cd4.setCpf("888.888.888-88");
        cd4.setApartamento(apartamentos.get(3));
        cd4.setEstadoCivil(estadosCivis.get(3));
        
        CondominoDAO condominoDAO = new CondominoDAO();
        condominoDAO.addCondomino(adm1);
        condominoDAO.addCondomino(adm2);
        condominoDAO.addCondomino(adm3);
        condominoDAO.addCondomino(adm4);
        condominoDAO.addCondomino(cd1);
        condominoDAO.addCondomino(cd2);
        condominoDAO.addCondomino(cd3);
        condominoDAO.addCondomino(cd4);
    }
    
    public void populaCategoria(){
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
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.addCategoria(cat1);
        categoriaDAO.addCategoria(cat2);
        categoriaDAO.addCategoria(cat3);
        categoriaDAO.addCategoria(cat4);
        categoriaDAO.addCategoria(cat5);
        categoriaDAO.addCategoria(cat6);
        categoriaDAO.addCategoria(cat7);
        categoriaDAO.addCategoria(cat8);
        categoriaDAO.addCategoria(cat9);
        categoriaDAO.addCategoria(cat10);
        categoriaDAO.addCategoria(cat11);
        categoriaDAO.addCategoria(cat12);
        categoriaDAO.addCategoria(cat13);
        categoriaDAO.addCategoria(cat14);
        categoriaDAO.addCategoria(cat15);
        categoriaDAO.addCategoria(cat16);
        categoriaDAO.addCategoria(cat17);
        categoriaDAO.addCategoria(cat18);
        categoriaDAO.addCategoria(cat19);
        categoriaDAO.addCategoria(cat20);
        categoriaDAO.addCategoria(cat21);
        categoriaDAO.addCategoria(cat22);
        categoriaDAO.addCategoria(cat23);
        categoriaDAO.addCategoria(cat24);
        categoriaDAO.addCategoria(cat25);
        categoriaDAO.addCategoria(cat26);
        categoriaDAO.addCategoria(cat27);
        categoriaDAO.addCategoria(cat28);
        categoriaDAO.addCategoria(cat29);
        categoriaDAO.addCategoria(cat30);
        categoriaDAO.addCategoria(cat31);
        categoriaDAO.addCategoria(cat32);
        categoriaDAO.addCategoria(cat33);
        categoriaDAO.addCategoria(cat34);
        categoriaDAO.addCategoria(cat35);
        categoriaDAO.addCategoria(cat36);
        categoriaDAO.addCategoria(cat37);
        categoriaDAO.addCategoria(cat38);
        categoriaDAO.addCategoria(cat39);
        categoriaDAO.addCategoria(cat40);
        categoriaDAO.addCategoria(cat41);
        categoriaDAO.addCategoria(cat42);
        categoriaDAO.addCategoria(cat43);
        categoriaDAO.addCategoria(cat44);
        categoriaDAO.addCategoria(cat45);
        categoriaDAO.addCategoria(cat46);
        categoriaDAO.addCategoria(cat47);
        categoriaDAO.addCategoria(cat48);
        categoriaDAO.addCategoria(cat49);
        categoriaDAO.addCategoria(cat50);
    }
    
    public void populaProduto(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categorias = categoriaDAO.findCategoria(new Categoria(""));
        CondominoDAO condominoDAO = new CondominoDAO();
        condominos = condominoDAO.findCondominos(new Condomino(""));
        
        Produto p1 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(1);
        p1.setNome("MOUSE");
        p1.setStatus(true);
        p1.getCategorias().add(categorias.get(29));
        p1.getCategorias().add(categorias.get(33));

        Produto p2 = new Produto();
        p2.setDiaria(6);
        p2.setTaxa(1);
        p2.setNome("TECLADO");
        p2.setStatus(true);
        p2.getCategorias().add(categorias.get(29));
        p2.getCategorias().add(categorias.get(32));

        Produto p3 = new Produto();
        p3.setDiaria(15);
        p3.setTaxa(3);
        p3.setNome("MONITOR");
        p3.setStatus(true);
        p3.getCategorias().add(categorias.get(29));
        p3.getCategorias().add(categorias.get(35));
        
        Produto p4 = new Produto();
        p4.setDiaria(3);
        p4.setTaxa(1);
        p4.setNome("CADERNO");
        p4.setStatus(true);
        p4.getCategorias().add(categorias.get(0));

        Produto p5 = new Produto();
        p5.setDiaria(35);
        p5.setTaxa(5);
        p5.setNome("NOTEBOOK");
        p5.setStatus(true);
        p5.getCategorias().add(categorias.get(29));
        p5.getCategorias().add(categorias.get(31));

        Produto p6 = new Produto();
        p6.setDiaria(3);
        p6.setTaxa(0.5);
        p6.setNome("CANETA");
        p6.setStatus(true);
        p6.getCategorias().add(categorias.get(0));

        Produto p7 = new Produto();
        p7.setDiaria(25);
        p7.setTaxa(4);
        p7.setNome("CELULAR");
        p7.setStatus(true);
        p7.getCategorias().add(categorias.get(29));

        Produto p8 = new Produto();
        p1.setDiaria(10);
        p1.setTaxa(3);
        p8.setNome("FONE");
        p8.setStatus(true);
        p8.getCategorias().add(categorias.get(29));

        Produto p9 = new Produto();
        p1.setDiaria(2);
        p1.setTaxa(0.25);
        p9.setNome("CABO USB");
        p9.setStatus(true);
        p9.getCategorias().add(categorias.get(29));

        Produto p10 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(2);
        p10.setNome("CHAVE");
        p10.getCategorias().add(categorias.get(23));

        Produto p11 = new Produto();
        p1.setDiaria(5);
        p1.setTaxa(2);
        p11.setNome("CHAVEIRO");
        p11.getCategorias().add(categorias.get(26));

        Produto p12 = new Produto();
        p1.setDiaria(10);
        p1.setTaxa(5);
        p12.setNome("GARRAFA");
        p12.getCategorias().add(categorias.get(46));
        
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
        
        condominos.get(0).getTelefones().add("1111111111");
        condominos.get(1).getTelefones().add("2222222222");
        condominos.get(2).getTelefones().add("3333333333");
        condominos.get(3).getTelefones().add("4444444444");
                
        condominos.get(0).getProdutos().add(p1);
        condominos.get(0).getProdutos().add(p2);
        condominos.get(0).getProdutos().add(p3);
        
        condominos.get(1).getProdutos().add(p4);
        condominos.get(1).getProdutos().add(p5);
        condominos.get(1).getProdutos().add(p6);

        condominos.get(2).getProdutos().add(p7);
        condominos.get(2).getProdutos().add(p8);
        condominos.get(2).getProdutos().add(p9);
        
        condominos.get(3).getProdutos().add(p10);
        condominos.get(3).getProdutos().add(p11);
        condominos.get(3).getProdutos().add(p12);
        
        p1.setCondomino(condominos.get(0));
        p2.setCondomino(condominos.get(0));
        p3.setCondomino(condominos.get(0));

        p4.setCondomino(condominos.get(1));
        p5.setCondomino(condominos.get(1));
        p6.setCondomino(condominos.get(1));
        
        p7.setCondomino(condominos.get(2));
        p8.setCondomino(condominos.get(2));
        p9.setCondomino(condominos.get(2));

        p10.setCondomino(condominos.get(3));
        p11.setCondomino(condominos.get(3));
        p12.setCondomino(condominos.get(3));
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.addProduto(p1);
        produtoDAO.addProduto(p2);
        produtoDAO.addProduto(p3);
        produtoDAO.addProduto(p4);
        produtoDAO.addProduto(p5);
        produtoDAO.addProduto(p6);
        produtoDAO.addProduto(p7);
        produtoDAO.addProduto(p8);
        produtoDAO.addProduto(p9);
        produtoDAO.addProduto(p10);
        produtoDAO.addProduto(p11);
        produtoDAO.addProduto(p12);
        
        condominoDAO.alteraCondomino(condominos.get(0));
        condominoDAO.alteraCondomino(condominos.get(1));
        condominoDAO.alteraCondomino(condominos.get(2));
        condominoDAO.alteraCondomino(condominos.get(3));
    }
    
    public void populaSolicitacaoAluguel(){
        CondominoDAO condominoDAO = new CondominoDAO();
        condominos = condominoDAO.findCondominos(new Condomino(""));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.findProduto(new Produto(""));
        
        for (int i = 5; i < 1605; i++) {
            int diaSolicitacao, diaInicioAluguel, quantidadeDias, sorteioProduto, sorteioCondomino;
            Calendar dataSolicitacao = Calendar.getInstance(), dataInicioAluguel = Calendar.getInstance();
            diaSolicitacao = i/5;
            diaInicioAluguel = (int) (diaSolicitacao + (8 + Math.random() * 15));
            quantidadeDias = (int) (5 + Math.random() * 12);
            dataSolicitacao.set(Calendar.DAY_OF_YEAR, diaSolicitacao);
            dataInicioAluguel.set(Calendar.DAY_OF_YEAR, diaInicioAluguel);
            sorteioProduto = (int) (Math.random() * 12);
            sorteioCondomino = (int) (Math.random() * 4);
            while (sorteioProduto == 12) {
                sorteioProduto = (int) (Math.random() * 12);
            }
            while (Objects.equals(condominos.get(sorteioCondomino).getCodigo(), produtos.get(sorteioProduto).getCondomino().getCodigo())) {
                sorteioCondomino = (int) (Math.random() * 4);
            }
            SolicitacaoAluguel sa = new SolicitacaoAluguel(quantidadeDias, 1, produtos.get(sorteioProduto), condominos.get(sorteioCondomino), dataSolicitacao, dataInicioAluguel);
            SolicitacaoAluguelDAO solicitacaoAluguelDAO = new SolicitacaoAluguelDAO();
            solicitacaoAluguelDAO.addSolicitacao(sa);
        }
    }
    
    public void populaAluguel(){
        SolicitacaoAluguelDAO solicitacaoAluguelDAO = new SolicitacaoAluguelDAO();
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(Calendar.DAY_OF_YEAR, 0);
        solicitacoes = solicitacaoAluguelDAO.findSolicitacoes(dataInicio);
        
        for (int i = 0; i<50; i++) {
            Calendar dataDevolucao = Calendar.getInstance();
            SolicitacaoAluguel solicitacao = sorteiaAluguelSemRepeticao(alugueis, solicitacoes, dataDevolucao); // HARD
            dataDevolucao.set(Calendar.DAY_OF_YEAR, (int) (solicitacao.getDataInicioAluguel().get(Calendar.DAY_OF_YEAR) + (solicitacao.getDiasPretendidos() - 4 + Math.random() * 8)));
            
            Aluguel aluguel = new Aluguel();
            aluguel.setSolicitacaoAluguel(solicitacao);
            aluguel.setDataDevolucao(dataDevolucao);
            
            AluguelDAO aluguelDAO = new AluguelDAO();
            aluguelDAO.addAluguel(aluguel);
        }
    }
    
    public void populaComentario(){
        AluguelDAO aluguelDAO = new AluguelDAO();
        alugueis = aluguelDAO.findAlugueis();
        
        for (int i=0; i<50; i++) {
            Comentario comentario = new Comentario();
            Calendar dataComentario = Calendar.getInstance();
            dataComentario.set(Calendar.DAY_OF_YEAR, (int) (alugueis.get(i).getDataDevolucao().get(Calendar.DAY_OF_YEAR) + 2 + Math.random() * 8));
            comentario.setComentario(sorteiaComentario());
            comentario.setAvaliacao(sorteiaAvaliacao());
            comentario.setDataComentario(dataComentario);
            comentario.setAluguel(alugueis.get(i));
            
            ComentarioDAO comentarioDAO = new ComentarioDAO();
            comentarioDAO.addComentario(comentario);
        }
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
        int sorteioSolicitacao = (int) (Math.random() * 1600);
        SolicitacaoAluguel solicitacao = solicitacoes.get(sorteioSolicitacao);
        int sorteioDataDevolucao = (int) (solicitacao.getDataInicioAluguel().get(Calendar.DAY_OF_YEAR) + (solicitacao.getDiasPretendidos() - 4 + Math.random() * 8));
        dataDevolucao.set(Calendar.DAY_OF_YEAR, sorteioDataDevolucao);
        
        boolean merda = forAluguel(solicitacao, alugueis, dataDevolucao);
        
        if (merda){
            return solicitacao;
        } else {
            sorteiaAluguelSemRepeticao(alugueis, solicitacoes, dataDevolucao);
        }
        return solicitacao;
    }
    
    private boolean forAluguel(SolicitacaoAluguel solicitacao, List<Aluguel> alugueis, Calendar dataDevolucao){
        for (Aluguel aluguel: alugueis){
            if (solicitacao == aluguel.getSolicitacaoAluguel()){
                System.out.println("Erro: " + solicitacao.getCodigo());
                return false;
            }
        }
        for (Aluguel aluguel: alugueis){
            boolean dataFimSolicitacaoIsBeforeAluguel = dataDevolucao.getTime().before(aluguel.getSolicitacaoAluguel().getDataInicioAluguel().getTime());
            boolean dataInicioSolicitacaoIsAfterAluguelDevolucao = solicitacao.getDataInicioAluguel().getTime().after(aluguel.getDataDevolucao().getTime());
            if (!dataFimSolicitacaoIsBeforeAluguel && !dataInicioSolicitacaoIsAfterAluguelDevolucao){
                return false;
            }
        }
        return true;
    }
    
    private String sorteiaComentario(){
        int numSorteio = (int) (Math.random() * 8);
        switch (numSorteio) {
            case 0: return "Muito linda a locadora";
            case 1: return "Muito bom esse produto";
            case 2: return "Não gostei";
            case 3: return "Muito show";
            case 4: return "Não gostei";
            case 5: return "Sem defeitos";
            case 6: return "Legalzão, gostei mesmo";
            case 7: return "Uma porcaria!!!";
            default: return "Nada a declarar";
        }
    }
    
    private Avaliacao sorteiaAvaliacao(){
        int numSorteio = (int) (Math.random() * 3);
        switch (numSorteio) {
            case 0: return Avaliacao.NEGATIVA;
            case 1: return Avaliacao.NEUTRA;
            case 2: return Avaliacao.POSITIVA;
            default: return Avaliacao.POSITIVA;
        }
    }
    
    public static void main(String args[]){
        PopulaBanco populaBanco = new PopulaBanco();
        populaBanco.populaEstadosCivis();
        populaBanco.populaApartamentos();
        populaBanco.populaCondominos();
        populaBanco.populaCategoria();
        populaBanco.populaProduto();
        populaBanco.populaSolicitacaoAluguel();
        populaBanco.populaAluguel();
        populaBanco.populaComentario();
        System.exit(0);
    }
}