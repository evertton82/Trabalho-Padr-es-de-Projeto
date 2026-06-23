package hamburgueria;

public class FabricaClassico extends FabricaHamburguer {

    @Override
    public Hamburguer criar() {
        return new HamburguerBuilder()
                .comNome("Clássico")
                .comPao("brioche")
                .comCarne("carne bovina 150g")
                .comIngrediente("queijo")
                .comIngrediente("alface")
                .comIngrediente("tomate")
                .comPrecoBase(25.00)
                .build();
    }
}
