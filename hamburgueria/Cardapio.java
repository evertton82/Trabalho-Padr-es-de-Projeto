package hamburgueria;

public class Cardapio {

    public static Hamburguer classico() {
        return new FabricaClassico().criar();
    }

    public static Hamburguer vegano() {
        return new FabricaVegano().criar();
    }

    public static Hamburguer duploBacon() {
        return new FabricaDuploBacon().criar();
    }
}
