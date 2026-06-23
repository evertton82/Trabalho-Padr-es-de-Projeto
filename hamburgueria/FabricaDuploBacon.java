package hamburgueria;

public class FabricaDuploBacon extends FabricaHamburguer {

    @Override
    public Hamburguer criar() {
        return new HamburguerBuilder()
                .comNome("Duplo Bacon")
                .comPao("australiano")
                .comCarne("duas carnes bovinas 120g")
                .comIngrediente("cheddar")
                .comIngrediente("bacon")
                .comIngrediente("cebola caramelizada")
                .comPrecoBase(32.00)
                .build();
    }
}
