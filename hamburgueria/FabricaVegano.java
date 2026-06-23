package hamburgueria;

public class FabricaVegano extends FabricaHamburguer {

    @Override
    public Hamburguer criar() {
        return new HamburguerBuilder()
                .comNome("Vegano")
                .comPao("integral")
                .comCarne("hambúrguer de grão-de-bico")
                .comIngrediente("alface")
                .comIngrediente("tomate")
                .comIngrediente("cebola roxa")
                .comPrecoBase(28.00)
                .build();
    }
}
